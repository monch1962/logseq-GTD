# Logseq GTD Query Library Guide
## Comprehensive Reference for Template Developers and Users
**Version:** 1.1.0  
**Last Updated:** January 27, 2026

## Overview

The Logseq GTD Query Library is a collection of 46 reusable query components that power the GTD template system. This library enables consistent query patterns, reduces duplication, and makes template maintenance easier.

## Quick Start

### Using Query Library Components

**Basic Usage:**
```markdown
{{query (read-file "queries/library/category/component-name.clj")}}
```

**With Template Variables:**
```markdown
{{query (assoc (read-file "queries/library/context/tasks-by-context.clj")
               :title "📊 Tasks in {{context}}")
        :inputs ["{{context}}"]}}
```

**With Custom Parameters:**
```markdown
{{query (assoc (read-file "queries/library/next-actions/by-priority.clj")
               :title "HIGH Priority Tasks"
               :limit "{{show-count}}")
        :inputs ["HIGH"]}}
```

## Query Library Categories

### 1. Capture Queries (2 components)
**Location:** `queries/library/capture/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `todays-captures.clj` | Shows items captured today | `{{query (read-file "queries/library/capture/todays-captures.clj")}}` |
| `inbox-status.clj` | Count of unprocessed items | `{{query (read-file "queries/library/capture/inbox-status.clj")}}` |

### 2. Process Queries (2 components)
**Location:** `queries/library/process/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `processed-today.clj` | Count of items processed today | `{{query (read-file "queries/library/process/processed-today.clj")}}` |
| `average-processing-time.clj` | Average time between capture and processing | `{{query (read-file "queries/library/process/average-processing-time.clj")}}` |

### 3. Context Queries (3 components)
**Location:** `queries/library/context/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `selection.clj` | Most recently used contexts | `{{query (read-file "queries/library/context/selection.clj")}}` |
| `tasks-by-context.clj` | Tasks for specific context | `{{query (assoc (read-file "queries/library/context/tasks-by-context.clj") :title "Tasks in {{context}}") :inputs ["{{context}}"]}}` |
| `most-used.clj` | Contexts with most tasks | `{{query (read-file "queries/library/context/most-used.clj")}}` |

### 4. Time-based Queries (3 components)
**Location:** `queries/library/time/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `quick-tasks.clj` | Tasks <15 minutes | `{{query (read-file "queries/library/time/quick-tasks.clj")}}` |
| `focus-sessions.clj` | Tasks 30-60 minutes | `{{query (read-file "queries/library/time/focus-sessions.clj")}}` |
| `high-energy-tasks.clj` | Tasks requiring high energy | `{{query (read-file "queries/library/time/high-energy-tasks.clj")}}` |

### 5. Project Queries (3 components)
**Location:** `queries/library/projects/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `missing-next-actions.clj` | Projects without next actions | `{{query (read-file "queries/library/projects/missing-next-actions.clj")}}` |
| `vague-next-actions.clj` | Vague project next actions | `{{query (read-file "queries/library/projects/vague-next-actions.clj")}}` |
| `stale-next-actions.clj` | Next actions >7 days old | `{{query (read-file "queries/library/projects/stale-next-actions.clj")}}` |

### 6. Integration Queries (2 components)
**Location:** `queries/library/integration/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `email-processing.clj` | Emails processed today | `{{query (read-file "queries/library/integration/email-processing.clj")}}` |
| `calendar-events.clj` | Calendar events for period | `{{query (assoc (read-file "queries/library/integration/calendar-events.clj") :title "{{period}} Events") :inputs ["{{period}}"]}}` |

### 7. Analytics Queries (2 components)
**Location:** `queries/library/analytics/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `performance-trends.clj` | Weekly performance trends | `{{query (read-file "queries/library/analytics/performance-trends.clj")}}` |
| `completion-rates.clj` | Next actions completed today | `{{query (read-file "queries/library/analytics/completion-rates.clj")}}` |

### 8. Dashboard Queries (11 components)
**Location:** `queries/library/dashboard/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `waiting-for-items.clj` | Active waiting-for items | `{{query (read-file "queries/library/dashboard/waiting-for-items.clj")}}` |
| `overdue-follow-ups.clj` | Overdue waiting-for items | `{{query (read-file "queries/library/dashboard/overdue-follow-ups.clj")}}` |
| `recently-completed.clj` | Recently completed tasks | `{{query (read-file "queries/library/dashboard/recently-completed.clj")}}` |
| `waiting-active-count.clj` | Count of active waiting items | `{{query (read-file "queries/library/dashboard/waiting-active-count.clj")}}` |
| `someday-by-category.clj` | Someday/Maybe by category | `{{query (read-file "queries/library/dashboard/someday-by-category.clj")}}` |
| `high-interest-someday.clj` | High interest Someday/Maybe | `{{query (read-file "queries/library/dashboard/high-interest-someday.clj")}}` |
| `ready-for-consideration.clj` | Ready Someday/Maybe items | `{{query (read-file "queries/library/dashboard/ready-for-consideration.clj")}}` |
| `total-someday-items.clj` | Count of Someday/Maybe items | `{{query (read-file "queries/library/dashboard/total-someday-items.clj")}}` |
| `references-by-tag.clj` | References grouped by tag | `{{query (read-file "queries/library/dashboard/references-by-tag.clj")}}` |
| `recent-references.clj` | Recently added references | `{{query (read-file "queries/library/dashboard/recent-references.clj")}}` |
| `most-useful-references.clj` | Most useful references | `{{query (read-file "queries/library/dashboard/most-useful-references.clj")}}` |
| `total-references.clj` | Count of reference items | `{{query (read-file "queries/library/dashboard/total-references.clj")}}` |
| `recently-completed-waiting.clj` | Recently completed waiting | `{{query (read-file "queries/library/dashboard/recently-completed-waiting.clj")}}` |

