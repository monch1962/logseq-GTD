# Usage Guide

## 🚀 Quick Start

### First 15 Minutes with GTD Templates

#### Step 1: Set Up Daily Journal
1. Open Logseq and create/open your daily journal
2. Type `/` and select **"GTD Daily Journal"**
3. Fill in the template variables:
   - **Current Context:** @computer (or your current location)
   - **Time Available:** 30 minutes (start small)
   - **Energy Level:** medium
   - **Action Count:** 5 (default)

#### Step 2: Capture Your First Tasks
1. Type `/` and select **"GTD Quick Capture"**
2. Choose **Option 1: One-Tap Capture**
3. Enter 3-5 things on your mind
4. They'll appear in your inbox with `status:: unprocessed`

#### Step 3: Process Your Inbox
1. Type `/` and select **"GTD Task Processing"**
2. For each captured item:
   - **Is it actionable?** Yes/No decision tree
   - **<2 minutes?** Do it now or defer
   - **Assign:** Context, priority, time estimate
3. Process all items to inbox zero

#### Step 4: Review Next Actions
1. Go back to your **GTD Daily Journal**
2. The "Current Context Next Actions" section now shows your processed tasks
3. Work on tasks based on your current context, time, and energy

## 📋 Basic Usage

### Daily Workflow

#### Morning Routine (5-10 minutes)
```markdown
## Morning GTD Routine
1. **Open:** [[GTD Daily Journal]]
2. **Process:** Overnight captures (email, messages, thoughts)
3. **Review:** Today's calendar and waiting-for items
4. **Select:** 3-5 next actions for today's focus
5. **Plan:** Schedule time for high-priority tasks
```

#### Throughout the Day
- **Quick captures:** Use `/GTD Quick Capture` for new items
- **2-minute rule:** Do immediately if <2 minutes
- **Context switching:** Check [[GTD Daily Journal]] when changing locations
- **Energy management:** Match tasks to energy levels

#### Evening Routine (5-10 minutes)
```markdown
## Evening GTD Routine
1. **Complete:** Finish scheduled next actions
2. **Capture:** New items from the day
3. **Process:** Inbox to zero
4. **Update:** [[GTD Next Actions Dashboard]]
5. **Preview:** Tomorrow's calendar and priorities
```

### Weekly Workflow

#### Weekly Review (60-90 minutes)
1. **Schedule:** Regular time (Friday afternoon or Sunday evening)
2. **Use:** [[GTD Weekly Review]] template
3. **Complete:** All 5 phases (Collect, Process, Organize, Review, Plan)
4. **Result:** Clear system, focused plan for next week

## 🎯 Core Templates Usage

### GTD Daily Journal
**When to use:** Every day, morning and evening
**Key features:**
- Customizable next action count (3-10)
- Context-based task filtering
- Quick stats and dashboard links
- Mobile context detection

**Usage tips:**
- Set your current context first
- Adjust action count based on available time
- Use quick links to navigate to other dashboards
- Review stats to track system health

### GTD Quick Capture
**When to use:** Whenever something comes to mind
**Options:**
1. **One-Tap Capture:** Simplest, just the thought
2. **Categorized Capture:** Add urgency and category
3. **Voice Memo:** For mobile voice capture

**Usage tips:**
- Capture first, judge later
- One thought per capture
- Use voice on mobile for speed
- Process captures daily

### GTD Task Processing
**When to use:** During dedicated processing time
**Decision tree:**
- **Actionable?** Yes → Next action, No → File/Delete
- **<2 minutes?** Do now or defer
- **Multiple steps?** Create project

**Usage tips:**
- Batch process for efficiency
- Use the 2-minute rule strictly
- Be specific with next actions
- Assign appropriate contexts

### GTD Next Actions Dashboard
**When to use:** When deciding what to work on
**Filter options:**
- Context (@computer, @phone, @errands)
- Time available (15, 30, 60, 120+ minutes)
- Energy level (high, medium, low)
- Priority (HIGH, MEDIUM, LOW)

**Usage tips:**
- Use filter presets for common situations
- Check compliance warnings
- Export lists for planning sessions
- Review statistics regularly

## 🔄 Advanced Usage

### Integrated Dashboards

#### GTD Management Dashboard
**Combines:** Waiting-for, Someday/Maybe, Reference
**When to use:**
- Tracking delegated items (waiting-for)
- Storing future ideas (someday/maybe)
- Organizing reference materials

**Usage workflow:**
1. **Weekly:** Review all three sections
2. **Waiting-for:** Follow up on overdue items
3. **Someday/maybe:** Consider promotion to active
4. **References:** File new items, organize existing

#### GTD Integration Hub
**Combines:** Email, Calendar, External Tools
**When to use:**
- Processing email with GTD methodology
- Syncing calendar events with tasks
- Integrating web clips and notes

**Usage tips:**
- Set up email rules for auto-categorization
- Extract preparation tasks from calendar events
- Use web clipping for research
- Batch process communications

