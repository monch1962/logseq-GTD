# Complete GTD Implementation Example

## File Structure
```
logseq-gtd/
├── pages/
│   ├── inbox.md          # Capture point
│   ├── projects.md       # Active projects
│   ├── areas.md          # Areas of responsibility
│   ├── references.md     # Non-actionable items
│   └── someday.md        # Future ideas
├── journals/             # Daily pages
│   └── 2024-01-30.md
├── templates/            # GTD templates
│   └── gtd-templates.md
└── queries/              # Saved queries
    └── dashboard.md
```

## 1. Inbox Implementation

### `pages/inbox.md`
```markdown
# Inbox

## Unprocessed
- TODO Call dentist about appointment
  captured:: 2024-01-30T08:30:00
  source:: mobile
  
- Research new project management tools
  captured:: 2024-01-30T10:15:00
  source:: web
  
- [[Interesting article about productivity]]
  captured:: 2024-01-30T11:45:00
  type:: reference

## Processing Queue
{{query:unprocessed-inbox}}
```

## 2. Project Implementation

### `pages/projects.md`
```markdown
# Projects

## Active
### Website Redesign
type:: project
status:: active
target-completion:: 2024-03-15

**Next Actions:**
- TODO Draft new homepage content
  priority:: A
  context:: computer
  time-estimate:: 60
  
- TODO Review competitor websites
  priority:: B
  context:: computer
  time-estimate:: 30

### Quarterly Planning
type:: project
status:: active
target-completion:: 2024-02-15

**Next Actions:**
- TODO Schedule planning meeting
  priority:: A
  context:: office
  time-estimate:: 15
```

## 3. Context-Based Task Views

### `pages/contexts.md`
```markdown
# Contexts

## @computer
{{query:next-actions context=computer}}

## @office
{{query:next-actions context=office}}

## @phone
{{query:next-actions context=phone}}

## @errand
{{query:next-actions context=errand}}

## @home
{{query:next-actions context=home}}
```

## 4. Daily Journal with GTD Integration

### `journals/2024-01-30.md`
```markdown
# 2024-01-30

## Daily Plan
**Focus:** Complete website draft

### Morning Review
- [x] Process inbox (3 items)
- [x] Review calendar
- [ ] Check waiting-for

### Today's Priorities
1. Draft homepage content (A priority)
2. Team meeting at 2 PM
3. Process inbox completely

### Energy Schedule
- **High energy (8-11 AM):** Creative work
- **Medium energy (11-2 PM):** Meetings, communication
- **Low energy (3-5 PM):** Administrative tasks

## Work Log
### 8:30 AM
Started drafting homepage content. Key points:
- Clear value proposition
- Simple navigation
- Strong call-to-action

### 2:00 PM
Team meeting notes:
- Project timeline approved
- Budget constraints discussed
- Next review scheduled for Feb 15

## Captured Items
- TODO Follow up with design team about mockups
  captured:: 2024-01-30T14:30:00
  context:: office
  priority:: B

## Evening Review
**Accomplished:**
- Drafted homepage content
- Processed 5 inbox items
- Completed team meeting

**Carry Forward:**
- Follow up with design team
- Review analytics report

**Tomorrow's Focus:**
- Review draft with team
- Process remaining inbox items
```

## 5. Smart Dashboard

### `queries/dashboard.md`
````markdown
# GTD Dashboard

## Quick Stats
```clojure
#+BEGIN_QUERY
{:title "📊 Task Summary"
 :query [:find (count ?b) ?status
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :status) ?status]]
 :view :table}
#+END_QUERY
```

## Next Actions by Priority
```clojure
#+BEGIN_QUERY
{:title "🚀 Priority A Tasks"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         [?b :block/marker "TODO"]
         [?b :block/priority "A"]
         (not [?b :block/refs ?dep]
              [?dep :block/marker "TODO"])]}
#+END_QUERY
```

## Due This Week
```clojure
#+BEGIN_QUERY
{:title "📅 Due This Week"
 :query [:find (pull ?b [*])
         :where
         [?b :block/marker "TODO"]
         [?b :block/properties ?props]
         [(get ?props :due-date) ?due]
         [(<= ?due (today-plus 7))]]}
#+END_QUERY
```

## Blocked Tasks
```clojure
#+BEGIN_QUERY
{:title "🚧 Blocked Tasks"
 :query [:find (pull ?b [*])
         :where
         [?b :block/marker "TODO"]
         [?b :block/refs ?dep]
         [?dep :block/marker "TODO"]]}
#+END_QUERY
```

## Inbox Status
```clojure
#+BEGIN_QUERY
{:title "📥 Inbox Status"
 :query [:find (count ?b)
         :where
         [?b :block/page ?page]
         [?page :block/name "inbox"]
         [?b :block/properties ?props]
         [(get ?props :status) "unprocessed"]]}
#+END_QUERY
```
````

## 6. Mobile Capture Implementation

### iOS Shortcut: "Quick Capture to Logseq"
```
1. Ask for input: "What would you like to capture?"
2. Get current date and time
3. Format text:
   - {Provided Input}
     captured:: {Current Date and Time}
     source:: mobile
     status:: unprocessed
4. Get file "inbox.md" from iCloud/Logseq
5. Append to file
6. Show confirmation
```

### Android: Tasker Profile
```
Profile: Quick Capture
Event: Notification (Logseq Capture)
Task:
1. Get voice/text input
2. Get location
3. Write to file:
   - {Input}
     captured:: {Time}
     location:: {Location}
     status:: unprocessed
4. Sync via Git/Dropbox
```

## 7. Processing Workflow

### Step-by-Step Processing:
1. **Open Inbox** (`inbox.md`)
2. **For each item:**
   - If actionable:
     - Define next action
     - Assign project/context
     - Set priority/due date
     - Move to appropriate location
   - If not actionable:
     - File as reference
     - Move to someday/maybe
     - Delete if irrelevant
3. **Review processed items** weekly

### Processing Query:
```clojure
#+BEGIN_QUERY
{:title "🔄 Process Inbox"
 :query [:find (pull ?b [*])
         :where
         [?b :block/page ?page]
         [?page :block/name "inbox"]
         [?b :block/properties ?props]
         [(get ?props :status) "unprocessed"]]
 :view :page}
#+END_QUERY
```

## 8. Weekly Review Template

### `templates/weekly-review.md`
```markdown
# Weekly Review - {{date}}

## Collection Points
- [ ] Physical inbox
- [ ] Email inbox
- [ ] Digital notes
- [ ] Voice memos
- [ ] Browser bookmarks

## Projects Review
{{query:all-projects}}

## Next Actions Review
{{query:all-next-actions}}

## Waiting For Review
{{query:waiting-for}}

## Calendar Review
- Past week review
- Upcoming week preview
- Long-term commitments

## Goals & Objectives
- Progress check
- Adjustments needed
- New objectives

## Someday/Maybe
- Review list
- Promote if ready
- Remove if irrelevant
```

## Implementation Tips

1. **Start Simple:** Begin with basic inbox and next actions
2. **Gradual Adoption:** Add contexts, then priorities, then dependencies
3. **Mobile First:** Ensure capture works on mobile before optimizing desktop
4. **Regular Reviews:** Daily quick review, weekly comprehensive review
5. **Iterate:** Adjust system based on what works for you
6. **Automate:** Use queries and templates to reduce manual work
7. **Sync:** Ensure all devices have access to current data
8. **Backup:** Regular backups of your Logseq graph
