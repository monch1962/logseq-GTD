template:: GTD Enhanced Next Actions Dashboard (Synthesis Lab)
description:: Dynamic engagement dashboard with context-aware task selection, energy matching, and smart scheduling
version:: 2.0
compatibility:: Logseq mobile & desktop with Synthesis Lab
synthesis-required:: true
gtd-compliance:: Engage phase - Enhanced with NirvanaHQ-style task selection
performance-optimized:: true
mobile-optimized:: true

# GTD Enhanced Next Actions Dashboard ⚡

## 🎯 Smart Task Selection Engine

### Context-Aware Filtering (NirvanaHQ Style)
```synthesis
{{eval show me tasks for current context}}
→ **Detects context:** {{cell current-context}}
→ **Available tasks:** {{cell context-tasks-count}}
→ **Sorted by:** Priority → Due date → Energy match
→ **Shows:** {{cell suggested-tasks}} most relevant

{{eval what can I do in {{cell available-time}} minutes}}
→ **Time-based filtering:**
   - Quick wins (<15 min): {{cell quick-wins}}
   - Medium tasks (15-60 min): {{cell medium-tasks}}
   - Deep work (>60 min): {{cell deep-work-tasks}}
→ **Suggests:** {{cell time-appropriate-suggestions}}
```

### Energy & Focus Matching
```synthesis
{{cell energy-matching-engine}}
**Current energy:** {{cell current-energy-level}} ({{cell energy-source}})
**Focus level:** {{cell current-focus}} ({{cell focus-factors}})

**Task matching:**
- High energy tasks: {{cell high-energy-matches}}
- Medium energy tasks: {{cell medium-energy-matches}}
- Low energy tasks: {{cell low-energy-matches}}

**Optimal sequencing:**
{{eval suggest-task-sequence}}
1. {{cell sequence-1}} (warm-up)
2. {{cell sequence-2}} (peak energy)
3. {{cell sequence-3}} (cool-down)
```

## 📊 Dynamic Engagement Dashboard

### Live Action Dashboard
```synthesis
## 🎯 Now-Next-Later Dashboard
{{cell now-next-later-view}}

**Now ({{cell now-count}} items):**
{{eval show-now-tasks}}
→ Context: {{cell now-context}}
→ Energy: {{cell now-energy}}
→ Time: {{cell now-time}} minutes

**Next ({{cell next-count}} items):**
{{eval show-next-tasks}}
→ When: {{cell next-timing}}
→ Prerequisites: {{cell next-prerequisites}}
→ Preparation: {{cell next-preparation}}

**Later ({{cell later-count}} items):**
{{eval show-later-tasks}}
→ Scheduled: {{cell later-schedule}}
→ Dependencies: {{cell later-dependencies}}
→ Notifications: {{cell later-notifications}}
```

### Smart Priority Visualization
```synthesis
{{cell priority-visualization}}
**Priority heatmap:**
- 🔴 **Critical ({{cell critical-count}}):** {{cell critical-tasks}}
- 🟡 **High ({{cell high-count}}):** {{cell high-tasks}}
- 🟢 **Medium ({{cell medium-count}}):** {{cell medium-tasks}}
- 🔵 **Low ({{cell low-count}}):** {{cell low-tasks}}

**Dynamic prioritization:**
{{eval update-priorities-dynamically}}
→ Based on: {{cell priority-factors}}
→ Changes: {{cell priority-changes}}
→ Notifications: {{cell priority-notifications}}
```

## ⚡ Intelligent Task Execution

### One-Tap Task Start
```synthesis
{{eval start-task "Write report"}}
→ **Prepares:**
   - Context setup: {{cell context-setup}}
   - Time block: {{cell time-block}} minutes
   - Resources: {{cell task-resources}}
   - Focus mode: {{cell focus-mode-enabled}}

→ **Tracks:**
   - Start time: {{cell start-time}}
   - Expected finish: {{cell expected-finish}}
   - Progress: {{cell progress-tracker}}
   - Interruptions: {{cell interruption-tracker}}
```

