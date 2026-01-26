;; Performance Trends Query
;; Usage: {{query (read-file "queries/library/analytics/performance-trends.clj")}}
;; Shows weekly performance trends

{:title "📈 Weekly Performance Trends"
 :query [:find ?week (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :completed) ?completed]
         [(clojure.string/includes? ?completed "{{this-year}}")]
         [(clojure.string/split ?completed #"-") [_ _ ?day]]
         [(clojure.string/split ?completed #"-") [?year ?month _]]
         [(str ?year "-W" (format "%02d" (int (/ (Integer/parseInt ?day) 7)))) ?week]]
 :view :table
 :group-by ?week
 :result-transform (fn [result]
                     (sort-by first result))}