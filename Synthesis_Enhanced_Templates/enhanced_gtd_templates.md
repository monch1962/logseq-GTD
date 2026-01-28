# Synthesis Lab Enhanced GTD Templates - Complete Collection

template:: GTD Enhanced Templates Complete Collection
description:: All 5 enhanced GTD templates in one file with natural language processing and AI features
version:: 2.0
compatibility:: Logseq mobile & desktop with Synthesis Lab
synthesis-required:: true
gtd-compliance:: Complete GTD workflow - Enhanced with AI-powered features
performance-optimized:: true
mobile-optimized:: true
template-type:: consolidated-collection
includes-templates:: Enhanced Quick Capture, Enhanced Task Processing, Enhanced Management Dashboard, Enhanced Weekly Review, Enhanced Next Actions Dashboard

---

# GTD Enhanced Quick Capture 🚀

template:: GTD Enhanced Quick Capture (Synthesis Lab)
description:: Ultra-fast mobile capture with natural language processing and smart suggestions
version:: 2.0
compatibility:: Logseq mobile & desktop with Synthesis Lab
synthesis-required:: true
gtd-compliance:: Capture phase - Enhanced with natural language processing
performance-optimized:: true
mobile-optimized:: true

## 🎯 Smart Capture with Natural Language

### Option 1: Natural Language Capture (NirvanaHQ Style)
```synthesis
{{eval capture "Call dentist tomorrow about appointment"}}
```
**Result:** Creates task with auto-assigned properties:
- TODO Call dentist about appointment
  captured:: {{now}}
  context:: @phone
  due-date:: {{tomorrow}}
  priority:: {{eval auto-calculate-priority "dentist appointment"}}
  time-estimate:: 15 minutes
  status:: unprocessed

### Option 2: Voice-to-Text Smart Capture
```synthesis
{{eval voice-capture "Remind me to buy groceries on Friday"}}
```
**Smart Features:**
- Auto-detects "remind me" → sets type:: reminder
- Extracts "buy groceries" → suggests context:: @errands
- Identifies "Friday" → sets due-date:: next Friday
- Suggests project:: [[Personal/Errands]]

### Option 3: Email/Text Forward Capture
```synthesis
{{eval forward-to-inbox "Project meeting notes from John"}}
```
**Integration Features:**
- Auto-extracts key information
- Suggests related projects
- Creates waiting-for items if delegation detected
- Links to existing reference materials

## 📱 Mobile-Optimized Synthesis Features

### Live Capture Statistics
```synthesis
Today's captures: {{cell count of today's captures}}
Unprocessed items: {{cell count of unprocessed items}}
Average processing time: {{cell average processing time}}
```

### Smart Context Detection
```synthesis
{{eval detect-context "write report"}}
→ Suggests: context:: @computer, time-estimate:: 60 minutes, energy:: medium

{{eval detect-context "call mom"}}
→ Suggests: context:: @phone, time-estimate:: 30 minutes, energy:: low
```

### Natural Language Queries (NirvanaHQ Style)
```synthesis
{{eval show me tasks I can do in 15 minutes at home}}
{{eval what's my focus for today}}
{{eval show overdue items}}
{{eval suggest next action based on current energy high}}
```

## 🧠 Intelligent Property Assignment

### Auto-Categorization
```synthesis
{{eval auto-categorize "Research AI tools for project"}}
→ Result: type:: reference, category:: research, project:: [[AI Project]]

{{eval auto-categorize "Schedule team meeting"}}
→ Result: type:: task, context:: @computer, project:: [[Team Management]]
```

### Priority Calculation
```synthesis
{{cell priority-score: calculate based on due date, project importance, and urgency}}
Priority breakdown:
- Due date urgency: {{cell due-date-score}}
- Project importance: {{cell project-score}}
- Time sensitivity: {{cell time-sensitivity}}
Total: {{cell total-priority-score}} → Priority: {{cell suggested-priority}}
```

### Time Estimation
```synthesis
{{eval estimate-time "write quarterly report"}}
→ Result: 4 hours (based on similar tasks)

{{eval estimate-time "quick email response"}}
→ Result: 5 minutes
```

## 🔄 Enhanced Processing Workflow

### Batch Processing Commands
```synthesis
{{eval process all unprocessed items}}
{{eval categorize today's captures}}
{{eval assign contexts to pending tasks}}
{{eval update priorities based on new information}}
```

### Smart Inbox Clearing
```synthesis
{{eval clear inbox using 2-minute rule}}
→ Processes items under 2 minutes immediately
→ Flags longer items for detailed processing
→ Suggests delegation for appropriate items
```

### Natural Language Processing Flow
1. **Capture:** "Schedule dentist appointment next week"
2. **Auto-process:** {{eval process-capture "Schedule dentist appointment next week"}}
3. **Result:** Creates task with all properties auto-assigned
4. **Follow-up:** {{eval suggest-followup "dentist appointment"}}

## 📊 Advanced Analytics Dashboard

### Live Capture Metrics
```synthesis
## 📈 Capture Analytics
- **Capture rate:** {{cell captures per day}} items/day
- **Processing speed:** {{cell average processing time}} minutes
- **Capture sources:** Mobile: {{cell mobile-captures}}%, Desktop: {{cell desktop-captures}}%
- **Voice capture usage:** {{cell voice-capture-percentage}}%

## 🎯 Smart Suggestions
{{eval suggest-capture-improvements}}
{{eval identify-capture-patterns}}
{{eval recommend-capture-workflow-optimizations}}
```

### Performance Tracking
```synthesis
## ⚡ Performance Metrics
- **Inbox zero streak:** {{cell days inbox zero}} days
- **Average capture-to-completion:** {{cell average completion time}} hours
- **Most productive capture times:** {{cell peak-capture-hours}}
- **Common capture categories:** {{cell top-capture-categories}}
```

## 🛠️ Synthesis-Specific Features

### Dynamic Template Generation
```synthesis
{{eval create-capture-template for "frequent work tasks"}}
{{eval customize-capture-flow based on "current location"}}
{{eval adapt-capture-interface for "mobile vs desktop"}}
```

### Learning System
```synthesis
{{eval learn from my capture patterns}}
{{eval improve property suggestions over time}}
{{eval adapt to my personal workflow preferences}}
```

### Integration Capabilities
```synthesis
{{eval connect to calendar for time blocking}}
{{eval sync with email for task creation}}
{{eval integrate with other productivity tools}}
```

## 📋 Quick Reference Commands

### Common Natural Language Commands
```
"Capture [task]" - Quick capture with auto-processing
"Remind me to [task] [time]" - Time-based capture
"Add to [project]" - Project-specific capture
"Forward this to inbox" - External content capture
"Process my inbox" - Batch processing
"Show me what to do next" - Context-aware suggestions
```

### Synthesis Macros for Capture
```synthesis
{{eval quick-capture "task description"}}
{{cell live-inbox-count}}
{{eval smart-process-all}}
{{eval suggest-next-capture-time}}
```

## ⚡ Setup Instructions

### Required Synthesis Setup
1. Install Kits plugin in Logseq
2. Add custom.css from Synthesis_Enhanced_Templates/
3. Create page named "Synthesis" with core code blocks
4. Load this template using `/` key

### Mobile Optimization
- Voice capture enabled by default
- Touch-optimized Synthesis cells
- Offline capture support
- Battery-aware processing

### Performance Tips
- Use `{{evalonce}}` for static content
- Use `{{cell}}` for live updating metrics
- Cache frequently used queries
- Batch process during low-energy times

## 🎨 Customization Options

### Personalize Capture Flow
```synthesis
{{eval set-my-preferred-contexts @computer @phone @home}}
{{eval configure-auto-categorization-rules}}
{{eval customize-priority-calculation}}
{{eval set-default-time-estimates}}
```

