;; Processed Today Query
;; Usage: {{query (read-file "queries/library/process/processed-today.clj")}}
;; Count of items processed today

{:query [:find (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :processed) ?processed]
         [(clojure.string/includes? ?processed "{{today}}")]]
 :view :text}