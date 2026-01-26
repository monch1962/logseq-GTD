# Installation Guide

## 📋 Prerequisites

### Required Software
- **Logseq Desktop** version 0.9.x or higher
- **Logseq Mobile App** (optional, for mobile use)
- **Modern web browser** (for mobile web access)

### System Requirements
- **Desktop:** Windows 10+, macOS 10.15+, or Linux
- **Mobile:** iOS 14+ or Android 10+
- **Storage:** Minimum 100MB free space
- **Memory:** 2GB RAM minimum, 4GB recommended

## 🚀 Quick Installation (5 Minutes)

### Step 1: Download Templates
1. **Clone or download** this repository:
   ```bash
   git clone https://github.com/yourusername/logseq-GTD.git
   ```
   Or download ZIP from GitHub and extract.

2. **Navigate to** the templates directory:
   ```bash
   cd logseq-GTD/GTD_Templates
   ```

### Step 2: Copy Templates to Logseq
#### Option A: Manual Copy (Recommended)
1. Open your Logseq graph directory:
   - **Windows:** `%USERPROFILE%/logseq`
   - **macOS:** `~/logseq`
   - **Linux:** `~/.logseq`

2. Create or navigate to the `templates` directory:
   ```bash
   # Create if it doesn't exist
   mkdir -p ~/logseq/templates
   ```

3. Copy all template files:
   ```bash
   # Copy Phase 1 templates
   cp Phase1/*.md ~/logseq/templates/
   
   # Copy Phase 2 templates (optional, start with Phase 1)
   cp Phase2/*.md ~/logseq/templates/
   ```

#### Option B: Logseq Template Folder
1. In Logseq, go to **Settings** → **General**
2. Find **"Preferred templates folder"**
3. Set it to: `~/logseq-GTD/GTD_Templates`
4. Restart Logseq

### Step 3: Verify Installation
1. Open Logseq
2. Create a new page or open daily journal
3. Type `/` and search for "GTD"
4. You should see GTD templates in the list

## 🔧 Advanced Installation

### Multiple Graph Setup
If you use multiple Logseq graphs:

1. **For each graph:**
   ```bash
   # Navigate to graph directory
   cd ~/logseq/graphs/your-graph-name
   
   # Create templates directory
   mkdir -p templates
   
   # Copy templates
   cp -r ~/logseq-GTD/GTD_Templates/* ./templates/
   ```

2. **Or use symbolic links** (saves space, updates all graphs):
   ```bash
   # Remove existing templates directory
   rm -rf ~/logseq/graphs/your-graph-name/templates
  
   # Create symbolic link
   ln -s ~/logseq-GTD/GTD_Templates ~/logseq/graphs/your-graph-name/templates
   ```

### Mobile Installation

#### iOS Installation
1. **Using Files app:**
   - Download templates to Files app
   - Open Logseq app
   - Go to Settings → Advanced → "Open Logseq folder in Files"
   - Copy templates to `templates` directory

2. **Using iCloud:**
   - Store templates in iCloud Drive
   - Set Logseq's template folder to iCloud location

#### Android Installation
1. **Using file manager:**
   - Download templates to device
   - Use file manager to copy to Logseq directory
   - Path: `Android/data/com.logseq.app/files/templates`

2. **Using cloud sync:**
   - Sync template folder via Google Drive, Dropbox, etc.
   - Use app like FolderSync for automatic sync

### Git Integration (Advanced)

#### Track Templates with Git
```bash
# Initialize git in your Logseq graph
cd ~/logseq
git init

# Add templates directory
git add templates/

# Commit templates
git commit -m "Add GTD templates"

# Set up remote repository (optional)
git remote add origin https://github.com/yourusername/logseq-gtd-graph.git
git push -u origin main
```

#### Auto-sync Script
Create a sync script (`sync-templates.sh`):
```bash
#!/bin/bash
# Sync templates from repository to Logseq
cd ~/logseq-GTD
git pull origin main
cp -r GTD_Templates/* ~/logseq/templates/
echo "Templates updated: $(date)"
```

Make executable and schedule with cron:
```bash
chmod +x sync-templates.sh
# Add to crontab for daily updates
0 9 * * * ~/logseq-GTD/sync-templates.sh
```

## ⚙️ Configuration

### Initial Setup

#### 1. Template Settings
Edit template variables in your preferred templates:

```markdown
## GTD Settings (add to your journal or settings page)
default-action-count:: 5
default-context:: @computer
weekly-review-day:: Friday
mobile-optimized:: true
notifications-enabled:: true
```

#### 2. Logseq Configuration
**Recommended Logseq settings:**
- **Preferred workflow:** Left sidebar closed
- **Default template:** `GTD Daily Journal`
- **Journal format:** `MMM do, yyyy`
- **Preferred todo:** `TODO`
- **Enable query:** Yes

**Settings path:** Settings → General & Editor

#### 3. Keyboard Shortcuts
Add custom shortcuts in `keybindings.json`:
```json
{
  "shortcuts": {
    "gtd-capture": ["mod+shift+c", "Capture to inbox"],
    "gtd-journal": ["mod+shift+j", "Open GTD journal"],
    "gtd-review": ["mod+shift+r", "Weekly review"]
  }
}
```

### Platform-Specific Configuration

