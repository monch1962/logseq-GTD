;; Projects Missing Next Actions Query
;; Usage: {{query (read-file "queries/library/projects/missing-next-actions.clj")}}
;; Identifies projects without defined next actions

{:title "⚠️ Projects Missing Next Actions"
 :query [:find (pull ?p [:block/name :block/properties])
         :where
         [?p :block/name ?name]
         [(clojure.string/starts-with? ?name "Project/")]
         [?p :block/properties ?props]
         [(get ?props :status) ?status]
         [(contains? #{"active" "planning"} ?status)]
         (not-join [?p]
           [?na :block/properties ?na-props]
           [(get ?na-props :project) ?project-name]
           [(= ?project-name ?name)]
           [?na :block/marker "TODO"])]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [name (:block/name b)
                                  props (:block/properties b)]
                              {:project (last (clojure.string/split name #"/"))
                               :status (get props :status)
                               :last-updated (get props :last-updated)})) result))}