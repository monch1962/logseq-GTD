;; Email Processing Query
;; Usage: {{query (read-file "queries/library/integration/email-processing.clj")}}
;; Count of emails processed today

{:query [:find (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :source) "email"]
         [(get ?props :captured) ?captured]
         [(clojure.string/includes? ?captured "{{today}}")]]
 :view :text}