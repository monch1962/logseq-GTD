;; Focus Sessions Query (30-60 minutes)
;; Usage: {{query (read-file "queries/library/time/focus-sessions.clj")}}
;; Shows tasks suitable for focus sessions (30-60 minutes)

{:title "🎯 Focus Sessions (30-60min)"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :time-estimate) ?est]
         [(>= ?est 30)]
         [(<= ?est 60)]
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