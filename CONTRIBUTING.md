# Contributing to Logseq GTD Template System

Thank you for your interest in contributing to the Logseq GTD Template System! This document provides guidelines and instructions for contributing.

## 🎯 Contribution Areas

We welcome contributions in the following areas:

### 1. **Template Development**
- New GTD workflow templates
- Template variations for different use cases
- Mobile-optimized template versions
- Internationalization templates

### 2. **Query Library**
- New query components
- Performance-optimized queries
- Specialized query patterns
- Query documentation

### 3. **Documentation**
- Usage examples and tutorials
- Translation of documentation
- Video tutorials and screencasts
- Troubleshooting guides

### 4. **Testing & Quality**
- Test cases and validation scripts
- Cross-platform testing results
- Performance benchmarking
- Accessibility improvements

### 5. **Community Support**
- Answering questions
- Creating example implementations
- Sharing workflow variations
- Mentoring new users

## 🚀 Getting Started

### Prerequisites
- Basic understanding of GTD methodology
- Experience with Logseq templates and queries
- Markdown knowledge
- Git familiarity

### Development Environment
1. **Fork the repository** on GitHub
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/YOUR-USERNAME/logseq-GTD.git
   cd logseq-GTD
   ```

3. **Create a feature branch**:
   ```bash
   git checkout -b feature/your-feature-name
   ```

4. **Set up development environment**:
   - Install Logseq (desktop recommended)
   - Copy templates to your test graph
   - Test changes locally

## 📝 Contribution Guidelines

### Template Development Guidelines

#### File Structure
```
GTD_Templates/
├── Phase_Name/              # GTD phase directory
│   └── ##-descriptive-name.md  # Template file
├── System/                  # System templates
└── Starter_Kit/            # Beginner templates
```

#### Template Format
```markdown
template:: Template Name
description:: Brief description (1-2 sentences)
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: GTD phase description

# Template Title

## Section Header

### Subsection (if needed)

- Template content with {{variables}}
  property:: value
  another-property:: {{variable}}
