# Consolidated Template Testing Script

## Purpose
Test the consolidated `enhanced_gtd_templates.md` file to ensure all 5 enhanced templates work correctly in a single file format.

## Test Environment
- **File**: `enhanced_gtd_templates.md` (1,817 lines)
- **Format**: Single consolidated markdown file
- **Target**: Logseq with Synthesis Lab (Kits plugin)
- **Platform**: Desktop and mobile testing

## Test 1: File Structure Validation

### 1.1 Check Template Sections Exist
```bash
# Verify all 5 template sections are present
grep -n "^# GTD Enhanced" enhanced_gtd_templates.md
```

### 1.2 Check Template Headers
```bash
# Verify template:: headers for each section
grep -n "template:: GTD Enhanced" enhanced_gtd_templates.md
```

### 1.3 Check Section Separators
```bash
# Verify proper section separation
grep -n "^---$" enhanced_gtd_templates.md
```

## Test 2: Template Content Validation

### 2.1 Quick Capture Template
```bash
# Check key features
grep -n "Natural Language Capture" enhanced_gtd_templates.md
grep -n "Voice-to-Text Smart Capture" enhanced_gtd_templates.md
grep -n "Mobile Capture Workflow" enhanced_gtd_templates.md
```

### 2.2 Task Processing Template
```bash
# Check processing features
grep -n "AI-Powered Auto-Categorization" enhanced_gtd_templates.md
grep -n "Batch Processing Commands" enhanced_gtd_templates.md
grep -n "Smart Delegation Detection" enhanced_gtd_templates.md
```

### 2.3 Management Dashboard
```bash
# Check dashboard features
grep -n "Natural Language Queries" enhanced_gtd_templates.md
grep -n "Dynamic Views" enhanced_gtd_templates.md
grep -n "Smart Analytics" enhanced_gtd_templates.md
```

### 2.4 Weekly Review
```bash
# Check review features
grep -n "Automated Review Preparation" enhanced_gtd_templates.md
grep -n "Smart Time Allocation" enhanced_gtd_templates.md
grep -n "Predictive Analytics" enhanced_gtd_templates.md
```

### 2.5 Next Actions Dashboard
```bash
# Check engagement features
grep -n "Context-Aware Task Selection" enhanced_gtd_templates.md
grep -n "Energy Matching" enhanced_gtd_templates.md
grep -n "Smart Scheduling" enhanced_gtd_templates.md
```

## Test 3: Synthesis Lab Integration

### 3.1 Check Synthesis Commands
```bash
# Count all {{eval commands}}
grep -o "{{eval" enhanced_gtd_templates.md | wc -l

# Count all {{cell commands}}
grep -o "{{cell" enhanced_gtd_templates.md | wc -l

# List unique command types
grep -o "{{eval [^}]*}}" enhanced_gtd_templates.md | sort | uniq -c | sort -nr
```

### 3.2 Check Natural Language Examples
```bash
# Count natural language examples
grep -n "Natural Language Examples:" enhanced_gtd_templates.md
grep -n "{{eval what should I do now}}" enhanced_gtd_templates.md
grep -n "{{eval show me" enhanced_gtd_templates.md
```

## Test 4: Mobile Optimization Validation

### 4.1 Check Mobile-Specific Features
```bash
# Check mobile optimization mentions
grep -n "mobile-optimized" enhanced_gtd_templates.md
grep -n "Mobile Optimization:" enhanced_gtd_templates.md
grep -n "voice commands" enhanced_gtd_templates.md
grep -n "touch-friendly" enhanced_gtd_templates.md
```

### 4.2 Check Performance Indicators
```bash
# Check performance mentions
grep -n "performance-optimized" enhanced_gtd_templates.md
grep -n "efficient" enhanced_gtd_templates.md
grep -n "fast" enhanced_gtd_templates.md
```

## Test 5: GTD Compliance Validation

### 5.1 Check GTD Phase Coverage
```bash
# Verify all 5 GTD phases are covered
grep -n "gtd-compliance" enhanced_gtd_templates.md
grep -n "Capture phase" enhanced_gtd_templates.md
grep -n "Process phase" enhanced_gtd_templates.md
grep -n "Organize phase" enhanced_gtd_templates.md
grep -n "Review phase" enhanced_gtd_templates.md
grep -n "Engage phase" enhanced_gtd_templates.md
```

### 5.2 Check Property Consistency
```bash
# Check standard GTD properties
grep -n "context::" enhanced_gtd_templates.md
grep -n "priority::" enhanced_gtd_templates.md
grep -n "status::" enhanced_gtd_templates.md
grep -n "project::" enhanced_gtd_templates.md
grep -n "time-estimate::" enhanced_gtd_templates.md
```

## Test 6: Cross-Platform Compatibility

### 6.1 Check Platform Support
```bash
# Check compatibility mentions
grep -n "compatibility::" enhanced_gtd_templates.md
grep -n "Logseq mobile" enhanced_gtd_templates.md
grep -n "Logseq desktop" enhanced_gtd_templates.md
```

