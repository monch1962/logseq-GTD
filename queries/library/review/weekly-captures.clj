;; Weekly Captures Query
;; Usage: {{query (read-file "queries/library/review/weekly-captures.clj")}}
;; Count of items captured this week

{:query [:find (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :captured) ?captured]
         [(clojure.string/includes? ?captured "{{this-week}}")]]
 :view :text}