### Theme and Interface
- Adjust Synthesis cell colors in custom.css
- Configure touch targets for mobile
- Set preferred capture shortcuts
- Customize notification preferences

---

**Note:** This enhanced template requires Synthesis Lab installation. For basic functionality without Synthesis, use the original GTD Quick Capture template.

**Next Steps:** After capture, use [[Enhanced Task Processing]] for intelligent inbox clearing.

---
# GTD Enhanced Task Processing 🧠

template:: GTD Enhanced Task Processing (Synthesis Lab)
description:: Intelligent inbox processing with auto-categorization and smart suggestions
version:: 2.0
compatibility:: Logseq mobile & desktop with Synthesis Lab
synthesis-required:: true
gtd-compliance:: Clarify phase - Enhanced with AI-powered processing
performance-optimized:: true
mobile-optimized:: true

## 🔄 Intelligent Processing Workflow

### Step 1: Smart Inbox Review
```synthesis
## 📋 Inbox Overview
- **Total items:** {{cell count of unprocessed items}}
- **By category:** Tasks: {{cell task-count}}, Ideas: {{cell idea-count}}, Reference: {{cell reference-count}}
- **Processing time estimate:** {{cell total-processing-time}} minutes
- **Suggested batch size:** {{cell optimal-batch-size}} items

## 🎯 Smart Processing Order
{{eval suggest-processing-order}}
1. {{cell first-priority-item}} ({{cell first-reason}})
2. {{cell second-priority-item}} ({{cell second-reason}})
3. {{cell third-priority-item}} ({{cell third-reason}})
```

### Step 2: Auto-Decision Making (NirvanaHQ Style)
```synthesis
{{eval process-item "Call dentist about appointment"}}
→ **Analysis:**
   - Actionable: Yes (single action)
   - Context: @phone
   - Time estimate: 15 minutes
   - Priority: Medium (health-related)
   - Suggested project: [[Personal/Health]]
   
→ **Creates:** TODO Call dentist about appointment
   context:: @phone
   time-estimate:: 15 minutes
   priority:: MEDIUM
   project:: [[Personal/Health]]
   due-date:: {{eval suggest-due-date "dentist appointment"}}
```

## 🤖 AI-Powered Categorization

### Natural Language Understanding
```synthesis
{{eval categorize "Research project management tools"}}
→ **Result:** type:: reference, category:: research, tags:: #tools #productivity

{{eval categorize "Plan team offsite meeting"}}
→ **Result:** type:: project, category:: planning, context:: @computer

{{eval categorize "Buy groceries"}}
→ **Result:** type:: task, context:: @errands, time-estimate:: 45 minutes
```

### Context Detection
```synthesis
{{cell context-detection-engine}}
- **@computer tasks:** {{cell computer-task-keywords}}
- **@phone tasks:** {{cell phone-task-keywords}}
- **@errands tasks:** {{cell errands-task-keywords}}
- **@home tasks:** {{cell home-task-keywords}}

**Example:** "Write report" → context:: @computer (confidence: 95%)
```

### Project Association
```synthesis
{{eval associate-with-project "Update project timeline"}}
→ **Analysis:** Contains "project" → suggests existing projects
→ **Matches:** [[Project X]] (85%), [[Project Y]] (60%)
→ **Result:** project:: [[Project X]]

{{eval create-new-project-if-needed "Launch new marketing campaign"}}
→ **Analysis:** "launch" + "campaign" → suggests new project
→ **Creates:** [[Marketing Campaign Launch]]
→ **Sets up:** Project page with template
```

## ⚡ Batch Processing Commands

### One-Click Processing
```synthesis
{{eval process-all-using-2-minute-rule}}
→ Processes items under 2 minutes immediately
→ Returns: Processed {{cell quick-items}} items in {{cell processing-time}} seconds

{{eval auto-categorize-all}}
→ Analyzes all unprocessed items
→ Suggests categories with confidence scores
→ Returns: Categorized {{cell categorized-items}} items
```

### Smart Delegation Detection
```synthesis
{{eval identify-delegation-items}}
→ **Finds items containing:** "ask", "follow up with", "waiting for", "check with"
→ **Suggests:** Convert to waiting-for items
→ **Example:** "Ask John for report" → waiting-for from:: [[John]], type:: delegation
```

### Reference Material Processing
```synthesis
{{eval process-reference-material "Article about productivity tips"}}
→ **Extracts:** Key points, tags, summary
→ **Creates:** Reference page with organized content
→ **Links to:** Related projects and tasks
```

## 📊 Intelligent Property Assignment

### Dynamic Priority Calculation
```synthesis
{{cell priority-engine}}
**Input factors:**
- Due date proximity: {{cell due-date-score}}
- Project importance: {{cell project-importance-score}}
- Time sensitivity: {{cell time-sensitivity}}
- Energy match: {{cell energy-match-score}}
- Context availability: {{cell context-availability}}

**Output:** Priority: {{cell calculated-priority}} (Score: {{cell priority-score}})
```

### Smart Time Estimation
```synthesis
{{eval learn-from-past-tasks}}
**Historical data:**
- Similar tasks completed: {{cell similar-task-count}}
- Average completion time: {{cell average-completion-time}}
- Your speed vs average: {{cell personal-speed-factor}}

**Estimation:** "Write report" → {{cell estimated-time}} minutes (based on {{cell data-points}} similar tasks)
```

### Energy Level Matching
```synthesis
{{eval match-energy-to-task "complex analysis"}}
→ **Task requires:** High focus, analytical thinking
→ **Your current energy:** {{cell current-energy-level}}
→ **Match score:** {{cell energy-match-percentage}}%
→ **Suggestion:** {{cell best-time-to-do}}
```

## 🎨 Custom Processing Rules

### Personal Workflow Configuration
```synthesis
{{eval configure-my-processing-rules}}
**Rule examples:**
- If contains "urgent" → priority:: HIGH
- If contains "research" → type:: reference
- If contains "meeting" → context:: @computer
- If time estimate > 60 minutes → break into subtasks
```

### Learning from Corrections
```synthesis
{{eval learn-from-my-corrections}}
**System learns when you:**
- Change auto-assigned categories
- Adjust suggested priorities
- Modify time estimates
- Reassign contexts
```

### Template Customization
```synthesis
{{eval create-custom-processing-template for "email processing"}}
{{eval adapt-processing-flow for "meeting notes"}}
{{eval optimize-for-mobile-processing}}
```

## 📈 Processing Analytics Dashboard

### Performance Metrics
```synthesis
## ⚡ Processing Efficiency
- **Items processed today:** {{cell today-processed}} / {{cell today-total}}
- **Average processing time:** {{cell avg-processing-time}} seconds/item
- **Decision accuracy:** {{cell auto-category-accuracy}}%
- **Time saved with auto-processing:** {{cell time-saved}} minutes/day

## 🎯 Quality Metrics
- **Recategorization rate:** {{cell recategorization-rate}}%
- **Priority adjustment rate:** {{cell priority-adjustment-rate}}%
- **Context accuracy:** {{cell context-accuracy}}%
- **Project association accuracy:** {{cell project-accuracy}}%
```

### Improvement Suggestions
```synthesis
{{eval suggest-processing-improvements}}
**Based on your patterns:**
1. {{cell improvement-1}}
2. {{cell improvement-2}}
3. {{cell improvement-3}}

{{eval identify-processing-bottlenecks}}
**Common issues detected:**
- {{cell bottleneck-1}}
- {{cell bottleneck-2}}
- {{cell bottleneck-3}}
```

## 🔄 Integration with Other GTD Phases

