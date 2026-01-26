;; References by Tag Query
;; Usage: {{query (read-file "queries/library/dashboard/references-by-tag.clj")}}
;; Shows reference materials grouped by tag

{:title "📚 References by Tag"
 :query [:find ?tag (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :type) "reference"]
         [(get ?props :tags) ?tags]
         [(clojure.string/split ?tags #",") ?tag-list]
         [?tag ?tag-list]]
 :view :table
 :group-by ?tag
 :result-transform (fn [result]
                     (sort-by second > result))}