template:: GTD Context Manager
description:: Context management with MRU dropdowns and creation prompts
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Organize phase - Context-based task organization and filtering

# GTD Context Manager

## 🎯 What are Contexts?

Contexts define **where** or **with what** you can do a task. They help you:
- Filter tasks to match your current situation
- Reduce decision fatigue
- Increase productivity by batching similar tasks
- Work effectively in different locations

## 🏷️ Default Contexts

### Core Contexts (Recommended)
**@computer:** Any computer-based work
**@phone:** Calls, messages, voice tasks  
**@office:** In-office specific tasks
**@home:** Home-related tasks
**@errands:** Out and about tasks

### Extended Contexts (Optional)
**@meeting:** For meeting-related tasks
**@reading:** Reading/research tasks
**@writing:** Writing/composition tasks
**@planning:** Planning/thinking tasks
**@admin:** Administrative tasks

## 🔄 MRU Context Selection (Last 10 Used)

### Select Existing Context
{{query {:title "🎯 Select Context (Last 10 Used)"
         :query [:find (pull ?p [:block/name :block/properties])
                 :where 
                 [?p :block/name ?name]
                 [(clojure.string/starts-with? ?name "@")]
                 [?p :block/properties ?props]
                 [(get ?props :last-used) ?last-used]
                 [(not= ?last-used nil)]]
         :limit 10
         :sort-by :last-used
         :sort-dir :desc
         :result-transform (fn [results]
                             (map (fn [r] 
                                    {:title (:block/name r)
                                     :description (str "Last used: " 
                                                     (get-in r [:block/properties :last-used]))})
                                  results))}}}

### Or Create New Context
**New Context Name:** @{{new-context-name}}
**Category:** {{location|tool|mindset|energy}}
**Description:** {{what-tasks-belong-here}}
**Icon:** {{optional-emoji}}

**Confirm Creation?** {{yes|no}}
**If yes, create page:** [[@{{new-context-name}}]]

## 📝 Context Template

### New Context Page Template
```markdown
# @{{context-name}}
type:: context
created:: {{now}}
category:: {{location|tool|mindset|energy}}
icon:: {{context-emoji}}
last-used:: {{now}}

## Description
{{context-description}}

## Typical Tasks
- {{example-task-1}}
- {{example-task-2}}
- {{example-task-3}}

## Best Time For This Context
- {{morning|afternoon|evening|anytime}}
- Energy level: {{high|medium|low}}
- Duration: {{short|medium|long}}

## Related Contexts
- [[@{{related-context-1}}]]
- [[@{{related-context-2}}]]

## Statistics
{{query {:title "📊 Tasks in this context"
         :query [:find (count ?b)
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :context) "@{{context-name}}"]]
         :view :text}}}
```

## 🛠️ Context Management Tools

### Context Usage Dashboard
{{query {:title "📈 Most Used Contexts"
         :query [:find ?context (count ?b)
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :context) ?context]
                 [?context-page :block/name ?context]
                 [?context-page :block/properties ?ctx-props]
                 [(get ?ctx-props :last-used) ?last-used]]
         :group-by ?context
         :sort-by (count ?b)
         :sort-dir :desc
         :limit 10
         :view :table}}}

### Context Last Used
{{query {:title "🕒 Context Recency"
         :query [:find ?context ?last-used
                 :where
                 [?p :block/name ?context]
                 [(clojure.string/starts-with? ?context "@")]
                 [?p :block/properties ?props]
                 [(get ?props :last-used) ?last-used]
                 [(not= ?last-used nil)]]
         :sort-by ?last-used
         :sort-dir :desc
         :limit 10
         :view :table}}}

### Context Task Count
{{query {:title "📋 Tasks per Context"
         :query [:find ?context (count ?b)
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :context) ?context]]
         :group-by ?context
         :sort-by (count ?b)
         :sort-dir :desc
         :view :table}}}

## 🔄 Context Update Workflow

### When Using a Context
1. **Select context** from MRU list
2. **Update last-used timestamp:**
   ```
   last-used:: {{now}}
   ```
3. **Filter tasks** by selected context
4. **Work** on context-appropriate tasks
5. **Review** context effectiveness

### Creating New Contexts
1. **Identify need:** New location, tool, or mindset
2. **Check existing:** Avoid duplication
3. **Create page:** Use context template
4. **Add to MRU:** Initial last-used timestamp
5. **Assign tasks:** Start using new context

### Archiving Contexts
1. **Identify unused** contexts (>30 days)
2. **Move tasks** to related contexts
3. **Archive page:** `status:: archived`
4. **Remove from MRU:** No last-used updates

## ⚠️ Common Context Mistakes

### Mistake 1: Too many contexts
**Solution:** Limit to 5-7 active contexts
- Merge similar contexts
- Archive unused ones
- Use categories instead of many contexts

### Mistake 2: Vague contexts
**Solution:** Make contexts specific
- Bad: @work
- Good: @computer, @meeting, @planning

### Mistake 3: Not using contexts
**Solution:** Always assign context
- Make it required in templates
- Use default contexts
- Review un-contexted tasks

### Mistake 4: Wrong context assignment
**Solution:** Context validation
- Computer tasks → @computer
- Phone calls → @phone
- Location-specific → @location

## 📝 Example Contexts

### @computer
```
type:: context
category:: tool
icon:: 💻
description:: Any task requiring a computer
typical-tasks:: Coding, writing, research, email
best-time:: Morning, high energy
duration:: Medium to long
```

### @errands
```
type:: context  
category:: location
icon:: 🛒
description:: Tasks done while out and about
typical-tasks:: Groceries, post office, bank
best-time:: Afternoon, medium energy
duration:: Short to medium
```

### @reading
```
type:: context
category:: mindset
icon:: 📚
description:: Focused reading/research time
typical-tasks:: Articles, books, reports
best-time:: Evening, low energy
duration:: Medium
```

## 🔧 Context Customization

### Add Custom Context Properties
- **energy-required::** {{high|medium|low}}
- **focus-level::** {{deep|shallow|mixed}}
- **interruptibility::** {{high|medium|low}}
- **tools-required::** {{list-of-tools}}

### Context Shortcuts
- **Quick select:** `@c` = @computer, `@p` = @phone
- **Auto-context:** Based on task keywords
- **Location-based:** GPS auto-context (mobile)

### Platform-Specific Contexts
**Mobile-only:**
- @commute
- @waiting
- @appointment

**Desktop-only:**
- @deep-work
- @creative
- @analysis

## ✅ Success Metrics
- **Context Usage:** 95% of tasks have context
- **MRU Accuracy:** Top 10 reflect actual usage
- **Context Effectiveness:** Right tasks in right contexts
- **New Context Creation:** Prompted when needed
- **Context Cleanup:** Regular archiving of unused