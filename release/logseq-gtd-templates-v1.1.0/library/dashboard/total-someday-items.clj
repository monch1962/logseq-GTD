;; Total Someday/Maybe Items Query
;; Usage: {{query (read-file "queries/library/dashboard/total-someday-items.clj")}}
;; Count of all Someday/Maybe items

{:query [:find (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :type) "someday-maybe"]]
 :view :text}