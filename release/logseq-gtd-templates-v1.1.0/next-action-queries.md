# Next Action Queries for Logseq GTD

## 1. Basic Next Action Query by Context

```clojure
#+BEGIN_QUERY
{:title "📱 Next Actions: {{context}}"
 :query [:find (pull ?b [*])
         :in $ ?context
         :where
         [?b :block/marker ?marker]
         [(contains? #{"TODO" "DOING" "NOW"} ?marker)]
         [?b :block/refs ?tag]
         [?tag :block/name ?context]
         (not [?b :block/refs ?dep]
              [?dep :block/marker "TODO"]) ; Not blocked
         ]
 :inputs [:context]}
#+END_QUERY
```

## 2. Priority-Based Next Actions

```clojure
#+BEGIN_QUERY
{:title "🔥 High Priority Tasks"
 :query [:find (pull ?b [*])
         :where
         [?b :block/marker "TODO"]
         [?b :block/priority "A"]
         [?b :block/page ?page]
         [?page :block/journal? true]
         [?page :block/journal-day ?date]
         [(<= ?date (today))]]
 :result-transform (fn [result]
                     (sort-by :block/priority result))}
#+END_QUERY
```

## 3. Time-Based Task Selection

```clojure
#+BEGIN_QUERY
{:title "⏰ Tasks for {{time}} minutes"
 :query [:find (pull ?b [*])
         :in $ ?available-minutes
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :time-estimate) ?time-estimate]
         [(<= ?time-estimate ?available-minutes)]
         (not [?b :block/properties ?p2]
              [(get ?p2 :blocked) true])]
 :inputs [:available-minutes]}
#+END_QUERY
```

## 4. Energy Level Matching

```clojure
#+BEGIN_QUERY
{:title "⚡ {{energy-level}} Energy Tasks"
 :query [:find (pull ?b [*])
         :in $ ?energy
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :energy) ?task-energy]
         [(= ?task-energy ?energy)]
         [?b :block/priority ?priority]
         [(contains? #{"A" "B"} ?priority)]]
 :inputs [:energy]}
#+END_QUERY
```

## 5. Comprehensive Smart Next Action

```clojure
#+BEGIN_QUERY
{:title "🤖 Smart Next Action"
 :query [:find (pull ?b [*])
         :in $ ?context ?time ?energy
         :where
         [?b :block/marker "TODO"]
         
         ; Context match
         (or-join [?b ?context]
           [?b :block/refs ?tag]
           [?tag :block/name ?context]
           [?b :block/properties ?props]
           [(get ?props :context) ?context])
         
         ; Time estimate within available
         [?b :block/properties ?props2]
         [(get ?props2 :time-estimate) ?est]
         [(<= ?est ?time)]
         
         ; Energy match
         [(get ?props2 :energy) ?e]
         [(= ?e ?energy)]
         
         ; Not overdue by more than 3 days
         (or-join [?b]
           (not [?b :block/properties ?p3]
                [(get ?p3 :due-date) ?due])
           (and [?b :block/properties ?p4]
                [(get ?p4 :due-date) ?due2]
                [(> (days-between (today) ?due2) -3)]))
         
         ; Not blocked
         (not [?b :block/refs ?dep]
              [?dep :block/marker "TODO"])]
 :inputs [:context :time :energy]
 :result-transform (fn [results]
                     (->> results
                          (sort-by (fn [b]
                                     [(get-in b [:block/priority] "C")
                                      (get-in b [:block/properties :due-date] "9999-12-31")]))))}
#+END_QUERY
```

## 6. Due Today with Priority

```clojure
#+BEGIN_QUERY
{:title "📅 Due Today"
 :query [:find (pull ?b [*])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :due-date) ?due]
         [(= ?due (today))]
         ]
 :result-transform (fn [results]
                     (sort-by (fn [b]
                                [(get-in b [:block/priority] "C")
                                 (get-in b [:block/properties :time-estimate] 999)]) results))}
#+END_QUERY
```

## 7. Blocked Tasks Report

```clojure
#+BEGIN_QUERY
{:title "🚧 Blocked Tasks"
 :query [:find (pull ?b [*])
         :where
         [?b :block/marker "TODO"]
         [?b :block/refs ?dep]
         [?dep :block/marker "TODO"]
         ]
 :result-transform (fn [results]
                     (map (fn [b]
                            (assoc b :block/dependencies
                                   (find-dependencies b))) results))}
#+END_QUERY
```

## Usage Instructions:

1. Copy queries to your Logseq journal or query page
2. Customize context tags, priorities, and properties to match your system
3. Use query inputs for dynamic filtering
4. Create dashboard pages with multiple queries for different contexts

## Query Input Values:

### Contexts:
- `context/office`
- `context/home`
- `context/errand`
- `context/computer`
- `context/phone`

### Time Estimates (minutes):
- `5`, `15`, `30`, `60`, `120`

### Energy Levels:
- `high`, `medium`, `low`
