;; Active Projects Count Query
;; Usage: {{query (read-file "queries/library/projects/active-count.clj")}}
;; Count of active projects

{:query [:find (count ?p)
         :where
         [?p :block/properties ?props]
         [(get ?props :type) "project"]
         [(get ?props :status) "active"]]
 :view :text}