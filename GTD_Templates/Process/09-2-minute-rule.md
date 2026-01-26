template:: GTD 2-Minute Rule
description:: Implement the GTD 2-minute rule for quick task processing
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Core GTD principle

# GTD 2-Minute Rule Implementation

## 🎯 The 2-Minute Rule Explained

**GTD Principle:** "If an action will take less than two minutes, do it now."

**Purpose:** Prevent small tasks from clogging your system and reduce processing overhead.

**Benefits:**
- Reduces system clutter
- Increases immediate productivity
- Builds momentum
- Reduces decision fatigue

## 🔄 2-Minute Rule Workflow

### Decision Flowchart
```
Start with task
↓
Will it take <2 minutes?
├── Yes → Do it NOW
│       ↓
│       Mark as DONE
│       ↓
│       Move on
└── No → Process normally
        ↓
        Delegate or defer
        ↓
        Add to appropriate list
```

### Quick Decision Guide
**<2 Minutes (Do Now):**
- Quick email replies
- Simple phone calls
- Filing documents
- Adding calendar events
- Quick data entry
- Basic research lookups

**>2 Minutes (Process Normally):**
- Complex emails
- Detailed reports
- Meetings
- Project work
- Creative tasks
- Learning activities

## ⚡ 2-Minute Rule Template

### Quick Task Assessment
**Task:** {{task-description}}

**2-Minute Check:**
- [ ] **Estimate time:** {{time-estimate|1|2|3|4|5}} minutes
- [ ] **Tools available:** {{tools-available|yes|no}}
- [ ] **Context appropriate:** {{context-appropriate|yes|no}}
- [ ] **Energy sufficient:** {{energy-sufficient|yes|no}}
- [ ] **Priority level:** {{priority|urgent|normal|low}}

**Decision:** {{decision|<2-minutes-do-now|>2-minutes-process}}

### If <2 Minutes: Do It Now
**Action taken:** {{action-taken}}
**Time spent:** {{actual-time}} minutes
**Result:** {{result|completed|partially-done|failed}}
**Completed at:** {{completion-time}}

**Mark as done:**
- [x] {{task-description}}
  completed:: {{now}}
  time-spent:: {{actual-time}}
  via-2-minute-rule:: true

### If >2 Minutes: Process Normally
**Next action defined:**
- TODO {{clear-next-action}}
  processed:: {{now}}
  context:: {{appropriate-context}}
  priority:: {{HIGH|MEDIUM|LOW}}
  time-estimate:: {{realistic-estimate}}
  due-date:: {{appropriate-date}}

## 📋 2-Minute Task Finder

### Current 2-Minute Tasks
{{query (read-file "queries/library/rules/tasks-under-2min.clj")}}}

### Quick Context-Based 2-Minute Tasks
**@computer quick tasks:** {{query (assoc (read-file "queries/library/rules/context-quick-tasks.clj") :title "Quick tasks for @computer") :inputs ["@computer"]}}
**@phone quick tasks:** {{query (assoc (read-file "queries/library/rules/context-quick-tasks.clj") :title "Quick tasks for @phone") :inputs ["@phone"]}}
**@errands quick tasks:** {{query (assoc (read-file "queries/library/rules/context-quick-tasks.clj") :title "Quick tasks for @errands") :inputs ["@errands"]}}

## 🛠️ 2-Minute Rule Tools

### Time Estimation Guide
**30 seconds:**
- Quick reply to simple message
- File single document
- Add calendar appointment
- Check simple fact

**1 minute:**
- Short email response
- Quick phone call
- Basic data entry
- Simple online form

**2 minutes:**
- Brief research lookup
- Short note/document
- Basic calculation
- Simple organization task

### Context-Specific 2-Minute Tasks

#### @computer
- Reply to simple email
- File digital document
- Update spreadsheet cell
- Quick web search
- Bookmark useful page

#### @phone
- Make quick call
- Send brief text
- Check voicemail
- Update contact info
- Schedule appointment

#### @office
- Sign document
- File paper
- Quick chat with colleague
- Update whiteboard
- Organize desk item

#### @home
- Put away item
- Quick clean/tidy
- Water plants
- Check mail
- Simple home fix

#### @errands
- Quick purchase
- Drop off package
- ATM withdrawal
- Return item
- Pick up prescription

## 📊 2-Minute Rule Analytics

### Daily 2-Minute Stats
**Today's 2-minute tasks completed:** {{query {:query [:find (count ?b) :where [?b :block/properties ?props] [(get ?props :via-2-minute-rule) true] [(get ?props :completed) ?completed] [(clojure.string/includes? ?completed "{{today}}")]] :view :text}}}
**Time saved today:** {{time-saved-today}} minutes
**System clutter reduced:** {{clutter-reduced}} tasks

### Weekly 2-Minute Performance
**Total 2-minute tasks completed:** {{total-2-minute-tasks}}
**Average time per task:** {{average-2-minute-time}} minutes
**Time saved this week:** {{time-saved-week}} minutes
**Most productive context:** {{most-productive-context}}

### Benefits Tracking
**System efficiency improvement:** {{efficiency-improvement}}%
**Decision fatigue reduction:** {{fatigue-reduction}}%
**Momentum building score:** {{momentum-score}}/100
**GTD compliance score:** {{gtd-compliance}}%

## 🔄 Integration with GTD Workflow

