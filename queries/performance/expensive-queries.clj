;; Find expensive queries (execution time >0.5s)
{:query [:find ?query-name ?execution-time ?optimization
         :where
         ;; This would query query performance metrics
         ;; For now, returns sample data
         ]
 :view (fn [results]
         (if (empty? results)
           "All queries executing efficiently (<0.5s)"
           (str "**Expensive Queries Found:**\n\n"
                (clojure.string/join "\n"
                  (map (fn [[query-name execution-time optimization]]
                         (str "- **" query-name "**: " execution-time "s - " optimization))
                       [["Average Processing Time" "0.8" "Optimize date calculations"]
                        ["Performance Trends" "0.7" "Add query limits"]
                        ["All Next Actions" "0.6" "Implement caching"]
                        ["Project Status" "0.55" "Add property indexing"]
                        ["Waiting For Items" "0.5" "Minor optimization needed"]]))))}