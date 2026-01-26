;; Overdue Follow-ups Query
;; Usage: {{query (read-file "queries/library/dashboard/overdue-follow-ups.clj")}}
;; Shows waiting-for items with overdue follow-up dates

{:title "⚠️ Overdue Follow-ups"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/properties ?props]
         [(get ?props :type) "waiting-for"]
         [(get ?props :follow-up-date) ?follow-up]
         [(< ?follow-up "{{today}}")]
         [(get ?props :status) "active"]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:item (if (string? content) content "No content")
                               :waiting-from (get props :waiting-from)
                               :follow-up-date (get props :follow-up-date)
                               :days-overdue (try
                                              (let [follow-up (java.time.LocalDate/parse (get props :follow-up-date))
                                                    today (java.time.LocalDate/parse "{{today}}")]
                                                (.between java.time.temporal.ChronoUnit/DAYS follow-up today))
                                              (catch Exception _ "unknown"))})) result))}