### 9. Journal Queries (2 components)
**Location:** `queries/library/journal/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `next-actions-by-context.clj` | Next actions for context | `{{query (assoc (read-file "queries/library/journal/next-actions-by-context.clj") :title "Next Actions for {{context}}") :inputs ["{{context}}"]}}` |
| `do-now-tasks.clj` | Tasks <2 minutes | `{{query (read-file "queries/library/journal/do-now-tasks.clj")}}` |

### 10. Review Queries (2 components)
**Location:** `queries/library/review/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `weekly-captures.clj` | Items captured this week | `{{query (read-file "queries/library/review/weekly-captures.clj")}}` |
| `total-next-actions.clj` | Count of all next actions | `{{query (read-file "queries/library/review/total-next-actions.clj")}}` |

### 11. Rule Queries (2 components)
**Location:** `queries/library/rules/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `tasks-under-2min.clj` | Tasks <2 minutes | `{{query (read-file "queries/library/rules/tasks-under-2min.clj")}}` |
| `context-quick-tasks.clj` | Quick tasks for context | `{{query (assoc (read-file "queries/library/rules/context-quick-tasks.clj") :title "Quick tasks for {{context}}") :inputs ["{{context}}"]}}` |

### 12. Area Queries (4 components)
**Location:** `queries/library/areas/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `status.clj` | Areas of responsibility status | `{{query (read-file "queries/library/areas/status.clj")}}` |
| `needing-attention.clj` | Areas needing attention | `{{query (read-file "queries/library/areas/needing-attention.clj")}}` |
| `upcoming-reviews.clj` | Upcoming area reviews | `{{query (read-file "queries/library/areas/upcoming-reviews.clj")}}` |
| `next-actions-by-area.clj` | Next actions grouped by area | `{{query (read-file "queries/library/areas/next-actions-by-area.clj")}}` |

### 13. Next Actions Queries (2 components)
**Location:** `queries/library/next-actions/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `by-context.clj` | Next actions by context | `{{query (assoc (read-file "queries/library/next-actions/by-context.clj") :title "{{context}} Tasks") :inputs ["{{context}}"]}}` |
| `by-priority.clj` | Next actions by priority | `{{query (assoc (read-file "queries/library/next-actions/by-priority.clj") :title "{{priority}} Priority") :inputs ["{{priority}}"]}}` |

### 14. Project Status Queries (1 component)
**Location:** `queries/library/projects/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `status.clj` | Project status overview | `{{query (read-file "queries/library/projects/status.clj")}}` |

### 15. Review Queries (2 components)
**Location:** `queries/library/reviews/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `overdue-tasks.clj` | Overdue tasks | `{{query (read-file "queries/library/reviews/overdue-tasks.clj")}}` |
| `upcoming-due-dates.clj` | Upcoming due dates | `{{query (read-file "queries/library/reviews/upcoming-due-dates.clj")}}` |

### 16. Utility Queries (1 component)
**Location:** `queries/library/utils/`

| Component | Purpose | Usage Example |
|-----------|---------|---------------|
| `property-counts.clj` | Property value counts | `{{query (read-file "queries/library/utils/property-counts.clj")}}` |

## Advanced Usage

### Customizing Query Components

**Modifying Title:**
```clojure
{{query (assoc (read-file "queries/library/component.clj")
               :title "Custom Title")}}
```

**Adding Limit:**
```clojure
{{query (assoc (read-file "queries/library/component.clj")
               :limit 10)}}
```

**Changing View Mode:**
```clojure
{{query (assoc (read-file "queries/library/component.clj")
               :view :text)}}
```

**Multiple Customizations:**
```clojure
{{query (assoc (read-file "queries/library/component.clj")
               :title "Custom Title"
               :limit "{{count}}"
               :view :table)}}