### Seamless Transition to Organize
```synthesis
{{eval prepare-for-organization}}
→ Groups tasks by context: {{cell context-groups}}
→ Suggests project structures: {{cell project-suggestions}}
→ Identifies dependencies: {{cell dependency-map}}
```

### Smart Review Preparation
```synthesis
{{eval prepare-for-weekly-review}}
→ Flags items needing review: {{cell review-items}}
→ Identifies stuck projects: {{cell stuck-projects}}
→ Suggests agenda items: {{cell review-agenda-items}}
```

### Engagement Readiness Check
```synthesis
{{eval check-engagement-readiness}}
→ Validates next actions: {{cell valid-next-actions}}
→ Checks context availability: {{cell context-availability}}
→ Verifies prerequisites: {{cell prerequisites-met}}
```

## 🛠️ Advanced Synthesis Features

### Natural Language Processing Commands
```synthesis
"Process this as a task" → Converts to actionable item
"File as reference" → Creates reference material
"Defer until Friday" → Sets deferred date
"Delegate to Sarah" → Creates waiting-for item
"Break into subtasks" → Creates project with actions
```

### Batch Operations
```synthesis
{{eval apply-context @computer to selected}}
{{eval set-priority HIGH for overdue}}
{{eval assign-to-project [[Project X]]}}
{{eval estimate-times based-on-history}}
```

### Learning System
```synthesis
{{eval improve-suggestions based-on-feedback}}
{{eval adapt-to-workflow-changes}}
{{eval learn-from-successful-processing}}
{{eval optimize-decision-algorithms}}
```

## 📋 Quick Reference

### Common Processing Scenarios
```
**Email processing:** {{eval process-email "Subject: Project update"}}
**Meeting notes:** {{eval process-meeting-notes "Weekly team sync"}}
**Quick ideas:** {{eval process-idea "New feature suggestion"}}
**Reference material:** {{eval process-reference "Research paper"}}
**Delegated items:** {{eval process-delegation "Ask team for input"}}
```

### Synthesis Shortcuts
```synthesis
{{eval quick-process}} - Process current item with defaults
{{eval smart-categorize}} - Auto-categorize with explanations
{{eval batch-apply}} - Apply changes to multiple items
{{eval learn-now}} - Provide feedback to improve suggestions
```

## ⚡ Setup & Optimization

### Initial Configuration
```synthesis
{{eval setup-processing-profile}}
**Configure:**
- Your typical contexts
- Common project categories
- Priority calculation weights
- Time estimation baselines
```

### Performance Optimization
```synthesis
{{eval optimize-processing-performance}}
**Settings:**
- Cache frequent decisions
- Pre-compute suggestions
- Batch similar operations
- Learn during idle times
```

### Mobile Optimization
```synthesis
{{eval optimize-for-mobile}}
**Features:**
- Touch-friendly interfaces
- Voice command processing
- Offline processing support
- Battery-efficient operations
```

---

**Note:** This enhanced template requires Synthesis Lab installation. It builds upon the intelligent capture from [[Enhanced Quick Capture]] and prepares items for [[Enhanced Management Dashboard]].

**Next Steps:** After processing, use natural language queries like "{{eval show me next actions for @computer}}" to engage with your organized tasks.

---

# GTD Enhanced Management Dashboard 🎯

template:: GTD Enhanced Management Dashboard (Synthesis Lab)
description:: Intelligent dashboard with natural language filtering, smart analytics, and dynamic views
version:: 2.0
compatibility:: Logseq mobile & desktop with Synthesis Lab
synthesis-required:: true
gtd-compliance:: Organize phase - Enhanced with NirvanaHQ-style filtering
performance-optimized:: true
cache-enabled:: true
mobile-optimized:: true

## 🎨 Dynamic Dashboard Overview

### Live System Status
```synthesis
## 📊 System Health Dashboard
{{cell system-status}}
- **Inbox:** {{cell inbox-count}} items ({{cell inbox-status}})
- **Next Actions:** {{cell next-actions-count}} ({{cell next-actions-status}})
- **Projects:** {{cell active-projects}} active ({{cell projects-status}})
- **Waiting For:** {{cell waiting-count}} items ({{cell waiting-status}})
- **Someday/Maybe:** {{cell someday-count}} items ({{cell someday-status}})

## ⚡ Performance Metrics
- **GTD compliance:** {{cell gtd-compliance-score}}%
- **Processing efficiency:** {{cell processing-efficiency}}%
- **Completion rate:** {{cell completion-rate}}%
- **System trust score:** {{cell system-trust-score}}/100
```

## 🔍 Natural Language Filtering (NirvanaHQ Style)

### Smart Context Filtering
```synthesis
{{eval show me tasks for @computer}}
→ **Filters by:** context:: @computer
→ **Sorts by:** priority then due date
→ **Shows:** {{cell filtered-count}} items

{{eval what can I do in 15 minutes at home}}
→ **Filters:** context:: @home AND time-estimate:: <= 15
→ **Energy match:** {{cell current-energy}}
→ **Shows:** {{cell quick-tasks}} suitable tasks
```

### Advanced Filter Combinations
```synthesis
{{eval show high priority work tasks due this week}}
→ **Filters:** priority:: HIGH AND context:: @computer AND due-date:: this week
→ **Result:** {{cell filtered-results}} items

{{eval show me overdue items waiting for others}}
→ **Filters:** status:: waiting AND due-date:: < today
→ **By person:** {{cell grouped-by-person}}
→ **Follow-up needed:** {{cell followup-needed}} items
```

### Personal Energy & Time Matching
```synthesis
{{eval suggest tasks for my current energy {{cell current-energy}}}}
→ **Energy-aware filtering:**
   - High energy: Complex, creative tasks
   - Medium energy: Routine, administrative tasks
   - Low energy: Simple, maintenance tasks
→ **Matches:** {{cell energy-matched-tasks}} tasks

{{eval what can I do in my available {{cell available-time}} minutes}}
→ **Time-based filtering:**
   - Groups by time blocks
   - Suggests optimal sequencing
   - Considers transition time
```

## 📈 Intelligent Analytics Dashboard

### Waiting For Analytics
```synthesis
## 🔄 Waiting For Intelligence
{{cell waiting-for-analytics}}
- **Active items:** {{cell waiting-active}} ({{cell waiting-trend}})
- **Average wait time:** {{cell avg-wait-time}} days
- **Overdue rate:** {{cell overdue-rate}}%
- **Top delegators:** {{cell top-delegators}}
- **Common delay reasons:** {{cell delay-reasons}}

### Smart Follow-up Suggestions
{{eval suggest-follow-ups}}
**Based on:**
- Response time patterns: {{cell response-patterns}}
- Communication history: {{cell comm-history}}
- Priority levels: {{cell priority-distribution}}
- Project dependencies: {{cell project-dependencies}}
```

### Someday/Maybe Intelligence
```synthesis
## 🔮 Someday/Maybe Insights
{{cell someday-analytics}}
- **Total ideas:** {{cell total-ideas}} ({{cell growth-rate}})
- **Interest distribution:** High: {{cell high-interest}}%, Medium: {{cell medium-interest}}%, Low: {{cell low-interest}}%
- **Promotion rate:** {{cell promotion-rate}}% to active projects
- **Archive rate:** {{cell archive-rate}}% removed

### Ready for Consideration
{{eval identify-ready-items}}
**Criteria:**
- High interest + short timeline: {{cell ready-count-1}}
- Prerequisites met: {{cell ready-count-2}}
- Seasonal relevance: {{cell ready-count-3}}
- Resource availability: {{cell ready-count-4}}
```