#### GTD Analytics & Improvement
**When to use:** Regular system optimization
**Key metrics:**
- System health score
- Capture and processing efficiency
- Completion rates and trends
- Improvement opportunities

**Usage tips:**
- Review weekly for small improvements
- Conduct monthly deep analysis
- Set quarterly improvement goals
- Track progress over time

#### GTD Learning Center
**When to use:** Learning and skill development
**Resources:**
- GTD fundamentals and principles
- FAQ and troubleshooting guides
- Tutorials and best practices
- Community knowledge

**Usage tips:**
- Follow learning paths (beginner to expert)
- Use tutorials for specific skills
- Participate in community discussions
- Track learning progress

## ⚙️ Customization

### Template Variables

#### Daily Journal Customization
```markdown
## GTD Daily Journal Settings
default-action-count:: 5          # 3-10 actions
default-context:: @computer       # Your most common context
show-2-minute-tasks:: true        # Show quick tasks
show-stats:: true                 # Display statistics
show-projects:: true              # Show projects overview
weekly-review-reminder:: true     # Weekly review alerts
```

#### Dashboard Customization
```markdown
## Dashboard Settings
### Next Actions Dashboard
default-show-count:: 10           # Items per section
show-compliance-checks:: true     # Quality warnings
show-statistics:: true            # Performance stats

### Management Dashboard
waiting-reminders:: true          # Follow-up alerts
someday-review-reminders:: true   # Idea review prompts
reference-organization:: true     # Filing reminders
```

### Query Customization

#### Simple Query Modifications
**Example:** Change number of next actions shown
```clojure
# In GTD Daily Journal template
:limit "{{action-count}}"  # Change this variable
```

**Example:** Add custom filter
```clojure
# Add to existing query
[(get ?props :custom-field) "your-value"]
```

#### Creating Custom Queries
1. **Identify need:** What information do you want?
2. **Start simple:** Basic count or list
3. **Add filters:** Context, priority, date
4. **Test:** Verify results are correct
5. **Integrate:** Add to appropriate template

### Mobile Optimization

#### Mobile Settings
```markdown
## Mobile Configuration
touch-optimized:: true            # Larger buttons
voice-input:: true                # Voice capture
offline-mode:: true               # Basic offline access
simplified-views:: true           # Reduced complexity
battery-optimized:: true          # Power saving
```

#### Mobile Workflow
**On the go:**
- Voice capture for quick thoughts
- Photo capture for reference materials
- Location-based context switching

**Short breaks:**
- Process 2-minute tasks
- Quick inbox review
- Next action selection

**Dedicated time:**
- Full processing sessions
- Weekly review preparation
- Template customization

## 🔗 Workflow Integration

### Complete GTD Workflow

#### Capture to Completion
```
1. Capture → [[GTD Quick Capture]]
2. Process → [[GTD Task Processing]]
3. Organize → [[GTD Management Dashboard]]
4. Review → [[GTD Daily Journal]] + [[GTD Weekly Review]]
5. Engage → [[GTD Next Actions Dashboard]]
6. Improve → [[GTD Analytics & Improvement]]
7. Learn → [[GTD Learning Center]]
```

#### Project Management Flow
```
1. Idea → Capture as someday/maybe
2. Activate → Create project with [[Project-Next Action Enforcement]]
3. Execute → Next actions in [[GTD Next Actions Dashboard]]
4. Track → Progress in [[GTD Management Dashboard]]
5. Complete → Archive and lessons learned
```

### Integration with Other Systems

#### Email Integration
**Workflow:**
1. **Capture:** Forward emails to processing
2. **Process:** Use [[GTD Integration Hub]] email templates
3. **Organize:** File as reference, waiting-for, or next action
4. **Review:** During weekly processing

**Automation ideas:**
- Auto-forward meeting invites
- Categorize by sender or subject
- Extract action items automatically

#### Calendar Integration
**Workflow:**
1. **Review:** Daily in [[GTD Daily Journal]]
2. **Prepare:** Extract tasks from events
3. **Schedule:** Time-specific actions
4. **Follow up:** After meetings

**Tips:**
- Add preparation time before events
- Extract action items during/after
- Sync with next actions dashboard

#### Note-Taking Integration
**Workflow:**
1. **Capture:** Notes from meetings, research, ideas
2. **Process:** Extract actions and references
3. **Organize:** File in appropriate dashboards
4. **Archive:** Processed notes

**Tools:**
- Web clippers for research
- Voice notes for ideas
- Meeting note templates

## 📊 Performance Optimization

### Query Performance

#### Optimizing Slow Queries
**Symptoms:** Templates load slowly, especially on mobile
**Solutions:**
1. **Add limits:** `:limit 10` to large queries
2. **Simplify:** Reduce complex joins
3. **Cache:** Use less frequent updates
4. **Index:** Ensure proper property usage

**Example optimization:**
```clojure
# Before (slow)
:query [:find (pull ?b [*]) ...]

# After (faster)
:query [:find (pull ?b [:block/content :block/properties]) ...]
:limit 10
```

