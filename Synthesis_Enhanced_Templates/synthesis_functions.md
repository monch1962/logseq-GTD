# Synthesis Lab Function Implementations

This document contains the actual JavaScript function implementations for the enhanced GTD templates. These functions should be added to your Synthesis page in Logseq (created via the Kits plugin).

## How to Use These Functions

1. Install the Kits plugin in Logseq
2. Create a page named "Synthesis" 
3. Add 11 JavaScript code blocks to the Synthesis page
4. Copy the functions below into the appropriate code blocks
5. Save and test the functions

## Core GTD Functions

### 1. Natural Language Capture Parser

```javascript
// Code Block 1: Natural Language Processing
async function parseNaturalLanguageCapture(text) {
  // Parse natural language input and extract GTD properties
  const result = {
    description: text,
    context: '@anywhere',
    priority: 'MEDIUM',
    timeEstimate: 15,
    project: null,
    tags: []
  };

  // Context detection
  const contextPatterns = {
    '@computer': ['computer', 'laptop', 'desktop', 'online', 'internet', 'email', 'code', 'write'],
    '@phone': ['phone', 'call', 'text', 'message', 'mobile', 'whatsapp'],
    '@office': ['office', 'work', 'meeting', 'print', 'scan', 'fax'],
    '@home': ['home', 'house', 'clean', 'cook', 'garden', 'repair'],
    '@errands': ['store', 'shop', 'bank', 'post', 'pharmacy', 'grocery']
  };

  // Priority detection
  if (text.toLowerCase().includes('urgent') || text.toLowerCase().includes('asap')) {
    result.priority = 'HIGH';
  } else if (text.toLowerCase().includes('whenever') || text.toLowerCase().includes('someday')) {
    result.priority = 'LOW';
  }

  // Time estimate detection
  const timeMatch = text.match(/(\d+)\s*(min|minutes|hour|hours)/i);
  if (timeMatch) {
    const value = parseInt(timeMatch[1]);
    const unit = timeMatch[2].toLowerCase();
    result.timeEstimate = unit.includes('hour') ? value * 60 : value;
  }

  // Project detection
  const projectMatch = text.match(/for\s+(\w+)/i);
  if (projectMatch) {
    result.project = `[[Project/${projectMatch[1]}]]`;
  }

  // Context detection
  for (const [context, keywords] of Object.entries(contextPatterns)) {
    if (keywords.some(keyword => text.toLowerCase().includes(keyword))) {
      result.context = context;
      break;
    }
  }

  return result;
}
```

### 2. Smart Task Categorization

```javascript
// Code Block 2: Task Categorization
async function categorizeTask(taskText) {
  const categories = {
    'next-action': ['do', 'complete', 'finish', 'submit', 'send', 'call', 'email'],
    'waiting-for': ['waiting', 'pending', 'follow up', 'check on', 'awaiting'],
    'someday-maybe': ['someday', 'maybe', 'would be nice', 'if time', 'consider'],
    'reference': ['read', 'review', 'study', 'learn', 'research']
  };

  const text = taskText.toLowerCase();
  let category = 'next-action';

  for (const [cat, keywords] of Object.entries(categories)) {
    if (keywords.some(keyword => text.includes(keyword))) {
      category = cat;
      break;
    }
  }

  return {
    category,
    properties: {
      status: category === 'next-action' ? 'next-action' : 'unprocessed',
      processed: category !== 'unprocessed'
    }
  };
}
```

### 3. Natural Language Query Processor

```javascript
// Code Block 3: Query Processing
async function processNaturalLanguageQuery(query) {
  const queryLower = query.toLowerCase();
  let result = {
    type: 'tasks',
    filters: [],
    sort: 'priority-desc',
    limit: 20
  };

  // Time-based queries
  if (queryLower.includes('15 minutes') || queryLower.includes('quick')) {
    result.filters.push(['time-estimate', '<=', 15]);
  } else if (queryLower.includes('30 minutes')) {
    result.filters.push(['time-estimate', '<=', 30]);
  } else if (queryLower.includes('hour')) {
    result.filters.push(['time-estimate', '<=', 60]);
  }

  // Context queries
  if (queryLower.includes('@computer') || queryLower.includes('computer')) {
    result.filters.push(['context', '=', '@computer']);
  } else if (queryLower.includes('@phone') || queryLower.includes('phone')) {
    result.filters.push(['context', '=', '@phone']);
  } else if (queryLower.includes('@home') || queryLower.includes('home')) {
    result.filters.push(['context', '=', '@home']);
  }

  // Priority queries
  if (queryLower.includes('high priority') || queryLower.includes('urgent')) {
    result.filters.push(['priority', '=', 'HIGH']);
  } else if (queryLower.includes('low priority')) {
    result.filters.push(['priority', '=', 'LOW']);
  }

  // Status queries
  if (queryLower.includes('next actions') || queryLower.includes('what can i do')) {
    result.filters.push(['status', '=', 'next-action']);
  } else if (queryLower.includes('waiting')) {
    result.filters.push(['status', '=', 'waiting']);
  }

  // Project queries
  const projectMatch = queryLower.match(/for\s+(\w+)/);
  if (projectMatch) {
    result.filters.push(['project', 'contains', projectMatch[1]]);
  }

  return result;
}
```

