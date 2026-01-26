template:: GTD Daily Journal (Mobile Optimized)
description:: Simplified mobile daily journal with GTD workflow
version:: 1.1
compatibility:: Logseq mobile (optimized)
gtd-compliance:: Guided GTD
performance-optimized:: true
cache-enabled:: true
cache-ttl:: 900
lazy-loading:: enabled
mobile-optimized:: true
battery-optimized:: true
touch-friendly:: true
offline-support:: true

# {{date}} - GTD Daily (Mobile)

## 📱 Mobile Morning Review

### 1. Quick Inbox Check
- [ ] Check mobile notifications
- [ ] Review voice memos
- [ ] Scan photos/captures
**Inbox:** {{query (read-file "queries/library/capture/inbox-status.clj") :limit 1}}

### 2. Mobile Context
**Where am I:** {{location|@phone|@home|@errands|@office}}
**Time available:** {{minutes|5|15|30|60}}
**Battery level:** {{battery|high|medium|low|critical}}

### 3. Quick Calendar
- [ ] Check next appointment
- [ ] Review time-sensitive items
- [ ] Set mobile reminders

## 🎯 Mobile Next Actions

### Quick Actions ({{count|3}})
{{query {:title "📱 Mobile Actions"
         :query [:find (pull ?b [:block/content :block/properties])
                 :in $ ?context ?count
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :context) ?ctx]
                 [(= ?ctx ?context)]
                 [(get ?props :time-estimate) ?time]
                 [(<= ?time 30)]  ;; Max 30 minutes for mobile
                 :limit ?count]
         :inputs [:context :count]
         :limit "{{count}}"
         :cache-enabled true
         :cache-key "mobile-actions-{{context}}-{{count}}"
         :cache-ttl 300
         :result-transform (fn [results]
                             (if (empty? results)
                               "No quick actions available"
                               (str "**Quick Actions:**\n\n"
                                    (clojure.string/join "\n"
                                      (map (fn [r]
                                             (str "• " (:block/content r)
                                                  " [" (get-in r [:block/properties :time-estimate] "?") "min]"))
                                           results)))))}}}

## 📝 Mobile Capture

### Quick Notes
```markdown
## 📝 Mobile Note
- {{note}}
  captured:: {{now}}
  location:: {{location}}
  type:: note
  
  **Context:**
  {{context}}
```

### Voice Memo
```markdown
## 🎤 Voice Memo
- {{topic}}
  captured:: {{now}}
  type:: voice-memo
  duration:: {{duration}}
  transcribed:: false
  
  **Summary:**
  {{summary}}
```

### Photo Capture
```markdown
## 📸 Photo Note
- {{subject}}
  captured:: {{now}}
  type:: photo
  location:: {{location}}
  
  **Description:**
  {{description}}
```

## 🔄 Mobile Processing

### Quick Process Inbox
1. **<2 minutes:** Do it now
2. **Delegate:** Add to waiting for
3. **Defer:** Schedule for later
4. **File:** Add to references
5. **Trash:** Delete if not needed

### Mobile Waiting For
```markdown
## ⏳ Mobile Waiting
- {{item}}
  type:: waiting-for
  from:: {{person}}
  follow-up:: {{date}}
  
  **Mobile reminder:**
  {{reminder}}
```

## 📊 Mobile Review

### End of Day Check
- [ ] Process mobile captures
- [ ] Review completed actions
- [ ] Plan tomorrow's mobile tasks
- [ ] Charge device for tomorrow

### Weekly Mobile Sync
- **Monday:** Review mobile captures
- **Wednesday:** Clean up photos/voice memos
- **Friday:** Sync with desktop system
- **Sunday:** Plan mobile week ahead

## ⚙️ Mobile Settings

```markdown
## Mobile Daily Journal Settings
### Performance
cache-ttl:: 900
query-limit:: 3
offline-mode:: true
auto-sync:: wifi-only

### Display
theme:: auto
font-size:: medium
show-images:: false
haptic-feedback:: true

### Battery
low-battery-mode:: auto
critical-battery-limit:: 20%
power-saver-query-limit:: 1
```

## 🛠️ Mobile Tools

### Quick Templates
- **Meeting notes:** [[Mobile Meeting Template]]
- **Shopping list:** [[Mobile Shopping Template]]
- **Travel notes:** [[Mobile Travel Template]]
- **Health tracking:** [[Mobile Health Template]]

### Mobile Integrations
- **Calendar:** Check appointments
- **Contacts:** Quick delegation
- **Camera:** Document capture
- **Voice recorder:** Memos

## 📈 Mobile Metrics

### Daily Usage
- **Capture time:** <2 minutes
- **Review time:** <5 minutes
- **Processing time:** <10 minutes
- **Battery impact:** <2% per day

### Success Indicators
- **Inbox zero:** Daily achievement
- **Action completion:** >80%
- **System trust:** High confidence
- **Stress reduction:** Noticeable

## 🔗 Mobile Workflow

### Morning Routine (5 min)
1. Check inbox
2. Set context
3. Pick 3 actions
4. Start day

### Throughout Day
1. Quick captures
2. Context switches
3. Micro-processing
4. Progress updates

### Evening Routine (5 min)
1. Process captures
2. Review completed
3. Plan tomorrow
4. Charge device

## 🎯 Mobile GTD Principles

### Simplified for Mobile
1. **Capture:** Anything that grabs attention
2. **Clarify:** Quick 2-minute rule
3. **Organize:** Simple categories
4. **Reflect:** Daily quick review
5. **Engage:** Context-based action

### Mobile Constraints
- **Screen size:** Limited real estate
- **Battery:** Finite power
- **Attention:** Frequent interruptions
- **Connectivity:** Variable signal

## ✅ Mobile Implementation

### Setup Checklist
- [ ] Configure mobile settings
- [ ] Test quick capture
- [ ] Verify offline mode
- [ ] Set up sync schedule
- [ ] Train muscle memory

### Usage Tips
1. **On the go:** Use voice capture
2. **Low signal:** Work offline
3. **Short breaks:** Process 2-minute items
4. **Waiting time:** Review next actions
5. **End of day:** Quick cleanup

---
*Mobile-optimized version of GTD Daily Journal*
*Version: 1.1 | Last updated: January 2026*
*Compatibility: Logseq Mobile 0.9.0+*