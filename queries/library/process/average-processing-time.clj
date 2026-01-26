;; Average Processing Time Query
;; Usage: {{query (read-file "queries/library/process/average-processing-time.clj")}}
;; Calculates average time between capture and processing

{:title "⏱️ Average Processing Time"
 :query [:find (pull ?b [:block/properties])
         :where
         [?b :block/properties ?props]
         [(get ?props :captured) ?captured]
         [(get ?props :processed) ?processed]
         [(not (nil? ?captured))]
         [(not (nil? ?processed))]]
 :view :table
 :result-transform (fn [result]
                     (let [times (map (fn [b]
                                        (let [props (:block/properties b)
                                              captured (get props :captured)
                                              processed (get props :processed)]
                                          (when (and captured processed)
                                            (try
                                              (let [captured-date (java.time.LocalDate/parse captured)
                                                    processed-date (java.time.LocalDate/parse processed)]
                                                (.between java.time.temporal.ChronoUnit/DAYS captured-date processed-date))
                                              (catch Exception _ nil))))) result)
                           valid-times (filter some? times)
                           avg-time (if (seq valid-times)
                                      (/ (reduce + valid-times) (count valid-times))
                                      0)]
                       [{:average-days (format "%.1f" avg-time)
                         :sample-size (count valid-times)}]))}