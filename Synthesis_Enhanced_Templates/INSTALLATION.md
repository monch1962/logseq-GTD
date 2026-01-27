# Synthesis Lab Enhanced GTD Installation Guide

## Overview

This guide walks you through installing and setting up the Synthesis Lab Enhanced GTD system. The enhanced templates provide natural language processing, AI-powered categorization, and mobile optimization features that go beyond basic template functionality.

## Prerequisites

1. **Logseq** installed (desktop or mobile)
2. **Basic GTD knowledge** (familiarity with Capture, Process, Organize, Review, Engage)
3. **Existing GTD setup** (optional but recommended)

## Step 1: Install Kits Plugin

### Desktop Installation
1. Open Logseq
2. Go to **Plugins** (⚡ icon)
3. Search for **"Kits"**
4. Click **Install**
5. Restart Logseq if prompted

### Mobile Installation
1. Open Logseq mobile app
2. Tap **Settings** (gear icon)
3. Tap **Plugins**
4. Search for **"Kits"**
5. Tap **Install**
6. Restart the app if prompted

## Step 2: Create Synthesis Page

1. Create a new page named exactly: **"Synthesis"**
   - Use capital S
   - No spaces before or after
   - Exact spelling: `Synthesis`

2. Add 11 JavaScript code blocks to the Synthesis page:
   ```
   ```javascript
   // Code Block 1: Natural Language Processing
   async function parseNaturalLanguageCapture(text) {
     // Function code here
   }
   ```

   ```javascript
   // Code Block 2: Task Categorization
   async function categorizeTask(taskText) {
     // Function code here
   }
   ```

   // ... continue for all 11 code blocks
   ```

3. Copy the functions from `synthesis_functions.md` into the appropriate code blocks

## Step 3: Add Custom CSS

1. Copy the contents of `custom.css`
2. In Logseq, go to **Settings** → **Custom CSS**
3. Paste the CSS code
4. Save and refresh

## Step 4: Import Enhanced Templates

### Option A: Manual Import (Recommended)
1. Navigate to each enhanced template file
2. Copy the template content
3. In Logseq, create a new page for each template
4. Paste the template content
5. Add `template::` property at the top

### Option B: Bulk Import
1. Create a folder in your Logseq graph called `GTD_Templates_Enhanced`
2. Copy all `.md` files from `Synthesis_Enhanced_Templates/` into this folder
3. Restart Logseq to load the templates

## Step 5: Test Your Setup

### Quick Test Commands
Run these in any Logseq page to verify installation:

```markdown
Test 1: Natural Language Capture
{{eval parseNaturalLanguageCapture "Call dentist tomorrow"}}

Test 2: Task Categorization  
{{eval categorizeTask "Follow up with client about project"}}

Test 3: Natural Language Query
{{eval processNaturalLanguageQuery "Show me @computer tasks"}}

Test 4: Energy Matching
{{eval matchTasksByEnergy "medium" 30}}
```

### Expected Results
1. **Test 1**: Should return structured task object with properties
2. **Test 2**: Should return category and status suggestions
3. **Test 3**: Should return query filters for Logseq
4. **Test 4**: Should return energy-matched task filters

## Step 6: Configure Your Workflow

### A. Set Up Template Slots
1. Go to **Settings** → **Templates**
2. Add template locations for each enhanced template
3. Assign keyboard shortcuts if desired

### B. Configure Default Properties
Edit the enhanced templates to match your preferences:
- Default contexts
- Priority system
- Time estimates
- Project structure

### C. Set Up Mobile Shortcuts
On mobile Logseq:
1. Pin frequently used templates
2. Set up voice command shortcuts
3. Configure quick capture workflows

## Step 7: Integration with Existing GTD

### Migrating Existing Tasks
1. **Batch Process**: Use the enhanced processing template to categorize existing tasks
2. **Smart Import**: Use natural language to convert legacy tasks
3. **Gradual Transition**: Start using enhanced templates for new tasks only

