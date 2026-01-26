template:: GTD Management Dashboard
description:: Integrated dashboard for waiting-for, someday/maybe, and reference management
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Integrated FAQ solution

# GTD Management Dashboard

## 🎯 Dashboard Overview

**Purpose:** Centralized management of waiting-for items, someday/maybe ideas, and reference materials  
**GTD Integration:** Combines three key GTD components into one integrated view  
**Navigation:** ← Back to [[GTD Daily Journal]] | [[GTD Next Actions Dashboard]]

## 🔄 Waiting For Management

### What is "Waiting For" in GTD?
**Definition:** Items you've delegated to others or are dependent on external factors  
**Purpose:** Track dependencies without mental clutter  
**Best Practice:** Review weekly during [[GTD Weekly Review]]

### Waiting For Dashboard

#### Active Waiting For Items
{{query {:title "⏳ Active Waiting For Items"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "waiting-for"]
                 [(get ?props :status) "waiting"]]
         :result-transform (fn [results]
                             (map (fn [r]
                                    {:title (str "⏳ " (:block/content r))
                                     :description (str "From: " (get-in r [:block/properties :from] "Unknown")
                                                    " | Expected: " (get-in r [:block/properties :expected-by] "None")
                                                    " | Follow-up: " (get-in r [:block/properties :followup-date] "None"))
                                     :url (str "#" (:block/uuid r))})
                                  results))}}}

#### Overdue Follow-ups
{{query {:title "⚠️ Overdue Follow-ups"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "waiting-for"]
                 [(get ?props :status) "waiting"]
                 [(get ?props :followup-date) ?followup]
                 [(< ?followup "{{today}}")]]
         :limit 5}}}

#### Recently Completed
{{query {:title "✅ Recently Completed"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "waiting-for"]
                 [(get ?props :status) "completed"]
                 [(get ?props :completed-date) ?completed]
                 [(clojure.string/includes? ?completed "{{this-week}}")]]
         :limit 5}}}

### Waiting For Template
```markdown
## New Waiting For Item
- {{item-description}}
  type:: waiting-for
  status:: waiting
  from:: [[{{person-or-entity}}]]
  delegated:: {{delegation-date}}
  expected-by:: {{expected-date}}
  followup-date:: {{followup-date}}
  priority:: {{high|medium|low}}
  related-to:: [[{{project-or-task}}]]
  
  **Notes:**
  {{additional-notes}}
  
  **Follow-up History:**
  - {{followup-date}}: {{followup-action}}
```

### Waiting For Statistics
- **Active items:** {{query {:query [:find (count ?b) :where [?b :block/properties ?props] [(get ?props :type) "waiting-for"] [(get ?props :status) "waiting"]] :view :text}}}
- **Overdue:** {{query {:query [:find (count ?b) :where [?b :block/properties ?props] [(get ?props :type) "waiting-for"] [(get ?props :status) "waiting"] [(get ?props :followup-date) ?followup] [(< ?followup "{{today}}")]] :view :text}}}
- **Avg wait time:** {{average-wait-time}} days
- **Completion rate:** {{completion-rate}}%

## 🔮 Someday/Maybe Management

### What is "Someday/Maybe" in GTD?
**Definition:** Ideas, projects, or tasks that might be valuable someday  
**Purpose:** Capture possibilities without commitment  
**Best Practice:** Review monthly, promote when timing is right

### Someday/Maybe Dashboard

#### By Category
{{query {:title "🔮 Someday/Maybe by Category"
         :query [:find ?category (count ?b)
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "someday-maybe"]
                 [(get ?props :category) ?category]]
         :group-by ?category
         :sort-by (count ?b)
         :sort-dir :desc
         :view :table}}}

#### High Interest Items
{{query {:title "🌟 High Interest Someday/Maybe"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "someday-maybe"]
                 [(get ?props :interest) "high"]]
         :limit 5}}}

#### Ready for Promotion
{{query {:title "🚀 Ready for Active Consideration"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "someday-maybe"]
                 [(get ?props :readiness) "high"]
                 [(get ?props :timeline) "short"]]
         :limit 5}}}

### Someday/Maybe Template
```markdown
## New Someday/Maybe Item
- {{idea-or-possibility}}
  type:: someday-maybe
  captured:: {{now}}
  category:: {{hobby|learning|travel|business|home|creative|other}}
  interest:: {{high|medium|low}}
  timeline:: {{short|medium|long}}
  effort:: {{low|medium|high}}
  cost:: {{low|medium|high}}
  prerequisites:: {{prerequisites}}
  
  **Why interesting:**
  {{reason-for-interest}}
  
  **Potential timing:**
  {{best-timing}}
  
  **Related items:**
  - [[{{related-item-1}}]]
  - [[{{related-item-2}}]]
```

