;; Someday/Maybe by Category Query
;; Usage: {{query (read-file "queries/library/dashboard/someday-by-category.clj")}}
;; Shows Someday/Maybe items grouped by category

{:title "🔮 Someday/Maybe by Category"
 :query [:find ?category (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :type) "someday-maybe"]
         [(get ?props :category) ?category]]
 :view :table
 :group-by ?category
 :result-transform (fn [result]
                     (sort-by second > result))}