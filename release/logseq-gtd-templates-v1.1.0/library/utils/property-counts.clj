;; Property Counts Utility Query
;; Usage: {{query (read-file "queries/library/utils/property-counts.clj") :inputs [:property]}}

{:title "Property Distribution"
 :query [:find ?value (count ?b)
         :in $ ?property
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props ?property) ?value]]
 :inputs [:property]
 :group-by ?value
 :view :table}