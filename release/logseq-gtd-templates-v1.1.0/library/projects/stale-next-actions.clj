;; Stale Next Actions Query (>7 days)
;; Usage: {{query (read-file "queries/library/projects/stale-next-actions.clj")}}
;; Identifies next actions that haven't been updated in over 7 days

{:title "⚠️ Stale Next Actions (>7 days)"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :last-updated) ?updated]
         [(< ?updated "{{7-days-ago}}")]
         [(get ?props :status) "not-started"]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:task (if (string? content) content "No content")
                               :project (get props :project)
                               :last-updated (get props :last-updated)
                               :context (get props :context "none")})) result))}