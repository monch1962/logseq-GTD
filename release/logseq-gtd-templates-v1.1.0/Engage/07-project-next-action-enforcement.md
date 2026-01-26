template:: GTD Project Next Action Enforcement
description:: Ensure every project has at least one next action defined (Guided GTD approach)
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Guided GTD (enforcement with guidance)

# GTD Project Next Action Enforcement

## 🎯 GTD Principle: Every Project Needs a Next Action

**GTD Rule:** "A project is any desired result that requires more than one action step. Therefore, every project must have a next action defined."

**Guided Approach:** We encourage and guide users to define next actions for all projects, with warnings for non-compliance rather than blocking.

## 📋 Project Template with Next Action Enforcement

### Basic Project Template
```markdown
# {{project-name}}
type:: project
status:: {{active|on-hold|completed}}
created:: {{now}}
target-completion:: {{yyyy-mm-dd}}
owner:: [[{{person}}]]
review-schedule:: {{weekly|biweekly|monthly}}

## 🎯 Project Purpose
{{why-this-project-exists}}

## ✅ Success Criteria
- [ ] {{criteria-1}}
- [ ] {{criteria-2}}
- [ ] {{criteria-3}}

## 🔥 NEXT ACTION (REQUIRED)
**What's the very next physical action?**
- TODO {{clear-action-verb}} {{specific-outcome}}
  next-action:: true
  context:: {{@computer|@phone|@office|@home|@errands}}
  priority:: {{HIGH|MEDIUM|LOW}}
  time-estimate:: {{5|15|30|60|120}} minutes
  due-date:: {{yyyy-mm-dd}}
  assigned-to:: [[{{person}}]]

## 📋 Additional Actions
- TODO {{action-2}}
- TODO {{action-3}}
- TODO {{action-4}}

## 🔗 Dependencies
depends-on:: [[{{project-or-task}}]]
blocks:: [[{{project-or-task}}]]

## 📁 Reference Materials
- [[{{document-1}}]]
- [[{{document-2}}]]
- [[{{document-3}}]]

## 📝 Notes
{{project-notes}}
```

## ⚠️ Project Compliance Checks

### Projects Without Next Actions
{{query {:title "⚠️ Projects Missing Next Actions"
         :query [:find (pull ?p [:block/name :block/properties])
                 :where
                 [?p :block/properties ?props]
                 [(get ?props :type) "project"]
                 [(get ?props :status) "active"]
                 (not [?a :block/properties ?a-props]
                      [(get ?a-props :project) ?p]
                      [(get ?a-props :next-action) true])]
         :result-transform (fn [results]
                             (map (fn [r]
                                    {:title (str "📁 " (:block/name r))
                                     :description "No next action defined"
                                     :url (str "/page/" (:block/name r))
                                     :action "Define next action"})
                                  results))}}}

### Next Action Quality Check
{{query {:title "⚠️ Vague Project Next Actions"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :next-action) true]
                 ; Check for vague action verbs
                 [(clojure.string/includes? (:block/content ?b) "work on")]
                 [(clojure.string/includes? (:block/content ?b) "look into")]
                 [(clojure.string/includes? (:block/content ?b) "think about")]]
         :limit 5
         :result-transform (fn [results]
                             (map (fn [r]
                                    {:title (str "❌ " (:block/content r))
                                     :description "Make more specific. Example: 'Draft introduction section' not 'Work on report'"
                                     :url (str "#" (:block/uuid r))})
                                  results))}}}

### Stale Next Actions (>7 days without update)
{{query {:title "⚠️ Stale Next Actions (>7 days)"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :next-action) true]
                 [(get ?props :status) "not-started"]
                 [(get ?props :last-reviewed) ?reviewed]
                 [(> (days-between "{{today}}" ?reviewed) 7)]]
         :limit 5}}}

## 🛠️ Next Action Definition Tools

### Next Action Generator
**Project:** {{project-name}}
**Desired Outcome:** {{project-outcome}}

**Suggested Next Actions:**
1. **Research:** Gather information about {{topic}}
2. **Plan:** Create outline/structure for {{deliverable}}
3. **Create:** Draft first version of {{component}}
4. **Review:** Get feedback on {{item}}
5. **Finalize:** Complete and submit {{deliverable}}

**Selected Next Action:**
- TODO {{selected-action}}
  next-action:: true
  context:: {{appropriate-context}}
  priority:: {{HIGH|MEDIUM|LOW}}
  time-estimate:: {{realistic-estimate}}

### Action Verb Library
**Clear action verbs to use:**
- **Create:** Draft, write, design, build, develop
- **Review:** Check, verify, test, validate, proofread
- **Communicate:** Call, email, message, discuss, present
- **Organize:** Sort, file, categorize, arrange, schedule
- **Research:** Find, gather, analyze, investigate, study

**Vague verbs to avoid:**
- Work on, look into, think about, handle, deal with

### Context Assignment Guide
**For project next actions:**
- **@computer:** Writing, research, design, coding
- **@phone:** Calls, interviews, follow-ups
- **@office:** Meetings, collaboration, presentations
- **@home:** Planning, thinking, personal projects
- **@errands:** Purchases, deliveries, appointments

## 📊 Project Dashboard Integration

