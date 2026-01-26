template:: GTD Daily Journal
description:: Daily journal with GTD workflow integration and customizable next actions view
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Guided GTD

# {{date}} - GTD Daily

## 🎯 GTD Morning Review

### 1. Process Inbox
- [ ] Clear physical inbox
- [ ] Process email inbox
- [ ] Process digital captures
- [ ] Empty mental RAM
**Current inbox count:** {{query (read-file "queries/library/capture/inbox-status.clj")}}

### 2. Review Next Actions
**Current Context:** {{current-context|@computer|@phone|@office|@home|@errands}}
**Time Available:** {{available-minutes|15|30|60|120|240}} minutes
**Energy Level:** {{energy-level|high|medium|low}}
**Priority Focus:** {{priority-focus|HIGH|MEDIUM|LOW|ALL}}

### 3. Check Calendar & Waiting For
- [ ] Review today's calendar
- [ ] Check [[GTD Waiting For Dashboard]]
- [ ] Review upcoming deadlines

## 🔥 Next Actions by GTD Criteria

### Customize View
**Number of actions to show:** {{action-count|3|5|7|10}} (Default: 5)
**Sort by:** {{sort-by|priority|due-date|time-estimate|context}}

### Current Context Next Actions ({{action-count}})
{{query {:title "🎯 Next Actions for {{current-context}}"
         :query [:find (pull ?b [:block/content :block/properties])
                 :in $ ?context ?count
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :context) ?ctx]
                 [(= ?ctx ?context)]
                 [(get ?props :status) "not-started"]
                 (not [?b :block/properties ?p2]
                      [(get ?p2 :blocked) true])]
         :inputs [:context :count]
         :limit "{{action-count}}"
         :result-transform (fn [results]
                             (map (fn [r]
                                    {:title (str "• " (:block/content r)
                                               " | Priority: " (get-in r [:block/properties :priority] "MEDIUM")
                                               " | Time: " (get-in r [:block/properties :time-estimate] "?") "min")
                                     :url (str "#" (:block/uuid r))})
                                  results))}}}

**View all next actions →** [[GTD Next Actions Dashboard]]

## ⚡ Quick 2-Minute Tasks
{{query {:title "⚡ Do Now (<2 minutes)"
         :query [:find (pull ?b [:block/content])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :time-estimate) ?est]
                 [(<= ?est 2)]
                 [(get ?props :status) "not-started"]]
         :limit 3
         :result-transform (fn [results]
                             (map (fn [r]
                                    {:title (str "✓ " (:block/content r))
                                     :url (str "#" (:block/uuid r))})
                                  results))}}}

## 📊 GTD System Status

### Quick Stats
- **Inbox:** {{query {:query [:find (count ?b) :where [?b :block/properties ?props] [(get ?props :status) "unprocessed"]] :view :text}}} items (goal: 0)
- **Next Actions:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :status) "not-started"]] :view :text}}} total
- **High Priority:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :priority) "HIGH"] [(get ?props :status) "not-started"]] :view :text}}} tasks
- **Projects:** {{query {:query [:find (count ?p) :where [?p :block/properties ?props] [(get ?props :type) "project"] [(get ?props :status) "active"]] :view :text}}} active
- **Waiting For:** {{query {:query [:find (count ?b) :where [?b :block/properties ?props] [(get ?props :type) "waiting-for"] [(get ?props :status) "waiting"]] :view :text}}} items

### Dashboard Links
📊 **[[GTD Next Actions Dashboard]]** - All next actions by context/priority  
📁 **[[GTD Projects Dashboard]]** - Active projects with next actions  
⏳ **[[GTD Waiting For Dashboard]]** - Delegated items tracking  
📈 **[[GTD Statistics Dashboard]]** - System metrics and trends  
🔍 **[[GTD Weekly Review]]** - Comprehensive weekly review

## 📱 Mobile Context Detection

### Auto-Detected Context (Mobile)
{{if (platform? "mobile")}}
**Detected:** {{auto-context|@computer|@phone|@office|@home|@errands|@commute|@waiting}}
**Confidence:** {{confidence|high|medium|low}}
**Override:** [[Change Context|context-selector]]
{{else}}
**Desktop mode:** Manual context selection
**Current:** {{current-context}}
{{end}}