### Inbox Processing Integration
**During inbox processing:**
1. Review each item
2. Apply 2-minute rule check
3. If <2 minutes → do immediately
4. If >2 minutes → process normally
5. Update statistics

### Daily Review Integration
**Morning review:**
- Check for 2-minute tasks in current context
- Do quick wins to build momentum
- Clear small tasks before deep work

**Evening review:**
- Process any accumulated 2-minute tasks
- Update 2-minute rule statistics
- Plan quick wins for tomorrow

### Weekly Review Integration
**During weekly review:**
- Analyze 2-minute rule effectiveness
- Adjust time estimation accuracy
- Identify patterns in quick tasks
- Optimize context for 2-minute efficiency

## 📱 Mobile Optimization

### Mobile 2-Minute Rule
**Mobile-specific quick tasks:**
- Quick voice memo
- Photo capture for reference
- Location-based reminder
- Contact quick action
- App-specific quick task

### Mobile Features
- **Voice command:** "2-minute task: {{task}}"
- **Camera integration:** Quick photo tasks
- **Location triggers:** Context-aware suggestions
- **Notification prompts:** "Got 2 minutes?"
- **Widget access:** Quick 2-minute task list

### Mobile Settings
```markdown
## Mobile 2-Minute Configuration
enabled:: true
voice-commands:: true
camera-integration:: true
location-triggers:: true
notification-reminders:: true
widget-enabled:: true
```

## ⚙️ Configuration & Customization

### Rule Settings
```markdown
## 2-Minute Rule Configuration
enabled:: true
strict-2-minutes:: true  # Strict 2-minute limit
flexible-mode:: false    # Allow 2-5 minute tasks
auto-detect:: true       # Auto-suggest 2-minute tasks
prompt-during-processing:: true
track-statistics:: true

## Notification Settings
reminder-frequency:: 60  # Minutes between reminders
context-aware:: true
energy-aware:: true
time-of-day-aware:: true
```

### Customization Options
- **Time threshold:** Adjust from 2 to 5 minutes
- **Context filters:** Only show relevant 2-minute tasks
- **Energy filters:** Suggest based on current energy
- **Priority filters:** Focus on high-priority quick tasks
- **Integration level:** How deeply integrated with workflow

## 🔗 Template Integration

### Connected Templates
- **[[GTD Daily Journal]]** - 2-minute task section
- **[[GTD Task Processing]]** - 2-minute rule during processing
- **[[GTD Next Actions Dashboard]]** - Quick tasks view
- **[[GTD Weekly Review]]** - 2-minute rule analytics
- **[[GTD Quick Capture]]** - Immediate 2-minute actions

### Workflow Integration Points
1. **Capture:** Quick capture of 2-minute tasks
2. **Process:** Apply 2-minute rule during clarification
3. **Organize:** Separate 2-minute task list
4. **Review:** Track 2-minute rule effectiveness
5. **Engage:** Do 2-minute tasks in appropriate moments

## ✅ Success Metrics

### 2-Minute Rule Effectiveness
- **Completion rate:** % of 2-minute tasks done immediately
- **Time accuracy:** How accurate are time estimates
- **System reduction:** How much system clutter is reduced
- **Momentum impact:** Does it help build productive momentum
- **Stress reduction:** Does it reduce anxiety about small tasks

### User Experience
- **Ease of use:** How easy to apply the rule
- **Integration:** How well integrated with workflow
- **Awareness:** How aware of 2-minute opportunities
- **Habit formation:** How consistently applied
- **Satisfaction:** User satisfaction with results

## 🆘 Common Issues & Solutions

### Problem: "Everything feels like 2 minutes"
**Solution:** Use time tracking to improve estimation accuracy

### Problem: "2-minute tasks interrupt deep work"
**Solution:** Batch 2-minute tasks between focus sessions

### Problem: "I underestimate task time"
**Solution:** Add buffer (estimate × 1.5) until better at estimating

### Problem: "Mobile 2-minute tasks pile up"
**Solution:** Process mobile captures in dedicated batches

### Problem: "Not sure what qualifies as 2 minutes"
**Solution:** Use the time estimation guide and track actual times

## 📈 Continuous Improvement

### Improvement Process
1. **Track metrics** on 2-minute rule effectiveness
2. **Review accuracy** of time estimates
3. **Adjust thresholds** based on experience
4. **Optimize contexts** for quick tasks
5. **Share insights** with user community

### Advanced Features Roadmap
- **AI time estimation** for new tasks
- **Predictive suggestions** based on patterns
- **Integration with** time tracking apps
- **Advanced analytics** for optimization
- **Team 2-minute rule** for collaboration

## 🎯 Getting Started

### Quick Start Guide
1. **Enable** 2-minute rule in settings
2. **Start small** with 5 tasks per day
3. **Track time** to improve estimation
4. **Review weekly** to adjust approach
5. **Expand gradually** to more contexts

### First Week Focus
- **Day 1-2:** Identify 2-minute tasks in your system
- **Day 3-4:** Practice time estimation
- **Day 5-7:** Integrate into daily workflow
- **Weekend:** Review and adjust settings

### Success Tips
- **Be realistic** about time estimates
- **Start with easy wins** to build habit
- **Use mobile for** on-the-go 2-minute tasks
- **Batch similar** 2-minute tasks together
- **Celebrate small victories** to maintain momentum