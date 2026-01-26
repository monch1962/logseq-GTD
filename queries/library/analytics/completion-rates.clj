;; Completion Rates Query
;; Usage: {{query (read-file "queries/library/analytics/completion-rates.clj")}}
;; Shows next actions completed today

{:query [:find (count ?b)
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :completed) ?completed]
         [(clojure.string/includes? ?completed "{{today}}")]]
 :view :text}