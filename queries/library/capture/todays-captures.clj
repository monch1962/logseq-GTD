;; Today's Captures Query
;; Usage: {{query (read-file "queries/library/capture/todays-captures.clj")}}
;; Shows items captured today with their status

{:title "📈 Today's Captures"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/properties ?props]
         [(get ?props :captured) ?captured]
         [(clojure.string/includes? ?captured "{{today}}")]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [props (:block/properties b)
                                  content (:block/content b)]
                              {:item (if (string? content) content "No content")
                               :source (get props :source "unknown")
                               :status (get props :status "unprocessed")
                               :captured (get props :captured)})) result))}