### Reference Material Intelligence
```synthesis
## 📚 Reference Analytics
{{cell reference-analytics}}
- **Total references:** {{cell total-references}}
- **By category:** {{cell reference-categories}}
- **Usage frequency:** {{cell reference-usage}}
- **Recency:** {{cell reference-recency}}

### Smart Organization Suggestions
{{eval suggest-reference-organization}}
**Based on:**
- Usage patterns: {{cell usage-patterns}}
- Topic clusters: {{cell topic-clusters}}
- Project relevance: {{cell project-relevance}}
- Access frequency: {{cell access-frequency}}
```

## 🎯 Smart Dashboard Features

### Dynamic View Customization
```synthesis
{{eval create-custom-view "My Weekly Focus"}}
**Includes:**
- High priority items: {{cell high-priority-items}}
- Critical deadlines: {{cell critical-deadlines}}
- Key meetings: {{cell key-meetings}}
- Blocked items: {{cell blocked-items}}

{{eval adapt-view-for "mobile"}}
**Optimizes:**
- Touch targets: {{cell touch-optimized}}
- Load time: {{cell optimized-load-time}}
- Battery usage: {{cell battery-efficient}}
- Offline access: {{cell offline-capable}}
```

### Personal Dashboard Configuration
```synthesis
{{eval configure-my-dashboard}}
**Settings:**
- Default filters: {{cell default-filters}}
- Sort preferences: {{cell sort-preferences}}
- View density: {{cell view-density}}
- Notification rules: {{cell notification-rules}}
```

### Learning Dashboard
```synthesis
{{eval learn-from-my-usage}}
**Tracks:**
- Most used filters: {{cell popular-filters}}
- Common queries: {{cell common-queries}}
- View patterns: {{cell view-patterns}}
- Interaction habits: {{cell interaction-habits}}

{{eval suggest-dashboard-improvements}}
**Based on your usage:**
1. {{cell improvement-1}}
2. {{cell improvement-2}}
3. {{cell improvement-3}}
```

## 🔄 Integration & Automation

### Smart Workflow Automation
```synthesis
{{eval automate-weekly-review-prep}}
**Prepares:**
- Review agenda: {{cell review-agenda}}
- Status reports: {{cell status-reports}}
- Metrics summary: {{cell metrics-summary}}
- Improvement suggestions: {{cell improvement-suggestions}}

{{eval automate-project-updates}}
**Updates:**
- Project status: {{cell project-status-updates}}
- Next actions: {{cell next-action-updates}}
- Dependencies: {{cell dependency-updates}}
- Resource allocation: {{cell resource-updates}}
```

### External Integration
```synthesis
{{eval integrate-with-calendar}}
**Syncs:**
- Time blocks: {{cell time-blocks}}
- Meetings: {{cell meetings}}
- Deadlines: {{cell deadlines}}
- Availability: {{cell availability}}

{{eval connect-to-email}}
**Processes:**
- Task emails: {{cell task-emails}}
- Meeting invites: {{cell meeting-invites}}
- Reference material: {{cell reference-emails}}
- Delegation requests: {{cell delegation-emails}}
```

## 📊 Advanced Analytics & Reporting

### Performance Reporting
```synthesis
{{eval generate-weekly-report}}
**Includes:**
- Completion metrics: {{cell completion-metrics}}
- Productivity trends: {{cell productivity-trends}}
- Bottleneck analysis: {{cell bottleneck-analysis}}
- Improvement opportunities: {{cell improvement-opportunities}}

{{eval create-productivity-insights}}
**Analyzes:**
- Peak productivity times: {{cell peak-times}}
- Most effective contexts: {{cell effective-contexts}}
- Task completion patterns: {{cell completion-patterns}}
- Interruption impact: {{cell interruption-impact}}
```

### Predictive Analytics
```synthesis
{{cell predictive-analytics}}
**Forecasts:**
- Completion timelines: {{cell completion-forecast}}
- Workload capacity: {{cell capacity-forecast}}
- Project risks: {{cell risk-forecast}}
- Resource needs: {{cell resource-forecast}}

{{eval suggest-optimizations}}
**Based on predictions:**
1. {{cell optimization-1}}
2. {{cell optimization-2}}
3. {{cell optimization-3}}
```

## 🛠️ Synthesis-Specific Features

### Natural Language Query Engine
```synthesis
## 💬 Natural Language Interface
**Example queries:**
- "Show me overdue tasks": {{eval natural-query "show me overdue tasks"}}
- "What's blocking my projects": {{eval natural-query "what's blocking my projects"}}
- "Suggest focus for today": {{eval natural-query "suggest focus for today"}}
- "Find tasks I can delegate": {{eval natural-query "find tasks I can delegate"}}

**Query learning:**
{{eval improve-query-understanding}}
- Common patterns: {{cell query-patterns}}
- Success rate: {{cell query-success-rate}}
- Learning progress: {{cell learning-progress}}
```

### Dynamic Visualization
```synthesis
{{eval create-visual-overview}}
**Visualizations:**
- Priority heatmap: {{cell priority-heatmap}}
- Time distribution: {{cell time-distribution}}
- Context allocation: {{cell context-allocation}}
- Progress tracking: {{cell progress-tracking}}

{{eval customize-visualizations}}
**Options:**
- Chart types: {{cell chart-options}}
- Color schemes: {{cell color-schemes}}
- Data granularity: {{cell data-granularity}}
- Update frequency: {{cell update-frequency}}
```

## 📱 Mobile-Optimized Features

### Touch-Optimized Interface
```synthesis
{{eval optimize-for-touch}}
**Features:**
- Gesture support: {{cell gesture-support}}
- Voice commands: {{cell voice-commands}}
- One-tap actions: {{cell one-tap-actions}}
- Swipe gestures: {{cell swipe-gestures}}

### Offline Capabilities
{{eval enable-offline-mode}}
**Capabilities:**
- Data caching: {{cell cache-size}}
- Sync management: {{cell sync-management}}
- Conflict resolution: {{cell conflict-resolution}}
- Battery optimization: {{cell battery-optimization}}
```

## ⚡ Performance & Optimization

### Smart Caching System
```synthesis
{{cell caching-system}}
**Cache performance:**
- Hit rate: {{cell cache-hit-rate}}%
- Size: {{cell cache-size}} MB
- Freshness: {{cell cache-freshness}}
- Efficiency: {{cell cache-efficiency}}%

{{eval optimize-cache-strategy}}
**Based on usage:**
- Frequent queries: {{cell frequent-queries}}
- Access patterns: {{cell access-patterns}}
- Update frequency: {{cell update-patterns}}
- Priority data: {{cell priority-data}}
```

### Load Time Optimization
```synthesis
{{eval optimize-load-times}}
**Improvements:**
- Initial load: {{cell initial-load-time}} ms
- Query response: {{cell query-response-time}} ms
- Update speed: {{cell update-speed}} ms
- Mobile performance: {{cell mobile-performance}} score
```

## 📋 Quick Reference

### Common Dashboard Commands
```synthesis
## 🎯 Quick Actions
{{eval show-overview}} - System overview
{{eval filter-by @context}} - Context filtering
{{eval sort-by priority}} - Priority sorting
{{eval group-by project}} - Project grouping
{{eval search "keyword"}} - Full-text search

## 📊 Quick Reports
{{eval show-today-stats}} - Today's statistics
{{eval show-week-trend}} - Weekly trends
{{eval show-project-health}} - Project health
{{eval show-waiting-status}} - Waiting for status
```

### Personal Shortcuts
```synthesis
{{eval my-daily-view}} - Your daily dashboard
{{eval my-weekly-focus}} - Weekly focus items
{{eval my-blocked-items}} - Currently blocked
{{eval my-delegation-tracker}} - Delegation tracking
```