### Someday/Maybe Statistics
- **Total items:** {{query {:query [:find (count ?b) :where [?b :block/properties ?props] [(get ?props :type) "someday-maybe"]] :view :text}}}
- **By interest:** High: {{high-interest}}, Medium: {{medium-interest}}, Low: {{low-interest}}
- **Promotion rate:** {{promotion-rate}}% (to active projects)
- **Archive rate:** {{archive-rate}}% (removed as no longer relevant)

## 📚 Reference Management

### What are "Reference Materials" in GTD?
**Definition:** Non-actionable information worth keeping  
**Purpose:** Organized knowledge base for future reference  
**Best Practice:** File immediately, review annually

### Reference Dashboard

#### By Tag/Category
{{query {:title "📚 References by Tag"
         :query [:find ?tag (count ?b)
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "reference"]
                 [?b :block/refs ?t]
                 [?t :block/name ?tag]]
         :group-by ?tag
         :sort-by (count ?b)
         :sort-dir :desc
         :limit 10
         :view :table}}}

#### Recently Added
{{query {:title "🆕 Recent References"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "reference"]
                 [(get ?props :filed) ?filed]
                 [(clojure.string/includes? ?filed "{{this-month}}")]]
         :limit 5}}}

#### Most Useful (Based on access)
{{query {:title "⭐ Most Useful References"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :type) "reference"]
                 [(get ?props :access-count) ?count]
                 [(> ?count 5)]]
         :sort-by :access-count
         :sort-dir :desc
         :limit 5}}}

### Reference Template
```markdown
## New Reference Item
- [[{{title}}]]
  type:: reference
  filed:: {{now}}
  source:: {{url|book|article|document|meeting|other}}
  url:: {{optional-url}}
  author:: {{optional-author}}
  date:: {{source-date}}
  summary:: {{brief-summary}}
  
  **Key points:**
  - {{point-1}}
  - {{point-2}}
  - {{point-3}}
  
  **Actionable insights:**
  {{insights}}
  
  **Related to:**
  - [[{{project-1}}]]
  - [[{{area-2}}]]
  
  **Tags:**
  {{tag1}} {{tag2}} {{tag3}}
```

### Reference Statistics
- **Total references:** {{query {:query [:find (count ?b) :where [?b :block/properties ?props] [(get ?props :type) "reference"]] :view :text}}}
- **By source:** Web: {{web-count}}, Books: {{book-count}}, Documents: {{doc-count}}
- **Access frequency:** {{average-access}} times per reference
- **Organization score:** {{organization-score}}/100

## 🔗 Integrated Workflows

### From Inbox to Management
**Processing flow:**
1. **Capture:** [[GTD Quick Capture]]
2. **Clarify:** [[GTD Task Processing]]
3. **Categorize:** 
   - Waiting for → This dashboard
   - Someday/maybe → This dashboard  
   - Reference → This dashboard
   - Next action → [[GTD Next Actions Dashboard]]
   - Project → [[GTD Projects Dashboard]]

### Weekly Review Integration
**During [[GTD Weekly Review]]:**
1. **Waiting for:** Check status, follow up if needed
2. **Someday/maybe:** Review for promotion opportunities
3. **References:** File new items, archive old ones
4. **Update:** All lists in this dashboard

### Project Integration
**Link projects to:**
- **Waiting for:** Dependencies on others
- **References:** Research and documentation
- **Someday/maybe:** Future project ideas

## 📱 Mobile Optimization

### Mobile-Specific Features
**Waiting for:**
- Quick photo of delegated item
- Contact integration for follow-ups
- Location-based reminders

**Someday/maybe:**
- Voice capture of ideas
- Photo inspiration board
- Mood-based suggestions

**References:**
- Camera document scanning
- Web clipping integration
- Offline access to key references

### Mobile Dashboard View
```markdown
## Mobile Quick View
### ⏳ Waiting ({{waiting-count}})
{{mobile-waiting-list}}

### 🔮 Someday ({{someday-count}})
{{mobile-someday-list}}

### 📚 References ({{reference-count}})
{{mobile-reference-list}}
```

## ⚙️ Dashboard Settings

### Configuration Options
```markdown
## GTD Management Dashboard Settings
### Display Settings
show-statistics:: true
default-view:: integrated  # integrated|waiting|someday|reference
items-per-section:: 10
auto-refresh:: false

### Notification Settings
waiting-reminders:: true
someday-review-reminders:: true
reference-organization-reminders:: true

### Integration Settings
link-to-projects:: true
weekly-review-integration:: true
mobile-optimized:: true
```

