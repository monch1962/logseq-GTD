;; Inbox Status Query
;; Usage: {{query (read-file "queries/library/capture/inbox-status.clj")}}
;; Count of unprocessed items in inbox

{:query [:find (count ?b)
         :where
         [?b :block/properties ?props]
         [(get ?props :status) "unprocessed"]]
 :view :text}