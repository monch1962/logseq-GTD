;; Next Actions by Context
;; Usage: {{query (read-file "queries/library/next-actions/by-context.clj") :inputs [:context]}}

{:title "Next Actions by Context"
 :query [:find (pull ?b [:block/content :block/properties :block/uuid])
         :in $ ?context
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :status) "not-started"]
         [(get ?props :context) ?ctx]
         [(= ?ctx ?context)]
         (not [?b :block/properties ?p2]
              [(get ?p2 :blocked) true])]
 :inputs [:context]
 :limit 20
 :result-transform (fn [results]
                     (map (fn [r]
                            {:title (str "• " (:block/content r))
                             :description (str "Priority: " (get-in r [:block/properties :priority] "MEDIUM")
                                            " | Time: " (get-in r [:block/properties :time-estimate] "?") "min")
                             :url (str "#" (:block/uuid r))})
                          results))}