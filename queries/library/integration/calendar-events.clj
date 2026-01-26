;; Calendar Events Query
;; Usage: {{query (assoc (read-file "queries/library/integration/calendar-events.clj")
;;                       :title "📅 {{period}} Events")
;;         :inputs ["{{period}}"]}
;; Shows calendar events for a specific period

{:title "📅 Calendar Events"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/properties ?props]
         [(get ?props :source) "calendar"]
         [(get ?props :event-date) ?date]
         [(clojure.string/includes? ?date "{{period}}")]]
 :view :table
 :result-transform (fn [result]
                     (map (fn [b]
                            (let [content (:block/content b)
                                  props (:block/properties b)]
                              {:event (if (string? content) content "No content")
                               :date (get props :event-date)
                               :time (get props :event-time)
                               :location (get props :location)})) result))}