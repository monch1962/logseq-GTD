;; Waiting For Active Items Count Query
;; Usage: {{query (read-file "queries/library/dashboard/waiting-active-count.clj")}}
;; Count of active waiting-for items

{:query [:find (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :type) "waiting-for"]
         [(get ?props :status) "waiting"]]
 :view :text}