```

#### Property Naming Conventions
- Use **kebab-case**: `next-action`, `time-estimate`, `captured-date`
- Be **descriptive**: `project-context` not `ctx`
- **Consistent** across templates
- **GTD standard properties**:
  - `context::` - GTD context (e.g., `@computer`, `@phone`, `@office`)
  - `priority::` - `HIGH`, `MEDIUM`, `LOW`
  - `status::` - `unprocessed`, `next-action`, `waiting`, `someday`
  - `project::` - Link to project page `[[Project/Name]]`
  - `time-estimate::` - Minutes required

#### Variable Syntax
- Use `{{variable-name}}` with descriptive names
- Placeholder text: Use descriptive placeholders like `{{task-description}}`
- Date/time: Use `{{now}}`, `{{today}}`, `{{tomorrow}}` for common dates
- Options: Use `{{option1|option2|option3}}` for choice variables

### Query Development Guidelines

#### Query File Structure
```
queries/
├── library/                 # Reusable query components
│   ├── capture/            # Capture phase queries
│   ├── process/            # Process phase queries
│   └── ...                 # Other categories
└── examples/               # Example queries
```

#### Query Format
```clojure
;; Query description
;; Returns: What the query returns
;; Parameters: Any parameters needed
{:query [:find ?b :where [?b :block/marker "TODO"]]}
```

#### Performance Guidelines
- **Limit results** for mobile optimization
- **Use indexes** for frequently queried properties
- **Cache results** where appropriate
- **Test performance** on mobile devices

### Documentation Guidelines

#### File Location
- **User documentation**: Root directory (`README.md`, `USAGE.md`, etc.)
- **Examples**: `examples/` directory
- **Templates**: Documentation within template files
- **Community**: `community/` directory

#### Writing Style
- **Clear and concise** instructions
- **Practical examples** with real-world scenarios
- **Step-by-step** guides for complex workflows
- **Troubleshooting** sections for common issues

## 🔧 Development Workflow

### 1. Planning
- Check existing issues and feature requests
- Discuss major changes via GitHub issues first
- Ensure alignment with GTD methodology
- Consider cross-platform compatibility

### 2. Implementation
- Follow template structure guidelines
- Test on both desktop and mobile Logseq
- Verify GTD methodology compliance
- Update documentation as needed

### 3. Testing
- Use `TESTING_CHECKLIST.md` as reference
- Test on multiple platforms (Desktop, iOS, Android)
- Verify performance on mobile devices
- Check backward compatibility

### 4. Documentation
- Update relevant documentation files
- Add examples if applicable
- Include troubleshooting information
- Update changelog for significant changes

### 5. Submission
1. **Commit changes** with descriptive messages:
   ```bash
   git commit -m "feat: Add new template for email processing"
   git commit -m "docs: Update installation guide for mobile"
   git commit -m "fix: Correct query syntax in dashboard"
   ```

2. **Push to your fork**:
   ```bash
   git push origin feature/your-feature-name
   ```

3. **Create Pull Request**:
   - Use the PR template
   - Describe changes and motivation
   - Reference related issues
   - Include testing results

## 🧪 Testing Requirements

### Required Testing
- [ ] **Template functionality** - Basic operations work
- [ ] **Cross-platform** - Works on desktop and mobile
- [ ] **GTD compliance** - Follows GTD methodology
- [ ] **Performance** - Acceptable load times (<2 seconds)
- [ ] **Documentation** - Instructions are clear and accurate

### Testing Tools
- **Logseq Desktop** for primary testing
- **Logseq Mobile** for mobile optimization
- **Testing checklist** for systematic validation
- **Performance monitoring** for optimization

### Test Results
Include test results in PR description:
- Platforms tested (Desktop, iOS, Android)
- Performance measurements
- Any issues encountered
- Solutions implemented

## 📚 Documentation Requirements

### Required Updates
- [ ] **README.md** - If adding major features
- [ ] **USAGE.md** - If changing user workflows
- [ ] **INSTALLATION.md** - If changing installation process
- [ ] **CHANGELOG.md** - For all user-facing changes
- [ ] **Template documentation** - Within template files

### Documentation Format
- Use Markdown with clear headings
- Include practical examples
- Add screenshots for complex workflows
- Link to related documentation

## 🏆 Quality Standards

### Code Quality
- **Follow existing patterns** and conventions
- **Maintain consistency** across templates
- **Optimize for performance**, especially mobile
- **Ensure accessibility** for all users

### User Experience
- **Intuitive design** - Easy to understand and use
- **Clear instructions** - Self-explanatory templates
- **Progressive enhancement** - Simple to advanced
- **Error prevention** - Guide users away from mistakes

### GTD Methodology
- **Follow GTD principles** - Capture, Clarify, Organize, Reflect, Engage
- **Weekly review support** - Complete review process
- **Project management** - Next action enforcement
- **Context system** - Proper context implementation

## 🤝 Community Guidelines

### Communication
- **Be respectful** to all community members
- **Provide constructive feedback**
- **Help others** when possible
- **Share knowledge** and experiences

### Collaboration
- **Discuss before implementing** major changes
- **Consider existing workflows**
- **Build on existing patterns**
- **Credit contributions** appropriately

### Support
- **Answer questions** in issues and discussions
- **Share your experiences** with the system
- **Help test** other contributions
- **Mentor new contributors**

## 🚨 Issue Reporting

### Bug Reports
When reporting bugs, include:
1. **Description** of the issue
2. **Steps to reproduce**
3. **Expected behavior**
4. **Actual behavior**
5. **Screenshots** if applicable
6. **System information** (Logseq version, OS, device)

### Feature Requests
When requesting features, include:
1. **Problem description** - What problem does this solve?
2. **Proposed solution** - How should it work?
3. **Use cases** - Who will use this and how?
4. **Alternatives considered** - Other ways to solve the problem

## 📜 License

By contributing, you agree that your contributions will be licensed under the MIT License. See [LICENSE](LICENSE) for details.

## 🙏 Acknowledgments

- **David Allen** for the GTD methodology
- **Logseq team** for the amazing platform
- **All contributors** who help improve the system
- **Community members** for feedback and testing

## 📞 Contact

### Project Maintainer
- **David M** - Lead developer
- GitHub: [@monch1962](https://github.com/monch1962)

### Communication Channels
- **GitHub Issues** - For bugs and feature requests
- **GitHub Discussions** - For questions and discussions
- **Pull Requests** - For code contributions

---

**Thank you for contributing to making the Logseq GTD Template System better for everyone!** 🚀

*"Alone we can do so little; together we can do so much." - Helen Keller*