### Smart Pomodoro Integration
```synthesis
{{cell pomodoro-engine}}
**Current session:** {{cell current-session}}
- Focus time: {{cell focus-time}} minutes
- Break time: {{cell break-time}} minutes
- Sessions completed: {{cell sessions-completed}}
- Productivity score: {{cell productivity-score}}

**Adaptive timing:**
{{eval adapt-pomodoro-timing}}
→ Based on: {{cell timing-factors}}
→ Adjusts: {{cell timing-adjustments}}
→ Optimizes: {{cell timing-optimizations}}
```

### Context Switching Intelligence
```synthesis
{{eval minimize-context-switching}}
**Current context:** {{cell current-context}}
**Suggested batch:**
1. {{cell batch-task-1}} ({{cell batch-reason-1}})
2. {{cell batch-task-2}} ({{cell batch-reason-2}})
3. {{cell batch-task-3}} ({{cell batch-reason-3}})

**Switch cost analysis:**
- Estimated switch time: {{cell switch-time}} minutes
- Mental reload: {{cell mental-reload}} effort
- Suggested grouping: {{cell task-grouping}}
```

## 📈 Engagement Analytics

### Real-Time Productivity Tracking
```synthesis
## ⚡ Live Productivity Dashboard
{{cell productivity-dashboard}}

**Today's engagement:**
- Tasks started: {{cell tasks-started}}
- Tasks completed: {{cell tasks-completed}}
- Time engaged: {{cell time-engaged}} hours
- Focus score: {{cell focus-score}}%

**Efficiency metrics:**
- Completion rate: {{cell completion-rate}}%
- Average task time: {{cell avg-task-time}} minutes
- Context switch frequency: {{cell switch-frequency}}
- Deep work ratio: {{cell deep-work-ratio}}%
```

### Energy & Focus Analytics
```synthesis
{{cell energy-analytics}}
**Energy patterns:**
- Peak energy times: {{cell peak-energy-times}}
- Energy dips: {{cell energy-dips}}
- Recovery patterns: {{cell recovery-patterns}}
- Sustainable pace: {{cell sustainable-pace}}

**Focus analysis:**
{{eval analyze-focus-patterns}}
→ Best focus times: {{cell best-focus-times}}
→ Common distractions: {{cell common-distractions}}
→ Focus duration: {{cell focus-duration}}
→ Recovery needs: {{cell recovery-needs}}
```

### Task Completion Intelligence
```synthesis
{{eval analyze-completion-patterns}}
**Completion factors:**
- Time of day: {{cell completion-time-patterns}}
- Day of week: {{cell completion-day-patterns}}
- Context effectiveness: {{cell context-effectiveness}}
- Task characteristics: {{cell task-characteristics}}

**Predictive completion:**
{{cell predictive-completion}}
- Likely completion time: {{cell likely-completion}}
- Risk factors: {{cell completion-risks}}
- Success probability: {{cell success-probability}}
- Optimization suggestions: {{cell completion-optimizations}}
```

## 🎮 Gamification & Motivation

### Progress Visualization
```synthesis
{{cell progress-visualization}}
**Today's progress:**
- [██████----] {{cell today-progress}}%
- Streak: {{cell current-streak}} days
- Weekly goal: {{cell weekly-goal-progress}}%
- Monthly target: {{cell monthly-target-progress}}%

**Achievements unlocked:**
{{cell recent-achievements}}
1. {{cell achievement-1}}
2. {{cell achievement-2}}
3. {{cell achievement-3}}
```

### Smart Rewards System
```synthesis
{{eval suggest-rewards}}
**Based on completion:**
- Small win: {{cell small-reward}}
- Medium achievement: {{cell medium-reward}}
- Major milestone: {{cell major-reward}}
- Streak maintenance: {{cell streak-reward}}

**Motivation factors:**
{{cell motivation-analysis}}
- Intrinsic motivation: {{cell intrinsic-motivation}}
- Extrinsic motivation: {{cell extrinsic-motivation}}
- Progress motivation: {{cell progress-motivation}}
- Social motivation: {{cell social-motivation}}
```

