;; Next Actions by Area Query
;; Usage: {{query (read-file "queries/library/areas/next-actions-by-area.clj")}}
;; Groups next actions by their assigned area

{:title "Next Actions by Area"
 :query [:find (pull ?b [*])
         :where
         [?b :block/marker ?marker]
         [(= ?marker "TODO")]
         [?b :block/properties ?props]
         [(get ?props "area") ?area]]
 :view :table
 :group-by :area}