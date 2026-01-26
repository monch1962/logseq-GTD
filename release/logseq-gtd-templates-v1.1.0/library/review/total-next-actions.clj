;; Total Next Actions Query
;; Usage: {{query (read-file "queries/library/review/total-next-actions.clj")}}
;; Count of all next actions

{:query [:find (count ?b)
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :status) "not-started"]]
 :view :text}