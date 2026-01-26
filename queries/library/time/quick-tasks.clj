;; Quick Tasks Query (<15 minutes)
;; Usage: {{query (read-file "queries/library/time/quick-tasks.clj")}}
;; Shows tasks estimated to take less than 15 minutes

{:title "⚡ Quick Tasks (<15min)"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :time-estimate) ?est]
         [(< ?est 15)]
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