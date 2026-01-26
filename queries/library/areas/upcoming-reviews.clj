;; Upcoming Area Reviews Query
;; Usage: {{query (read-file "queries/library/areas/upcoming-reviews.clj")}}
;; Shows areas with upcoming review dates

{:title "Upcoming Area Reviews"
 :query [:find (pull ?b [*])
         :where
         [?b :block/name ?name]
         [(clojure.string/includes? ?name "Area/")]
         [?b :block/properties ?props]
         [(get ?props :type) ?type]
         [(= ?type "area-of-responsibility")]
         [(get ?props "next-review") ?review-date]
         [(> ?review-date "{{today}}")]]
 :view :table
 :result-transform (fn [result]
                     (sort-by (fn [b]
                                (get (:block/properties b) "next-review"))
                              result))}