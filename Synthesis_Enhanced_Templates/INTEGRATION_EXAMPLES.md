# Integration Examples: Enhanced + Original GTD Templates

This document provides practical examples of how to integrate the enhanced Synthesis Lab templates with your existing GTD template system.

## Integration Philosophy

**Coexistence, Not Replacement**: The enhanced templates are designed to work alongside your existing GTD system. You can:
- Use enhanced templates for new workflows
- Keep original templates for established processes
- Gradually migrate specific projects
- Mix and match based on context

## Example 1: Hybrid Capture Workflow

### Scenario
You want to use natural language capture for quick inputs but keep structured capture for complex items.

### Implementation

**Enhanced Quick Capture** (for speed):
```markdown
{{eval capture "Call dentist tomorrow at 2pm for cleaning"}}
```

**Original Capture Template** (for complexity):
```markdown
template:: Detailed Capture
description:: Use for complex items requiring multiple properties

# {{item-description}}

## Details
- Context:: {{context}}
- Priority:: {{priority}}
- Time estimate:: {{time-estimate}}
- Project:: [[{{project}}]]
- Tags:: {{tags}}
```

**Integration Script**:
```javascript
// In Synthesis page
async function smartCaptureRouter(text) {
  const simplePatterns = ['call', 'email', 'text', 'remind'];
  const isSimple = simplePatterns.some(pattern => text.toLowerCase().includes(pattern));
  
  if (isSimple) {
    // Use enhanced capture
    return await parseNaturalLanguageCapture(text);
  } else {
    // Use original template
    return {
      useTemplate: 'Detailed Capture',
      variables: {
        'item-description': text,
        'context': '@anywhere',
        'priority': 'MEDIUM'
      }
    };
  }
}
```

## Example 2: Enhanced Processing of Legacy Tasks

### Scenario
You have existing tasks captured with original templates that need smart processing.

### Implementation

**Batch Processing Command**:
```markdown
{{eval processBatchTasks getUnprocessedTasks() "categorize"}}
```

