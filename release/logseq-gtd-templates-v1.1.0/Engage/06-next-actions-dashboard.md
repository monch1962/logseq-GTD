template:: GTD Next Actions Dashboard
description:: Comprehensive view of all next actions with GTD filtering by context, time, energy, and priority
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Guided GTD

# GTD Next Actions Dashboard

## 🎯 Dashboard Overview

**Purpose:** View all next actions filtered by GTD criteria (context, time, energy, priority)  
**GTD Principle:** Do the right work at the right time with what you have  
**Navigation:** ← Back to [[{{yesterday}}|{{today}}|{{tomorrow}}]]

## 🔄 GTD Filter Controls

### Filter Settings
**Current Context:** {{filter-context|@computer|@phone|@office|@home|@errands|@all}}
**Time Available:** {{filter-time|15|30|60|120|240|all}} minutes
**Energy Level:** {{filter-energy|high|medium|low|all}}
**Priority Level:** {{filter-priority|HIGH|MEDIUM|LOW|all}}
**Show Count:** {{show-count|5|10|20|50|all}}

### Quick Filter Presets
- **🔥 Focus Mode:** @computer, 60min, high energy, HIGH priority
- **📱 Quick Tasks:** @phone, 15min, any energy, MEDIUM+ priority  
- **🏠 Home Mode:** @home, 120min, medium energy, any priority
- **🛒 Errand Mode:** @errands, 30min, any energy, any priority
- **🔍 Review All:** all contexts, all times, all energies, all priorities

## 📋 Next Actions by Priority

### 🔥 HIGH Priority Next Actions
{{query (assoc (read-file "queries/library/next-actions/by-priority.clj")
               :title "HIGH Priority ({{filter-context}})"
               :limit "{{show-count}}")
        :inputs ["HIGH" :context]}}

### 🎯 MEDIUM Priority Next Actions
{{query (assoc (read-file "queries/library/next-actions/by-priority.clj")
               :title "MEDIUM Priority ({{filter-context}})"
               :limit "{{show-count}}")
        :inputs ["MEDIUM" :context]}}

### 📋 LOW Priority Next Actions
{{query (assoc (read-file "queries/library/next-actions/by-priority.clj")
               :title "LOW Priority ({{filter-context}})"
               :limit "{{show-count}}")
        :inputs ["LOW" :context]}}

## ⏰ Time-Based Next Actions

### Quick Tasks (<15 minutes)
{{query {:title "⚡ Quick Tasks (<15min)"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :time-estimate) ?est]
                 [(<= ?est 15)]
                 [(get ?props :status) "not-started"]
                 [(get ?props :context) "{{filter-context}}"]
                 (not [?b :block/properties ?p2]
                      [(get ?p2 :blocked) true])]
         :limit 5}}}

### Focus Sessions (30-60 minutes)
{{query {:title "🎯 Focus Sessions (30-60min)"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :time-estimate) ?est]
                 [(>= ?est 30)]
                 [(<= ?est 60)]
                 [(get ?props :status) "not-started"]
                 [(get ?props :context) "{{filter-context}}"]
                 (not [?b :block/properties ?p2]
                      [(get ?p2 :blocked) true])]
         :limit 5}}}

## ⚡ Energy-Based Next Actions

### High Energy Tasks
{{query {:title "⚡ High Energy Tasks"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :energy) "high"]
                 [(get ?props :status) "not-started"]
                 [(get ?props :context) "{{filter-context}}"]
                 (not [?b :block/properties ?p2]
                      [(get ?p2 :blocked) true])]
         :limit 5}}}

### Low Energy Tasks
{{query {:title "😴 Low Energy Tasks"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :energy) "low"]
                 [(get ?props :status) "not-started"]
                 [(get ?props :context) "{{filter-context}}"]
                 (not [?b :block/properties ?p2]
                      [(get ?p2 :blocked) true])]
         :limit 5}}}

## 📍 Context-Specific Views

### All Contexts Overview
{{query {:title "📊 Tasks by Context"
         :query [:find ?context (count ?b)
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :context) ?context]
                 [(get ?props :status) "not-started"]]
         :group-by ?context
         :sort-by (count ?b)
         :sort-dir :desc
         :view :table}}}

### Quick Context Links
- **@computer:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :context) "@computer"] [(get ?props :status) "not-started"]] :view :text}}} tasks → [[@computer tasks]]
- **@phone:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :context) "@phone"] [(get ?props :status) "not-started"]] :view :text}}} tasks → [[@phone tasks]]
- **@office:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :context) "@office"] [(get ?props :status) "not-started"]] :view :text}}} tasks → [[@office tasks]]
- **@home:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :context) "@home"] [(get ?props :status) "not-started"]] :view :text}}} tasks → [[@home tasks]]
- **@errands:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :context) "@errands"] [(get ?props :status) "not-started"]] :view :text}}} tasks → [[@errands tasks]]

