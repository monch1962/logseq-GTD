# Troubleshooting FAQ - Logseq GTD Template System

Common issues and solutions for the Logseq GTD Template System.

## 🚨 Installation Issues

### Q1: Templates don't appear in Logseq
**Symptoms**: Templates not showing in Logseq template picker
**Solutions**:
1. **Check directory location**:
   ```bash
   # Correct location examples:
   # macOS: ~/logseq/templates/
   # Windows: %USERPROFILE%/logseq/templates/
   # Linux: ~/.logseq/templates/
   ```

2. **Verify file permissions**:
   ```bash
   chmod 644 ~/logseq/templates/*.md
   ```

3. **Restart Logseq**: Close and reopen Logseq after copying templates

4. **Check template syntax**: Ensure files have `template::` header
   ```markdown
   template:: Template Name
   description:: Brief description
   ```

### Q2: Mobile installation problems
**Symptoms**: Templates not working on iOS/Android
**Solutions**:
- **iOS**: Use Files app to copy to Logseq folder
- **Android**: Use file manager to copy to `Android/data/com.logseq.app/files/templates`
- **Mobile web**: Ensure using latest Logseq mobile app, not browser

### Q3: Sync issues between devices
**Symptoms**: Templates work on one device but not another
**Solutions**:
1. **Use cloud sync**: iCloud, Google Drive, or Dropbox
2. **Manual sync**: Copy templates to each device
3. **Check sync settings**: Ensure template folder is included in sync

## 🔧 Template Functionality Issues

### Q4: Queries not returning results
**Symptoms**: Query sections show empty or incorrect results
**Solutions**:
1. **Check property names**: Ensure tasks use correct properties
   ```markdown
   - TODO Task description
     status:: not-started
     priority:: HIGH
     context:: @computer
   ```

2. **Verify marker format**: Use `TODO` not `todo` or `ToDo`
   ```markdown
   # Correct
   - TODO Task description
   
   # Incorrect  
   - todo Task description
   - ToDo Task description
   ```

3. **Refresh queries**: Sometimes queries need refresh
   - Desktop: `Cmd/Ctrl + R` to refresh page
   - Mobile: Pull down to refresh

### Q5: Template variables not working
**Symptoms**: `{{variables}}` not replacing with user input
**Solutions**:
1. **Use template insertion**: Don't edit template files directly
2. **Check variable syntax**: `{{variable-name}}` not `{variable}` or `[[variable]]`
3. **Template engine**: Ensure using Logseq's template feature, not manual editing

### Q6: Performance issues on mobile
**Symptoms**: Slow template loading or laggy queries
**Solutions**:
1. **Reduce query complexity**: Limit queries in mobile templates
2. **Optimize properties**: Use fewer properties per task
3. **Clear cache**: Logseq mobile app cache clearing
4. **Update app**: Ensure latest Logseq mobile version

## 📱 Mobile-Specific Issues

### Q7: Touch targets too small
**Symptoms**: Hard to tap buttons or links on mobile
**Solutions**:
1. **Use mobile-optimized templates**: Templates marked `touch-optimized:: true`
2. **Adjust zoom**: Use accessibility zoom features
3. **Larger text**: Increase font size in Logseq settings

### Q8: Voice capture not working
**Symptoms**: Voice memo templates not functioning
**Solutions**:
1. **App permissions**: Grant microphone access to Logseq
2. **Browser limitations**: Some browsers don't support voice in web version
3. **Native app**: Use Logseq mobile app for best voice support

### Q9: Offline functionality issues
**Symptoms**: Templates not working without internet
**Solutions**:
1. **Cache templates**: Ensure templates are cached locally
2. **Simple templates**: Use basic templates offline, complex ones online
3. **Progressive enhancement**: Design for offline-first, enhance online

## 🎯 GTD Workflow Issues

### Q10: Inbox not clearing
**Symptoms**: Can't achieve inbox zero
**Solutions**:
1. **2-minute rule**: Process quick tasks immediately
2. **Batch processing**: Set specific times for inbox processing
3. **Clarify workflow**: Follow task processing template steps
4. **Delegate**: Use waiting-for tracking for delegated tasks

### Q11: Context switching difficulties
**Symptoms**: Hard to switch between contexts
**Solutions**:
1. **MRU dropdowns**: Use context manager template
2. **Physical triggers**: Change location when changing contexts
3. **Time blocking**: Schedule context-specific time blocks
4. **Mobile detection**: Use mobile context auto-detection

### Q12: Weekly review overwhelming
**Symptoms**: Weekly review takes too long or feels burdensome
**Solutions**:
1. **Break it up**: Do review in 15-minute chunks
2. **Focus areas**: Prioritize key GTD areas each week
3. **Automate**: Use query templates for automatic gathering
4. **Simplify**: Use starter kit weekly review first

