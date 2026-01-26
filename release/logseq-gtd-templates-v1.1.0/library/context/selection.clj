;; Context Selection Query
;; Usage: {{query (read-file "queries/library/context/selection.clj")}}
;; Shows most recently used contexts for dropdown selection

{:title "🎯 Select Context (Last 10 Used)"
 :query [:find (pull ?p [:block/name :block/properties])
         :where
         [?p :block/name ?name]
         [(clojure.string/starts-with? ?name "Context/")]
         [?p :block/properties ?props]
         [(get ?props :last-used) ?last-used]]
 :view :table
 :result-transform (fn [result]
                     (take 10 (sort-by (fn [b]
                                         (get (:block/properties b) :last-used "1970-01-01"))
                                       > result)))}