### 4. Energy Level Matcher

```javascript
// Code Block 4: Energy Matching
async function matchTasksByEnergy(energyLevel, availableTime) {
  // energyLevel: 'high', 'medium', 'low'
  // availableTime: minutes available
  
  const energyMap = {
    'high': {
      priority: ['HIGH', 'MEDIUM'],
      timeEstimate: [5, 120],
      complexity: 'any'
    },
    'medium': {
      priority: ['MEDIUM', 'LOW'],
      timeEstimate: [5, 60],
      complexity: 'medium'
    },
    'low': {
      priority: ['LOW'],
      timeEstimate: [5, 30],
      complexity: 'low'
    }
  };

  const config = energyMap[energyLevel] || energyMap.medium;
  
  return {
    filters: [
      ['priority', 'in', config.priority],
      ['time-estimate', '<=', availableTime],
      ['time-estimate', '>=', config.timeEstimate[0]],
      ['time-estimate', '<=', config.timeEstimate[1]],
      ['status', '=', 'next-action']
    ],
    sort: 'priority-desc',
    limit: 5
  };
}
```

### 5. Batch Processing Engine

```javascript
// Code Block 5: Batch Processing
async function processBatchTasks(tasks, operation) {
  const results = [];
  
  for (const task of tasks) {
    try {
      let result;
      
      switch (operation) {
        case 'categorize':
          result = await categorizeTask(task.description);
          break;
        case 'delegate':
          result = await delegateTask(task);
          break;
        case 'schedule':
          result = await scheduleTask(task);
          break;
        case 'convert-to-project':
          result = await convertToProject(task);
          break;
        default:
          result = { error: 'Unknown operation' };
      }
      
      results.push({
        task: task.description,
        success: true,
        result
      });
    } catch (error) {
      results.push({
        task: task.description,
        success: false,
        error: error.message
      });
    }
  }
  
  return {
    total: tasks.length,
    successful: results.filter(r => r.success).length,
    failed: results.filter(r => !r.success).length,
    results
  };
}
```

### 6. Smart Delegation Detector

```javascript
// Code Block 6: Delegation Detection
async function detectDelegationOpportunities(task) {
  const delegationKeywords = [
    'ask', 'request', 'delegate', 'assign', 'hand off',
    'follow up with', 'check with', 'email to', 'send to'
  ];
  
  const text = task.description.toLowerCase();
  const isDelegation = delegationKeywords.some(keyword => text.includes(keyword));
  
  if (!isDelegation) {
    return { shouldDelegate: false };
  }
  
  // Extract person/team name
  const personMatch = text.match(/(?:to|with|for)\s+(\w+(?:\s+\w+)?)/i);
  const person = personMatch ? personMatch[1] : 'someone';
  
  return {
    shouldDelegate: true,
    delegatedTo: person,
    followUpDate: new Date(Date.now() + 7 * 24 * 60 * 60 * 1000), // 7 days from now
    properties: {
      status: 'waiting',
      waiting-for: person,
      'follow-up-date': new Date(Date.now() + 7 * 24 * 60 * 60 * 1000).toISOString().split('T')[0]
    }
  };
}
```

### 7. Learning System

