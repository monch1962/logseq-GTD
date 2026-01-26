# Agent Guidelines for Logseq GTD Template System

## Project Overview
This is a **Logseq GTD (Getting Things Done) template system** - a collection of markdown templates for implementing GTD methodology in Logseq without plugins. The system is designed to work on both desktop and mobile Logseq.

## Repository Structure
```
logseq-GTD/
├── GTD_Templates/              # Main template system
│   ├── Phase1/                 # Core GTD foundation (10 templates)
│   └── Phase2/                 # Integrated FAQ solution (5 templates)
├── research/                   # Research and planning documents
├── queries/                    # Logseq query examples
├── templates/                  # Legacy templates (deprecated)
├── mobile/                     # Mobile-specific workflows
├── examples/                   # Complete implementation examples
├── INSTALLATION.md            # Setup instructions
├── USAGE.md                   # Usage guide
├── TESTING_CHECKLIST.md       # Comprehensive testing framework
├── PACKAGE_SUMMARY.md         # Package documentation
└── README.md                  # Project overview
```

## Build/Test/Lint Commands

### No Build System
This is a **template-only repository** with no build system, package.json, or compilation required. All files are plain markdown.

### Testing Commands
Since this is a template system, testing is manual:
1. **Template validation**: Check template syntax and structure
2. **Cross-platform testing**: Verify templates work on Logseq desktop and mobile
3. **GTD compliance**: Ensure templates follow GTD methodology
4. **Documentation testing**: Verify all documentation is accurate

To test a specific template:
```bash
# Check template syntax
grep -n "template::" GTD_Templates/Phase1/01-quick-capture.md

# Verify template structure
head -20 GTD_Templates/Phase1/01-quick-capture.md

# Test cross-references
grep -r "\[\[.*\]\]" GTD_Templates/ --include="*.md"
```

### Linting/Validation
No automated linting exists. Manual checks include:
1. **Markdown syntax**: Valid markdown structure
2. **Template variables**: Proper `{{variable}}` syntax
3. **Property consistency**: Consistent property names across templates
4. **Link validation**: All internal links resolve correctly

## Code Style Guidelines

### File Organization
1. **Template files**: Use `.md` extension with `template::` header
2. **Documentation**: Use `.md` with clear headings and structure
3. **Naming convention**: `##-descriptive-name.md` for templates (e.g., `01-quick-capture.md`)

### Template Structure
Each template should follow this pattern:
```markdown
template:: Template Name
description:: Brief description
version:: 1.0
compatibility:: Logseq mobile & desktop

# Template Title

## Section Header

### Subsection (if needed)

- Template content with {{variables}}
  property:: value
  another-property:: {{variable}}
```

### Property Naming Conventions
1. **Use kebab-case**: `next-action`, `time-estimate`, `captured-date`
2. **Be descriptive**: `project-context` not `ctx`
3. **Consistent across templates**: Use same property names for same concepts
4. **GTD standard properties**:
   - `context::` - GTD context (e.g., `@computer`, `@phone`, `@office`)
   - `priority::` - `HIGH`, `MEDIUM`, `LOW`
   - `status::` - `unprocessed`, `next-action`, `waiting`, `someday`
   - `project::` - Link to project page `[[Project/Name]]`
   - `time-estimate::` - Minutes required

### Markdown Formatting
1. **Headers**: Use `#` for main title, `##` for sections, `###` for subsections
2. **Lists**: Use `-` for unordered lists, maintain consistent indentation
3. **Code blocks**: Use triple backticks with language when appropriate
4. **Links**: Use `[[page-name]]` for internal links, `[text](url)` for external
5. **Emojis**: Use sparingly for visual cues (🚀, 📱, 🎯, ✅)

### Template Variables
1. **Syntax**: `{{variable-name}}` with descriptive names
2. **Placeholder text**: Use descriptive placeholders like `{{task-description}}`
3. **Date/time**: Use `{{now}}`, `{{today}}`, `{{tomorrow}}` for common dates
4. **Options**: Use `{{option1|option2|option3}}` for choice variables

### Query Examples (in queries/ directory)
1. **Datalog queries**: Use Logseq's native query syntax
2. **Comment queries**: Include `#+BEGIN_QUERY` and `#+END_QUERY`
3. **Descriptive**: Add comments explaining query purpose
4. **Performance**: Optimize for mobile performance

