;; Tasks by Context Query
;; Usage: {{query (assoc (read-file "queries/library/context/tasks-by-context.clj")
;;                       :title "📊 Tasks in {{context}}")
;;         :inputs ["{{context}}"]}
;; Shows tasks for a specific context

{:title "📊 Tasks in this context"
 :query [:find (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :context) ?context]
         [(= ?context "{{context}}")]]
 :view :text}