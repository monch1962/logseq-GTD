;; Overdue Tasks Query
;; Usage: {{query (read-file "queries/library/reviews/overdue-tasks.clj") :inputs [:today]}}

{:title "⚠️ Overdue Tasks"
 :query [:find (pull ?b [:block/content :block/properties :block/uuid])
         :in $ ?today
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :due-date) ?due]
         [(< ?due ?today)]
         [(get ?props :status) ?status]
         [(contains? #{"not-started" "in-progress"} ?status)]]
 :inputs [:today]
 :view :table
 :result-transform (fn [results]
                     (map (fn [r]
                            {:task (:block/content r)
                             :due-date (get-in r [:block/properties :due-date])
                             :priority (get-in r [:block/properties :priority] "MEDIUM")
                             :context (get-in r [:block/properties :context] "?")})
                          results))}