## ⚠️ GTD Compliance Checks

### Next Action Quality Check
{{query {:title "⚠️ Vague Next Actions (Needs Clarification)"
         :query [:find (pull ?b [:block/content])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :status) "not-started"]
                 ; Check for vague action verbs
                 [(clojure.string/includes? (:block/content ?b) "work on")]
                 [(clojure.string/includes? (:block/content ?b) "look into")]
                 [(clojure.string/includes? (:block/content ?b) "think about")]]
         :limit 5
         :result-transform (fn [results]
                             (map (fn [r]
                                    {:title (str "❌ " (:block/content r))
                                     :description "Make more specific: Use clear action verbs"
                                     :url (str "#" (:block/uuid r))})
                                  results))}}}

### Missing Contexts
{{query {:title "⚠️ Tasks Without Context"
         :query [:find (pull ?b [:block/content])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :status) "not-started"]
                 (not [?b :block/properties ?p2]
                      [(get ?p2 :context)])]
         :limit 5}}}

### Blocked Tasks
{{query {:title "🚧 Blocked Tasks"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :status) "not-started"]
                 [(get ?props :blocked) true]]
         :limit 5}}}

## 📊 Dashboard Statistics

### Next Actions Summary
- **Total Next Actions:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :status) "not-started"]] :view :text}}}
- **High Priority:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :priority) "HIGH"] [(get ?props :status) "not-started"]] :view :text}}}
- **Due Today:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :due-date) "{{today}}"] [(get ?props :status) "not-started"]] :view :text}}}
- **Overdue:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :due-date) ?due] [(< ?due "{{today}}")] [(get ?props :status) "not-started"]] :view :text}}}

### Context Distribution
{{query {:title "📈 Context Distribution"
         :query [:find ?context (count ?b)
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :context) ?context]
                 [(get ?props :status) "not-started"]]
         :group-by ?context
         :sort-by (count ?b)
         :sort-dir :desc
         :view :chart}}}

### Priority Distribution
{{query {:title "📊 Priority Distribution"
         :query [:find ?priority (count ?b)
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :priority) ?priority]
                 [(get ?props :status) "not-started"]]
         :group-by ?priority
         :sort-by ?priority
         :view :chart}}}

## 🛠️ Dashboard Tools

### Quick Actions
- **Add Next Action:** [[GTD Task Processing]]
- **Process Inbox:** [[GTD Quick Capture]]
- **Review Projects:** [[GTD Projects Dashboard]]
- **Weekly Review:** [[GTD Weekly Review]]

### Export Options
- **CSV Export:** Next actions list
- **PDF Report:** Dashboard summary
- **Calendar Sync:** Due dates to calendar
- **Mobile View:** Optimized for phone

### Settings
```markdown
## Dashboard Settings
default-context:: @computer
default-show-count:: 10
show-statistics:: true
show-compliance-checks:: true
auto-refresh:: false
mobile-optimized:: true
```

## 📱 Mobile Optimization

### Touch-Friendly Navigation
- **Large buttons** for context selection
- **Swipe gestures** between views
- **Voice commands** for quick filtering
- **Offline access** to filtered lists

### Mobile-Specific Features
- **GPS context detection** (auto-suggest context)
- **Voice capture** of next actions
- **Notification integration** for due tasks
- **Quick widget** for top 3 next actions

### Performance Optimization
- **Lazy loading** of query results
- **Cached filters** for faster switching
- **Progressive enhancement** based on device
- **Offline fallback** for basic functionality

## 🔗 Related Dashboards

### GTD System Integration
📁 **[[GTD Projects Dashboard]]** - Projects with next actions  
⏳ **[[GTD Waiting For Dashboard]]** - Delegated items tracking  
📈 **[[GTD Statistics Dashboard]]** - System metrics and trends  
🔍 **[[GTD Weekly Review]]** - Comprehensive weekly review  
📥 **[[GTD Inbox]]** - Capture and processing

### Quick Navigation
← **Back to Journal:** [[{{yesterday}}|{{today}}|{{tomorrow}}]]  
🏠 **Home:** [[GTD Daily Journal]]  
⚙️ **Settings:** [[GTD System Settings]]  
🆘 **Help:** [[GTD User Guide]]

## ✅ GTD Success Indicators
- **Next Action Clarity:** Specific physical actions defined
- **Context Accuracy:** Tasks in appropriate contexts  
- **Priority Realism:** True urgency reflected in priorities
- **Time Estimates:** Realistic completion times
- **System Trust:** Relied upon for task management