---

**Note:** This enhanced dashboard requires Synthesis Lab installation. It integrates with [[Enhanced Quick Capture]] and [[Enhanced Task Processing]] for a complete GTD workflow.

**Natural Language Examples:**
- "{{eval what should I work on now}}"
- "{{eval show me overdue items}}"
- "{{eval what's my focus for today}}"
- "{{eval suggest tasks for 30 minutes}}"

**Mobile Commands:** Use voice commands or touch gestures for quick access to filtered views.

---

# GTD Enhanced Weekly Review 📅

template:: GTD Enhanced Weekly Review (Synthesis Lab)
description:: Intelligent weekly review with automated preparation, smart analytics, and improvement suggestions
version:: 2.0
compatibility:: Logseq mobile & desktop with Synthesis Lab
synthesis-required:: true
gtd-compliance:: Review phase - Enhanced with AI-powered insights
performance-optimized:: true
mobile-optimized:: true

## 🎯 Smart Review Preparation

### Automated Review Setup
```synthesis
{{eval prepare-weekly-review}}
→ **Collects data from:** {{cell data-sources}}
→ **Analysis time:** {{cell analysis-time}} seconds
→ **Items to review:** {{cell total-review-items}}
→ **Estimated duration:** {{cell estimated-duration}} minutes

## 📋 Review Agenda (Auto-Generated)
{{cell review-agenda}}
1. **Inbox Processing** ({{cell inbox-items}} items, {{cell inbox-time}} min)
2. **Project Review** ({{cell project-count}} projects, {{cell project-time}} min)
3. **Next Actions** ({{cell action-count}} items, {{cell action-time}} min)
4. **Waiting For** ({{cell waiting-items}} items, {{cell waiting-time}} min)
5. **Someday/Maybe** ({{cell someday-items}} items, {{cell someday-time}} min)
6. **Reference** ({{cell reference-items}} items, {{cell reference-time}} min)
7. **System Improvement** ({{cell improvement-items}} items, {{cell improvement-time}} min)
```

### Smart Time Allocation
```synthesis
{{eval optimize-review-schedule}}
**Based on:**
- Available time: {{cell available-time}} minutes
- Energy levels: {{cell current-energy}}
- Priority areas: {{cell priority-areas}}
- Historical patterns: {{cell historical-patterns}}

**Suggested schedule:**
- High energy tasks: {{cell high-energy-tasks}}
- Medium energy tasks: {{cell medium-energy-tasks}}
- Low energy tasks: {{cell low-energy-tasks}}
```

## 🔄 Intelligent Review Workflow

### Step 1: Automated Inbox Processing
```synthesis
{{eval review-inbox}}
**Analysis:**
- Total items: {{cell inbox-total}}
- By category: Tasks: {{cell inbox-tasks}}, Ideas: {{cell inbox-ideas}}, Reference: {{cell inbox-reference}}
- Processing suggestions: {{cell inbox-suggestions}}

**Auto-processing results:**
- Quick decisions: {{cell quick-decisions}} items
- Needs attention: {{cell needs-attention}} items
- Delegation candidates: {{cell delegation-candidates}} items
```

### Step 2: Smart Project Review
```synthesis
{{eval review-projects}}
**Project Health Dashboard:**
{{cell project-health}}
- **Active projects:** {{cell active-projects}} ({{cell project-health-score}}%)
- **On track:** {{cell on-track-projects}}
- **Needs attention:** {{cell needs-attention-projects}}
- **Stuck:** {{cell stuck-projects}}
- **Completed this week:** {{cell completed-projects}}

**Automated status updates:**
{{eval update-project-status}}
→ Updates: {{cell updated-projects}} projects
→ Flags: {{cell flagged-issues}} issues
→ Suggests: {{cell suggested-actions}} actions
```

### Step 3: Next Actions Intelligence
```synthesis
{{eval review-next-actions}}
**Action Analysis:**
- Total actions: {{cell total-actions}}
- By context: {{cell actions-by-context}}
- Completion rate: {{cell completion-rate}}%
- Average completion time: {{cell avg-completion-time}} hours

**Smart cleanup:**
{{eval cleanup-next-actions}}
→ Archives completed: {{cell archived-actions}}
→ Updates stale: {{cell updated-actions}}
→ Creates new: {{cell new-actions}}
→ Delegates appropriate: {{cell delegated-actions}}
```

### Step 4: Waiting For Automation
```synthesis
{{eval review-waiting-for}}
**Waiting Analysis:**
- Active items: {{cell waiting-active}}
- Average wait time: {{cell avg-wait-time}} days
- Overdue: {{cell waiting-overdue}}
- Follow-up needed: {{cell followup-needed}}

**Automated follow-ups:**
{{eval generate-followup-reminders}}
→ Creates: {{cell followup-reminders}} reminders
→ Schedules: {{cell followup-schedule}} schedule
→ Updates: {{cell waiting-status-updates}} statuses
```

### Step 5: Someday/Maybe Intelligence
```synthesis
{{eval review-someday-maybe}}
**Someday Analysis:**
- Total items: {{cell someday-total}}
- Interest distribution: {{cell interest-distribution}}
- Ready for promotion: {{cell ready-to-promote}}
- Should archive: {{cell should-archive}}

**Smart promotion suggestions:**
{{eval suggest-promotions}}
**Based on:**
- Timing: {{cell timing-analysis}}
- Resources: {{cell resource-availability}}
- Interest: {{cell interest-levels}}
- Prerequisites: {{cell prerequisites-met}}
```

## 📊 Advanced Review Analytics

### Performance Metrics
```synthesis
## ⚡ Weekly Performance Dashboard
{{cell weekly-performance}}
- **Tasks completed:** {{cell tasks-completed}} ({{cell completion-trend}})
- **Projects progressed:** {{cell projects-progressed}}
- **Waiting items resolved:** {{cell waiting-resolved}}
- **New items captured:** {{cell new-captures}}
- **System trust score:** {{cell trust-score-change}}

## 🎯 Goal Achievement
{{eval analyze-goal-progress}}
**Weekly goals:** {{cell weekly-goals}}
- Achieved: {{cell goals-achieved}}
- In progress: {{cell goals-in-progress}}
- Not started: {{cell goals-not-started}}
- Adjusted: {{cell goals-adjusted}}
```

### Productivity Insights
```synthesis
{{eval generate-productivity-insights}}
**Key insights:**
1. **Peak productivity:** {{cell peak-productivity-times}}
2. **Most effective contexts:** {{cell effective-contexts}}
3. **Common distractions:** {{cell common-distractions}}
4. **Optimal task sequencing:** {{cell optimal-sequencing}}

**Improvement opportunities:**
{{eval suggest-productivity-improvements}}
1. {{cell improvement-1}}
2. {{cell improvement-2}}
3. {{cell improvement-3}}
```

### System Health Analysis
```synthesis
{{eval analyze-system-health}}
**GTD Compliance:**
- Capture effectiveness: {{cell capture-effectiveness}}%
- Processing efficiency: {{cell processing-efficiency}}%
- Organization quality: {{cell organization-quality}}%
- Review consistency: {{cell review-consistency}}%
- Engagement success: {{cell engagement-success}}%

**System improvements needed:**
{{cell system-improvements}}
- Critical: {{cell critical-improvements}}
- Important: {{cell important-improvements}}
- Nice-to-have: {{cell nice-to-have-improvements}}
```

## 🧠 Intelligent Improvement Suggestions