### Coexistence Strategy
- Keep original templates for reference
- Use enhanced templates for new workflows
- Gradually migrate high-value projects

## Step 8: Advanced Configuration

### Custom Function Development
1. Study the existing functions in `synthesis_functions.md`
2. Modify functions to match your workflow
3. Add new functions for specific needs

### Performance Optimization
1. **Limit batch sizes**: Process 10-20 items at a time
2. **Cache results**: Use `{{evalonce}}` for expensive operations
3. **Mobile first**: Test all functions on mobile

### Integration with External Tools
1. **Calendar**: Modify `integrateWithCalendar()` for your calendar system
2. **Email**: Update `exportToEmail()` for your email provider
3. **Task Managers**: Add export functions for Todoist, Trello, etc.

## Troubleshooting

### Common Issues

#### Issue 1: Functions Not Working
**Symptoms**: `{{eval}}` commands return errors or nothing
**Solutions**:
1. Verify Kits plugin is enabled
2. Check Synthesis page exists with exact name
3. Ensure all 11 code blocks are present
4. Check browser console for JavaScript errors

#### Issue 2: Performance Problems
**Symptoms**: Slow response, timeouts
**Solutions**:
1. Reduce batch sizes
2. Use `{{evalonce}}` instead of `{{eval}}` for static data
3. Disable unused functions
4. Clear Logseq cache

#### Issue 3: Mobile Issues
**Symptoms**: Functions work on desktop but not mobile
**Solutions**:
1. Test with simpler functions first
2. Reduce JavaScript complexity
3. Use mobile-optimized templates
4. Check mobile Logseq version compatibility

#### Issue 4: Template Loading Errors
**Symptoms**: Templates don't appear in template menu
**Solutions**:
1. Verify `template::` property is at top of file
2. Check template file location
3. Restart Logseq
4. Check template settings in Logseq preferences

### Debugging Steps

1. **Enable Developer Mode**:
   ```javascript
   // Add to Synthesis page
   console.log('GTD Functions loaded:', Object.keys(window.GTDFunctions || {}));
   ```

2. **Test Individual Functions**:
   ```markdown
   {{eval (async () => {
     try {
       const result = await parseNaturalLanguageCapture("test");
       return JSON.stringify(result, null, 2);
     } catch (e) {
       return "Error: " + e.message;
     }
   })()}}
   ```

3. **Check Function Availability**:
   ```markdown
   Available functions: {{eval Object.keys(window.GTDFunctions || {}).join(", ")}}
   ```

## Maintenance

### Regular Updates
1. **Backup Synthesis page** before making changes
2. **Test functions** after updates
3. **Update documentation** when modifying workflows

### Performance Monitoring
1. Track function execution times
2. Monitor mobile performance
3. Optimize based on usage patterns

### Community Support
1. Check GitHub issues for known problems
2. Share successful customizations
3. Contribute back improvements

## Next Steps After Installation

1. **Complete the testing checklist** in `TESTING.md`
2. **Customize functions** for your specific needs
3. **Develop advanced workflows** using the enhanced features
4. **Share feedback** to improve the system

## Getting Help

- **Documentation**: Refer to `README.md` for feature overview
- **Testing**: Use `TESTING.md` for validation
- **Community**: Check GitHub discussions
- **Issues**: Report bugs on GitHub

## Success Metrics

Your installation is successful when:
1. ✅ All test commands work
2. ✅ Enhanced templates load correctly
3. ✅ Natural language processing functions
4. ✅ Mobile optimization works
5. ✅ Integration with existing workflow

## Rollback Plan

If issues arise:
1. Disable Kits plugin temporarily
2. Use original GTD templates
3. Restore from backup of Synthesis page
4. Contact support with error details

---

**Remember**: The enhanced system is designed to complement, not replace, your existing GTD workflow. Start with one enhanced template, master it, then gradually add more features.