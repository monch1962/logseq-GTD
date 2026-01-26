;; Areas of Responsibility Status Query
;; Usage: {{query (read-file "queries/library/areas/status.clj")}}

{:title "Areas of Responsibility - Current Status"
 :query [:find (pull ?b [*])
         :where
         [?b :block/name ?name]
         [(clojure.string/includes? ?name "Area/")]
         [?b :block/properties ?props]
         [(get ?props :type) ?type]
         [(= ?type "area-of-responsibility")]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [props (:block/properties b)]
                              {:area (last (clojure.string/split (:block/name b) #"/"))
                               :category (get props "category")
                               :status (get props "current-status")
                               :last-reviewed (get props "last-reviewed")
                               :next-review (get props "next-review")})) result))}