### Workflow Optimization
```synthesis
{{eval suggest-workflow-optimizations}}
**Based on your patterns:**
1. **Capture optimization:** {{cell capture-optimization}}
2. **Processing improvement:** {{cell processing-improvement}}
3. **Organization enhancement:** {{cell organization-enhancement}}
4. **Review adjustment:** {{cell review-adjustment}}
5. **Engagement strategy:** {{cell engagement-strategy}}
```

### Template Customization
```synthesis
{{eval customize-review-template}}
**Personalization options:**
- Review frequency: {{cell review-frequency}}
- Focus areas: {{cell focus-areas}}
- Metrics tracked: {{cell tracked-metrics}}
- Success criteria: {{cell success-criteria}}

**Auto-adaptation:**
{{eval adapt-to-changing-needs}}
→ Learns from: {{cell learning-sources}}
→ Adapts: {{cell adaptation-areas}}
→ Improves: {{cell improvement-areas}}
```

### Learning from Reviews
```synthesis
{{eval learn-from-review-history}}
**Historical analysis:**
- Review patterns: {{cell review-patterns}}
- Success factors: {{cell success-factors}}
- Common challenges: {{cell common-challenges}}
- Improvement trends: {{cell improvement-trends}}

**Predictive suggestions:**
{{eval predict-review-needs}}
**Next week focus:**
1. {{cell focus-1}}
2. {{cell focus-2}}
3. {{cell focus-3}}
```

## 🔄 Integration with Other Phases

### Seamless Phase Transition
```synthesis
{{eval prepare-for-next-week}}
**Sets up:**
- Weekly goals: {{cell weekly-goals-setup}}
- Project priorities: {{cell project-priorities}}
- Focus areas: {{cell focus-areas-setup}}
- Time blocks: {{cell time-blocks-setup}}

**Cleanup:**
{{eval cleanup-after-review}}
→ Archives: {{cell archived-items}}
→ Updates: {{cell updated-systems}}
→ Prepares: {{cell prepared-systems}}
```

### Cross-Phase Intelligence
```synthesis
{{eval share-insights-across-phases}}
**Insights shared:**
- Capture patterns → Processing optimization
- Processing results → Organization improvements
- Organization status → Review preparation
- Review findings → Engagement strategy
- Engagement results → System improvements
```

## 🛠️ Advanced Synthesis Features

### Natural Language Review Commands
```synthesis
## 💬 Review Conversation
**Example commands:**
- "Start my weekly review": {{eval start-review}}
- "Review projects needing attention": {{eval review-projects-needing-attention}}
- "Show me completion statistics": {{eval show-completion-stats}}
- "Suggest improvements for next week": {{eval suggest-next-week-improvements}}
- "Generate review summary": {{eval generate-review-summary}}

**Voice commands (mobile):**
{{eval enable-voice-review}}
→ "Start review" → Begins automated review
→ "Skip to projects" → Jumps to project review
→ "Summarize findings" → Creates summary
→ "Schedule next review" → Sets next review time
```

### Automated Documentation
```synthesis
{{eval generate-review-documentation}}
**Creates:**
- Review notes: {{cell review-notes}}
- Action items: {{cell action-items}}
- Decisions made: {{cell decisions-made}}
- Follow-ups: {{cell follow-ups-scheduled}}

**Formats:**
- Summary report: {{cell summary-report}}
- Email update: {{cell email-update}}
- Team share: {{cell team-share}}
- Personal reflection: {{cell personal-reflection}}
```

### Learning System
```synthesis
{{eval improve-review-process}}
**Learning from:**
- Your feedback: {{cell feedback-learning}}
- Review outcomes: {{cell outcome-learning}}
- Time usage: {{cell time-usage-learning}}
- Effectiveness measures: {{cell effectiveness-learning}}

**Adaptation:**
{{eval adapt-review-process}}
→ Adjusts: {{cell process-adjustments}}
→ Optimizes: {{cell process-optimizations}}
→ Personalizes: {{cell process-personalizations}}
```

## 📱 Mobile-Optimized Review

### Touch-Optimized Interface
```synthesis
{{eval optimize-review-for-mobile}}
**Mobile features:**
- Gesture navigation: {{cell gesture-navigation}}
- Voice input: {{cell voice-input-support}}
- Offline capability: {{cell offline-capability}}
- Battery efficiency: {{cell battery-efficiency}}

**Review on-the-go:**
{{eval enable-mobile-review}}
→ Micro-reviews: {{cell micro-review-support}}
→ Quick updates: {{cell quick-update-support}}
→ Voice summaries: {{cell voice-summary-support}}
→ Photo documentation: {{cell photo-documentation}}
```

### Progressive Review
```synthesis
{{eval enable-progressive-review}}
**Flexible review options:**
- Full review: {{cell full-review-time}} minutes
- Quick review: {{cell quick-review-time}} minutes
- Focused review: {{cell focused-review-time}} minutes
- Status check: {{cell status-check-time}} minutes

**Adaptive scheduling:**
{{eval adapt-review-schedule}}
→ Based on: {{cell schedule-factors}}
→ Suggests: {{cell schedule-suggestions}}
→ Adjusts: {{cell schedule-adjustments}}
```

## 📊 Review Analytics & Reporting

### Performance Tracking
```synthesis
{{cell review-analytics}}
**Review metrics:**
- Completion rate: {{cell review-completion-rate}}%
- Average duration: {{cell avg-review-duration}} minutes
- Quality score: {{cell review-quality-score}}
- Improvement rate: {{cell improvement-rate}}%

**Trend analysis:**
{{eval analyze-review-trends}}
→ Weekly trends: {{cell weekly-trends}}
→ Monthly patterns: {{cell monthly-patterns}}
→ Seasonal variations: {{cell seasonal-variations}}
→ Long-term improvements: {{cell long-term-improvements}}
```

### Success Measurement
```synthesis
{{eval measure-review-success}}
**Success indicators:**
- System clarity: {{cell system-clarity-score}}
- Stress reduction: {{cell stress-reduction-score}}
- Productivity increase: {{cell productivity-increase}}
- Goal achievement: {{cell goal-achievement-rate}}

**Improvement tracking:**
{{cell improvement-tracking}}
- Week-over-week: {{cell wow-improvement}}
- Month-over-month: {{cell mom-improvement}}
- Quarter-over-quarter: {{cell qoq-improvement}}
- Year-over-year: {{cell yoy-improvement}}
```

## 📋 Quick Reference

### Common Review Commands
```synthesis
## 🎯 Quick Start
{{eval quick-review}} - 15-minute focused review
{{eval full-review}} - Complete weekly review
{{eval project-review}} - Project-focused review
{{eval status-review}} - Quick status check

## 📊 Quick Analytics
{{eval show-week-stats}} - Weekly statistics
{{eval show-progress}} - Progress tracking
{{eval show-improvements}} - Improvement suggestions
{{eval show-trends}} - Performance trends
```

### Personal Review Templates
```synthesis
{{eval my-standard-review}} - Your standard review template
{{eval my-quick-review}} - Your quick review template
{{eval my-project-review}} - Your project review template
{{eval my-team-review}} - Your team review template
```

---

**Note:** This enhanced weekly review requires Synthesis Lab installation. It builds upon the intelligent organization from [[Enhanced Management Dashboard]] and prepares for effective engagement.

**Natural Language Examples:**
- "{{eval start my weekly review}}"
- "{{eval review my projects}}"
- "{{eval show me last week's accomplishments}}"
- "{{eval plan next week's focus}}"

**Mobile Optimization:** Use voice commands for hands-free review or touch gestures for quick navigation through review sections.

---

# GTD Enhanced Next Actions Dashboard ⚡

