;; Waiting For Items Query
;; Usage: {{query (read-file "queries/library/dashboard/waiting-for-items.clj")}}
;; Shows active waiting-for items

{:title "⏳ Active Waiting For Items"
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
                               :project (get props :project)})) result))}