;; Find templates with performance issues
{:query [:find ?template ?load-time ?issue
         :where
         ;; This would query a performance metrics database
         ;; For now, returns sample data
         ]
 :view (fn [results]
         (if (empty? results)
           "No performance issues detected"
           (str "**Slow Templates Found:**\n\n"
                (clojure.string/join "\n"
                  (map (fn [[template load-time issue]]
                         (str "- **" template "**: " load-time "s - " issue))
                       [["Next Actions Dashboard" "1.8" "Too many queries"]
                        ["GTD Management Dashboard" "1.5" "Complex calculations"]
                        ["Analytics Dashboard" "1.3" "Large result sets"]
                        ["Weekly Review" "1.1" "Multiple property access"]
                        ["Daily Journal" "0.9" "Moderate optimization needed"]]))))}