### Customization
- **Section order:** Rearrange waiting/someday/reference
- **View preferences:** List, table, or card view
- **Filter presets:** Custom filters for each section
- **Export options:** CSV, PDF, or sync with other tools

## 🛠️ Tools & Utilities

### Quick Actions
- **Add waiting for:** [[Waiting For Template]]
- **Add someday/maybe:** [[Someday/Maybe Template]]
- **Add reference:** [[Reference Template]]
- **Process batch:** [[Batch Processing]]
- **Export data:** [[Export Dashboard]]

### Maintenance Tools
**Cleanup wizard:**
1. Archive completed waiting for items (>30 days)
2. Review stale someday/maybe items (>1 year)
3. Organize uncategorized references
4. Update follow-up dates
5. Backup dashboard data

**Health check:**
- Waiting for follow-up compliance: {{followup-compliance}}%
- Someday/maybe review frequency: {{review-frequency}}
- Reference organization: {{organization-score}}
- System integration: {{integration-score}}

## 🔄 FAQ Integration

### Common GTD Questions Addressed

#### "How do I track what I'm waiting for from others?"
**Solution:** Waiting For section with:
- Clear delegation tracking
- Follow-up reminders
- Status updates
- Integration with projects

#### "How do I capture ideas without cluttering my system?"
**Solution:** Someday/Maybe section with:
- Categorized idea storage
- Interest and timing assessment
- Regular review for promotion
- Archive for irrelevant ideas

#### "How do I organize reference materials in GTD?"
**Solution:** Reference section with:
- Tag-based organization
- Quick retrieval system
- Actionable insights extraction
- Regular maintenance

#### "How do these fit into my weekly review?"
**Solution:** Integrated workflow:
- All three sections reviewed weekly
- Clear actions for each category
- Metrics to track effectiveness
- Continuous improvement

### Troubleshooting Guide
**Problem:** "My waiting for list is too long"
**Solution:** Set stricter delegation criteria, automate follow-ups

**Problem:** "Someday/maybe becomes a dumping ground"
**Solution:** Regular reviews, clear promotion criteria, archive old items

**Problem:** "References are disorganized"
**Solution:** Consistent tagging, regular filing, purge unused items

**Problem:** "I forget to check these lists"
**Solution:** Integrate into [[GTD Daily Journal]] and [[GTD Weekly Review]]

## 📈 Success Metrics

### Dashboard Effectiveness
- **Waiting for resolution time:** {{avg-resolution-time}} days
- **Someday/maybe promotion rate:** {{promotion-rate}}%
- **Reference usefulness score:** {{usefulness-score}}/100
- **System integration score:** {{integration-score}}/100
- **User satisfaction:** {{satisfaction-score}}/100

### GTD Compliance
- **Weekly review coverage:** {{review-coverage}}%
- **Inbox processing accuracy:** {{processing-accuracy}}%
- **Stress reduction:** {{stress-reduction}}%
- **Focus improvement:** {{focus-improvement}}%
- **Productivity gain:** {{productivity-gain}}%

## 🔗 Related Dashboards

### GTD System Integration
📊 **[[GTD Next Actions Dashboard]]** - Actionable tasks  
📁 **[[GTD Projects Dashboard]]** - Active projects  
📅 **[[GTD Weekly Review]]** - Comprehensive review  
📈 **[[GTD Analytics Dashboard]]** - System metrics  
🎓 **[[GTD Learning Center]]** - Tutorials and guides

### Quick Navigation
← **Back:** [[GTD Daily Journal]]  
🏠 **Home:** [[GTD Management Dashboard]]  
⚙️ **Settings:** [[GTD System Settings]]  
🆘 **Help:** [[GTD User Guide]]  
🔄 **Workflow:** [[GTD Complete Workflow]]

## ✅ Implementation Checklist

### Setup Steps
- [ ] Configure dashboard settings
- [ ] Import existing waiting for items
- [ ] Import someday/maybe ideas  
- [ ] Organize reference materials
- [ ] Set up weekly review integration
- [ ] Configure mobile optimization
- [ ] Test all queries and templates
- [ ] Train on dashboard usage

### Ongoing Maintenance
- [ ] Weekly: Review all three sections
- [ ] Monthly: Clean up and organize
- [ ] Quarterly: Review effectiveness metrics
- [ ] Annually: Major cleanup and reorganization
- [ ] As needed: Update templates and workflows