;; High Energy Tasks Query
;; Usage: {{query (read-file "queries/library/time/high-energy-tasks.clj")}}
;; Shows tasks requiring high energy levels

{:title "⚡ High Energy Tasks"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :energy-level) ?energy]
         [(= ?energy "high")]
         [(get ?props :status) "not-started"]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [props (:block/properties b)
                                  content (:block/content b)]
                              {:task (if (string? content) content "No content")
                               :context (get props :context "none")
                               :time-estimate (get props :time-estimate)
                               :priority (get props :priority "MEDIUM")})) result))}