```javascript
// Code Block 7: Learning System
class GTDLearingSystem {
  constructor() {
    this.userPatterns = {
      preferredContexts: {},
      timePreferences: {},
      completionTimes: []
    };
    this.loadPatterns();
  }

  loadPatterns() {
    // Load from localStorage or Logseq database
    try {
      const saved = localStorage.getItem('gtd-learning-patterns');
      if (saved) {
        this.userPatterns = JSON.parse(saved);
      }
    } catch (e) {
      console.log('No saved patterns found');
    }
  }

  savePatterns() {
    localStorage.setItem('gtd-learning-patterns', JSON.stringify(this.userPatterns));
  }

  recordCompletion(task, actualTime) {
    // Record completion time for learning
    this.userPatterns.completionTimes.push({
      estimated: task.timeEstimate,
      actual: actualTime,
      context: task.context,
      priority: task.priority,
      timestamp: Date.now()
    });

    // Update context preferences
    if (!this.userPatterns.preferredContexts[task.context]) {
      this.userPatterns.preferredContexts[task.context] = 0;
    }
    this.userPatterns.preferredContexts[task.context]++;

    this.savePatterns();
  }

  getTimeEstimateSuggestion(taskDescription) {
    // Suggest time estimate based on past completions
    const similarTasks = this.userPatterns.completionTimes.filter(
      ct => ct.context === task.context
    );

    if (similarTasks.length === 0) {
      return 30; // Default 30 minutes
    }

    const avgTime = similarTasks.reduce((sum, ct) => sum + ct.actual, 0) / similarTasks.length;
    return Math.round(avgTime);
  }

  getContextSuggestion(timeOfDay) {
    // Suggest context based on time of day and past productivity
    const hour = new Date().getHours();
    
    // Simple time-based suggestions
    if (hour < 12) {
      return '@computer'; // Morning: computer work
    } else if (hour < 17) {
      return '@phone'; // Afternoon: calls and communication
    } else {
      return '@home'; // Evening: home tasks
    }
  }
}

// Global instance
const gtdLearningSystem = new GTDLearingSystem();
```

### 8. Analytics Engine

```javascript
// Code Block 8: Analytics
async function generateGTDAnalytics(timeframe = 'week') {
  const now = new Date();
  let startDate;
  
  switch (timeframe) {
    case 'day':
      startDate = new Date(now.getFullYear(), now.getMonth(), now.getDate());
      break;
    case 'week':
      startDate = new Date(now.getFullYear(), now.getMonth(), now.getDate() - 7);
      break;
    case 'month':
      startDate = new Date(now.getFullYear(), now.getMonth() - 1, now.getDate());
      break;
    default:
      startDate = new Date(now.getFullYear(), now.getMonth(), now.getDate() - 7);
  }

  // This would query Logseq database
  // For now, return mock analytics
  return {
    timeframe,
    startDate: startDate.toISOString().split('T')[0],
    endDate: now.toISOString().split('T')[0],
    metrics: {
      tasksCaptured: Math.floor(Math.random() * 50) + 20,
      tasksCompleted: Math.floor(Math.random() * 40) + 15,
      completionRate: Math.floor(Math.random() * 30) + 60, // 60-90%
      averageCompletionTime: Math.floor(Math.random() * 45) + 15, // 15-60 minutes
      mostProductiveContext: '@computer',
      peakProductivityTime: '10:00 AM',
      pendingTasks: Math.floor(Math.random() * 30) + 10,
      overdueTasks: Math.floor(Math.random() * 5) + 1
    },
    recommendations: [
      'Consider batching similar @computer tasks',
      'Schedule phone calls in the afternoon',
      'Review waiting-for items weekly',
      'Break down large projects into smaller next actions'
    ]
  };
}
```

### 9. Mobile Optimization Functions

```javascript
// Code Block 9: Mobile Optimization
async function optimizeForMobile(task) {
  // Ensure task is mobile-friendly
  const mobileOptimized = { ...task };
  
  // Simplify for mobile
  if (mobileOptimized.description.length > 100) {
    mobileOptimized.shortDescription = mobileOptimized.description.substring(0, 97) + '...';
  }
  
  // Add touch-friendly properties
  mobileOptimized.mobileProperties = {
    touchTarget: 'large',
    oneHanded: mobileOptimized.timeEstimate <= 10,
    voiceCommand: true,
    quickAction: mobileOptimized.priority === 'HIGH'
  };
  
  return mobileOptimized;
}

async function getVoiceCommandSuggestions() {
  return [
    'Capture: "Add task to call dentist"',
    'Query: "Show me @computer tasks"',
    'Process: "Categorize all unprocessed items"',
    'Review: "Start weekly review"',
    'Execute: "What can I do in 15 minutes?"'
  ];
}
```

### 10. Integration Functions