### 6.2 Check Plugin Requirements
```bash
# Check Synthesis Lab requirement
grep -n "synthesis-required" enhanced_gtd_templates.md
grep -n "Kits plugin" enhanced_gtd_templates.md
grep -n "Synthesis Lab" enhanced_gtd_templates.md
```

## Test 7: Documentation and Help

### 7.1 Check Help Sections
```bash
# Check quick reference sections
grep -n "Quick Reference" enhanced_gtd_templates.md
grep -n "Common Commands" enhanced_gtd_templates.md
grep -n "Examples:" enhanced_gtd_templates.md
```

### 7.2 Check Error Handling
```bash
# Check error messages and fallbacks
grep -n "fallback" enhanced_gtd_templates.md
grep -n "alternative" enhanced_gtd_templates.md
grep -n "manual" enhanced_gtd_templates.md
```

## Test 8: File Size and Performance

### 8.1 Check File Statistics
```bash
# Get file statistics
wc -l enhanced_gtd_templates.md
wc -c enhanced_gtd_templates.md
du -h enhanced_gtd_templates.md
```

### 8.2 Check Line Lengths
```bash
# Check for excessively long lines
awk 'length > 200' enhanced_gtd_templates.md | wc -l
```

## Test 9: Integration Points

### 9.1 Check Cross-Template References
```bash
# Check references between templates
grep -n "\[\[Enhanced" enhanced_gtd_templates.md
grep -n "integration" enhanced_gtd_templates.md
grep -n "workflow" enhanced_gtd_templates.md
```

### 9.2 Check Data Flow
```bash
# Check how data flows between phases
grep -n "from capture" enhanced_gtd_templates.md
grep -n "to process" enhanced_gtd_templates.md
grep -n "review results" enhanced_gtd_templates.md
```

## Test 10: User Experience Validation

### 10.1 Check Readability
```bash
# Check section headers for clarity
grep -n "^## " enhanced_gtd_templates.md | head -20
grep -n "^### " enhanced_gtd_templates.md | head -20
```

### 10.2 Check Visual Elements
```bash
# Check emojis and visual cues
grep -n "🚀" enhanced_gtd_templates.md
grep -n "🎯" enhanced_gtd_templates.md
grep -n "📱" enhanced_gtd_templates.md
grep -n "✅" enhanced_gtd_templates.md
```

## Running the Tests

### Quick Test Command
```bash
# Run all structural tests
bash -c '
echo "=== Consolidated Template Test Results ==="
echo "File: enhanced_gtd_templates.md"
echo "Lines: $(wc -l < enhanced_gtd_templates.md)"
echo "Size: $(du -h enhanced_gtd_templates.md | cut -f1)"
echo ""
echo "1. Template Sections:"
grep -c "^# GTD Enhanced" enhanced_gtd_templates.md
echo ""
echo "2. Synthesis Commands:"
grep -o "{{eval" enhanced_gtd_templates.md | wc -l
echo ""
echo "3. Mobile Optimization:"
grep -c "mobile-optimized" enhanced_gtd_templates.md
echo ""
echo "4. GTD Compliance:"
grep -c "gtd-compliance" enhanced_gtd_templates.md
echo ""
echo "=== Test Complete ==="
'
```

### Expected Results
- **5 template sections** (Quick Capture, Task Processing, Management Dashboard, Weekly Review, Next Actions)
- **100+ Synthesis commands** ({{eval and {{cell}})
- **Mobile optimization** mentioned in each template
- **GTD compliance** specified for each phase
- **File size**: ~90KB (1,817 lines)
- **No broken links** or missing references

## Manual Testing Steps

### Step 1: Load in Logseq
1. Open Logseq with Kits plugin installed
2. Create new page or use existing page
3. Insert `enhanced_gtd_templates.md` content
4. Verify all 5 templates appear correctly

### Step 2: Test Each Template
1. **Quick Capture**: Try natural language capture command
2. **Task Processing**: Test auto-categorization
3. **Management Dashboard**: Try natural language query
4. **Weekly Review**: Test automated review preparation
5. **Next Actions**: Test context-aware task selection

### Step 3: Verify Integration
1. Capture task → Process it → See in Dashboard → Review weekly → Engage with next actions
2. Verify data flows correctly between phases
3. Check that Synthesis commands work as expected

## Troubleshooting

### Common Issues
1. **Synthesis commands not working**: Ensure Kits plugin is installed and Synthesis page is set up
2. **Template too large for mobile**: Consider extracting individual templates
3. **Performance issues**: Check file size and optimize if needed
4. **Missing features**: Verify all 5 templates are present in the consolidated file

### Fallback Options
1. Use individual template files if consolidated file causes issues
2. Disable certain features if performance is problematic
3. Use manual entry as fallback for Synthesis commands

## Success Criteria
- ✅ All 5 templates load correctly in Logseq
- ✅ Synthesis commands work as expected
- ✅ Natural language processing functions
- ✅ Mobile optimization is effective
- ✅ GTD workflow is complete and functional
- ✅ Performance is acceptable (<3s response time)

## Notes
- This consolidated file is optimized for desktop use
- Mobile users may prefer individual template files
- File size may impact mobile performance
- Regular testing recommended after updates