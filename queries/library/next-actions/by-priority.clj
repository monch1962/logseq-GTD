;; Next Actions by Priority
;; Usage: {{query (read-file "queries/library/next-actions/by-priority.clj") :inputs [:priority :context]}}

{:title "Next Actions by Priority"
 :query [:find (pull ?b [:block/content :block/properties :block/uuid])
         :in $ ?priority ?context
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :priority) ?priority]
         [(get ?props :status) "not-started"]
         [(get ?props :context) ?ctx]
         [(= ?ctx ?context)]
         (not [?b :block/properties ?p2]
              [(get ?p2 :blocked) true])]
 :inputs [:priority :context]
 :limit 10
 :result-transform (fn [results]
                     (map (fn [r]
                            {:title (str "• " (:block/content r))
                             :description (str "Due: " (get-in r [:block/properties :due-date] "None")
                                            " | Energy: " (get-in r [:block/properties :energy] "medium"))
                             :url (str "#" (:block/uuid r))})
                          results))}