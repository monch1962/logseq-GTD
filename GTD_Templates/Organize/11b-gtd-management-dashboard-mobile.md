template:: GTD Management Dashboard (Mobile Optimized)
description:: Simplified mobile-optimized dashboard for waiting-for, someday/maybe, and reference management
version:: 1.1
compatibility:: Logseq mobile (optimized)
gtd-compliance:: Integrated FAQ solution
performance-optimized:: true
cache-enabled:: true
cache-ttl:: 600
lazy-loading:: enabled
mobile-optimized:: true
battery-optimized:: true
touch-friendly:: true
offline-support:: true

# GTD Management Dashboard (Mobile)

## 🎯 Mobile Dashboard Overview

**Purpose:** Lightweight mobile version of management dashboard  
**Optimized for:** Touch interaction, battery life, offline use  
**Data usage:** Minimal queries, aggressive caching  
**Navigation:** ← Back to [[GTD Daily Journal (Mobile)]] | [[GTD Next Actions Dashboard (Mobile)]]

## 🔄 Waiting For (Mobile)

### Quick Waiting For View
{{query (read-file "queries/library/dashboard/waiting-for-items.clj") :limit 5}}

### Add New Waiting For (Mobile)
```markdown
## ⏳ New Waiting For
- {{item}}
  type:: waiting-for
  status:: waiting
  from:: {{person}}
  expected:: {{date}}
  priority:: {{high|medium|low}}
  
  **Mobile notes:**
  {{notes}}
```

## 🔮 Someday/Maybe (Mobile)

### Quick Someday View
{{query (read-file "queries/library/dashboard/high-interest-someday.clj") :limit 3}}

### Add New Someday (Mobile)
```markdown
## 🔮 New Someday Idea
- {{idea}}
  type:: someday-maybe
  captured:: {{now}}
  interest:: {{high|medium|low}}
  
  **Why interesting:**
  {{reason}}
```

## 📚 References (Mobile)

### Recent References
{{query (read-file "queries/library/dashboard/recent-references.clj") :limit 3}}

### Add New Reference (Mobile)
```markdown
## 📚 New Reference
- [[{{title}}]]
  type:: reference
  filed:: {{now}}
  source:: {{url|note|photo|audio}}
  summary:: {{summary}}
  
  **Mobile tags:**
  {{tag1}} {{tag2}}
```

## 📱 Mobile-Specific Features

### Battery Optimization
- **Low battery mode:** Longer cache TTL (900s)
- **Power saver:** Reduced query limits
- **Offline mode:** Cached data only

### Touch Optimization
- **Large touch targets:** Easy tapping
- **Swipe navigation:** Between sections
- **Haptic feedback:** Confirmation taps

### Offline Support
- **Cached data:** Available offline
- **Queue updates:** Sync when online
- **Local storage:** No network required

## ⚙️ Mobile Settings

```markdown
## Mobile Dashboard Settings
### Performance Settings
cache-ttl:: 600
query-limit:: 5
lazy-loading:: true
offline-mode:: true

### Display Settings
font-size:: medium  # small|medium|large
theme:: light  # light|dark|auto
show-images:: false  # true|false

### Battery Settings
battery-saver:: auto  # auto|on|off
low-battery-ttl:: 900
power-saver-limit:: 3
```

## 🔗 Mobile Workflows

### Quick Capture → Mobile Dashboard
1. **Capture:** Voice/photo/text in [[GTD Quick Capture (Mobile)]]
2. **Process:** Quick categorization
3. **File:** To appropriate mobile section
4. **Sync:** Later when on desktop

### Mobile → Desktop Sync
- **Waiting for:** Full details added on desktop
- **Someday/maybe:** Elaborated during weekly review
- **References:** Organized and tagged on desktop

## 🛠️ Mobile Tools

### Quick Actions
- **Add waiting:** [[Mobile Waiting For Template]]
- **Add someday:** [[Mobile Someday Template]]
- **Add reference:** [[Mobile Reference Template]]
- **Take photo:** Attach to any item
- **Record audio:** Voice notes

### Mobile Maintenance
- **Weekly:** Quick review of all sections
- **Monthly:** Cleanup of old items
- **As needed:** Sync with desktop

## 📊 Mobile Performance

### Optimization Status
- **Cache hit rate:** {{cache-hit-rate}}%
- **Memory usage:** {{memory-usage}}MB
- **Load time:** {{load-time}}s
- **Battery impact:** {{battery-impact}}/100

### Success Metrics
- **Setup time:** <5 minutes
- **Daily usage:** <2 minutes
- **Battery drain:** <1% per hour
- **Offline reliability:** 100%

## 🔗 Related Mobile Dashboards

### Mobile GTD System
📱 **[[GTD Quick Capture (Mobile)]]** - Fast capture  
📋 **[[GTD Next Actions Dashboard (Mobile)]]** - Mobile tasks  
📅 **[[GTD Daily Journal (Mobile)]]** - Daily planning  
📊 **[[GTD Weekly Review (Mobile)]]** - Mobile review

### Quick Navigation
← **Back:** [[GTD Daily Journal (Mobile)]]  
🏠 **Home:** [[GTD Management Dashboard (Mobile)]]  
⚙️ **Settings:** [[Mobile GTD Settings]]  
🆘 **Help:** [[Mobile GTD Guide]]

## ✅ Mobile Implementation

### Setup Checklist
- [ ] Enable mobile caching
- [ ] Configure battery settings
- [ ] Test touch interactions
- [ ] Verify offline functionality
- [ ] Set up sync with desktop

### Usage Tips
1. **On the go:** Use quick capture and basic views
2. **Low battery:** Enable power saver mode
3. **No signal:** Work offline with cached data
4. **Weekly review:** Use desktop for detailed work

---
*Mobile-optimized version of GTD Management Dashboard*
*Version: 1.1 | Last updated: January 2026*
*Compatibility: Logseq Mobile 0.9.0+*