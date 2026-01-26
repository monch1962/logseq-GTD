;; Ready for Active Consideration Query
;; Usage: {{query (read-file "queries/library/dashboard/ready-for-consideration.clj")}
;; Shows Someday/Maybe items ready to become active projects

{:title "🚀 Ready for Active Consideration"
:query [:find (pull ?b [:block/content :block/properties])
:where
[?b :block/properties ?props]
[(get ?props :type) "someday-maybe"]
[(get ?props :readiness) "ready"]
[(get ?props :review-date) ?review]
[(<= ?review "{{today}}")]]
:view :table
:result-transform (fn [result]
(map (fn [b]
(let [content (:block/content b)
props (:block/properties b)]
{:idea (if (string? content) content "No content")
:category (get props :category)
:readiness (get props :readiness)
:last-reviewed (get props :review-date)})) result))
 :cache-enabled true
 :cache-key "ready-for-consideration"
 :cache-ttl 300
 :mobile-ttl 600}
