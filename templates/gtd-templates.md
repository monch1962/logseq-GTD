# GTD Templates for Logseq

## 1. Task Template with Full GTD Metadata

```markdown
- TODO {{description}}
  id:: {{uuid}}
  created:: {{date}}
  
  # GTD Properties
  priority:: {{A|B|C}}
  context:: {{context/tag}}
  project:: [[{{project-page}}]]
  area:: [[{{area-of-responsibility}}]]
  
  # Execution Properties
  energy:: {{high|medium|low}}
  time-estimate:: {{minutes}}
  due-date:: {{yyyy-mm-dd}}
  scheduled:: {{yyyy-mm-dd}}
  
  # Dependencies
  depends-on:: [[{{block-id}}]]
  blocks:: [[{{block-id}}]]
  
  # Status Tracking
  status:: {{not-started|in-progress|waiting|completed}}
  started:: {{date}}
  completed:: {{date}}
  
  # Additional
  tags:: {{tag1}} {{tag2}}
  notes:: |
    {{multiline-notes}}
```

## 2. Project Template

```markdown
# {{Project Name}}
type:: project
status:: {{active|on-hold|completed}}
created:: {{date}}
target-completion:: {{date}}
owner:: [[{{person}}]]

## Purpose
{{Why this project exists}}

## Success Criteria
- [ ] {{criteria-1}}
- [ ] {{criteria-2}}

## Next Actions
{{query:project-next-actions id={{current-id}}}}

## Backlog
- TODO {{action-1}}
- TODO {{action-2}}

## Reference
- [[Related document 1]]
- [[Related document 2]]

## Notes
{{project-notes}}
```

## 3. Area of Responsibility Template

```markdown
# {{Area Name}} (Area)
type:: area
review-schedule:: {{weekly|monthly}}

## Current Projects
{{query:area-projects area={{current-id}}}}

## Active Tasks
{{query:area-tasks area={{current-id}}}}

## Resources
- [[{{resource-1}}]]
- [[{{resource-2}}]]

## Standards
{{area-standards}}

## Review Notes
### {{review-date}}
{{review-notes}}
```

## 4. Weekly Review Template

```markdown
# Weekly Review - {{week-ending}}

## 1. Collect
- [ ] Process physical inbox
- [ ] Process digital inbox
- [ ] Capture loose thoughts

## 2. Process
- [ ] Review all inbox items
- [ ] Empty all collection points

## 3. Organize
- [ ] Review projects list
- [ ] Update next actions
- [ ] Review waiting-for list
- [ ] Update someday/maybe

## 4. Review
- [ ] Review calendar (past & future)
- [ ] Review goals & objectives
- [ ] Review areas of responsibility

## 5. Plan
- [ ] Set priorities for week
- [ ] Schedule key actions
- [ ] Identify potential obstacles

## Notes
{{review-notes}}
```

## 5. Daily Planning Template

```markdown
# {{date}} - Daily Plan

## Morning Review
- [ ] Process overnight inbox
- [ ] Review calendar
- [ ] Check waiting-for

## Today's Priorities
1. {{priority-1}}
2. {{priority-2}}
3. {{priority-3}}

## Schedule
```timetable
8:00-9:00: {{task}}
9:00-10:30: {{task}}
10:30-12:00: {{task}}
```

## Context-Based Tasks
### @office
- {{task-1}}
- {{task-2}}

### @computer
- {{task-1}}
- {{task-2}}

### @phone
- {{task-1}}

## Energy Management
- High energy times: {{times}}
- Low energy times: {{times}}

## Evening Review
- [ ] Capture incomplete tasks
- [ ] Process new inbox items
- [ ] Plan tomorrow
```

## 6. Quick Capture Templates

### Quick Task
```markdown
- TODO {{text}}
  captured:: {{time}}
  source:: {{mobile|voice|web}}
  status:: unprocessed
```

### Idea
```markdown
- {{text}}
  type:: idea
  captured:: {{time}}
  tags:: {{auto-generated-tags}}
```

### Meeting Note
```markdown
# Meeting: {{topic}} - {{date}}
participants:: {{names}}
duration:: {{minutes}}

## Agenda
1. {{item-1}}
2. {{item-2}}

## Notes
{{meeting-notes}}

## Action Items
- TODO {{action}} @{{person}} due:: {{date}}
```

## 7. Smart Query Templates

### Next Actions by Context
```clojure
{{query:next-actions context={{current-context}}}}
```

### Due This Week
```clojure
{{query:due-this-week}}
```

### Blocked Tasks
```clojure
{{query:blocked-tasks}}
```

### High Impact Tasks
```clojure
{{query:high-impact priority=A time-estimate<=60}}
```

## 8. Mobile-Specific Templates

### One-Tap Capture
```markdown
- {{text}}
  captured:: {{time}}
  location:: {{gps}}
  status:: unprocessed
```

### Voice Memo
```markdown
- 🎤 {{transcribed-text}}
  type:: voice
  duration:: {{seconds}}
  file:: {{audio-file}}
  captured:: {{time}}
```

### Photo Capture
```markdown
- ![]({{image-path}})
  caption:: {{text}}
  captured:: {{time}}
  location:: {{gps}}
```

## Usage Instructions

1. Copy templates to your Logseq templates directory
2. Use `{{variable}}` syntax for dynamic content
3. Customize queries to match your tag structure
4. Set up template shortcuts for quick access
5. Regularly review and update templates as needed
