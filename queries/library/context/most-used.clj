;; Most Used Contexts Query
;; Usage: {{query (read-file "queries/library/context/most-used.clj")}}
;; Shows contexts with most tasks assigned

{:title "📈 Most Used Contexts"
 :query [:find ?context (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :context) ?context]
         [(not (nil? ?context))]]
 :view :table
 :group-by ?context
 :result-transform (fn [result]
                     (sort-by second > result))}