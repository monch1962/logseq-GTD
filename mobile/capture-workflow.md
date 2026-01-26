# Mobile Capture Workflow for Logseq GTD

## 1. Quick Capture Methods

### A. iOS Shortcuts Setup
```yaml
Shortcut: "Quick Capture to Logseq"
Steps:
1. Ask for input with "What's on your mind?"
2. Get current date and time
3. Format as: `- {{input}} \n  captured:: {{datetime}}`
4. Append to file: `logseq://graph/MyGraph?file=inbox.md`
5. Show confirmation
```

### B. Android Automate/Tasker Setup
```yaml
Flow: Quick Capture
1. Voice input or text input
2. Get location context
3. Format: `- {{input}} \n  context:: {{location}} \n  captured:: {{time}}`
4. Append to Markdown file
5. Sync via Git/Dropbox
```

### C. Web Clip/Share Extension
```javascript
// Browser extension for capturing web content
function captureToLogseq(url, title, selection) {
  const content = `- [[${title}]]\n  url:: ${url}\n  excerpt:: "${selection}"\n  captured:: ${new Date().toISOString()}`;
  appendToLogseqInbox(content);
}
```

## 2. Capture Templates

### Template 1: Quick Task
```markdown
- TODO {{text}}
  id:: {{uuid}}
  captured:: {{datetime}}
  source:: mobile
  status:: unprocessed
```

### Template 2: Idea/Note
```markdown
- {{text}}
  type:: idea
  captured:: {{datetime}}
  tags:: {{auto-tags}}
```

### Template 3: Reference
```markdown
- [[{{title}}]]
  type:: reference
  url:: {{url}}
  captured:: {{datetime}}
  summary:: {{summary}}
```

### Template 4: Voice Memo
```markdown
- 🎤 {{transcribed-text}}
  type:: voice-memo
  captured:: {{datetime}}
  duration:: {{duration}}
  file:: {{audio-file}}
```

## 3. Inbox Processing Templates

### Processing Page Template
```markdown
# Inbox Processing - {{date}}

## Unprocessed Items
{{query:unprocessed-inbox}}

## Processing Actions
For each item:
- [ ] Processed
- [ ] Assigned project
- [ ] Set priority
- [ ] Added context
- [ ] Set due date

## Quick Processing Shortcuts
- `pp` → Process as personal project
- `pw` → Process as work project
- `pr` → Process as reference
- `ps` → Process as someday/maybe
```

### Processing Query
```clojure
#+BEGIN_QUERY
{:title "📥 Unprocessed Inbox"
 :query [:find (pull ?b [*])
         :where
         [?b :block/page ?page]
         [(= ?page [:block/name "inbox"])]
         [?b :block/properties ?props]
         [(get ?props :status) "unprocessed"]
         ]
 :result-transform (fn [results]
                     (sort-by :block/created-at results))}
#+END_QUERY
```

## 4. Mobile-Optimized Views

### Today's Dashboard (Mobile)
```markdown
# Today {{date}}

## Quick Capture
[[Quick Capture Form]]

## Next Actions
{{query:mobile-next-actions context=current}}

## Due Today
{{query:due-today}}

## Inbox ({{count}})
[[inbox]]
```

### Mobile Next Actions Query
```clojure
#+BEGIN_QUERY
{:title "📱 Next Actions"
 :query [:find (pull ?b [*])
         :in $ ?location
         :where
         [?b :block/marker "TODO"]
         [?b :block/priority ?p]
         [(contains? #{"A" "B"} ?p)]
         
         ; Location-based context
         (or-join [?b ?location]
           [?b :block/refs ?tag]
           [?tag :block/name ?location]
           [?b :block/properties ?props]
           [(get ?props :context) ?location]
           [(= ?location "anywhere")])
         
         ; Quick tasks (< 30min)
         [?b :block/properties ?props2]
         [(get ?props2 :time-estimate) ?time]
         [(<= ?time 30)]]
 :inputs [:location]}
#+END_QUERY
```

## 5. Sync and Backup

### Git Sync for Mobile
```bash
#!/bin/bash
# Mobile sync script
cd ~/Documents/logseq-graph
git add .
git commit -m "Mobile capture: $(date)"
git push origin main
```

### Conflict Resolution Rules
```markdown
# Sync Rules
1. Mobile captures always win for new items
2. Desktop edits win for existing items
3. Timestamp-based resolution for conflicts
4. Daily backup to cloud storage
```

## 6. Voice Integration

### Voice Command Examples
```
"Logseq, add task: Call John about project"
"Logseq, capture idea: New feature for app"
"Logseq, what's next at office?"
"Logseq, process inbox"
```

### Voice Processing Workflow
```python
def process_voice_command(command):
    if "add task" in command:
        task = extract_task(command)
        return f"- TODO {task}\n  captured:: {datetime.now()}\n  source:: voice"
    elif "capture idea" in command:
        idea = extract_idea(command)
        return f"- {idea}\n  type:: idea\n  captured:: {datetime.now()}"
```

## 7. Notification Integration

### Task Reminders
```javascript
// Check for due tasks
function checkDueTasks() {
    const dueTasks = queryTasksDueToday();
    dueTasks.forEach(task => {
        sendNotification(`Due: ${task.title}`);
    });
}

// Context-aware notifications
function checkLocationBasedTasks(location) {
    const locationTasks = queryTasksByContext(location);
    if (locationTasks.length > 0) {
        sendNotification(`Tasks available at ${location}: ${locationTasks.length}`);
    }
}
```

## Implementation Checklist

- [ ] Set up mobile capture shortcuts
- [ ] Create inbox processing workflow
- [ ] Configure sync between devices
- [ ] Test voice capture (if needed)
- [ ] Set up notifications
- [ ] Create mobile-optimized dashboards
- [ ] Train processing habits
- [ ] Regular review and refinement
