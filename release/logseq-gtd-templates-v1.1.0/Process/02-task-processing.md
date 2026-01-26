template:: GTD Task Processing
description:: Complete inbox processing workflow with GTD decision tree
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Clarify phase - Process inbox to zero with GTD methodology

# GTD Task Processing

## 🔄 Processing Workflow

### Step 1: Review Inbox Item
**Original Capture:**
- {{inbox-item-text}}
  captured:: {{capture-time}}
  status:: unprocessed

### Step 2: Is it Actionable?
**Decision Tree:**
- ✅ **Yes, single action** → Create Next Action
- ✅ **Yes, multiple actions** → Create Project
- 📁 **No, reference** → File in Reference
- 🔮 **No, maybe later** → Someday/Maybe
- 🗑️ **No, not needed** → Delete

### Step 3: Process as Next Action (If Actionable)

#### Option A: Simple Next Action
- TODO {{action-description}}
  processed:: {{now}}
  source:: inbox
  context:: {{select-context}}
  priority:: {{HIGH|MEDIUM|LOW}}
  time-estimate:: {{5|15|30|60|120}} minutes
  energy:: {{high|medium|low}}
  due-date:: {{optional-date}}
  project:: {{optional-project}}

#### Option B: Detailed Next Action
- TODO {{clear-action-verb}} {{specific-outcome}}
  id:: {{block-id}}
  processed:: {{now}}
  
  **GTD Properties:**
  context:: {{@computer|@phone|@office|@home|@errands}}
  priority:: {{HIGH|MEDIUM|LOW}}
  project:: [[{{project-name}}]]
  area:: [[{{area-of-responsibility}}]]
  
  **Execution Properties:**
  time-estimate:: {{estimate-minutes}}
  energy:: {{high|medium|low}}
  due-date:: {{yyyy-mm-dd}}
  scheduled:: {{optional-start-date}}
  
  **Status Tracking:**
  status:: {{not-started|in-progress|waiting}}
  started:: {{date}}
  completed:: {{date}}
  
  **Notes:**
  {{additional-notes}}

### Step 4: Non-Actionable Items

#### Reference Material
- [[{{reference-title}}]]
  type:: reference
  url:: {{optional-url}}
  tags:: {{topic-tags}}
  filed:: {{now}}
  summary:: {{brief-summary}}

#### Someday/Maybe
- {{idea-or-possibility}}
  type:: someday-maybe
  category:: {{hobby|learning|travel|business}}
  interest:: {{high|medium|low}}
  timeline:: {{short|medium|long}}
  captured:: {{now}}

## 🎯 Processing Guidelines

### The 2-Minute Rule
**If action takes <2 minutes:** Do it immediately
**If action takes >2 minutes:** Delegate or defer

### Clarify Questions
1. **What's the desired outcome?**
2. **What's the very next physical action?**
3. **What context is required?**
4. **How long will it take?**
5. **What's the priority?**

### Common Processing Patterns

#### Email Processing
- TODO Respond to {{sender}} about {{topic}}
  context:: @computer
  time-estimate:: 15
  priority:: MEDIUM

#### Meeting Action Items
- TODO {{action}} for {{meeting}}
  context:: @office
  due-date:: {{follow-up-date}}
  priority:: HIGH

#### Errand Capture
- TODO Pick up {{items}} from {{location}}
  context:: @errands
  time-estimate:: 30
  priority:: {{urgency}}

## 📊 Processing Dashboard

### Inbox Status
{{query (read-file "queries/library/capture/inbox-status.clj")}}

### Today's Processing
{{query (read-file "queries/library/process/processed-today.clj")}}

### Processing Time Analysis
{{query (read-file "queries/library/process/average-processing-time.clj")}}

## 🛠️ Processing Tools

### Quick Context Selection
{{query {:title "🎯 Select Context (Last 10 Used)"
         :query [:find (pull ?p [:block/name])
                 :where [?p :block/name ?name]
                        [(clojure.string/starts-with? ?name "@")]
                        [?p :block/properties ?props]
                        [(get ?props :last-used) ?last-used]]
         :limit 10
         :sort-by :last-used
         :sort-dir :desc}}}

### Project Selection
{{query {:title "📁 Select Project"
         :query [:find (pull ?p [:block/name])
                 :where [?p :block/name ?name]
                        [(clojure.string/starts-with? ?name "Project/")]]
         :limit 10}}}

### Priority Helper
**HIGH:** Must do today, critical consequences
**MEDIUM:** Should do this week, important
**LOW:** Nice to do, no urgency

## ⚠️ Common Processing Mistakes

1. **❌ Not making actions specific enough**
   - Bad: "Work on project"
   - Good: "Draft introduction section"

2. **❌ Wrong context assignment**
   - Computer task assigned to @phone

3. **❌ Unrealistic time estimates**
   - 5-minute task estimated at 60 minutes

4. **❌ Skipping priority assignment**
   - Everything becomes "urgent"

5. **❌ Not using the 2-minute rule**
   - Quick tasks stay in system too long

## 📝 Example Processing

### Before Processing
- Need to update website
  captured:: 2024-01-30T09:00:00
  status:: unprocessed

### After Processing
- TODO Update homepage banner with new promotion
  processed:: 2024-01-30T09:05:00
  context:: @computer
  priority:: HIGH
  time-estimate:: 30
  project:: [[Project/Website Updates]]
  due-date:: 2024-01-31
  energy:: medium

## 🔧 Template Customization

### Add Custom Fields
- **impact::** {{high|medium|low}}
- **difficulty::** {{easy|medium|hard}}
- **stakeholder::** [[{{person}}]]
- **tools::** {{required-tools}}

### Processing Shortcuts
- **Quick keys:** `p1` = Priority HIGH, `p2` = MEDIUM, `p3` = LOW
- **Context codes:** `c` = @computer, `p` = @phone, `o` = @office
- **Time codes:** `5m`, `15m`, `30m`, `1h`, `2h`

## ✅ Success Metrics
- **Inbox Zero:** Daily achievement
- **Processing Time:** <2 minutes per item
- **Action Clarity:** Clear next physical action
- **Context Accuracy:** Right place for each task
- **Priority Realism:** True urgency reflected