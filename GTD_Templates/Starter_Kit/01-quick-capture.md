template:: GTD Quick Capture
description:: Ultra-fast mobile capture for inbox items (<10 seconds)
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Capture phase - Ultra-fast entry to trusted system

# GTD Quick Capture

## 🚀 Ultra-Fast Capture (Mobile Optimized)

### Option 1: One-Tap Capture (Simplest)
- {{capture-text}}
  captured:: {{now}}
  source:: {{mobile|desktop|voice}}
  status:: unprocessed
  type:: inbox-item

### Option 2: Categorized Quick Capture
- {{task-or-idea}}
  captured:: {{now}}
  category:: {{task|idea|reference|reminder}}
  urgency:: {{urgent|normal|low}}
  status:: unprocessed

### Option 3: Voice/Text Memo
- 🎤 {{voice-memo-text}}
  captured:: {{now}}
  type:: voice-memo
  duration:: {{seconds}}
  status:: unprocessed
  location:: {{optional-location}}

## 📱 Mobile-Specific Features

### iOS Shortcuts Integration
```
1. Ask for input: "What to capture?"
2. Get current date/time
3. Format: "- {input}\n  captured:: {timestamp}\n  status:: unprocessed"
4. Append to inbox.md
5. Show confirmation
```

### Android Quick Text
```
Share → Logseq → Auto-append to inbox
```

## 🖥️ Desktop Quick Keys
- `Ctrl+Shift+I` → Quick capture dialog
- Type `/quick-capture` in any page

## 📊 Capture Statistics
{{query {:title "📈 Today's Captures"
         :query [:find (count ?b)
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :captured) ?captured]
                 [(clojure.string/includes? ?captured "{{today}}")]]
         :view :text}}}

## 🎯 Best Practices
1. **Capture first, process later** - Don't organize during capture
2. **Keep it simple** - One thought per capture
3. **Use voice on mobile** - Faster than typing
4. **Process daily** - Clear inbox every 24 hours
5. **Tag immediately if obvious** - e.g., `#work` `#personal`

## 🔄 Processing Workflow
1. **Daily Review:** Process all unprocessed items
2. **Categorize:** Task, Project, Reference, Someday/Maybe
3. **Actionable?** If yes → Next Action, If no → File/Delete
4. **Assign:** Context, Priority, Due Date
5. **Move:** From inbox to appropriate location

## ⚠️ Common Capture Mistakes
- ❌ Writing paragraphs instead of bullet points
- ❌ Trying to organize during capture
- ❌ Skipping daily processing
- ❌ Not using voice capture on mobile
- ❌ Capturing to wrong place (use inbox only)

## 📝 Example Captures
```
- Call dentist about appointment
  captured:: 2024-01-30T08:30:00
  status:: unprocessed

- Research new project management tools
  captured:: 2024-01-30T10:15:00
  category:: reference
  status:: unprocessed

- Idea: Weekly team brainstorming session
  captured:: 2024-01-30T14:45:00
  type:: idea
  status:: unprocessed
```

## 🛠️ Template Customization
- Adjust time format: `{{now}}` vs `{{timestamp}}`
- Add custom categories: `{{work|personal|errand}}`
- Include location: `{{gps-coordinates}}`
- Add energy level: `{{high|medium|low}}`

## 📋 Quick Reference
- **Inbox Goal:** 0 items by EOD
- **Capture Time:** <10 seconds
- **Processing Time:** <2 minutes per item
- **Success Metric:** Empty inbox daily