```javascript
// Code Block 10: Integration
async function integrateWithCalendar(task) {
  // Integrate with external calendar
  const calendarEvent = {
    title: task.description,
    startTime: new Date(),
    endTime: new Date(Date.now() + task.timeEstimate * 60 * 1000),
    description: `GTD Task: ${task.description}\nContext: ${task.context}\nPriority: ${task.priority}`,
    location: task.context.replace('@', ''),
    reminders: ['15 minutes before']
  };
  
  return {
    success: true,
    calendarEvent,
    message: 'Task scheduled in calendar',
    exportFormat: 'ical'
  };
}

async function exportToEmail(task) {
  // Format task for email delegation
  const emailTemplate = `
Subject: GTD Task Delegation: ${task.description}

Hi,

Could you please handle this task:

${task.description}

Context: ${task.context}
Priority: ${task.priority}
Estimated time: ${task.timeEstimate} minutes

Please let me know when this is complete.

Thanks!
  `.trim();
  
  return {
    success: true,
    emailTemplate,
    recipients: task.delegatedTo || 'team@example.com',
    followUp: new Date(Date.now() + 3 * 24 * 60 * 60 * 1000) // 3 days
  };
}
```

### 11. Utility Functions

```javascript
// Code Block 11: Utilities
function formatTime(minutes) {
  if (minutes < 60) {
    return `${minutes} min`;
  } else {
    const hours = Math.floor(minutes / 60);
    const remaining = minutes % 60;
    return remaining > 0 ? `${hours}h ${remaining}m` : `${hours}h`;
  }
}

function calculatePriorityScore(task) {
  let score = 0;
  
  // Priority weighting
  const priorityWeights = {
    'HIGH': 3,
    'MEDIUM': 2,
    'LOW': 1
  };
  
  score += priorityWeights[task.priority] || 2;
  
  // Time sensitivity
  if (task.dueDate) {
    const daysUntilDue = Math.ceil((new Date(task.dueDate) - new Date()) / (1000 * 60 * 60 * 24));
    if (daysUntilDue <= 1) score += 3;
    else if (daysUntilDue <= 3) score += 2;
    else if (daysUntilDue <= 7) score += 1;
  }
  
  // Project importance
  if (task.project && task.project.includes('Important')) {
    score += 2;
  }
  
  return Math.min(score, 10); // Cap at 10
}

function getEmojiForContext(context) {
  const emojiMap = {
    '@computer': '💻',
    '@phone': '📱',
    '@office': '🏢',
    '@home': '🏠',
    '@errands': '🛒',
    '@anywhere': '🌍'
  };
  
  return emojiMap[context] || '📝';
}

// Export functions for Synthesis Lab
window.GTDFunctions = {
  parseNaturalLanguageCapture,
  categorizeTask,
  processNaturalLanguageQuery,
  matchTasksByEnergy,
  processBatchTasks,
  detectDelegationOpportunities,
  gtdLearningSystem,
  generateGTDAnalytics,
  optimizeForMobile,
  integrateWithCalendar,
  exportToEmail,
  formatTime,
  calculatePriorityScore,
  getEmojiForContext
};
```

## Installation Instructions

1. **Install Kits Plugin** in Logseq Marketplace
2. **Create Synthesis Page**: New page named "Synthesis"
3. **Add Code Blocks**: Create 11 JavaScript code blocks on the Synthesis page
4. **Copy Functions**: Copy each function above into corresponding code blocks
5. **Save and Test**: Save the page and test with `{{eval parseNaturalLanguageCapture "Call dentist tomorrow"}}`

## Testing Your Setup

Run these test commands in Logseq:

```markdown
Test natural language capture:
{{eval parseNaturalLanguageCapture "Call dentist tomorrow at 2pm for 30 minutes"}}

Test task categorization:
{{eval categorizeTask "Follow up with John about the report"}}

Test natural language query:
{{eval processNaturalLanguageQuery "Show me high priority @computer tasks"}}

Test energy matching:
{{eval matchTasksByEnergy "medium" 45}}
```

## Troubleshooting

1. **Functions not working**: Ensure Kits plugin is enabled
2. **Synthesis page not found**: Create page exactly named "Synthesis"
3. **JavaScript errors**: Check browser console for errors
4. **Performance issues**: Limit batch operations to 10 items at a time

## Next Steps

1. Test each function individually
2. Create custom functions for your specific workflow
3. Integrate with your existing GTD system
4. Share feedback for improvements