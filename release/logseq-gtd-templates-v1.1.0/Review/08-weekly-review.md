template:: GTD Weekly Review
description:: Comprehensive weekly review following GTD methodology with reminder system
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Full GTD weekly review process

# GTD Weekly Review - Week of {{week-start}} to {{week-end}}

## 🔔 Review Reminders & Scheduling

### Review Status
**Last Review:** {{last-review-date|Never}}
**Days Since Last Review:** {{days-since-last-review}}
**Next Review Due:** {{next-review-date}}

### ⚠️ Review Alerts
{{if (days-since-last-review > 7)}}
🔴 **OVERDUE!** Weekly review is {{days-since-last-review}} days late
**Recommended action:** Schedule 2 hours for comprehensive review
{{else if (days-since-last-review > 5)}}
🟡 **DUE SOON** Review due in {{7 - days-since-last-review}} days
**Recommended action:** Schedule 1.5 hours this week
{{else}}
🟢 **ON SCHEDULE** Next review in {{7 - days-since-last-review}} days
**Recommended action:** Regular maintenance review
{{end}}

### Review Scheduling
**Preferred day:** {{review-day|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday}}
**Preferred time:** {{review-time|Morning|Afternoon|Evening}}
**Duration needed:** {{review-duration|60|90|120|150}} minutes
**Scheduled time:** {{scheduled-review-time}}

## 📋 GTD Weekly Review Checklist

### Phase 1: Collect & Gather
- [ ] Gather all physical inbox items
- [ ] Process all digital inboxes (email, apps, etc.)
- [ ] Empty mental RAM (capture loose thoughts)
- [ ] Check voice memos and notes
- [ ] Review meeting notes and action items

**Current inbox status:** {{query (read-file "queries/library/capture/inbox-status.clj")}} items

### Phase 2: Process & Empty
- [ ] Process all inbox items to zero
- [ ] Apply 2-minute rule to quick tasks
- [ ] Clarify actionable vs non-actionable
- [ ] Organize into appropriate lists
- [ ] Delete/archive completed items

**Processing progress:** {{processing-progress|0|25|50|75|100}}%

### Phase 3: Organize & Update
- [ ] Review and update project lists
- [ ] Review and update next actions lists
- [ ] Review and update waiting-for list
- [ ] Review and update someday/maybe list
- [ ] File reference materials

### Phase 4: Review & Reflect
- [ ] Review past week's calendar
- [ ] Review upcoming calendar
- [ ] Review goals and objectives
- [ ] Review areas of responsibility
- [ ] Review checklists and templates

### Phase 5: Plan & Prioritize
- [ ] Set priorities for coming week
- [ ] Schedule key actions and meetings
- [ ] Identify potential obstacles
- [ ] Plan energy management
- [ ] Set weekly intentions

## 📊 System Status Review

### Inbox Analysis
**Total captured this week:** {{query (read-file "queries/library/review/weekly-captures.clj")}} items
**Average processing time:** {{average-processing-time}} minutes
**Inbox zero days:** {{inbox-zero-days}}/7

### Next Actions Review
**Total next actions:** {{query (read-file "queries/library/review/total-next-actions.clj")}}
**By priority:** HIGH: {{high-count}}, MEDIUM: {{medium-count}}, LOW: {{low-count}}
**Completion rate:** {{completion-rate}}%
**Average time to complete:** {{average-completion-time}} hours

### Projects Review
**Active projects:** {{query (read-file "queries/library/projects/active-count.clj")}}
**Projects with next actions:** {{projects-with-actions}}/{{total-projects}}
**Project completion rate:** {{project-completion-rate}}%
**Stuck projects:** {{stuck-projects-count}}

### Waiting For Review
**Items waiting:** {{query (read-file "queries/library/dashboard/waiting-items-count.clj")}}
**Overdue follow-ups:** {{overdue-followups}}
**Average wait time:** {{average-wait-time}} days

## 🔍 Detailed Review Sections