### Active Projects with Next Actions
{{query {:title "Active Projects with Next Actions"
         :query [:find (pull ?p [:block/name :block/properties])
                 :where
                 [?p :block/properties ?props]
                 [(get ?props :type) "project"]
                 [(get ?props :status) "active"]
                 [?a :block/properties ?a-props]
                 [(get ?a-props :project) ?p]
                 [(get ?a-props :next-action) true]]
         :limit 10
         :result-transform (fn [results]
                             (map (fn [r]
                                    {:title (str "✅ " (:block/name r))
                                     :description "Has defined next action"
                                     :url (str "/page/" (:block/name r))})
                                  results))}}}

### Project Next Action Status
{{query {:title "Project Next Action Status"
         :query [:find ?status (count ?p)
                 :where
                 [?p :block/properties ?props]
                 [(get ?props :type) "project"]
                 [(get ?props :status) "active"]
                 (or-join [?p ?status]
                   (and [?a :block/properties ?a-props]
                        [(get ?a-props :project) ?p]
                        [(get ?a-props :next-action) true]
                        [(get ?a-props :status) ?status])
                   (and (not [?a :block/properties ?a-props]
                             [(get ?a-props :project) ?p]
                             [(get ?a-props :next-action) true])
                        [(identity "no-next-action") ?status]))]
         :group-by ?status
         :view :table}}}

## 🔄 Project Review Workflow

### Weekly Project Review
1. **For each active project:**
   - Is the next action still valid?
   - Has it been completed?
   - Does it need to be updated?
   - Is the project still active?

2. **Next Action Update Process:**
   - Complete current next action → mark done
   - Define new next action → add to project
   - Update project status if needed
   - Review dependencies and blockers

### Project Completion Checklist
- [ ] All project actions completed
- [ ] Success criteria met
- [ ] Deliverables submitted
- [ ] Documentation updated
- [ ] Project page archived
- [ ] Lessons learned captured

## 📱 Mobile Optimization

### Mobile Project Management
- **Quick next action capture** from project page
- **Voice dictation** for action definition
- **Camera integration** for project references
- **Location-based** context suggestions

### Mobile-Specific Features
- **Project widget** showing next action
- **Notification reminders** for project reviews
- **Offline project access** with next actions
- **Quick status updates** via mobile

### Touch-Optimized Interface
- **Large buttons** for action completion
- **Swipe gestures** between projects
- **Voice commands** for project navigation
- **Simplified views** for small screens

## ⚙️ Enforcement Settings

### Guided GTD Configuration
```markdown
## Project Next Action Settings
enforcement-level:: guided  # strict|guided|informational
required-for-active:: true
quality-checks:: true
weekly-review-reminder:: true
mobile-optimized:: true

## Warning Triggers
warn-no-next-action:: true
warn-vague-action:: true  
warn-stale-action:: true
warn-missing-context:: true

## Notification Settings
notify-weekly-review:: true
notify-project-updates:: true
notify-action-completion:: true
```

### Customization Options
- **Strict mode:** Require next action for active projects
- **Guided mode:** Warn but allow continuation (default)
- **Informational mode:** Only show statistics
- **Quality thresholds:** Customize warning criteria

## 🔗 Integration with Other Templates

### Template Connections
- **[[GTD Daily Journal]]** - Shows project next actions in context
- **[[GTD Next Actions Dashboard]]** - Includes project-linked next actions
- **[[GTD Weekly Review]]** - Project review section
- **[[GTD Task Processing]]** - Next action definition during processing

### Workflow Integration
1. **Capture:** New project idea → [[GTD Quick Capture]]
2. **Define:** Project setup → This template
3. **Execute:** Next actions → [[GTD Next Actions Dashboard]]
4. **Review:** Weekly check → [[GTD Weekly Review]]
5. **Complete:** Project closure → Archive process

## ✅ Success Metrics

### Project Health Indicators
- **Next Action Coverage:** % of projects with defined next actions
- **Action Quality:** % of specific vs vague next actions
- **Completion Rate:** % of next actions completed on time
- **Review Consistency:** Regular project reviews completed
- **Project Velocity:** Time from next action to completion

### GTD Compliance Metrics
- **Project Trust:** Users trust the system for project tracking
- **Next Action Clarity:** Clear understanding of what to do next
- **Progress Visibility:** Easy to see project status
- **Stress Reduction:** Reduced anxiety about project management
- **Focus Improvement:** Better concentration on current work

## 🆘 Troubleshooting & Help

### Common Issues & Solutions
**Issue:** "I don't know what the next action should be"
**Solution:** Use the Next Action Generator or break down the project outcome

**Issue:** "The next action keeps changing"
**Solution:** That's normal! Update it during weekly reviews

**Issue:** "My project has no clear next action"
**Solution:** Consider if it's really a project or just a someday/maybe item

**Issue:** "I have too many project next actions"
**Solution:** Prioritize! Use HIGH/MEDIUM/LOW and focus on current context

### Getting Help
- **Template Guide:** [[GTD Template Documentation]]
- **GTD Principles:** [[GTD Methodology Overview]]
- **User Community:** [[GTD User Forum]]
- **Support:** [[GTD System Support]]

## 📈 Continuous Improvement

### Feedback Loop
1. **Track metrics** on project next action effectiveness
2. **Gather user feedback** on template usability
3. **Adjust enforcement levels** based on usage patterns
4. **Update templates** with improvements
5. **Share best practices** with user community

### Version History
- **v1.0:** Initial release with Guided GTD approach
- **Future:** Advanced analytics, AI suggestions, integration enhancements