### Context-Specific Views
- **@computer:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :context) "@computer"] [(get ?props :status) "not-started"]] :view :text}}} tasks → [[@computer tasks]]
- **@phone:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :context) "@phone"] [(get ?props :status) "not-started"]] :view :text}}} tasks → [[@phone tasks]]
- **@errands:** {{query {:query [:find (count ?b) :where [?b :block/marker "TODO"] [?b :block/properties ?props] [(get ?props :context) "@errands"] [(get ?props :status) "not-started"]] :view :text}}} tasks → [[@errands tasks]]

## 🎪 Projects at a Glance

### Active Projects
{{query {:title "Active Projects"
         :query [:find (pull ?p [:block/name :block/properties])
                 :where
                 [?p :block/properties ?props]
                 [(get ?props :type) "project"]
                 [(get ?props :status) "active"]]
         :limit 3
         :result-transform (fn [results]
                             (map (fn [r]
                                    {:title (str "📁 " (:block/name r))
                                     :description (str "Next: " (get-in r [:block/properties :next-action] "Not set"))
                                     :url (str "/page/" (:block/name r))})
                                  results))}}}

**View all projects →** [[GTD Projects Dashboard]]

## 🔄 GTD Workflow Integration

### Capture Throughout Day
**Quick capture to inbox:** [[GTD Quick Capture]]
**Voice memo:** [[Voice Capture]]
**Email processing:** [[Email to Inbox]]

### Processing Reminders
- **2-minute rule:** Do it now if <2 minutes
- **Next action clarity:** Must be specific physical action
- **Context assignment:** Always assign appropriate context
- **Project linkage:** Link to project when applicable

### Review Schedule
- **Daily:** This journal (morning & evening)
- **Weekly:** [[GTD Weekly Review]] ({{next-review-date}})
- **Monthly:** Project and goal review

## 🌙 GTD Evening Review

### 1. Complete & Capture
- [ ] Complete scheduled next actions
- [ ] Capture new items to inbox
- [ ] Process quick 2-minute tasks

### 2. Update & Plan
- [ ] Update [[GTD Next Actions Dashboard]]
- [ ] Process inbox to zero
- [ ] Review tomorrow's calendar
- [ ] Set priorities for tomorrow

### 3. Reflect & Adjust
**Today's accomplishments:**
{{accomplishments}}

**What didn't get done:**
{{carry-forward}}

**Tomorrow's focus:**
{{tomorrow-focus}}

## ⚠️ GTD Compliance Check

### Weekly Review Reminder
{{if (days-since-last-review > 6)}}
🔔 **Weekly Review Due!** Last review: {{last-review-date}}
**Schedule now →** [[GTD Weekly Review]]
{{else}}
✅ **Weekly review on track.** Next due: {{next-review-date}}
{{end}}

### System Health
- [ ] Inbox processed daily
- [ ] Next actions are specific
- [ ] Projects have defined next actions
- [ ] Contexts are appropriate
- [ ] Waiting for items tracked

## 🛠️ Customization Options

### Template Variables
- **action-count:** Number of next actions to show (3-10)
- **current-context:** Filter next actions by context
- **available-minutes:** Time available for task selection
- **energy-level:** Energy-based task filtering
- **priority-focus:** Priority level to emphasize

### Platform-Specific Features
**Mobile:**
- GPS context detection
- Voice capture integration
- Touch-optimized navigation
- Offline next actions list

**Desktop:**
- Advanced query filtering
- Multiple column views
- Keyboard shortcuts
- Export functionality

### Quick Settings
```markdown
## GTD Journal Settings
default-action-count:: 5
default-context:: @computer
show-2-minute-tasks:: true
show-stats:: true
show-projects:: true
weekly-review-reminder:: true
```

## ✅ Success Metrics
- **Inbox Zero:** Achieved daily
- **Next Action Clarity:** Specific physical actions defined
- **Context Accuracy:** Tasks in right contexts
- **Weekly Review:** Completed consistently
- **System Trust:** Relied upon for all commitments