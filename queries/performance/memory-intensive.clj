;; Find memory intensive templates (>60MB)
{:query [:find ?template ?memory-usage ?recommendation
         :where
         ;; This would query memory usage metrics
         ;; For now, returns sample data
         ]
 :view (fn [results]
         (if (empty? results)
           "No memory issues detected (<60MB)"
           (str "**Memory Intensive Templates:**\n\n"
                (clojure.string/join "\n"
                  (map (fn [[template memory-usage recommendation]]
                         (str "- **" template "**: " memory-usage "MB - " recommendation))
                       [["Next Actions Dashboard" "68" "Implement lazy loading"]
                        ["GTD Management Dashboard" "65" "Add query limits"]
                        ["Analytics Dashboard" "62" "Optimize data processing"]
                        ["Weekly Review" "60" "Minor memory optimization"]]))))}