**Integration Function**:
```javascript
async function getUnprocessedTasks() {
  // Query Logseq for tasks with original template properties
  const query = `
  [
    :find (pull ?b [*])
    :where
    [?b :block/properties ?p]
    [(get ?p :template) ?t]
    [(contains? #{"Quick Capture" "Detailed Capture"} ?t)]
    [?b :block/properties ?p2]
    [(get ?p2 :status) "unprocessed"]
  ]
  `;
  
  // This would execute the query and return tasks
  return window.logseq.api.q(query);
}

async function migrateLegacyTask(legacyTask) {
  // Convert original template task to enhanced format
  const enhancedTask = {
    description: legacyTask.content,
    context: legacyTask.properties?.context || '@anywhere',
    priority: legacyTask.properties?.priority || 'MEDIUM',
    // Add enhanced properties
    'smart-category': await categorizeTask(legacyTask.content),
    'processing-date': new Date().toISOString(),
    'migrated-from': 'legacy-template'
  };
  
  return enhancedTask;
}
```

## Example 3: Unified Dashboard View

### Scenario
You want a single dashboard that shows tasks from both original and enhanced systems.

### Implementation

**Enhanced Dashboard Query**:
```javascript
async function getUnifiedTasks() {
  // Get tasks from enhanced system
  const enhancedTasks = await window.logseq.api.q(`
  [
    :find (pull ?b [*])
    :where
    [?b :block/properties ?p]
    [(get ?p :template) ?t]
    [(clojure.string/includes? ?t "enhanced")]
    [?b :block/properties ?p2]
    [(get ?p2 :status) "next-action"]
  ]
  `);
  
  // Get tasks from original system
  const originalTasks = await window.logseq.api.q(`
  [
    :find (pull ?b [*])
    :where
    [?b :block/properties ?p]
    [(get ?p :template) ?t]
    [(clojure.string/includes? ?t "Capture")]
    [(not (clojure.string/includes? ?t "enhanced"))]
    [?b :block/properties ?p2]
    [(get ?p2 :status) "next-action"]
  ]
  `);
  
  // Normalize and combine
  return [...enhancedTasks, ...originalTasks].map(task => ({
    ...task,
    // Add unified properties
    system: task.properties?.template?.includes('enhanced') ? 'enhanced' : 'original',
    displayPriority: calculateUnifiedPriority(task)
  }));
}
```

**Unified Dashboard Template**:
```markdown
template:: Unified GTD Dashboard
description:: Shows tasks from both original and enhanced systems

# Unified GTD Dashboard {{today}}

## Next Actions

{{eval (async () => {
  const tasks = await getUnifiedTasks();
  return tasks.map(t => `- ${t.content} (${t.system})`).join('\\n');
})()}}

## Statistics
- Enhanced tasks: {{eval countEnhancedTasks()}}
- Original tasks: {{eval countOriginalTasks()}}
- Total: {{eval totalTaskCount()}}
```

## Example 4: Smart Review Integration

### Scenario
You want your weekly review to consider tasks from both systems.

### Implementation

**Enhanced Review with Legacy Support**:
```javascript
async function prepareWeeklyReview() {
  const reviewData = {
    enhanced: {
      nextActions: await getEnhancedTasksByStatus('next-action'),
      waitingFor: await getEnhancedTasksByStatus('waiting'),
      projects: await getEnhancedProjects()
    },
    original: {
      nextActions: await getOriginalTasksByStatus('next-action'),
      waitingFor: await getOriginalTasksByStatus('waiting'),
      projects: await getOriginalProjects()
    },
    recommendations: await generateCrossSystemRecommendations()
  };
  
  return reviewData;
}

async function generateCrossSystemRecommendations() {
  const recommendations = [];
  
  // Find duplicates across systems
  const enhancedTasks = await getEnhancedTasks();
  const originalTasks = await getOriginalTasks();
  
  // Simple duplicate detection by description
  const enhancedDescriptions = new Set(enhancedTasks.map(t => t.content.toLowerCase()));
  const duplicates = originalTasks.filter(t => 
    enhancedDescriptions.has(t.content.toLowerCase())
  );
  
  if (duplicates.length > 0) {
    recommendations.push({
      type: 'cleanup',
      message: `Found ${duplicates.length} duplicate tasks across systems`,
      action: 'Review and merge duplicates'
    });
  }
  
  // Migration opportunities
  const highValueOriginal = originalTasks.filter(t => 
    t.properties?.priority === 'HIGH' && 
    !t.properties?.template?.includes('enhanced')
  );
  
  if (highValueOriginal.length > 0) {
    recommendations.push({
      type: 'migration',
      message: `${highValueOriginal.length} high-priority tasks in original system`,
      action: 'Consider migrating to enhanced system for better tracking'
    });
  }
  
  return recommendations;
}
```

## Example 5: Context-Aware Template Selection

### Scenario
Automatically choose between original and enhanced templates based on context.

### Implementation

**Context Router**:
```javascript
async function selectTemplateByContext(taskDescription, context) {
  const templateMap = {
    '@computer': {
      simple: 'Enhanced Quick Capture',
      complex: 'Enhanced Computer Task'
    },
    '@phone': {
      simple: 'Enhanced Quick Capture',
      complex: 'Original Phone Call'
    },
    '@home': {
      simple: 'Original Quick Capture',
      complex: 'Original Home Task'
    },
    '@errands': {
      simple: 'Enhanced Quick Capture',
      complex: 'Enhanced Errand Planning'
    }
  };
  
  const isComplex = taskDescription.length > 50 || 
                   taskDescription.includes('project') ||
                   taskDescription.includes('multiple');
  
  const templates = templateMap[context] || templateMap['@anywhere'];
  return isComplex ? templates.complex : templates.simple;
}

// Usage in capture
async function smartCaptureWithContext(text, detectedContext) {
  const template = await selectTemplateByContext(text, detectedContext);
  const parsed = await parseNaturalLanguageCapture(text);
  
  return {
    template,
    properties: parsed,
    suggestedAction: `Use ${template} template`
  };
}
```

## Example 6: Data Synchronization Bridge

### Scenario
Keep data synchronized between original and enhanced systems.

### Implementation

**Bidirectional Sync**:
```javascript
class GTDSynchronizer {
  constructor() {
    this.syncQueue = [];
    this.syncInterval = null;
  }
  
  startAutoSync(intervalMinutes = 5) {
    this.syncInterval = setInterval(() => {
      this.syncChanges();
    }, intervalMinutes * 60 * 1000);
  }
  
  async syncChanges() {
    // Find tasks modified since last sync
    const recentChanges = await this.getRecentChanges();
    
    for (const change of recentChanges) {
      if (change.system === 'original' && change.type === 'update') {
        await this.mirrorToEnhanced(change.task);
      } else if (change.system === 'enhanced' && change.type === 'update') {
        await this.mirrorToOriginal(change.task);
      }
    }
    
    console.log(`Synced ${recentChanges.length} changes`);
  }
  
  async mirrorToEnhanced(originalTask) {
    // Create enhanced version of original task
    const enhancedTask = {
      ...originalTask,
      properties: {
        ...originalTask.properties,
        'mirrored-from': 'original',
        'mirror-date': new Date().toISOString(),
        'original-id': originalTask.id
      }
    };
    
    // Save to enhanced system
    await window.logseq.api.create_block(enhancedTask);
  }
  
  async mirrorToOriginal(enhancedTask) {
    // Create original version of enhanced task
    const originalTask = {
      ...enhancedTask,
      properties: {
        description: enhancedTask.content,
        context: enhancedTask.properties?.context || '@anywhere',
        priority: enhancedTask.properties?.priority || 'MEDIUM',
        'mirrored-from': 'enhanced',
        'mirror-date': new Date().toISOString(),
        'enhanced-id': enhancedTask.id
      }
    };
    
    // Save to original system
    await window.logseq.api.create_block(originalTask);
  }
}

// Initialize synchronizer
const gtdSync = new GTDSynchronizer();
```

## Example 7: Gradual Migration Workflow

### Scenario
Systematically migrate from original to enhanced templates.

### Implementation

**Migration Assistant**:
```javascript
async function createMigrationPlan() {
  const analysis = await analyzeCurrentSystem();
  
  return {
    phase1: {
      name: 'Capture Enhancement',
      tasks: analysis.captureTasks.map(task => ({
        task: `Migrate "${task.content.substring(0, 30)}..."`,
        template: 'Enhanced Quick Capture',
        estimatedTime: 2 // minutes
      })),
      estimatedTotal: analysis.captureTasks.length * 2
    },
    phase2: {
      name: 'Processing Enhancement',
      tasks: analysis.unprocessedTasks.map(task => ({
        task: `Process "${task.content.substring(0, 30)}..."`,
        template: 'Enhanced Task Processing',
        estimatedTime: 3
      })),
      estimatedTotal: analysis.unprocessedTasks.length * 3
    },
    // ... more phases
  };
}

async function executeMigrationStep(step) {
  console.log(`Executing migration step: ${step.name}`);
  
  for (const task of step.tasks) {
    try {
      await migrateTask(task);
      console.log(`Migrated: ${task.task}`);
      
      // Optional: Add delay for large migrations
      if (step.tasks.length > 10) {
        await new Promise(resolve => setTimeout(resolve, 100));
      }
    } catch (error) {
      console.error(`Failed to migrate: ${task.task}`, error);
    }
  }
  
  return {
    success: true,
    migrated: step.tasks.length,
    errors: 0 // Would track actual errors
  };
}
```

## Example 8: Reporting Across Systems

### Scenario
Generate reports that include data from both template systems.

### Implementation

**Cross-System Report Generator**:
```javascript
async function generateMonthlyReport() {
  const month = new Date().getMonth();
  const year = new Date().getFullYear();
  
  const report = {
    period: `${month + 1}/${year}`,
    summary: {
      totalTasks: await getTotalTasks(),
      completed: await getCompletedTasks(),
      created: await getCreatedTasks(),
      migrated: await getMigratedTasks()
    },
    bySystem: {
      enhanced: await getEnhancedMetrics(),
      original: await getOriginalMetrics()
    },
    trends: await calculateTrends(),
    recommendations: await generateReportRecommendations()
  };
  
  // Format for display
  return `
# GTD Monthly Report - ${report.period}

## Summary
- Total Tasks: ${report.summary.totalTasks}
- Completed: ${report.summary.completed} (${Math.round(report.summary.completed / report.summary.totalTasks * 100)}%)
- Created: ${report.summary.created}
- Migrated to Enhanced: ${report.summary.migrated}

## By System
### Enhanced System
${Object.entries(report.bySystem.enhanced).map(([k, v]) => `- ${k}: ${v}`).join('\\n')}

### Original System  
${Object.entries(report.bySystem.original).map(([k, v]) => `- ${k}: ${v}`).join('\\n')}

## Recommendations
${report.recommendations.map(r => `- ${r}`).join('\\n')}
  `.trim();
}
```

## Best Practices for Integration

### 1. Start Small
- Begin with one enhanced template
- Integrate with one existing workflow
- Expand gradually

### 2. Maintain Data Integrity
- Regular backups before integration
- Validation checks after migration
- Rollback plans for each integration

### 3. User Training
- Document integration points
- Provide transition guides
- Offer support during migration

### 4. Performance Monitoring
- Track system performance
- Monitor sync operations
- Optimize based on usage

### 5. Feedback Loops
- Collect user feedback
- Measure adoption rates
- Iterate based on real usage

## Common Integration Patterns

| Pattern | Use Case | Implementation |
|---------|----------|----------------|
| **Gateway** | Single entry point to both systems | Context router that chooses template |
| **Bridge** | Data synchronization between systems | Bidirectional sync with conflict resolution |
| **Adapter** | Using enhanced features with original data | Migration functions that convert formats |
| **Facade** | Unified interface hiding complexity | Dashboard that aggregates both systems |
| **Proxy** | Enhanced features as optional overlay | Functions that enhance original templates |

## Troubleshooting Integration Issues

### Issue: Data Inconsistency
**Symptoms**: Tasks appear in one system but not the other
**Solution**: Implement validation checks and repair scripts

### Issue: Performance Degradation
**Symptoms**: System slows down after integration
**Solution**: Optimize queries, add caching, batch operations

### Issue: User Confusion
**Symptoms**: Users don't know which system to use
**Solution**: Clear guidelines, visual indicators, training

### Issue: Migration Failures
**Symptoms**: Tasks fail to migrate properly
**Solution**: Incremental migration with validation at each step

## Next Steps

1. **Choose an integration pattern** that matches your workflow
2. **Implement one integration point** and test thoroughly
3. **Gather feedback** and refine the approach
4. **Expand integration** to other parts of your system
5. **Document successful patterns** for future reference

Remember: The goal is enhanced productivity, not perfect integration. Focus on what delivers the most value for your specific GTD practice.