;; Recently Completed Waiting For Query
;; Usage: {{query (read-file "queries/library/dashboard/recently-completed-waiting.clj")}}
;; Shows recently completed waiting-for items

{:title "✅ Recently Completed"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/properties ?props]
         [(get ?props :type) "waiting-for"]
         [(get ?props :status) "completed"]
         [(get ?props :completed-date) ?completed]
         [(clojure.string/includes? ?completed "{{this-week}}")]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:item (if (string? content) content "No content")
                               :from (get props :from)
                               :completed (get props :completed-date)
                               :wait-time (try
                                           (let [delegated (java.time.LocalDate/parse (get props :delegated-date))
                                                 completed (java.time.LocalDate/parse (get props :completed-date))]
                                             (.between java.time.temporal.ChronoUnit/DAYS delegated completed))
                                           (catch Exception _ "unknown"))})) result))}