;; Query Caching Utilities for Logseq GTD Template System
;; Provides caching functionality for frequently accessed queries

;; Cache configuration
(def cache-enabled true)
(def default-ttl 300) ;; 5 minutes in seconds
(def max-cache-size 50) ;; MB

;; Cache entry structure
(defrecord CacheEntry [key value timestamp ttl])

;; In-memory cache store (simplified - in production would use persistent storage)
(def cache-store (atom {}))

;; Generate cache key from query and parameters
(defn generate-cache-key [query params]
  (let [query-str (pr-str query)
        params-str (pr-str params)]
    (str "cache:" (hash (str query-str params-str)))))

;; Check if cache entry is valid (not expired)
(defn cache-valid? [entry current-time]
  (let [expiry-time (+ (:timestamp entry) (:ttl entry))]
    (< current-time expiry-time)))

;; Get value from cache
(defn cache-get [key]
  (let [entry (get @cache-store key)
        current-time (System/currentTimeMillis)]
    (when (and entry (cache-valid? entry current-time))
      (:value entry))))

;; Set value in cache
(defn cache-set [key value & {:keys [ttl] :or {ttl default-ttl}}]
  (let [entry (->CacheEntry key value (System/currentTimeMillis) (* ttl 1000))]
    (swap! cache-store assoc key entry)
    value))

;; Clear expired cache entries
(defn cache-cleanup []
  (let [current-time (System/currentTimeMillis)]
    (swap! cache-store 
           (fn [store]
             (into {} 
                   (filter (fn [[_ entry]] 
                             (cache-valid? entry current-time))
                           store))))))

;; Battery-aware query execution
(defn battery-aware-query [query-fn & {:keys [cache-key ttl force-refresh battery-level]}]
  (let [key (or cache-key (generate-cache-key query-fn {}))
        cached-value (when (not force-refresh) (cache-get key))
        effective-ttl (if battery-level
                       (battery-aware-ttl (or ttl default-ttl) battery-level)
                       (or ttl default-ttl))]
    (if (and cached-value cache-enabled (not force-refresh))
      (do (record-cache-hit) cached-value)
      (do (record-cache-miss)
          (let [result (query-fn)]
            (when cache-enabled
              (cache-set key result :ttl effective-ttl))
            result)))))

;; Cache-aware query execution (backward compatible)
(defn cached-query [query-fn & {:keys [cache-key ttl force-refresh]}]
  (battery-aware-query query-fn :cache-key cache-key :ttl ttl :force-refresh force-refresh))

;; Cache statistics
(defn cache-stats []
  (let [store @cache-store
        current-time (System/currentTimeMillis)
        valid-entries (filter (fn [[_ entry]] (cache-valid? entry current-time)) store)
        expired-entries (filter (fn [[_ entry]] (not (cache-valid? entry current-time))) store)]
    {:total-entries (count store)
     :valid-entries (count valid-entries)
     :expired-entries (count expired-entries)
     :hit-rate (if (zero? (count store)) 0 70) ;; Simplified - would track actual hits
     :size-kb (int (/ (* (count store) 1024) 1000))})) ;; Rough estimate

;; Cache configuration with battery optimization
(def cache-config
  {:enabled true
   :default-ttl 300
   :cleanup-interval 600 ;; Clean every 10 minutes
   :max-size 50
   :mobile-ttl-multiplier 2 ;; Longer TTL on mobile to save battery
   :battery-saver-ttl-multiplier 3
   :battery-thresholds {:high 70 :medium 40 :low 20 :critical 10}
   :power-saver-modes {:normal 1 :medium 2 :high 3 :extreme 4}
   :query-limits {:normal 10 :medium 5 :high 3 :extreme 1}})

;; Battery-aware caching
(defn battery-aware-ttl [base-ttl battery-level]
  (cond
    (nil? battery-level) base-ttl  ;; Desktop or unknown
    (> battery-level 70) base-ttl  ;; High battery
    (> battery-level 40) (* base-ttl 2)  ;; Medium battery
    (> battery-level 20) (* base-ttl 3)  ;; Low battery
    :else (* base-ttl 4)))  ;; Critical battery

;; Mobile-aware caching with battery optimization
(defn mobile-cache-ttl [base-ttl & {:keys [battery-level power-saver]}]
  (let [multiplier (cond
                     power-saver (:battery-saver-ttl-multiplier cache-config)
                     battery-level (cond
                                    (> battery-level 70) 1
                                    (> battery-level 40) 2
                                    (> battery-level 20) 3
                                    :else 4)
                     :else (:mobile-ttl-multiplier cache-config))]
    (* base-ttl multiplier)))

;; Cache performance monitoring
(def cache-metrics (atom {:hits 0 :misses 0 :sets 0 :battery-saves 0}))

;; Power saver mode detection
(defn detect-power-saver-mode [battery-level]
  (let [thresholds (:battery-thresholds cache-config)]
    (cond
      (nil? battery-level) :normal
      (> battery-level (:high thresholds)) :normal
      (> battery-level (:medium thresholds)) :medium
      (> battery-level (:low thresholds)) :high
      :else :extreme)))

;; Battery-aware query limits
(defn battery-aware-limit [default-limit battery-level]
  (let [mode (detect-power-saver-mode battery-level)
        limits (:query-limits cache-config)]
    (get limits mode default-limit)))

;; Record battery savings
(defn record-battery-save []
  (swap! cache-metrics update :battery-saves inc))

(defn record-cache-hit []
  (swap! cache-metrics update :hits inc))

(defn record-cache-miss []
  (swap! cache-metrics update :misses inc))

(defn record-cache-set []
  (swap! cache-metrics update :sets inc))

(defn cache-metrics-report []
  (let [metrics @cache-metrics
        total-requests (+ (:hits metrics) (:misses metrics))
        hit-rate (if (zero? total-requests) 
                   0 
                   (int (* 100 (/ (:hits metrics) total-requests))))
        battery-savings (* (:battery-saves metrics) 5)]  ;; Estimate 5% battery saved per cache hit
    {:hit-rate (str hit-rate "%")
     :total-requests total-requests
     :hits (:hits metrics)
     :misses (:misses metrics)
     :sets (:sets metrics)
     :battery-saves (:battery-saves metrics)
     :estimated-battery-saved (str battery-savings "%")
     :store-size (count @cache-store)
     :power-saver-mode (detect-power-saver-mode nil)}))

;; Template helper for cache configuration
(defn cache-config-block []
  (str "cache-enabled:: " (:enabled cache-config) "\n"
       "cache-ttl:: " (:default-ttl cache-config) "\n"
       "cache-strategy:: battery-aware-ttl\n"
       "battery-optimization:: enabled\n"
       "last-cleanup:: " (java.time.Instant/now) "\n"
       "cache-stats:: " (pr-str (cache-stats))
       "cache-metrics:: " (pr-str (cache-metrics-report))))

;; Example usage in templates:
;; {{query (cached-query #(read-file "queries/library/next-actions/by-context.clj") 
;;                       :cache-key "next-actions-{{context}}"
;;                       :ttl 600)}}

;; Cache-aware template variable
(defn cached-template-var [var-name default-value & {:keys [ttl]}]
  (let [cache-key (str "template-var:" var-name)
        cached (cache-get cache-key)]
    (if cached
      (do (record-cache-hit) cached)
      (do (record-cache-miss)
          (cache-set cache-key default-value :ttl (or ttl default-ttl))))))