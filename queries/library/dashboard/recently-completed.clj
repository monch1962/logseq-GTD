;; Recently Completed Query
;; Usage: {{query (read-file "queries/library/dashboard/recently-completed.clj")}}
;; Shows recently completed tasks

{:title "✅ Recently Completed"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "DONE"]
         [?b :block/properties ?props]
         [(get ?props :completed) ?completed]
         [(>= ?completed "{{7-days-ago}}")]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:task (if (string? content) content "No content")
                               :completed (get props :completed)
                               :project (get props :project)
                               :context (get props :context "none")})) result))}