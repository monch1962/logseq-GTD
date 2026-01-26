;; Vague Project Next Actions Query
;; Usage: {{query (read-file "queries/library/projects/vague-next-actions.clj")}}
;; Identifies next actions that are too vague (contain "work on", "continue", etc.)

{:title "⚠️ Vague Project Next Actions"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :project) ?project]
         [?b :block/content ?content]
         [(clojure.string/includes? (clojure.string/lower-case ?content) "work on")]
         [(get ?props :status) "not-started"]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:task (if (string? content) content "No content")
                               :project (get props :project)
                               :context (get props :context "none")})) result))}