#### Mobile Query Optimization
**Strategies:**
- Simpler queries on mobile
- Progressive loading
- Offline fallbacks
- Cached results

### Template Performance

#### Reducing Load Time
**Tips:**
- Minimize embedded queries
- Use conditional sections
- Optimize markdown structure
- Platform-specific optimizations

#### Memory Management
**Best practices:**
- Close unused graphs
- Limit open pages
- Clear cache periodically
- Use simpler templates on low-memory devices

## 🐛 Troubleshooting

### Common Issues

#### Templates Not Working
**Symptoms:** Errors, missing content, broken queries
**Solutions:**
1. **Check Logseq version:** Update to latest
2. **Verify installation:** Templates in correct folder
3. **Test queries:** Use simple test data first
4. **Check syntax:** Validate template markdown

#### Queries Returning No Results
**Symptoms:** Empty lists, "no results" messages
**Solutions:**
1. **Check properties:** Tasks need correct properties
2. **Test data:** Create sample tasks with properties
3. **Query syntax:** Verify query structure
4. **Permissions:** Check file access rights

#### Mobile Issues
**Symptoms:** Different behavior than desktop
**Solutions:**
1. **Use mobile views:** Simplified templates
2. **Check storage:** Ensure enough space
3. **Update app:** Latest version
4. **Offline mode:** Test without internet

### Recovery Procedures

#### Corrupted Templates
1. **Restore from backup:**
   ```bash
   cp ~/backups/templates/* ~/logseq/templates/
   ```

2. **Reinstall fresh:**
   ```bash
   rm -rf ~/logseq/templates/
   cp -r ~/logseq-GTD/GTD_Templates/* ~/logseq/templates/
   ```

3. **Manual repair:** Edit problematic templates

#### Data Loss
1. **Check recycle:** `~/.logseq/.recycle/`
2. **Git recovery:** `git checkout -- .`
3. **Backup restore:** From latest backup
4. **Manual recovery:** Recreate from memory/notes

## 🎓 Learning Resources

### Getting Started Resources
- **[[GTD Learning Center]]:** Complete learning hub
- **Beginner tutorials:** Step-by-step guides
- **Video tutorials:** Visual learning
- **Community forums:** Ask questions

### Skill Development
- **Learning paths:** Structured progression
- **Practice exercises:** Hands-on learning
- **Certification path:** Track progress
- **Community challenges:** Group learning

### Advanced Topics
- **Query development:** Custom queries
- **Template customization:** Advanced modifications
- **Workflow optimization:** Efficiency improvements
- **Integration development:** External tool connections

## 🔄 Continuous Improvement

### Improvement Cycle
1. **Measure:** Use [[GTD Analytics & Improvement]]
2. **Identify:** Find opportunities
3. **Learn:** [[GTD Learning Center]] resources
4. **Implement:** Make changes
5. **Validate:** Measure impact
6. **Standardize:** Update workflows

### Regular Reviews
**Daily:** Quick performance check  
**Weekly:** Detailed analysis and small improvements  
**Monthly:** Comprehensive review and medium improvements  
**Quarterly:** Strategic assessment and major improvements  
**Annually:** System overhaul and innovation planning

### Community Contribution
**Ways to contribute:**
1. **Share improvements:** Template modifications
2. **Report issues:** Bug reports and suggestions
3. **Create tutorials:** Share your expertise
4. **Help others:** Community support
5. **Translate:** Make available in other languages

## ✅ Success Checklist

### Daily Success
- [ ] Inbox processed to zero
- [ ] Next actions clear and specific
- [ ] Context-appropriate work completed
- [ ] New captures processed
- [ ] Evening review completed

### Weekly Success
- [ ] Weekly review completed
- [ ] All dashboards updated
- [ ] Improvement opportunities identified
- [ ] Learning progress made
- [ ] System trust maintained

### Monthly Success
- [ ] Performance metrics reviewed
- [ ] System optimizations implemented
- [ ] Skill development progress
- [ ] Community participation
- [ ] Continuous improvement cycle

### Long-term Success
- [ ] GTD mastery progressing
- [ ] System evolving with needs
- [ ] Stress reduction achieved
- [ ] Productivity improvement measurable
- [ ] Work-life balance improved

## 📞 Support

### Getting Help
- **Documentation:** This guide and [[README.md]]
- **Community:** Logseq Discord, Forum, Reddit
- **Issues:** GitHub repository issues
- **Email:** your-email@example.com

### Contributing
1. **Fork repository:** Create your copy
2. **Make changes:** Add improvements
3. **Test thoroughly:** Ensure quality
4. **Submit PR:** Share with community
5. **Participate:** Join discussions

### Updates
- **Check:** `git pull` for updates
- **Subscribe:** GitHub notifications
- **Follow:** @logseq on social media
- **Join:** Community announcements

---

**Ready to master GTD with Logseq!** Start with the [[Quick Start]] section and progress at your own pace.