## 🔄 Intelligent Workflow Management

### Dynamic Task Sequencing
```synthesis
{{eval optimize-task-sequence}}
**Based on:**
- Energy levels: {{cell energy-sequence}}
- Context availability: {{cell context-sequence}}
- Dependencies: {{cell dependency-sequence}}
- Deadlines: {{cell deadline-sequence}}

**Optimal flow:**
1. {{cell flow-task-1}} ({{cell flow-reason-1}})
2. {{cell flow-task-2}} ({{cell flow-reason-2}})
3. {{cell flow-task-3}} ({{cell flow-reason-3}})
4. {{cell flow-task-4}} ({{cell flow-reason-4}})
```

### Smart Break Scheduling
```synthesis
{{eval schedule-smart-breaks}}
**Break recommendations:**
- Micro-breaks: Every {{cell micro-break-interval}} minutes
- Pomodoro breaks: Every {{cell pomodoro-break-interval}} minutes
- Meal breaks: {{cell meal-break-times}}
- Recovery breaks: {{cell recovery-break-times}}

**Break activities:**
{{eval suggest-break-activities}}
→ Physical: {{cell physical-breaks}}
→ Mental: {{cell mental-breaks}}
→ Social: {{cell social-breaks}}
→ Creative: {{cell creative-breaks}}
```

### Interruption Management
```synthesis
{{cell interruption-management}}
**Current focus shield:** {{cell focus-shield-status}}
**Interception rules:**
- Urgent interruptions: {{cell urgent-handling}}
- Important interruptions: {{cell important-handling}}
- Optional interruptions: {{cell optional-handling}}
- Scheduled interruptions: {{cell scheduled-handling}}

**Recovery protocol:**
{{eval recover-from-interruption}}
→ Time lost: {{cell interruption-time}}
→ Mental reload: {{cell mental-reload-time}}
→ Resume point: {{cell resume-point}}
→ Prevention: {{cell prevention-suggestions}}
```

## 📱 Mobile-Optimized Engagement

### Touch-Optimized Interface
```synthesis
{{eval optimize-for-mobile-engagement}}
**Mobile features:**
- One-tap actions: {{cell one-tap-actions}}
- Swipe gestures: {{cell swipe-gestures}}
- Voice commands: {{cell voice-commands}}
- Haptic feedback: {{cell haptic-feedback}}

**On-the-go engagement:**
{{eval enable-mobile-engagement}}
→ Quick tasks: {{cell mobile-quick-tasks}}
→ Voice updates: {{cell voice-updates}}
→ Photo documentation: {{cell photo-documentation}}
→ Location-based tasks: {{cell location-tasks}}
```

### Offline Engagement
```synthesis
{{eval enable-offline-engagement}}
**Offline capabilities:**
- Task caching: {{cell task-cache-size}}
- Progress tracking: {{cell offline-progress}}
- Sync management: {{cell sync-management}}
- Conflict resolution: {{cell conflict-resolution}}

**Battery optimization:**
{{eval optimize-battery-usage}}
→ Background sync: {{cell background-sync}}
→ Update frequency: {{cell update-frequency}}
→ Power modes: {{cell power-modes}}
→ Efficiency score: {{cell battery-efficiency}}
```

## 🛠️ Advanced Synthesis Features

### Natural Language Engagement
```synthesis
## 💬 Engagement Conversation
**Example commands:**
- "What should I work on now?": {{eval suggest-now-task}}
- "Start working on [task]": {{eval start-specific-task}}
- "Take a break": {{eval initiate-break}}
- "Log completion of [task]": {{eval log-completion}}
- "Reschedule [task]": {{eval reschedule-task}}

**Voice engagement (mobile):**
{{eval enable-voice-engagement}}
→ "Start work" → Begins focused session
→ "Log task done" → Records completion
→ "Suggest next" → Recommends next action
→ "Take break" → Initiates smart break
```

