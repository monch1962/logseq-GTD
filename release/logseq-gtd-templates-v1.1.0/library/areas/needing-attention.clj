;; Areas Needing Attention Query
;; Usage: {{query (read-file "queries/library/areas/needing-attention.clj")}}
;; Finds areas with status "needs-attention" or "neglected"

{:title "Areas Needing Attention"
 :query [:find (pull ?b [*])
         :where
         [?b :block/name ?name]
         [(clojure.string/includes? ?name "Area/")]
         [?b :block/properties ?props]
         [(get ?props :type) ?type]
         [(= ?type "area-of-responsibility")]
         [(get ?props "current-status") ?status]
         [(contains? #{"needs-attention" "neglected"} ?status)]]
 :view :table}