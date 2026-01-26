# 📱 Mobile Templates Quick Reference

## 🎯 Template Comparison

| Template | Original | Mobile-Optimized | Key Differences |
|----------|----------|------------------|-----------------|
| **Daily Journal** | `05-gtd-daily-journal.md` | `05b-gtd-daily-journal-mobile.md` | 5-min review, battery-aware, voice capture |
| **Next Actions** | `06-next-actions-dashboard.md` | `06b-next-actions-dashboard-mobile.md` | Touch targets, swipe actions, offline support |
| **Management** | `11-gtd-management-dashboard.md` | `11b-gtd-management-dashboard-mobile.md` | Simplified views, mobile capture, battery profiles |

## ⚡ Quick Settings

### Cache Configuration
```markdown
# Add to any template header
cache-enabled:: true
cache-ttl:: 600  # 10 minutes default
battery-aware:: true
mobile-optimized:: true
```

### Battery Settings
```markdown
# Power saver profiles
battery-saver:: auto
low-battery-threshold:: 30%
critical-battery-threshold:: 15%
offline-mode-threshold:: 20%
```

### Display Settings
```markdown
# Touch optimization
touch-friendly:: true
touch-target-size:: large  # 44px minimum
haptic-feedback:: true
swipe-gestures:: enabled
```

## 🔋 Battery Optimization Cheat Sheet

### Cache TTL by Battery Level
| Battery | TTL | Query Limit | Mode |
|---------|-----|-------------|------|
| >70% | 5min | 10 items | Normal |
| 40-70% | 10min | 5 items | Balanced |
| 20-40% | 15min | 3 items | Power Saver |
| <20% | 20min | 1 item | Extreme Saver |

### Quick Commands
```bash
# Check performance
./scripts/performance-test.sh

# Fix cache formatting
./scripts/fix-cache-formatting.sh

# Revert template changes
./scripts/revert-template-caching.sh
```

## 🚀 Installation Commands

```bash
# Update templates
cp GTD_Templates/Review/05b-gtd-daily-journal-mobile.md ~/logseq/templates/
cp GTD_Templates/Engage/06b-next-actions-dashboard-mobile.md ~/logseq/templates/
cp GTD_Templates/Organize/11b-gtd-management-dashboard-mobile.md ~/logseq/templates/

# Add to Logseq
# 1. Open Logseq Mobile
# 2. Settings → Templates
# 3. Add new templates
# 4. Set as favorites
```

## 📞 Support & Troubleshooting

### Common Issues
1. **Slow loading:** Enable cache, reduce query limits
2. **High battery:** Use power saver, increase TTL
3. **Touch issues:** Use mobile templates, enable large targets
4. **Offline issues:** Open while online first, check storage

### Quick Fixes
- **Clear cache:** Settings → Advanced → Clear Template Cache
- **Reset templates:** Remove and re-add templates
- **Update Logseq:** Ensure latest version (0.9.0+)
- **Restart app:** Close and reopen Logseq

## 🔗 Essential Files

### Core Templates
- `GTD_Templates/Review/05b-gtd-daily-journal-mobile.md`
- `GTD_Templates/Engage/06b-next-actions-dashboard-mobile.md`
- `GTD_Templates/Organize/11b-gtd-management-dashboard-mobile.md`

### Configuration
- `queries/utils/cache-utils.clj` - Caching system
- `GTD_Templates/System/18-battery-optimization-guide.md` - Technical guide
- `mobile-optimization-guide.md` - User guide

### Scripts
- `scripts/performance-test.sh` - Performance testing
- `scripts/fix-cache-formatting.sh` - Cache formatting fix
- `scripts/revert-template-caching.sh` - Revert changes

## ✅ Daily Workflow

### Morning (5 min)
1. Open **Daily Journal (Mobile)**
2. Quick inbox check
3. Set context (@phone/@home/etc.)
4. Pick 3 actions for today

### Throughout Day
1. **Quick captures:** Voice/photo/text
2. **Context switches:** Update location/context
3. **2-minute rule:** Process immediately if <2min
4. **Status updates:** Complete/defer with one tap

### Evening (5 min)
1. Process remaining captures
2. Review completed actions
3. Plan tomorrow's mobile tasks
4. Charge device

## 🎯 Performance Targets

| Metric | Target | Measurement |
|--------|--------|-------------|
| Load time | <1s | Template opens |
| Battery drain | <1%/hour | Device battery stats |
| Memory usage | <50MB | Device memory monitor |
| Cache hits | >80% | Template headers |
| Offline reliability | 100% | No-signal testing |

## 📊 Monitoring

### Check Performance
1. **Template headers:** Show cache stats
2. **Device battery:** Usage by app
3. **Logseq settings:** Performance metrics
4. **System dashboard:** [[GTD System Performance Dashboard]]

### Optimize Settings
Based on your usage:
- **Heavy user:** TTL 300, limit 5, normal mode
- **Moderate user:** TTL 600, limit 3, balanced mode
- **Light user:** TTL 900, limit 1, power saver

## 🆘 Emergency Fixes

### If Battery Drains Too Fast
1. Enable **Extreme Saver** mode
2. Set **cache-ttl:: 1800** (30 minutes)
3. Use **offline-mode:: true**
4. Reduce screen brightness

### If Templates Won't Load
1. Clear template cache
2. Restart Logseq app
3. Reinstall templates
4. Check device storage (>100MB free)

### If Touch Doesn't Work
1. Enable **touch-friendly:: true**
2. Set **touch-target-size:: large**
3. Use device accessibility settings
4. Try swipe gestures instead of taps

## 🔄 Update Schedule

### Weekly
- Clear template cache
- Review performance metrics
- Adjust settings if needed
- Backup templates

### Monthly
- Test new features
- Review battery impact
- Optimize settings
- Update to latest version

### Quarterly
- Major performance review
- Update all templates
- Test on new devices
- Share feedback with community

---
*Quick Reference v1.2.0*  
*Last updated: January 2026*  
*For Logseq GTD Template System*