### Learning Engagement Patterns
```synthesis
{{eval learn-engagement-patterns}}
**Learning from:**
- Task completion times: {{cell completion-time-learning}}
- Focus duration: {{cell focus-duration-learning}}
- Break effectiveness: {{cell break-effectiveness-learning}}
- Motivation factors: {{cell motivation-learning}}

**Personalization:**
{{eval personalize-engagement}}
→ Adapts to: {{cell personalization-areas}}
→ Improves: {{cell improvement-areas}}
→ Optimizes: {{cell optimization-areas}}
```

### Integration with Other Systems
```synthesis
{{eval integrate-with-calendar-engagement}}
**Calendar sync:**
- Time blocking: {{cell time-blocking-integration}}
- Meeting preparation: {{cell meeting-prep-integration}}
- Availability management: {{cell availability-integration}}
- Schedule optimization: {{cell schedule-integration}}

**Communication integration:**
{{eval integrate-with-communication}}
→ Email tasks: {{cell email-integration}}
→ Chat tasks: {{cell chat-integration}}
→ Meeting tasks: {{cell meeting-integration}}
→ Collaboration tasks: {{cell collaboration-integration}}
```

## 📊 Engagement Analytics & Reporting

### Daily Engagement Report
```synthesis
{{eval generate-daily-engagement-report}}
**Today's summary:**
- Tasks completed: {{cell daily-completed}}
- Time engaged: {{cell daily-time-engaged}}
- Focus score: {{cell daily-focus-score}}
- Productivity score: {{cell daily-productivity-score}}

**Achievements:**
{{cell daily-achievements}}
1. {{cell achievement-1}}
2. {{cell achievement-2}}
3. {{cell achievement-3}}

**Improvement suggestions:**
{{eval suggest-daily-improvements}}
1. {{cell improvement-1}}
2. {{cell improvement-2}}
3. {{cell improvement-3}}
```

### Weekly Engagement Trends
```synthesis
{{cell weekly-engagement-trends}}
**Trend analysis:**
- Completion trends: {{cell completion-trends}}
- Focus trends: {{cell focus-trends}}
- Energy trends: {{cell energy-trends}}
- Productivity trends: {{cell productivity-trends}}

**Pattern recognition:**
{{eval identify-engagement-patterns}}
→ Productive patterns: {{cell productive-patterns}}
→ Inefficient patterns: {{cell inefficient-patterns}}
→ Improvement opportunities: {{cell improvement-opportunities}}
→ Success factors: {{cell success-factors}}
```

## 📋 Quick Reference

### Common Engagement Commands
```synthesis
## 🎯 Quick Actions
{{eval start-now}} - Start focused work session
{{eval suggest-next}} - Suggest next task
{{eval take-break}} - Take smart break
{{eval log-completion}} - Log task completion
{{eval reschedule}} - Reschedule current task

## 📊 Quick Analytics
{{eval show-today-stats}} - Today's engagement stats
{{eval show-focus-score}} - Current focus score
{{eval show-productivity}} - Productivity metrics
{{eval show-streak}} - Current streak
```

### Personal Engagement Profiles
```synthesis
{{eval my-focus-mode}} - Your focus settings
{{eval my-break-profile}} - Your break preferences
{{eval my-energy-profile}} - Your energy patterns
{{eval my-motivation-profile}} - Your motivation factors
```

---

**Note:** This enhanced engagement dashboard requires Synthesis Lab installation. It integrates with the intelligent review from [[Enhanced Weekly Review]] and provides dynamic task selection.

**Natural Language Examples:**
- "{{eval what should I do now}}"
- "{{eval start working on reports}}"
- "{{eval take a 5-minute break}}"
- "{{eval show me my progress today}}"

**Mobile Optimization:** Use voice commands for hands-free engagement or touch gestures for quick task management on mobile devices.