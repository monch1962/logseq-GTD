;; Total References Query
;; Usage: {{query (read-file "queries/library/dashboard/total-references.clj")}
;; Count of all reference materials

{:query [:find (count ?b)
:where
[?b :block/properties ?props]
[(get ?props :type) "reference"]]
:view :text
 :cache-enabled true
 :cache-key "total-references"
 :cache-ttl 300
 :mobile-ttl 600}
