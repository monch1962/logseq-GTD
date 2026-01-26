;; Recent References Query
;; Usage: {{query (read-file "queries/library/dashboard/recent-references.clj")}
;; Shows recently added reference materials

{:title "🆕 Recent References"
:query [:find (pull ?b [:block/content :block/properties])
:where
[?b :block/properties ?props]
[(get ?props :type) "reference"]
[(get ?props :added) ?added]
[(>= ?added "{{30-days-ago}}")]]
:view :table
:result-transform (fn [result]
(map (fn [b]
(let [content (:block/content b)
props (:block/properties b)]
{:reference (if (string? content) content "No content")
:type (get props :reference-type)
:added (get props :added)
:tags (get props :tags)})) result))
 :cache-enabled true
 :cache-key "recent-references"
 :cache-ttl 300
 :mobile-ttl 600}
