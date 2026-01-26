;; Context Quick Tasks Query
;; Usage: {{query (assoc (read-file "queries/library/rules/context-quick-tasks.clj")
;;                       :title "Quick tasks for {{context}}")
;;         :inputs ["{{context}}"]}
;; Shows quick tasks (<2 minutes) for a specific context

{:query [:find (count ?b)
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :context) "{{context}}"]
         [(get ?props :time-estimate) ?est]
         [(<= ?est 2)]
         [(get ?props :status) "not-started"]]
 :view :text}