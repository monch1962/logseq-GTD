template:: GTD Areas of Responsibility
description:: Define and manage life/work areas with goals and regular reviews
version:: 1.0
compatibility:: Logseq mobile & desktop
gtd-compliance:: Organize phase - Life/work area definition and management

# GTD Areas of Responsibility

## 🎯 What Are Areas of Responsibility?

Areas of Responsibility represent the key domains of your life and work that you want to maintain at a certain standard. Unlike projects (which have a clear end), areas are ongoing commitments that require regular attention.

### Key Characteristics:
- **Ongoing** - No completion date
- **Standards-based** - Maintain at a certain level
- **Regular review** - Weekly/monthly check-ins
- **Goal-oriented** - Progress toward ideals

## 📋 Define Your Areas

### Personal Areas Template
```
## Area/{{area-name}}
type:: area-of-responsibility
category:: {{personal|professional|health|relationships|financial|spiritual|creative}}
standard:: {{description-of-desired-standard}}
review-frequency:: {{weekly|bi-weekly|monthly}}
current-status:: {{thriving|maintaining|needs-attention|neglected}}
last-reviewed:: {{date}}
next-review:: {{date}}
```

### Example: Health & Fitness
```
## Area/Health & Fitness
type:: area-of-responsibility
category:: health
standard:: Exercise 4x weekly, eat balanced meals, get 7-8 hours sleep, annual checkups
review-frequency:: weekly
current-status:: maintaining
last-reviewed:: {{today}}
next-review:: {{next-week}}
goals:: 
  - Lose 5 pounds by {{next-month}}
  - Run 5k without stopping
  - Reduce processed food intake
```

### Example: Professional Development
```
## Area/Professional Development
type:: area-of-responsibility
category:: professional
standard:: Learn one new skill quarterly, attend relevant conferences, maintain professional network
review-frequency:: monthly
current-status:: needs-attention
last-reviewed:: {{last-month}}
next-review:: {{next-month}}
goals::
  - Complete {{certification-name}} by {{date}}
  - Attend {{conference-name}} in {{month}}
  - Connect with 3 industry peers this quarter
```

## 🔄 Area Review System

### Weekly Area Check-in
```markdown
## Weekly Area Review - {{today}}

### Health & Fitness
status:: {{on-track|needs-work|excellent}}
actions-taken:: 
  - Exercised 3 times
  - Ate healthy meals 5 days
  - Slept 7+ hours nightly
improvements-needed::
  - Increase water intake
  - Add strength training
next-week-focus:: Consistency with morning workouts

### Professional Development
status:: {{on-track|needs-work|excellent}}
actions-taken::
  - Completed online course module
  - Attended industry webinar
  - Updated LinkedIn profile
improvements-needed::
  - Schedule certification study time
  - Reach out to mentors
next-week-focus:: Block 2 hours for skill development
```

### Monthly Deep Review
```markdown
## Monthly Area Assessment - {{month}}

### Area Status Summary
| Area | Status | Trend | Key Achievement | Priority Action |
|------|--------|-------|-----------------|-----------------|
| Health & Fitness | Maintaining | ↗️ | Consistent exercise | Add variety to workouts |
| Professional Development | Needs Attention | ↘️ | Completed course | Schedule mentor meetings |
| Relationships | Thriving | ↗️ | Regular family time | Plan weekend activity |
| Financial | Maintaining | → | Saved 10% income | Review investment options |

### Quarterly Goal Setting
```markdown
## Q{{quarter}} Area Goals

### Health & Fitness
- [ ] Achieve target weight of {{weight}}
- [ ] Complete {{fitness-challenge}}
- [ ] Establish consistent sleep schedule

### Professional Development  
- [ ] Earn {{certification}}
- [ ] Present at {{event}}
- [ ] Build portfolio with 3 new projects
```

## 📊 Area Dashboard Queries

### Current Area Status
{{query (read-file "queries/library/areas/status.clj")}}

### Areas Needing Attention
{{query (read-file "queries/library/areas/needing-attention.clj")}}

### Upcoming Area Reviews
{{query (read-file "queries/library/areas/upcoming-reviews.clj")}}

## 🎯 Area-Project Connection

### Link Projects to Areas
```markdown
## Project/{{project-name}}
type:: project
area:: [[Area/{{area-name}}]]
status:: {{active|completed|on-hold}}
priority:: {{HIGH|MEDIUM|LOW}}

### Project tasks inherit area context:
- TODO {{task-description}}
  area:: [[Area/{{area-name}}]]
  project:: [[Project/{{project-name}}]]
```

### Area Progress Tracking
```markdown
## Area Progress - {{area-name}}

### Active Projects
{{query: {and [[type project]] [[area [[Area/{{area-name}}]]]]}}}

### Completed This Quarter
{{query: {and [[type project]] [[area [[Area/{{area-name}}]]]] [[status completed]] [[completed-date {{this-quarter}}]]}}}

