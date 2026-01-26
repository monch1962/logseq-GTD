;; Most Useful References Query
;; Usage: {{query (read-file "queries/library/dashboard/most-useful-references.clj")}}
;; Shows reference materials with high usefulness scores

{:title "⭐ Most Useful References"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/properties ?props]
         [(get ?props :type) "reference"]
         [(get ?props :usefulness-score) ?score]
         [(>= ?score 4)]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:reference (if (string? content) content "No content")
                               :type (get props :reference-type)
                               :usefulness (get props :usefulness-score)
                               :last-used (get props :last-accessed)})) result))}