template:: GTD Enhanced Next Actions Dashboard (Synthesis Lab)
description:: Dynamic engagement dashboard with context-aware task selection, energy matching, and smart scheduling
version:: 2.0
compatibility:: Logseq mobile & desktop with Synthesis Lab
synthesis-required:: true
gtd-compliance:: Engage phase - Enhanced with NirvanaHQ-style task selection
performance-optimized:: true
mobile-optimized:: true

## 🎯 Smart Task Selection Engine

### Context-Aware Filtering (NirvanaHQ Style)
```synthesis
{{eval show me tasks for current context}}
→ **Detects context:** {{cell current-context}}
→ **Available tasks:** {{cell context-tasks-count}}
→ **Sorted by:** Priority → Due date → Energy match
→ **Shows:** {{cell suggested-tasks}} most relevant

{{eval what can I do in {{cell available-time}} minutes}}
→ **Time-based filtering:**
   - Quick wins (<15 min): {{cell quick-wins}}
   - Medium tasks (15-60 min): {{cell medium-tasks}}
   - Deep work (>60 min): {{cell deep-work-tasks}}
→ **Suggests:** {{cell time-appropriate-suggestions}}
```

### Energy & Focus Matching
```synthesis
{{cell energy-matching-engine}}
**Current energy:** {{cell current-energy-level}} ({{cell energy-source}})
**Focus level:** {{cell current-focus}} ({{cell focus-factors}})

**Task matching:**
- High energy tasks: {{cell high-energy-matches}}
- Medium energy tasks: {{cell medium-energy-matches}}
- Low energy tasks: {{cell low-energy-matches}}

**Optimal sequencing:**
{{eval suggest-task-sequence}}
1. {{cell sequence-1}} (warm-up)
2. {{cell sequence-2}} (peak energy)
3. {{cell sequence-3}} (cool-down)
```

## 📊 Dynamic Engagement Dashboard

### Live Action Dashboard
```synthesis
## 🎯 Now-Next-Later Dashboard
{{cell now-next-later-view}}

**Now ({{cell now-count}} items):**
{{eval show-now-tasks}}
→ Context: {{cell now-context}}
→ Energy: {{cell now-energy}}
→ Time: {{cell now-time}} minutes

**Next ({{cell next-count}} items):**
{{eval show-next-tasks}}
→ When: {{cell next-timing}}
→ Prerequisites: {{cell next-prerequisites}}
→ Preparation: {{cell next-preparation}}

**Later ({{cell later-count}} items):**
{{eval show-later-tasks}}
→ Scheduled: {{cell later-schedule}}
→ Dependencies: {{cell later-dependencies}}
→ Notifications: {{cell later-notifications}}
```

### Smart Priority Visualization
```synthesis
{{cell priority-visualization}}
**Priority heatmap:**
- 🔴 **Critical ({{cell critical-count}}):** {{cell critical-tasks}}
- 🟡 **High ({{cell high-count}}):** {{cell high-tasks}}
- 🟢 **Medium ({{cell medium-count}}):** {{cell medium-tasks}}
- 🔵 **Low ({{cell low-count}}):** {{cell low-tasks}}

**Dynamic prioritization:**
{{eval update-priorities-dynamically}}
→ Based on: {{cell priority-factors}}
→ Changes: {{cell priority-changes}}
→ Notifications: {{cell priority-notifications}}
```

## ⚡ Intelligent Task Execution

### One-Tap Task Start
```synthesis
{{eval start-task "Write report"}}
→ **Prepares:**
   - Context setup: {{cell context-setup}}
   - Time block: {{cell time-block}} minutes
   - Resources: {{cell task-resources}}
   - Focus mode: {{cell focus-mode-enabled}}

→ **Tracks:**
   - Start time: {{cell start-time}}
   - Expected finish: {{cell expected-finish}}
   - Progress: {{cell progress-tracker}}
   - Interruptions: {{cell interruption-tracker}}
```

### Smart Pomodoro Integration
```synthesis
{{cell pomodoro-engine}}
**Current session:** {{cell current-session}}
- Focus time: {{cell focus-time}} minutes
- Break time: {{cell break-time}} minutes
- Sessions completed: {{cell sessions-completed}}
- Productivity score: {{cell productivity-score}}

**Adaptive timing:**
{{eval adapt-pomodoro-timing}}
→ Based on: {{cell timing-factors}}
→ Adjusts: {{cell timing-adjustments}}
→ Optimizes: {{cell timing-optimizations}}
```

### Context Switching Intelligence
```synthesis
{{eval minimize-context-switching}}
**Current context:** {{cell current-context}}
**Suggested batch:**
1. {{cell batch-task-1}} ({{cell batch-reason-1}})
2. {{cell batch-task-2}} ({{cell batch-reason-2}})
3. {{cell batch-task-3}} ({{cell batch-reason-3}})

**Switch cost analysis:**
- Estimated switch time: {{cell switch-time}} minutes
- Mental reload: {{cell mental-reload}} effort
- Suggested grouping: {{cell task-grouping}}
```

## 📈 Engagement Analytics

### Real-Time Productivity Tracking
```synthesis
## ⚡ Live Productivity Dashboard
{{cell productivity-dashboard}}

**Today's engagement:**
- Tasks started: {{cell tasks-started}}
- Tasks completed: {{cell tasks-completed}}
- Time engaged: {{cell time-engaged}} hours
- Focus score: {{cell focus-score}}%

**Efficiency metrics:**
- Completion rate: {{cell completion-rate}}%
- Average task time: {{cell avg-task-time}} minutes
- Context switch frequency: {{cell switch-frequency}}
- Deep work ratio: {{cell deep-work-ratio}}%
```

### Energy & Focus Analytics
```synthesis
{{cell energy-analytics}}
**Energy patterns:**
- Peak energy times: {{cell peak-energy-times}}
- Energy dips: {{cell energy-dips}}
- Recovery patterns: {{cell recovery-patterns}}
- Sustainable pace: {{cell sustainable-pace}}

**Focus analysis:**
{{eval analyze-focus-patterns}}
→ Best focus times: {{cell best-focus-times}}
→ Common distractions: {{cell common-distractions}}
→ Focus duration: {{cell focus-duration}}
→ Recovery needs: {{cell recovery-needs}}
```

### Task Completion Intelligence
```synthesis
{{eval analyze-completion-patterns}}
**Completion factors:**
- Time of day: {{cell completion-time-patterns}}
- Day of week: {{cell completion-day-patterns}}
- Context effectiveness: {{cell context-effectiveness}}
- Task characteristics: {{cell task-characteristics}}

**Predictive completion:**
{{cell predictive-completion}}
- Likely completion time: {{cell likely-completion}}
- Risk factors: {{cell completion-risks}}
- Success probability: {{cell success-probability}}
- Optimization suggestions: {{cell completion-optimizations}}
```

## 🎮 Gamification & Motivation

### Progress Visualization
```synthesis
{{cell progress-visualization}}
**Today's progress:**
- [██████----] {{cell today-progress}}%
- Streak: {{cell current-streak}} days
- Weekly goal: {{cell weekly-goal-progress}}%
- Monthly target: {{cell monthly-target-progress}}%

**Achievements unlocked:**
{{cell recent-achievements}}
1. {{cell achievement-1}}
2. {{cell achievement-2}}
3. {{cell achievement-3}}
```

### Smart Rewards System
```synthesis
{{eval suggest-rewards}}
**Based on completion:**
- Small win: {{cell small-reward}}
- Medium achievement: {{cell medium-reward}}
- Major milestone: {{cell major-reward}}
- Streak maintenance: {{cell streak-reward}}

**Motivation factors:**
{{cell motivation-analysis}}
- Intrinsic motivation: {{cell intrinsic-motivation}}
- Extrinsic motivation: {{cell extrinsic-motivation}}
- Progress motivation: {{cell progress-motivation}}
- Social motivation: {{cell social-motivation}}
```