## ⚡ Performance Optimization

### Q13: Slow query performance
**Symptoms**: Queries taking >2 seconds
**Solutions**:
1. **Index properties**: Ensure frequently queried properties are indexed
2. **Limit results**: Use `:limit` in queries for large datasets
3. **Cache queries**: Store query results where possible
4. **Optimize patterns**: Use efficient query patterns

### Q14: Large dataset issues
**Symptoms**: Performance degrades with 1000+ tasks
**Solutions**:
1. **Archive completed**: Move completed tasks to archive
2. **Project grouping**: Use project pages to organize tasks
3. **Query optimization**: Use targeted queries instead of all-tasks queries
4. **Regular cleanup**: Monthly cleanup of old tasks

### Q15: Memory usage high
**Symptoms**: Logseq using excessive memory
**Solutions**:
1. **Reduce open pages**: Close unused pages
2. **Limit queries**: Reduce number of active queries
3. **Simplify templates**: Use simpler template versions
4. **Update Logseq**: Use latest version with performance improvements

## 🔄 Migration & Upgrade Issues

### Q16: Upgrading from previous version
**Symptoms**: Issues after updating templates
**Solutions**:
1. **Backup first**: Always backup before upgrading
2. **Incremental update**: Update templates one at a time
3. **Test workflows**: Test key workflows after each update
4. **Rollback option**: Keep previous version available

### Q17: Custom template conflicts
**Symptoms**: Custom templates conflicting with system templates
**Solutions**:
1. **Namespace separation**: Use different directories
2. **Template naming**: Avoid duplicate template names
3. **Import order**: System templates first, custom second
4. **Conflict resolution**: Manual merge of conflicting templates

## 📚 Documentation & Support

### Q18: Can't find specific feature
**Solutions**:
1. **Check USAGE.md**: Comprehensive usage guide
2. **Template index**: `GTD_Templates/index.md` for all templates
3. **Search documentation**: Use `grep` or search in documentation
4. **Examples directory**: Real-world implementation examples

### Q19: Need more advanced features
**Solutions**:
1. **Custom queries**: Create your own query components
2. **Template modification**: Edit templates to fit your workflow
3. **Community templates**: Check for community contributions
4. **Feature requests**: Submit requests for future versions

### Q20: Getting help
**Support channels**:
1. **Documentation**: `INSTALLATION.md`, `USAGE.md`, `TESTING_CHECKLIST.md`
2. **Examples**: `examples/` directory with real implementations
3. **Testing framework**: Use `TESTING_CHECKLIST.md` for self-diagnosis
4. **Community**: Logseq forums and discussion groups

## 🛠️ Advanced Troubleshooting

### Debugging Queries
```clojure
# Test query in isolation
{:query [:find ?b :where [?b :block/marker "TODO"]]}

# Check property values
{:query [:find ?v :where [?b :block/properties ?p] [(get ?p :status) ?v]]}

# Count results for debugging
{:query [:find (count ?b) :where [?b :block/marker "TODO"]]}
```

### Template Validation
```bash
# Check template syntax
grep -n "template::" GTD_Templates/*/*.md

# Verify property consistency
grep -r "status::" GTD_Templates/ --include="*.md" | sort | uniq

# Check variable syntax
grep -r "{{" GTD_Templates/ --include="*.md" | head -20
```

### Performance Testing
```bash
# Test template load time
time logseq-open-template "GTD Quick Capture"

# Monitor memory usage
top -l 1 | grep -i logseq

# Check query execution
# Use Logseq's query timing in developer tools
```

## ✅ Quick Fix Checklist

Before seeking help, try these quick fixes:

1. [ ] **Restart Logseq** - Fixes many transient issues
2. [ ] **Check template location** - Verify correct directory
3. [ ] **Verify properties** - Ensure correct property names
4. [ ] **Test basic template** - Try simplest template first
5. [ ] **Clear cache** - Especially on mobile
6. [ ] **Update Logseq** - Use latest version
7. [ ] **Check permissions** - File and app permissions
8. [ ] **Review logs** - Logseq error logs for clues

## 📞 Emergency Contact

If all else fails:

1. **Document the issue**: Screenshots, error messages, steps to reproduce
2. **Check known issues**: Review this FAQ and testing checklist
3. **Community support**: Logseq community forums
4. **System information**: Logseq version, OS, device type
5. **Minimal test case**: Smallest example showing the issue

---

**Last Updated**: January 27, 2026  
**Template Version**: 1.1.0  
**Logseq Compatibility**: v0.9.0+  
**Support Level**: Community-supported with comprehensive documentation

> *Remember: Most issues can be resolved by following the testing checklist and verifying installation steps. The system has been thoroughly tested across all platforms.*