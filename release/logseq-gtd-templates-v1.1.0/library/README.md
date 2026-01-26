# Logseq GTD Query Library

## 📚 Overview

This library contains reusable query components for the Logseq GTD Template System. Instead of duplicating similar queries across multiple templates, you can use these centralized query components.

## 🏗️ Directory Structure

```
queries/library/
├── next-actions/          # Next action queries
│   ├── by-context.clj     # Tasks filtered by context
│   └── by-priority.clj    # Tasks filtered by priority
├── projects/              # Project queries
│   └── status.clj         # Project status and details
├── reviews/               # Review queries
│   ├── overdue-tasks.clj  # Overdue task detection
│   └── upcoming-due-dates.clj # Upcoming deadlines
├── areas/                 # Areas of responsibility
│   └── status.clj         # Area status and tracking
└── utils/                 # Utility queries
    └── property-counts.clj # Property distribution analysis
```

## 🚀 Usage

### Basic Usage in Templates

Replace inline queries with library references:

```clojure
;; OLD: Inline query
{{query {:title "Next Actions by Context"
         :query [:find (pull ?b [:block/content :block/properties])
                 :where ...]
         :inputs [:context]}}

;; NEW: Library query
{{query (read-file "queries/library/next-actions/by-context.clj") :inputs [:context]}}
```

### Available Queries

#### 1. Next Actions by Context
```clojure
{{query (read-file "queries/library/next-actions/by-context.clj") :inputs [:context]}}
```
**Inputs:** `:context` (e.g., "@computer", "@phone")
**Returns:** List of TODO tasks for specified context

#### 2. Next Actions by Priority
```clojure
{{query (read-file "queries/library/next-actions/by-priority.clj") :inputs [:priority :context]}}
```
**Inputs:** `:priority` (HIGH/MEDIUM/LOW), `:context`
**Returns:** Priority-filtered tasks for context

#### 3. Project Status
```clojure
{{query (read-file "queries/library/projects/status.clj")}}
```
**Returns:** Table of active projects with status and next actions

#### 4. Overdue Tasks
```clojure
{{query (read-file "queries/library/reviews/overdue-tasks.clj") :inputs [:today]}}
```
**Inputs:** `:today` (current date)
**Returns:** List of overdue tasks

#### 5. Upcoming Due Dates
```clojure
{{query (read-file "queries/library/reviews/upcoming-due-dates.clj") :inputs [:today :future-date]}}
```
**Inputs:** `:today`, `:future-date` (e.g., today+14)
**Returns:** Count of tasks due by date

#### 6. Areas of Responsibility Status
```clojure
{{query (read-file "queries/library/areas/status.clj")}}
```
**Returns:** Table of areas with status and review dates

#### 7. Property Counts
```clojure
{{query (read-file "queries/library/utils/property-counts.clj") :inputs [:property]}}
```
**Inputs:** `:property` (e.g., "priority", "context")
**Returns:** Distribution of property values

## 🔧 Customization

### Modifying Queries
All queries are editable. Common customizations:

1. **Change limit**: Modify `:limit` parameter
2. **Add filters**: Extend `:where` clause
3. **Change output**: Modify `:result-transform` function
4. **Add sorting**: Add `:sort-by` parameter

### Example: Custom Priority Query
```clojure
;; Custom version with additional filtering
{{query (assoc (read-file "queries/library/next-actions/by-priority.clj")
               :limit 5
               :sort-by :due-date)
        :inputs [:priority :context]}}
```

## 📊 Benefits

### 1. Reduced Duplication
- One query definition, multiple uses
- Consistent behavior across templates

### 2. Better Maintenance
- Fix bugs in one place
- Update queries globally
- Performance optimization centralized

### 3. Easier Customization
- Users modify library queries once
- Template-specific overrides possible
- Clear separation of concerns

### 4. Improved Performance
- Optimized query patterns
- Reduced template complexity
- Better caching potential

## 🎯 Best Practices

### 1. Use Library Queries for Common Patterns
- Task filtering by context/priority
- Project/area status queries
- Review and reporting queries

### 2. Keep Template-Specific Queries Local
- Unique, one-off queries stay in templates
- Complex template logic remains local
- Simple patterns use library

### 3. Document Customizations
- Comment modified library queries
- Track changes in version control
- Share improvements with community

### 4. Test After Changes
- Verify queries work in templates
- Check performance impact
- Validate output formatting

## 🔄 Migration Guide

### From Inline Queries to Library

1. **Identify duplicate patterns**:
   ```bash
   grep -r ":where" GTD_Templates/ --include="*.md" | grep "TODO"
   ```

2. **Replace with library reference**:
   ```clojure
   ;; Before
   {{query {:title "My Query" :query [...]}}
   
   ;; After  
   {{query (read-file "queries/library/next-actions/by-context.clj") :inputs [:context]}}
   ```

3. **Test functionality**:
   - Verify query returns expected results
   - Check template variables work
   - Test on mobile and desktop

## 🆕 Adding New Queries

### Step 1: Create Query File
```clojure
;; queries/library/new-category/my-query.clj
{:title "My New Query"
 :query [:find ...]
 :where [...]}
```

### Step 2: Update README
Add documentation for new query:
- Usage syntax
- Input parameters
- Expected output
- Example usage

### Step 3: Update Templates
Replace inline queries with library references where appropriate.

## 🚨 Troubleshooting

### Common Issues

#### 1. Query Not Found
**Error**: `read-file` returns nil
**Solution**: Verify file path is correct relative to Logseq graph root

#### 2. Input Parameters Missing
**Error**: Query expects inputs not provided
**Solution**: Ensure `:inputs` parameter matches query expectations

#### 3. Performance Issues
**Issue**: Query runs slowly
**Solution**: 
- Check query complexity
- Add appropriate limits
- Consider indexing strategies

#### 4. Formatting Problems
**Issue**: Output not formatted correctly
**Solution**: Adjust `:result-transform` function

## 📈 Future Enhancements

### Planned Features:
1. **Query Builder UI** - Visual query construction
2. **Performance Analytics** - Query execution tracking
3. **Template Integration** - Automatic query detection
4. **Community Queries** - User-contributed query library

### Contribution Guidelines:
1. Follow existing query patterns
2. Include comprehensive documentation
3. Test on mobile and desktop
4. Add to appropriate category

---

**Need Help?** Check the [main documentation](../README.md) or create an issue for query-related questions.