### 1. Projects Deep Dive
{{query {:title "Active Projects Status"
         :query [:find (pull ?p [:block/name :block/properties])
                 :where
                 [?p :block/properties ?props]
                 [(get ?props :type) "project"]
                 [(get ?props :status) "active"]]
         :result-transform (fn [results]
                             (map (fn [r]
                                    {:title (str "📁 " (:block/name r))
                                     :description (str "Status: " (get-in r [:block/properties :status] "active")
                                                    " | Next: " (get-in r [:block/properties :next-action] "Not set")
                                                    " | Target: " (get-in r [:block/properties :target-completion] "None"))
                                     :url (str "/page/" (:block/name r))})
                                  results))}}}

**Action:** For each project, verify next action is current and accurate.

### 2. Next Actions Quality Check
{{query {:title "Next Actions Needing Clarification"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/marker "TODO"]
                 [?b :block/properties ?props]
                 [(get ?props :status) "not-started"]
                 ; Quality checks
                 (or-join [?b]
                   [(clojure.string/includes? (:block/content ?b) "work on")]
                   [(clojure.string/includes? (:block/content ?b) "look into")]
                   [(clojure.string/includes? (:block/content ?b) "think about")]
                   (not [?b :block/properties ?p2]
                        [(get ?p2 :context)]))]
         :limit 10}}}

**Action:** Clarify vague actions and add missing contexts.

### 3. Waiting For Follow-ups
{{query {:title "Waiting For Items Needing Follow-up"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "waiting-for"]
                 [(get ?props :status) "waiting"]
                 [(get ?props :followup-date) ?followup]
                 [(<= ?followup "{{today}}")]]
         :limit 10}}}

**Action:** Follow up on overdue items or update expectations.

### 4. Someday/Maybe Review
{{query {:title "Someday/Maybe Items for Consideration"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "someday-maybe"]
                 [(get ?props :interest) "high"]]
         :limit 5}}}

**Action:** Consider promoting to active projects if timing is right.

## 📈 Weekly Metrics & Trends

### Performance Metrics
```markdown
## Week {{week-number}} Metrics
- **Productivity Score:** {{productivity-score}}/100
- **Focus Time:** {{focus-hours}} hours
- **Interruptions:** {{interruption-count}}
- **Energy Levels:** High: {{high-energy-days}}, Medium: {{medium-energy-days}}, Low: {{low-energy-days}}
- **GTD Compliance:** {{gtd-compliance-score}}%
```

### Trend Analysis
**Improving:** {{improving-metrics}}
**Declining:** {{declining-metrics}}
**Stable:** {{stable-metrics}}

### Weekly Insights
**What worked well:**
{{successes}}

**What needs improvement:**
{{improvements}}

**Key lessons learned:**
{{lessons}}

## 🎯 Planning for Next Week

### Weekly Goals
1. **Primary Focus:** {{primary-focus}}
2. **Key Deliverables:** {{deliverables}}
3. **Learning Goals:** {{learning-goals}}
4. **Personal Goals:** {{personal-goals}}

### Priority Actions
**HIGH Priority (Must do):**
- {{high-priority-1}}
- {{high-priority-2}}
- {{high-priority-3}}

**MEDIUM Priority (Should do):**
- {{medium-priority-1}}
- {{medium-priority-2}}

**LOW Priority (Nice to do):**
- {{low-priority-1}}

### Energy & Time Planning
**High Energy Times:** {{high-energy-times}}
**Low Energy Times:** {{low-energy-times}}
**Focus Blocks:** {{focus-blocks}}
**Meeting Times:** {{meeting-times}}

### Potential Obstacles
**Anticipated challenges:**
{{challenges}}

**Mitigation strategies:**
{{mitigations}}

**Contingency plans:**
{{contingencies}}

## 🔄 Review Completion & Follow-up

### Review Completion Checklist
- [ ] All inboxes processed to zero
- [ ] All lists reviewed and updated
- [ ] All projects have current next actions
- [ ] Calendar reviewed (past and future)
- [ ] Goals and objectives reviewed
- [ ] Weekly plan created
- [ ] Energy management planned
- [ ] Obstacles identified and planned for

