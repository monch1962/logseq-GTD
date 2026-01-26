;; High Interest Someday/Maybe Query
;; Usage: {{query (read-file "queries/library/dashboard/high-interest-someday.clj")}
;; Shows Someday/Maybe items with high interest scores

{:title "🌟 High Interest Someday/Maybe"
:query [:find (pull ?b [:block/content :block/properties])
:where
[?b :block/properties ?props]
[(get ?props :type) "someday-maybe"]
[(get ?props :interest-score) ?score]
[(>= ?score 8)]]
:view :table
:result-transform (fn [result]
(map (fn [b]
(let [content (:block/content b)
props (:block/properties b)]
{:idea (if (string? content) content "No content")
:category (get props :category)
:interest (get props :interest-score)
:added (get props :added-date)})) result))
 :cache-enabled true
 :cache-key "high-interest-someday"
 :cache-ttl 300
 :mobile-ttl 600}