### Upcoming Initiatives
- [ ] {{initiative}} - {{timeline}}
- [ ] {{initiative}} - {{timeline}}
```

## 📱 Mobile Optimization

### Quick Area Check-in (Mobile)
```markdown
## Quick Area Status - {{today}}

### Health
status:: {{✅|⚠️|❌}}
note:: {{brief-note}}

### Work  
status:: {{✅|⚠️|❌}}
note:: {{brief-note}}

### Relationships
status:: {{✅|⚠️|❌}}
note:: {{brief-note}}

### Personal Growth
status:: {{✅|⚠️|❌}}
note:: {{brief-note}}
```

### Voice Area Update
```markdown
## Voice Update - {{area-name}} - {{now}}
type:: area-update
method:: voice
duration:: {{seconds}}
summary:: {{voice-to-text-summary}}
action-items:: 
  - {{extracted-action-item}}
  - {{extracted-action-item}}
follow-up:: {{date}}
```

## 🔄 Integration with Other Templates

### With Daily Journal
```markdown
## Daily Focus - {{today}}

### Area Priorities
1. **{{area-name}}**: {{focus-for-today}}
2. **{{area-name}}**: {{focus-for-today}}

### Area Tasks
- TODO {{task}} ([[Area/{{area-name}}]])
- TODO {{task}} ([[Area/{{area-name}}]])
```

### With Weekly Review
```markdown
## Weekly Area Review - Week of {{date}}

### Area Assessment
| Area | Status | Key Win | Improvement Needed |
|------|--------|---------|-------------------|
| {{area}} | {{status}} | {{win}} | {{improvement}} |
| {{area}} | {{status}} | {{win}} | {{improvement}} |

### Area Goals for Next Week
1. **{{area}}**: {{goal}}
2. **{{area}}**: {{goal}}
```

### With Next Actions Dashboard
{{query (read-file "queries/library/areas/next-actions-by-area.clj")}}

## 🏆 Best Practices

### 1. Start with 5-7 Key Areas
- Health & Fitness
- Professional Development
- Relationships
- Financial
- Personal Growth
- Home & Environment
- Recreation & Fun

### 2. Define Clear Standards
For each area, define what "maintaining" looks like:
- **Health**: Exercise 3x weekly, 7+ hours sleep, balanced diet
- **Professional**: Learn monthly, network quarterly, skill development
- **Relationships**: Weekly family time, monthly friend connections

### 3. Regular Review Schedule
- **Weekly**: Quick status check (5-10 minutes)
- **Monthly**: Deep assessment (20-30 minutes)
- **Quarterly**: Goal setting and adjustment (1 hour)

### 4. Connect Projects to Areas
Every project should support at least one area. This ensures your projects align with your life priorities.

### 5. Balance Attention
Use the dashboard to identify neglected areas and redistribute focus as needed.

## 🚨 Common Pitfalls

### ❌ Too Many Areas
**Problem**: Defining 15+ areas leads to overwhelm
**Solution**: Start with 5-7 core areas, expand gradually

### ❌ Vague Standards
**Problem**: "Be healthier" is not measurable
**Solution**: "Exercise 3x weekly, eat vegetables daily, sleep 7+ hours"

### ❌ Infrequent Reviews
**Problem**: Areas neglected for months
**Solution**: Schedule weekly quick checks in calendar

### ❌ No Project Connection
**Problem**: Areas exist in isolation from projects
**Solution**: Tag all projects with relevant areas

## 📈 Success Metrics

### Area Health Indicators
- **Review consistency**: % of scheduled reviews completed
- **Status trends**: Improving/declining area status over time
- **Goal achievement**: % of area goals completed
- **Project alignment**: % of projects connected to areas

### Improvement Tracking
```markdown
## Area Improvement Timeline

### Q1 2026
- Health: Needs Attention → Maintaining
- Professional: Neglected → Needs Attention
- Financial: Maintaining → Thriving

### Q2 2026 Goals
- Health: Maintaining → Thriving
- Professional: Needs Attention → Maintaining
- Relationships: Maintaining → Thriving
```

## 🔗 Related Templates

- **[05-gtd-daily-journal.md](05-gtd-daily-journal.md)** - Daily area focus integration
- **[08-weekly-review.md](08-weekly-review.md)** - Weekly area assessment
- **[07-project-next-action-enforcement.md](07-project-next-action-enforcement.md)** - Project-area connection
- **[13-gtd-analytics-improvement.md](../Improve/13-gtd-analytics-improvement.md)** - Area performance analytics

---

**Next Steps:**
1. Define your 5-7 key areas using the template above
2. Schedule weekly area reviews in your calendar
3. Connect existing projects to relevant areas
4. Use the dashboard queries to monitor area health
5. Adjust areas and standards quarterly based on life changes