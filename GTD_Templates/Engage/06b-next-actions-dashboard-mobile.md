template:: GTD Next Actions Dashboard (Mobile Optimized)
description:: Simplified mobile view of next actions with GTD filtering
version:: 1.1
compatibility:: Logseq mobile (optimized)
gtd-compliance:: Guided GTD
performance-optimized:: true
cache-enabled:: true
cache-ttl:: 600
lazy-loading:: enabled
mobile-optimized:: true
battery-optimized:: true
touch-friendly:: true
offline-support:: true

# GTD Next Actions (Mobile)

## 📱 Mobile Dashboard

**Purpose:** Quick action selection on mobile  
**Optimized for:** Touch, battery, offline use  
**Data usage:** Minimal queries, aggressive caching  
**Navigation:** ← Back to [[GTD Daily Journal (Mobile)]]

## 🔄 Mobile Filter

### Quick Context
**Where am I:** {{context|@phone|@home|@errands|@office|@all}}
**Time available:** {{minutes|5|15|30|60|all}}
**Battery level:** {{battery|high|medium|low|critical}}

### Mobile Presets
- **📱 Phone Tasks:** @phone, 15min, any battery
- **🏠 Home Tasks:** @home, 30min, medium+ battery
- **🛒 Errands:** @errands, 60min, any battery
- **⚡ Quick Pick:** Any context, 5min, any battery

## 🎯 Mobile Next Actions

### Quick Actions ({{count|3}})
{{query (assoc (read-file "queries/library/next-actions/by-priority-cached.clj")
               :title "📱 Quick Actions"
               :limit "{{count}}"
               :cache-ttl 600
               :mobile-ttl 1200)
        :inputs ["{{priority|HIGH|MEDIUM|LOW|all}}" "{{context}}"]}}

### By Time Estimate
**<5 minutes:** {{query {:title "⚡ Micro Tasks"
                        :query [:find (pull ?b [:block/content :block/properties])
                                :where
                                [?b :block/marker "TODO"]
                                [?b :block/properties ?props]
                                [(get ?props :context) "{{context}}"]
                                [(get ?props :time-estimate) ?time]
                                [(<= ?time 5)]
                                :limit 3]
                        :cache-enabled true
                        :cache-key "micro-tasks-{{context}}"
                        :cache-ttl 300}}}

**5-15 minutes:** {{query {:title "📱 Quick Tasks"
                          :query [:find (pull ?b [:block/content :block/properties])
                                  :where
                                  [?b :block/marker "TODO"]
                                  [?b :block/properties ?props]
                                  [(get ?props :context) "{{context}}"]
                                  [(get ?props :time-estimate) ?time]
                                  [(> ?time 5)]
                                  [(<= ?time 15)]
                                  :limit 3]
                          :cache-enabled true
                          :cache-key "quick-tasks-{{context}}"
                          :cache-ttl 300}}}

## 📝 Mobile Action Tools

### Start Task (Mobile)
```markdown
## ▶️ Started: {{task}}
started:: {{now}}
context:: {{context}}
battery-before:: {{battery-level}}
location:: {{location}}

**Notes:**
{{notes}}
```

### Complete Task (Mobile)
```markdown
## ✅ Completed: {{task}}
completed:: {{now}}
time-taken:: {{minutes}} minutes
battery-after:: {{battery-level}}
satisfaction:: {{1-5}}

**Reflection:**
{{reflection}}
```

### Defer Task (Mobile)
```markdown
## ⏸️ Deferred: {{task}}
deferred:: {{now}}
reason:: {{battery|time|location|priority|energy}}
new-time:: {{new-time}}
reminder:: {{reminder}}
```

## ⚙️ Mobile Settings

```markdown
## Mobile Actions Settings
### Performance
cache-ttl:: 600
query-limit:: 3
offline-cache:: true
sync-interval:: 900  ;; 15 minutes

### Display
show-priority:: true
show-time-estimate:: true
show-context:: true
touch-target-size:: large

### Battery
low-battery-limit:: 30%
critical-battery-limit:: 15%
power-saver-mode:: auto
```

## 🔋 Battery Optimization

### Power Saver Mode
- **>50% battery:** Normal operation
- **30-50% battery:** Reduced queries
- **15-30% battery:** Cached data only
- **<15% battery:** Read-only mode

### Battery-Aware Caching
```clojure
(defn mobile-cache-ttl [base-ttl battery-level]
  (cond
    (> battery-level 50) base-ttl
    (> battery-level 30) (* base-ttl 2)
    (> battery-level 15) (* base-ttl 3)
    :else (* base-ttl 4)))  ;; Longer TTL when battery low
```

## 📊 Mobile Metrics

### Performance Tracking
- **Load time:** {{load-time}}s (target: <1s)
- **Memory usage:** {{memory}}MB (target: <50MB)
- **Cache hit rate:** {{hit-rate}}% (target: >80%)
- **Battery impact:** {{battery-impact}}/100

### Usage Statistics
- **Daily opens:** {{opens}}
- **Actions completed:** {{completed}}
- **Average time:** {{avg-time}} minutes
- **Success rate:** {{success-rate}}%

## 🛠️ Mobile Features

### Touch Optimization
- **Large buttons:** Easy tapping
- **Swipe actions:** Complete/defer
- **Haptic feedback:** Confirmation
- **Gesture shortcuts:** Quick filters

### Offline Support
- **Cached actions:** Available offline
- **Local updates:** Sync when online
- **Progress tracking:** Works without signal
- **Battery saving:** No network calls

### Voice Integration
- **Voice commands:** "Complete task X"
- **Voice capture:** "Add task about Y"
- **Voice search:** "Find phone tasks"
- **Voice reminders:** "Remind me at 3pm"

## 🔗 Mobile Workflow

### Quick Action Selection
1. **Check context:** Where am I?
2. **Check battery:** How much power?
3. **Check time:** How many minutes?
4. **Pick action:** Do it now

### Mobile Processing
1. **<2 minutes:** Do immediately
2. **2-5 minutes:** Consider battery
3. **5+ minutes:** Schedule properly
4. **Delegation:** Add to waiting for

### End of Session
1. **Update status:** Complete/defer
2. **Record time:** Track duration
3. **Note battery:** Monitor impact
4. **Sync data:** When connected

## ✅ Mobile Implementation

### Setup Checklist
- [ ] Configure mobile settings
- [ ] Test touch interactions
- [ ] Verify offline mode
- [ ] Set battery limits
- [ ] Train voice commands

### Usage Tips
1. **On the go:** Use voice commands
2. **Low battery:** Enable power saver
3. **No signal:** Work offline
4. **Quick breaks:** Pick micro tasks
5. **Waiting time:** Review actions

---
*Mobile-optimized version of GTD Next Actions Dashboard*
*Version: 1.1 | Last updated: January 2026*
*Compatibility: Logseq Mobile 0.9.0+*