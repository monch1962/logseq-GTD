;; Waiting Items Count Query
;; Usage: {{query (read-file "queries/library/dashboard/waiting-items-count.clj")}
;; Count of waiting-for items

{:query [:find (count ?b)
:where
[?b :block/properties ?props]
[(get ?props :type) "waiting-for"]
[(get ?props :status) "waiting"]]
:view :text
 :cache-enabled true
 :cache-key "waiting-items-count"
 :cache-ttl 300
 :mobile-ttl 600}
