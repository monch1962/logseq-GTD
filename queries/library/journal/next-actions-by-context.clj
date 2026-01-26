;; Next Actions by Context Query
;; Usage: {{query (assoc (read-file "queries/library/journal/next-actions-by-context.clj")
;;                       :title "🎯 Next Actions for {{current-context}}")
;;         :inputs ["{{current-context}}"]}
;; Shows next actions for a specific context

{:title "🎯 Next Actions by Context"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :context) ?context]
         [(= ?context "{{current-context}}")]
         [(get ?props :status) "not-started"]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:task (if (string? content) content "No content")
                               :priority (get props :priority "MEDIUM")
                               :time-estimate (get props :time-estimate)
                               :project (get props :project)})) result))}