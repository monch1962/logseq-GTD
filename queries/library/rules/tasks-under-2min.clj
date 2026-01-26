;; Tasks Under 2 Minutes Query
;; Usage: {{query (read-file "queries/library/rules/tasks-under-2min.clj")}}
;; Shows all tasks estimated to take less than 2 minutes

{:title "⚡ Tasks Under 2 Minutes"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :time-estimate) ?est]
         [(<= ?est 2)]
         [(get ?props :status) "not-started"]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:task (if (string? content) content "No content")
                               :context (get props :context "none")
                               :time-estimate (get props :time-estimate)
                               :priority (get props :priority "MEDIUM")})) result))}