## 🔄 Intelligent Workflow Management

### Dynamic Task Sequencing
```synthesis
{{eval optimize-task-sequence}}
**Based on:**
- Energy levels: {{cell energy-sequence}}
- Context availability: {{cell context-sequence}}
- Dependencies: {{cell dependency-sequence}}
- Deadlines: {{cell deadline-sequence}}

**Optimal flow:**
1. {{cell flow-task-1}} ({{cell flow-reason-1}})
2. {{cell flow-task-2}} ({{cell flow-reason-2}})
3. {{cell flow-task-3}} ({{cell flow-reason-3}})
4. {{cell flow-task-4}} ({{cell flow-reason-4}}
```

### Smart Break Scheduling
```synthesis
{{eval schedule-smart-breaks}}
**Break recommendations:**
- Micro-breaks: Every {{cell micro-break-interval}} minutes
- Pomodoro breaks: Every {{cell pomodoro-break-interval}} minutes
- Meal breaks: {{cell meal-break-times}}
- Recovery breaks: {{cell recovery-break-times}}

**Break activities:**
{{eval suggest-break-activities}}
→ Physical: {{cell physical-breaks}}
→ Mental: {{cell mental-breaks}}
→ Social: {{cell social-breaks}}
→ Creative: {{cell creative-breaks}}
```

### Interruption Management
```synthesis
{{cell interruption-management}}
**Current focus shield:** {{cell focus-shield-status}}
**Interception rules:**
- Urgent interruptions: {{cell urgent-handling}}
- Important interruptions: {{cell important-handling}}
- Optional interruptions: {{cell optional-handling}}
- Scheduled interruptions: {{cell scheduled-handling}}

**Recovery protocol:**
{{eval recover-from-interruption}}
→ Time lost: {{cell interruption-time}}
→ Mental reload: {{cell mental-reload-time}}
→ Resume point: {{cell resume-point}}
→ Prevention: {{cell prevention-suggestions}}
```

## 📱 Mobile-Optimized Engagement

### Touch-Optimized Interface
```synthesis
{{eval optimize-for-mobile-engagement}}
**Mobile features:**
- One-tap actions: {{cell one-tap-actions}}
- Swipe gestures: {{cell swipe-gestures}}
- Voice commands: {{cell voice-commands}}
- Haptic feedback: {{cell haptic-feedback}}

**On-the-go engagement:**
{{eval enable-mobile-engagement}}
→ Quick tasks: {{cell mobile-quick-tasks}}
→ Voice updates: {{cell voice-updates}}
→ Photo documentation: {{cell photo-documentation}}
→ Location-based tasks: {{cell location-tasks}}
```

### Offline Engagement
```synthesis
{{eval enable-offline-engagement}}
**Offline capabilities:**
- Task caching: {{cell task-cache-size}}
- Progress tracking: {{cell offline-progress}}
- Sync management: {{cell sync-management}}
- Conflict resolution: {{cell conflict-resolution}}

**Battery optimization:**
{{eval optimize-battery-usage}}
→ Background sync: {{cell background-sync}}
→ Update frequency: {{cell update-frequency}}
→ Power modes: {{cell power-modes}}
→ Efficiency score: {{cell battery-efficiency}}
```

## 🛠️ Advanced Synthesis Features

### Natural Language Engagement
```synthesis
## 💬 Engagement Conversation
**Example commands:**
- "What should I work on now?": {{eval suggest-now-task}}
- "Start working on [task]": {{eval start-specific-task}}
- "Take a break": {{eval initiate-break}}
- "Log completion of [task]": {{eval log-completion}}
- "Reschedule [task]": {{eval reschedule-task}}

**Voice engagement (mobile):**
{{eval enable-voice-engagement}}
→ "Start work" → Begins focused session
→ "Log task done" → Records completion
→ "Suggest next" → Recommends next action
→ "Take break" → Initiates smart break
```

### Learning Engagement Patterns
```synthesis
{{eval learn-engagement-patterns}}
**Learning from:**
- Task completion times: {{cell completion-time-learning}}
- Focus duration: {{cell focus-duration-learning}}
- Break effectiveness: {{cell break-effectiveness-learning}}
- Motivation factors: {{cell motivation-learning}}

**Personalization:**
{{eval personalize-engagement}}
→ Adapts to: {{cell personalization-areas}}
→ Improves: {{cell improvement-areas}}
→ Optimizes: {{cell optimization-areas}}
```

### Integration with Other Systems
```synthesis
{{eval integrate-with-calendar-engagement}}
**Calendar sync:**
- Time blocking: {{cell time-blocking-integration}}
- Meeting preparation: {{cell meeting-prep-integration}}
- Availability management: {{cell availability-integration}}
- Schedule optimization: {{cell schedule-integration}}

**Communication integration:**
{{eval integrate-with-communication}}
→ Email tasks: {{cell email-integration}}
→ Chat tasks: {{cell chat-integration}}
→ Meeting tasks: {{cell meeting-integration}}
→ Collaboration tasks: {{cell collaboration-integration}}
```

## 📊 Engagement Analytics & Reporting

### Daily Engagement Report
```synthesis
{{eval generate-daily-engagement-report}}
**Today's summary:**
- Tasks completed: {{cell daily-completed}}
- Time engaged: {{cell daily-time-engaged}}
- Focus score: {{cell daily-focus-score}}
- Productivity score: {{cell daily-productivity-score}}

**Achievements:**
{{cell daily-achievements}}
1. {{cell achievement-1}}
2. {{cell achievement-2}}
3. {{cell achievement-3}}

**Improvement suggestions:**
{{eval suggest-daily-improvements}}
1. {{cell improvement-1}}
2. {{cell improvement-2}}
3. {{cell improvement-3}}
```

### Weekly Engagement Trends
```synthesis
{{cell weekly-engagement-trends}}
**Trend analysis:**
- Completion trends: {{cell completion-trends}}
- Focus trends: {{cell focus-trends}}
- Energy trends: {{cell energy-trends}}
- Productivity trends: {{cell productivity-trends}}

**Pattern recognition:**
{{eval identify-engagement-patterns}}
→ Productive patterns: {{cell productive-patterns}}
→ Inefficient patterns: {{cell inefficient-patterns}}
→ Improvement opportunities: {{cell improvement-opportunities}}
→ Success factors: {{cell success-factors}}
```

## 📋 Quick Reference

### Common Engagement Commands
```synthesis
## 🎯 Quick Actions
{{eval start-now}} - Start focused work session
{{eval suggest-next}} - Suggest next task
{{eval take-break}} - Take smart break
{{eval log-completion}} - Log task completion
{{eval reschedule}} - Reschedule current task

## 📊 Quick Analytics
{{eval show-today-stats}} - Today's engagement stats
{{eval show-focus-score}} - Current focus score
{{eval show-productivity}} - Productivity metrics
{{eval show-streak}} - Current streak
```

### Personal Engagement Profiles
```synthesis
{{eval my-focus-mode}} - Your focus settings
{{eval my-break-profile}} - Your break preferences
{{eval my-energy-profile}} - Your energy patterns
{{eval my-motivation-profile}} - Your motivation factors
```

---

**Note:** This enhanced engagement dashboard requires Synthesis Lab installation. It integrates with the intelligent review from [[Enhanced Weekly Review]] and provides dynamic task selection.

**Natural Language Examples:**
- "{{eval what should I do now}}"
- "{{eval start working on reports}}"
- "{{eval take a 5-minute break}}"
- "{{eval show me my progress today}}"

**Mobile Optimization:** Use voice commands for hands-free engagement or touch gestures for quick task management on mobile devices.

---