```

### Template Variable Binding

**Single Variable:**
```clojure
{{query (read-file "queries/library/component.clj")
        :inputs ["{{variable}}"]}}
```

**Multiple Variables:**
```clojure
{{query (read-file "queries/library/component.clj")
        :inputs ["{{var1}}" "{{var2}}" "{{var3}}"]}}
```

**With assoc and inputs:**
```clojure
{{query (assoc (read-file "queries/library/component.clj")
               :title "{{title}}")
        :inputs ["{{input1}}" "{{input2}}"]}}
```

## Best Practices

### 1. Performance Optimization
- **Limit results**: Use `:limit` parameter for large datasets
- **Mobile first**: Optimize queries for mobile performance
- **Efficient filters**: Use indexed properties for faster queries
- **Result caching**: Logseq caches query results automatically

### 2. Mobile Compatibility
- **Touch targets**: Ensure interactive elements are touch-friendly
- **Load time**: Keep queries simple for mobile devices
- **Offline support**: Design queries to work without internet
- **Battery optimization**: Avoid complex calculations on mobile

### 3. GTD Methodology Compliance
- **Context filtering**: Always support context-based views
- **Priority sorting**: Maintain HIGH/MEDIUM/LOW priority system
- **Time estimates**: Include time-based filtering where relevant
- **Status tracking**: Support GTD status workflow

### 4. Template Integration
- **Consistent variables**: Use same variable names across templates
- **Error handling**: Gracefully handle missing data
- **Documentation**: Include usage examples in component files
- **Backward compatibility**: Don't break existing templates

## Migration Guide

### From Inline Queries to Library

**Before (inline query):**
```markdown
{{query {:title "Today's Captures"
         :query [:find (count ?b)
                 :where
                 [?b :block/properties ?props]
                 [(get ?props :captured) ?captured]
                 [(clojure.string/includes? ?captured "{{today}}")]]
         :view :text}}}
```

**After (library query):**
```markdown
{{query (read-file "queries/library/capture/todays-captures.clj")}}
```

### Steps for Migration:
1. **Identify query pattern** in existing template
2. **Check library** for existing component
3. **Create new component** if needed
4. **Update template** to use library component
5. **Test thoroughly** with sample data
6. **Update documentation** if necessary

## Troubleshooting

### Common Issues

**1. Query not returning results:**
- Check property names match your data
- Verify date formats are consistent
- Ensure template variables are properly bound

**2. Performance issues on mobile:**
- Add `:limit` parameter to restrict results
- Simplify complex `:result-transform` functions
- Use indexed properties for filtering

**3. Template variables not binding:**
- Verify `:inputs` parameter includes all variables
- Check variable names match between template and query
- Ensure proper Clojure syntax in `assoc` calls

**4. Query syntax errors:**
- Validate Clojure/Datalog syntax
- Check for missing brackets or parentheses
- Verify property access uses proper syntax

### Debugging Tips

**Enable query logging:**
```clojure
{{query (assoc (read-file "queries/library/component.clj")
               :debug true)}}
```

**Test with sample data:**
```markdown
- Test task
  captured:: 2026-01-27
  status:: unprocessed
  context:: @computer
  priority:: HIGH
```

**Check query results:**
- Use Logseq's query inspector
- Test queries in isolation first
- Verify with different data sets

## Contributing to the Library

### Adding New Components

1. **Choose appropriate category** based on query purpose
2. **Create component file** with `.clj` extension
3. **Include documentation** at top of file
4. **Follow naming conventions** (kebab-case)
5. **Test thoroughly** with sample data
6. **Update this guide** with new component

### Component Template
```clojure
;; Component Name Query
;; Usage: {{query (read-file "queries/library/category/component-name.clj")}}
;; Brief description of what the query does

{:title "Default Title"
 :query [:find (pull ?b [:block/content :block/properties])
         :where
         ; Query conditions here
         ]
 :view :table
 :result-transform (fn [result]
                     ; Optional result transformation
                     result)}
```

## Version History

### v1.1.0 (January 2026)
- **Initial query library release** with 46 components
- **12 categories** covering all GTD workflow phases
- **Template migration** for 8 critical templates
- **Comprehensive documentation** and usage guide

### v1.0.0 (January 2025)
- **Initial template system** with inline queries
- **16 templates** organized by GTD phase
- **Basic query functionality** in each template

## Support & Resources

### Getting Help
- **Documentation**: This guide and template comments
- **Testing**: Use `test_templates.sh` validation script
- **Community**: Logseq forums and GTD communities
- **Issues**: GitHub repository issue tracker

### Learning Resources
- **Logseq Query Guide**: Official Logseq documentation
- **GTD Methodology**: David Allen's Getting Things Done
- **Clojure/Datalog**: Query language references
- **Template Development**: Logseq template system docs

---

**Ready to implement efficient, maintainable GTD workflows with the query library!**