#### Desktop Optimization
```markdown
## Desktop Settings
enable-keyboard-shortcuts:: true
advanced-queries:: true
multi-column-view:: true
export-capabilities:: true
```

#### Mobile Optimization
```markdown
## Mobile Settings
touch-optimized:: true
voice-input:: true
offline-mode:: true
battery-optimized:: true
simplified-views:: true
```

## 🔄 Sync Setup

### Cross-Device Sync

#### Option 1: Logseq Built-in Sync
1. Enable Logseq Sync in Settings
2. Choose sync provider (recommended: iCloud or Google Drive)
3. Ensure templates are in synced graph

#### Option 2: Git-based Sync
```bash
# Setup git in your graph
cd ~/logseq
git init
git add .
git commit -m "Initial commit"

# Create .gitignore
echo ".recycle" >> .gitignore
echo "bak" >> .gitignore
echo "logseq/bak" >> .gitignore

# Add remote and push
git remote add origin your-repo-url
git push -u origin main
```

#### Option 3: Cloud Folder Sync
- **Dropbox/Google Drive:** Sync entire graph folder
- **Syncthing:** Peer-to-peer sync
- **Resilio Sync:** BitTorrent-based sync

### Backup Strategy

#### Automated Backups
Create backup script (`backup-gtd.sh`):
```bash
#!/bin/bash
BACKUP_DIR="$HOME/gtd-backups"
DATE=$(date +%Y%m%d_%H%M%S)

# Backup templates
tar -czf "$BACKUP_DIR/templates_$DATE.tar.gz" ~/logseq/templates/

# Backup graph (optional)
tar -czf "$BACKUP_DIR/graph_$DATE.tar.gz" ~/logseq/ --exclude=".recycle" --exclude="bak"

# Keep last 30 backups
find "$BACKUP_DIR" -name "*.tar.gz" -mtime +30 -delete

echo "Backup completed: $DATE"
```

#### Cloud Backup
- **Backblaze:** Unlimited backup
- **AWS S3:** Versioned backups
- **Google Cloud Storage:** Affordable storage

## 🐛 Troubleshooting

### Common Installation Issues

#### Templates Not Appearing
**Symptoms:** Templates don't show in `/` menu
**Solutions:**
1. Check template folder location in Settings
2. Ensure files have `.md` extension
3. Restart Logseq
4. Check file permissions

#### Query Errors
**Symptoms:** Queries show errors or no results
**Solutions:**
1. Update Logseq to latest version
2. Check query syntax in templates
3. Ensure you have tasks with required properties
4. Test with sample data first

#### Mobile Sync Issues
**Symptoms:** Changes not syncing across devices
**Solutions:**
1. Check sync provider connectivity
2. Ensure all devices use same sync method
3. Check storage space on mobile
4. Restart mobile app

### Performance Issues

#### Slow Queries
**Solutions:**
1. Reduce query complexity in templates
2. Add limits to query results
3. Use cached queries where possible
4. Upgrade device if consistently slow

#### High Memory Usage
**Solutions:**
1. Close unused graphs
2. Reduce number of open pages
3. Clear cache periodically
4. Use simpler templates on mobile

### Recovery Procedures

#### Corrupted Templates
1. **Restore from backup:**
   ```bash
   cp ~/gtd-backups/templates_latest.tar.gz ~/
   tar -xzf templates_latest.tar.gz -C ~/logseq/
   ```

2. **Reinstall fresh:**
   ```bash
   rm -rf ~/logseq/templates/
   cp -r ~/logseq-GTD/GTD_Templates/* ~/logseq/templates/
   ```

#### Data Loss
1. **Check recycle bin:** `~/.logseq/.recycle/`
2. **Restore from git:** `git checkout -- .`
3. **Use backup:** Restore from latest backup

## ✅ Verification Checklist

### Installation Verification
- [ ] Templates appear in `/` menu
- [ ] GTD Daily Journal template loads
- [ ] Queries execute without errors
- [ ] Mobile templates work (if applicable)
- [ ] Sync working across devices (if configured)

### Configuration Verification
- [ ] Default settings configured
- [ ] Keyboard shortcuts working
- [ ] Backup system tested
- [ ] Performance acceptable

### Readiness Verification
- [ ] Sample task captured and processed
- [ ] Next actions dashboard shows tasks
- [ ] Weekly review template accessible
- [ ] Learning resources available

## 🔗 Next Steps

After successful installation:

1. **Start with:** [[USAGE.md#quick-start]]
2. **Learn basics:** Read [[USAGE.md#basic-usage]]
3. **Customize:** Follow [[USAGE.md#customization]]
4. **Get help:** Visit [[USAGE.md#troubleshooting]]

## 📞 Support

### Getting Help
- **Documentation:** Read [[USAGE.md]] and [[README.md]]
- **Community:** Join Logseq Discord or Forum
- **Issues:** Report at GitHub repository
- **Email:** your-email@example.com

### Contributing
Found a bug or have improvement ideas?
1. Fork the repository
2. Create feature branch
3. Submit pull request
4. Join community discussions

### Updates
- **Check for updates:** `git pull` in repository
- **Subscribe:** GitHub notifications
- **Follow:** @logseq on Twitter for updates

---

**Installation complete!** Proceed to [[USAGE.md]] to learn how to use the GTD templates effectively.