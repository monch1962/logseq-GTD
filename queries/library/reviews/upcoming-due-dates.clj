;; Upcoming Due Dates Query
;; Usage: {{query (read-file "queries/library/reviews/upcoming-due-dates.clj") :inputs [:today :future-date]}}

{:title "📅 Upcoming Due Dates"
 :query [:find ?due (count ?b)
         :in $ ?today ?future-date
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :due-date) ?due]
         [(>= ?due ?today)]
         [(<= ?due ?future-date)]]
 :inputs [:today :future-date]
 :group-by ?due
 :sort-by ?due
 :view :table}