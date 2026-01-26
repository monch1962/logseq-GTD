;; Do Now Tasks Query (<2 minutes)
;; Usage: {{query (read-file "queries/library/journal/do-now-tasks.clj")}}
;; Shows tasks that can be done immediately (<2 minutes)

{:title "⚡ Do Now (<2 minutes)"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :time-estimate) ?est]
         [(<= ?est 2)]
         [(get ?props :status) "not-started"]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:task (if (string? content) content "No content")
                               :context (get props :context "none")
                               :time-estimate (get props :time-estimate)
                               :priority (get props :priority "MEDIUM")})) result))}