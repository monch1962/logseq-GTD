;; Cached version of next actions by priority query
;; Uses caching to improve performance, especially on mobile

{:query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :priority) ?priority]
         [(get ?props :status) "not-started"]
         [(= ?priority "{{priority}}")]
         ;; Optional context filter
         [(if (= "{{context}}" ":context")
            true
            [(get ?props :context) "{{context}}"])]
         :limit {{limit}}]
 
 ;; Cache configuration
 :cache-enabled true
 :cache-key "next-actions-{{priority}}-{{context}}-{{limit}}"
 :cache-ttl 300  ;; 5 minutes
 :mobile-ttl 600  ;; 10 minutes on mobile (battery optimization)
 
 ;; Performance optimization
 :result-transform (fn [results]
                     (if (empty? results)
                       "No next actions found"
                       (str "**{{title}}**\n\n"
                            (clojure.string/join "\n"
                              (map (fn [block]
                                     (let [content (:block/content block)
                                           props (:block/properties block)]
                                       (str "- " content
                                            (when-let [context (get props :context)]
                                              (str " (" context ")"))
                                            (when-let [time (get props :time-estimate)]
                                              (str " [" time "min]")))))
                                   results)))))
 
 :view :hiccup}