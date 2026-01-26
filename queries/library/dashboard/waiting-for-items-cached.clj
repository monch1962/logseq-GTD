;; Waiting For Items Query with Caching
;; Usage: {{query (cached-query #(read-file "queries/library/dashboard/waiting-for-items-cached.clj")
;; Shows active waiting-for items with caching

{:title "⏳ Active Waiting For Items (Cached)"
:query [:find (pull ?b [:block/content :block/properties])
:where
[?b :block/properties ?props]
[(get ?props :type) "waiting-for"]
[(get ?props :status) "active"]]
:view :table
:result-transform (fn [result]
(map (fn [b]
(let [content (:block/content b)
props (:block/properties b)]
{:item (if (string? content) content "No content")
:waiting-from (get props :waiting-from)
:follow-up-date (get props :follow-up-date)
:project (get props :project)})) result))
 :cache-enabled true
 :cache-key "waiting-for-items-cached"
 :cache-ttl 300
 :mobile-ttl 600}
