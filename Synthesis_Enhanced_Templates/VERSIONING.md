# Template Versioning System

## Overview
This document outlines the versioning system for the enhanced GTD templates to ensure consistent updates and backward compatibility.

## Version Format
`MAJOR.MINOR.PATCH`

- **MAJOR**: Breaking changes (incompatible with previous versions)
- **MINOR**: New features (backward compatible)
- **PATCH**: Bug fixes (backward compatible)

## Current Versions

### Consolidated Template
- **File**: `enhanced_gtd_templates.md`
- **Version**: 2.0.0
- **Date**: January 2026
- **Changes**: Consolidated 5 templates into single file

### Individual Templates
- **Files**: `01-enhanced-quick-capture.md`, etc.
- **Version**: 2.0.0
- **Date**: January 2026
- **Changes**: Extracted from consolidated file

### Synthesis Functions
- **File**: `synthesis_functions.md`
- **Version**: 1.0.0
- **Date**: January 2026
- **Changes**: Initial implementation (11 functions)

## Version History

### v2.0.0 (January 2026) - Consolidated Release
**Features:**
- Consolidated 5 enhanced templates into single file
- Added extraction script for individual templates
- Improved mobile performance documentation
- Added comprehensive testing framework

**Files affected:**
- `enhanced_gtd_templates.md` (new)
- `CONSOLIDATED_GUIDE.md` (new)
- `extract_templates.sh` (new)
- `TEST_CONSOLIDATED.md` (new)
- `MOBILE_PERFORMANCE.md` (new)
- `FEEDBACK_TEMPLATE.md` (new)

### v1.0.0 (January 2026) - Initial Release
**Features:**
- 5 individual enhanced templates
- 11 Synthesis Lab functions
- Complete documentation suite
- Mobile optimization

**Files affected:**
- All individual template files
- `synthesis_functions.md`
- `custom.css`
- All documentation files

## Update Process

### Minor Updates (Backward Compatible)
1. Update template content
2. Increment MINOR version
3. Update version in template headers
4. Update CHANGELOG.md
5. Test with existing workflows

### Major Updates (Breaking Changes)
1. Create migration guide
2. Update template content
3. Increment MAJOR version
4. Update version in template headers
5. Update CHANGELOG.md
6. Provide upgrade path

### Patch Updates (Bug Fixes)
1. Fix identified issues
2. Increment PATCH version
3. Update version in template headers
4. Update CHANGELOG.md
5. Verify fixes work

## Compatibility Matrix

| Version | Logseq Version | Kits Plugin | Mobile Support |
|---------|----------------|-------------|----------------|
| 2.0.0   | 0.9.x+         | Required    | Yes (optimized) |
| 1.0.0   | 0.9.x+         | Required    | Yes            |

## Migration Guidelines

### From v1.0.0 to v2.0.0
**Option 1: Stay with individual templates**
- No action needed
- Continue using existing files

**Option 2: Switch to consolidated file**
1. Backup existing templates
2. Import `enhanced_gtd_templates.md`
3. Remove individual template files
4. Update template references

**Option 3: Use both approaches**
1. Keep individual templates for mobile
2. Use consolidated file for desktop
3. Use extraction script as needed

## Version Checking

### Check Current Version
```bash
# Check consolidated file version
grep "version::" enhanced_gtd_templates.md | head -1

# Check individual template versions
grep "version::" individual_templates/*.md
```

### Verify Compatibility
```bash
# Check Logseq version requirement
grep "compatibility::" enhanced_gtd_templates.md

# Check plugin requirements
grep "synthesis-required::" enhanced_gtd_templates.md
```

## Release Checklist

### Before Release
- [ ] All tests pass
- [ ] Documentation updated
- [ ] Version numbers updated
- [ ] CHANGELOG.md updated
- [ ] Backward compatibility verified
- [ ] Mobile testing completed

### Release Steps
1. Update version numbers
2. Run extraction script
3. Test consolidated and individual files
4. Update documentation
5. Create release notes
6. Tag release in git

### After Release
1. Monitor for issues
2. Collect user feedback
3. Address critical bugs
4. Plan next version

## File Version Tracking

### Template Files
Each template file includes version metadata:
```markdown
template:: Template Name
version:: 2.0.0
compatibility:: Logseq mobile & desktop with Synthesis Lab
```

### Documentation Files
Documentation files should reference compatible versions:
```markdown
**Compatible with:** v2.0.0+
**Last updated:** January 2026
```

### Script Files
Scripts should check for version compatibility:
```bash
# Version check in scripts
REQUIRED_VERSION="2.0.0"
CURRENT_VERSION=$(grep "version::" enhanced_gtd_templates.md | cut -d: -f3)
```

## Best Practices

### Version Control
1. Use semantic versioning
2. Document breaking changes
3. Maintain backward compatibility when possible
4. Provide migration paths for major changes

### User Communication
1. Clearly label versions
2. Document changes between versions
3. Provide upgrade instructions
4. Announce breaking changes early

### Quality Assurance
1. Test with each version increment
2. Verify backward compatibility
3. Test on all platforms (desktop/mobile)
4. Validate with real user workflows

## Support Policy

### Current Version (v2.0.0)
- Full support
- Bug fixes
- Feature requests considered

### Previous Version (v1.0.0)
- Limited support
- Security fixes only
- No new features

### Older Versions
- No official support
- Community support only
- Upgrade recommended

## Future Version Planning

### v2.1.0 (Planned)
- Additional natural language commands
- Enhanced mobile optimizations
- More integration examples

### v3.0.0 (Future)
- Major UI redesign
- Advanced AI features
- Team collaboration features

## Contact & Support
- **Issues**: GitHub repository
- **Questions**: Logseq community forums
- **Feedback**: Use FEEDBACK_TEMPLATE.md
- **Contributions**: Pull requests welcome