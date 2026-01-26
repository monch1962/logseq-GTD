template:: GTD Basic Priority System
description:: Simple HIGH/MEDIUM/LOW priority system with due date integration
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Organize phase - Priority-based task organization and filtering

# GTD Basic Priority System

## 🎯 Priority Framework

### Three Priority Levels
**HIGH:** Must do today/tomorrow, critical consequences if missed
**MEDIUM:** Should do this week, important but not urgent  
**LOW:** Nice to do, no urgency, can wait

### Priority Selection Guide

#### When to use HIGH:
- ⏰ Due today or tomorrow
- 🔥 Critical business impact
- 👥 Others are waiting/dependent
- ⚠️ Legal/regulatory deadlines
- 🚨 Emergency situations

#### When to use MEDIUM:
- 📅 Due this week
- 🎯 Important goals/projects
- 🔄 Regular responsibilities
- 📈 Progress toward objectives
- 🤝 Team commitments

#### When to use LOW:
- 📆 Due next week or later
- ✨ Improvement ideas
- 🎨 Creative projects
- 📚 Learning goals
- 🏡 Personal development

## 📝 Priority Assignment Template

### Simple Priority Assignment
priority:: {{HIGH|MEDIUM|LOW}}
due-date:: {{yyyy-mm-dd}}
urgency:: {{today|this-week|next-week|later}}

### Detailed Priority Assignment
**Task:** {{task-description}}

**Priority Factors:**
- Business Impact: {{high|medium|low}}
- Time Sensitivity: {{urgent|soon|flexible}}
- Dependencies: {{blocked|unblocked}}
- Effort Required: {{high|medium|low}}

**Assigned Priority:** {{HIGH|MEDIUM|LOW}}
**Due Date:** {{yyyy-mm-dd}}
**Review Date:** {{review-before-due}}

## 📊 Priority Dashboard

### High Priority Tasks
{{query {:title "🔥 HIGH Priority - Due Soon"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :priority) "HIGH"]
                 [(get ?props :due-date) ?due]
                 [(<= ?due "{{today-plus-3}}")]]
         :limit 10}}}

### Medium Priority Tasks  
{{query {:title "🎯 MEDIUM Priority - This Week"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :priority) "MEDIUM"]
                 [(get ?props :due-date) ?due]
                 [(<= ?due "{{today-plus-7}}")]]
         :limit 10}}}

### Overdue Tasks
{{query {:title "⚠️ Overdue Tasks"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :due-date) ?due]
                 [(< ?due "{{today}}")]]
         :limit 10}}}

## 🛠️ Priority Tools

### Priority Calculator
**Answer these questions:**

1. **Consequences if not done?**
   - Critical = HIGH
   - Significant = MEDIUM  
   - Minor = LOW

2. **Time sensitivity?**
   - Today = HIGH
   - This week = MEDIUM
   - Later = LOW

3. **Dependencies?**
   - Blocking others = HIGH
   - Part of chain = MEDIUM
   - Independent = LOW

4. **Effort vs Impact?**
   - High impact, low effort = HIGH
   - Medium both = MEDIUM
   - Low impact, high effort = LOW

**Result:** {{calculated-priority}}

### Due Date Helper
{{query {:title "📅 Upcoming Due Dates"
         :query [:find ?due (count ?b)
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :due-date) ?due]
                 [(>= ?due "{{today}}")]
                 [(<= ?due "{{today-plus-14}}")]]
         :group-by ?due
         :sort-by ?due
         :view :table}}}

## 🔄 Priority Review System

### Daily Priority Check
**Morning Review:**
1. Review HIGH priority tasks
2. Check due dates for today
3. Adjust priorities if needed
4. Schedule time for HIGH tasks

**Evening Review:**
1. Complete HIGH priority tasks
2. Move completed tasks
3. Review tomorrow's HIGH priorities
4. Adjust MEDIUM/LOW as needed

### Weekly Priority Audit
{{query {:title "📊 Weekly Priority Distribution"
         :query [:find ?priority (count ?b)
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :priority) ?priority]]
         :group-by ?priority
         :view :table}}}

## ⚠️ Common Priority Mistakes

### Mistake 1: Everything is HIGH
**Solution:** Use the 2×2 matrix
- High Impact, High Urgency = HIGH
- High Impact, Low Urgency = MEDIUM
- Low Impact, High Urgency = MEDIUM
- Low Impact, Low Urgency = LOW

### Mistake 2: No due dates
**Solution:** Always assign a due date
- Real deadline = actual date
- No deadline = 2 weeks default
- Someday = no due date, LOW priority

### Mistake 3: Not reviewing priorities
**Solution:** Daily/Weekly review
- Priorities change with circumstances
- Re-evaluate based on new information
- Adjust as projects progress

### Mistake 4: Ignoring dependencies
**Solution:** Consider blocking status
- Blocked tasks = lower effective priority
- Unblock tasks first
- Consider chain dependencies

## 📝 Example Priority Assignments

### Example 1: Urgent Business Task
```
Task: Submit quarterly report to regulator
Priority Factors:
- Business Impact: HIGH (legal requirement)
- Time Sensitivity: HIGH (due tomorrow)
- Dependencies: None
- Effort Required: MEDIUM (2 hours)
Assigned Priority: HIGH
Due Date: 2024-01-31
```

### Example 2: Important Project Task
```
Task: Draft project proposal for new client
Priority Factors:
- Business Impact: HIGH (new revenue)
- Time Sensitivity: MEDIUM (due next week)
- Dependencies: Need input from team
- Effort Required: HIGH (8 hours)
Assigned Priority: MEDIUM
Due Date: 2024-02-07
```

### Example 3: Personal Development
```
Task: Read new programming book
Priority Factors:
- Business Impact: LOW (skill improvement)
- Time Sensitivity: LOW (no deadline)
- Dependencies: None
- Effort Required: MEDIUM (10 hours total)
Assigned Priority: LOW
Due Date: 2024-03-01
```

## 🔧 Priority Customization

### Add Custom Priority Factors
- **stakeholder-importance::** {{high|medium|low}}
- **strategic-alignment::** {{core|supportive|peripheral}}
- **visibility::** {{high|medium|low}}
- **learning-value::** {{high|medium|low}}

### Priority Shortcuts
- **H** = HIGH, **M** = MEDIUM, **L** = LOW
- **T** = Today, **W** = This Week, **N** = Next Week
- **Auto-priority:** `priority:: {{auto-calculate}}`

## ✅ Success Metrics
- **Priority Accuracy:** Tasks feel correctly prioritized
- **Due Date Realism:** 90% of tasks completed on time
- **Priority Distribution:** Balanced HIGH/MEDIUM/LOW mix
- **Review Consistency:** Daily priority check completed
- **Adjustment Frequency:** Priorities updated as needed