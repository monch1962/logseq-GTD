;; Project Status Query
;; Usage: {{query (read-file "queries/library/projects/status.clj")}}

{:title "Active Projects"
 :query [:find (pull ?b [*])
         :where
         [?b :block/name ?name]
         [(clojure.string/includes? ?name "Project/")]
         [?b :block/properties ?props]
         [(get ?props :type) ?type]
         [(= ?type "project")]
         [(get ?props :status) ?status]
         [(contains? #{"active" "on-hold"} ?status)]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [props (:block/properties b)]
                              {:project (last (clojure.string/split (:block/name b) #"/"))
                               :status (get props "status")
                               :next-action (get props "next-action")
                               :last-updated (get props "last-updated")})) result))}