### Documentation Style
1. **Installation docs**: Step-by-step instructions with examples
2. **Usage docs**: Practical examples and common workflows
3. **Testing docs**: Clear test cases and expected results
4. **Troubleshooting**: Common issues and solutions

## Error Handling & Validation

### Template Validation
1. **Required properties**: Ensure essential GTD properties are included
2. **Variable consistency**: Check all `{{variables}}` are properly closed
3. **Link validation**: Verify `[[links]]` reference existing or creatable pages
4. **Cross-reference**: Ensure templates reference each other correctly

### Compatibility Checks
1. **Mobile optimization**: Templates must work on mobile Logseq
2. **Touch targets**: Ensure interactive elements are touch-friendly
3. **Performance**: Queries should be efficient on mobile devices
4. **Offline support**: Templates should work without internet

### GTD Methodology Compliance
1. **Five phases**: Capture, Clarify, Organize, Reflect, Engage
2. **Context system**: Proper context implementation
3. **Priority system**: Clear priority definitions
4. **Review cycles**: Weekly review implementation

## Development Workflow

### Creating New Templates
1. **Analyze need**: Identify missing GTD functionality
2. **Check existing**: Ensure not duplicating existing templates
3. **Follow structure**: Use standard template format
4. **Test thoroughly**: Verify on desktop and mobile
5. **Update docs**: Add to INSTALLATION.md and USAGE.md

### Modifying Existing Templates
1. **Backward compatibility**: Don't break existing user workflows
2. **Version tracking**: Update `version::` property
3. **Update references**: Update any templates that reference modified template
4. **Test cross-platform**: Verify changes work on all platforms

### Documentation Updates
1. **Sync with code**: Documentation must match template functionality
2. **Clear examples**: Include practical usage examples
3. **Troubleshooting**: Add common issues and solutions
4. **Cross-reference**: Link between related documents

## Testing Guidelines

### Manual Testing Checklist
1. **Template loading**: Does template insert correctly?
2. **Variable replacement**: Do `{{variables}}` work as expected?
3. **Property persistence**: Do properties save correctly?
4. **Query functionality**: Do queries return expected results?
5. **Mobile compatibility**: Does it work on mobile Logseq?
6. **Performance**: Acceptable load times on mobile?

### Cross-Platform Testing
1. **Desktop Logseq**: Full functionality test
2. **Mobile web**: Responsive design test
3. **Mobile app**: Native features test
4. **Sync testing**: Multi-device workflow test

### GTD Workflow Testing
1. **End-to-end workflow**: Capture → Process → Organize → Review → Execute
2. **Edge cases**: Empty lists, large volumes, special characters
3. **Error scenarios**: Invalid inputs, missing properties
4. **Recovery**: Data loss prevention and recovery

## Agent Responsibilities

### When Working on This Repository
1. **Preserve GTD methodology**: All changes must align with GTD principles
2. **Maintain cross-platform compatibility**: Everything must work on mobile and desktop
3. **No plugin dependencies**: Use only native Logseq features
4. **Document changes**: Update relevant documentation
5. **Test thoroughly**: Use TESTING_CHECKLIST.md

### Code Review Checklist
1. ✅ Template follows standard structure
2. ✅ Properties use consistent naming
3. ✅ Mobile optimization considered
4. ✅ Documentation updated
5. ✅ GTD methodology preserved
6. ✅ No breaking changes to existing workflows

### Quality Standards
1. **Clarity**: Templates should be self-explanatory
2. **Consistency**: Follow established patterns
3. **Completeness**: Include all necessary properties
4. **Performance**: Optimized for mobile use
5. **Maintainability**: Easy to understand and modify

## Special Notes for This Project

### Unique Constraints
1. **No build system**: All files are plain markdown
2. **No TypeScript/JavaScript**: Pure template implementation
3. **No package.json**: No npm scripts or dependencies
4. **Mobile-first**: Everything must work on mobile Logseq

### Success Metrics
1. **Setup time**: <15 minutes for new users
2. **Template load**: <2 seconds on mobile
3. **Query performance**: <1 second for typical queries
4. **User comprehension**: Clear without extensive training

### Community Considerations
1. **MIT licensed**: Free to use and modify
2. **Template-based**: Users can customize easily
3. **Documentation focus**: Comprehensive guides included
4. **Testing framework**: Built-in validation tools

---
*Last updated: January 2025*
*Version: 1.0*
*For agentic coding assistants working on the Logseq GTD Template System*