### Review Quality Assessment
**Completeness:** {{completeness-rating|Excellent|Good|Fair|Poor}}
**Thoroughness:** {{thoroughness-rating|Excellent|Good|Fair|Poor}}
**Usefulness:** {{usefulness-rating|Excellent|Good|Fair|Poor}}
**Time spent:** {{review-duration}} minutes

### Follow-up Actions
**Immediate (today):**
{{immediate-actions}}

**This week:**
{{weekly-actions}}

**Next review preparation:**
{{next-review-preparation}}

## 📱 Mobile Weekly Review

### Mobile-Optimized Review
**Quick mobile review (30 minutes):**
1. Process digital inboxes
2. Review top 5 next actions
3. Check waiting-for items
4. Update weekly plan
5. Schedule full review if needed

### Mobile Features
- **Voice dictation** for review notes
- **Camera integration** for physical inbox
- **Notification reminders** for review schedule
- **Offline access** to review templates
- **Quick stats** on mobile dashboard

### Mobile Review Settings
```markdown
## Mobile Review Configuration
mobile-review-enabled:: true
mobile-review-duration:: 30
mobile-reminders:: true
voice-input:: true
camera-integration:: true
```

## ⚙️ Review System Configuration

### Reminder Settings
```markdown
## Weekly Review Reminders
enabled:: true
reminder-day:: Friday  # Day before preferred review day
reminder-time:: 17:00  # End of workday
reminder-method:: notification  # notification|email|calendar
escalation-days:: 3  # Remind every 3 days if overdue

## Review Scheduling
auto-schedule:: true
preferred-duration:: 120
buffer-time:: 30  # Extra time for overruns
reschedule-if-missed:: true
```

### Integration Settings
```markdown
## System Integration
sync-with-calendar:: true
export-review-notes:: true
backup-before-review:: true
version-control:: true
analytics-tracking:: true
```

## 🔗 Related Templates & Resources

### Template Connections
- **[[GTD Daily Journal]]** - Daily review and planning
- **[[GTD Next Actions Dashboard]]** - Next actions management
- **[[GTD Projects Dashboard]]** - Project status tracking
- **[[GTD Statistics Dashboard]]** - System metrics and trends
- **[[GTD Quick Capture]]** - Inbox processing

### GTD Resources
- **GTD Methodology:** [[GTD Principles Overview]]
- **Review Techniques:** [[Effective Review Strategies]]
- **Productivity Tools:** [[GTD Tools and Templates]]
- **Community Support:** [[GTD User Group]]

## ✅ Success Indicators

### Review Effectiveness
- **Consistency:** Weekly reviews completed on schedule
- **Thoroughness:** All GTD areas reviewed comprehensively
- **Actionability:** Clear outcomes and next steps
- **Efficiency:** Review completed in planned time
- **Satisfaction:** Feeling organized and prepared

### System Health
- **Inbox Zero:** Maintained between reviews
- **Next Action Clarity:** Specific actions defined
- **Project Progress:** Steady movement on projects
- **Stress Reduction:** Lower anxiety about commitments
- **Focus Improvement:** Better concentration on priorities

## 🆘 Troubleshooting & Support

### Common Review Challenges
**Issue:** "I don't have time for a full review"
**Solution:** Start with 30-minute mobile review, schedule full review later

**Issue:** "Reviews feel repetitive"
**Solution:** Vary review focus each week, track different metrics

**Issue:** "I keep postponing reviews"
**Solution:** Set smaller, more frequent reviews, use accountability partner

**Issue:** "Review doesn't lead to action"
**Solution:** Focus on defining specific next actions during review

### Getting Help
- **Review Guide:** [[Weekly Review Best Practices]]
- **GTD Coach:** [[GTD Coaching Resources]]
- **Community:** [[GTD Review Support Group]]
- **Templates:** [[Review Template Customization]]

## 📈 Continuous Improvement

### Review Process Refinement
1. **Track review metrics** over time
2. **Solicit feedback** on review effectiveness
3. **Experiment with** different review formats
4. **Adjust duration** based on needs
5. **Share insights** with community

### Version History
- **v1.0:** Initial release with full GTD weekly review
- **Future:** AI-assisted review, predictive analytics, enhanced mobile features