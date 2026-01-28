#!/bin/bash

# Extract Individual Templates from Consolidated File
# This script extracts the 5 enhanced GTD templates from the consolidated file
# into individual files for better mobile performance.

CONSOLIDATED_FILE="enhanced_gtd_templates.md"
OUTPUT_DIR="individual_templates"

# Create output directory
mkdir -p "$OUTPUT_DIR"

echo "Extracting individual templates from $CONSOLIDATED_FILE..."
echo "Output directory: $OUTPUT_DIR/"
echo ""

# Function to extract a template section
extract_template() {
    local template_name="$1"
    local start_pattern="$2"
    local end_pattern="$3"
    local output_file="$4"
    
    echo "Extracting $template_name..."
    
    # Find start line
    local start_line=$(grep -n "$start_pattern" "$CONSOLIDATED_FILE" | head -1 | cut -d: -f1)
    
    if [ -z "$start_line" ]; then
        echo "  ERROR: Start pattern '$start_pattern' not found"
        return 1
    fi
    
    # Find end line (next template start or end of file)
    local end_line=$(tail -n +$((start_line + 1)) "$CONSOLIDATED_FILE" | grep -n "^# GTD Enhanced\|^---$" | head -1 | cut -d: -f1)
    
    if [ -z "$end_line" ]; then
        # If no next template found, use end of file
        end_line=$(wc -l < "$CONSOLIDATED_FILE")
    else
        end_line=$((start_line + end_line - 1))
    fi
    
    # Extract the section
    sed -n "${start_line},${end_line}p" "$CONSOLIDATED_FILE" > "$OUTPUT_DIR/$output_file"
    
    echo "  ✓ Extracted lines $start_line-$end_line to $output_file"
    echo "  ✓ File size: $(wc -l < "$OUTPUT_DIR/$output_file") lines"
    echo ""
}

# Extract each template
extract_template "Enhanced Quick Capture" \
    "^# GTD Enhanced Quick Capture 🚀$" \
    "^# GTD Enhanced Task Processing" \
    "01-enhanced-quick-capture.md"

extract_template "Enhanced Task Processing" \
    "^# GTD Enhanced Task Processing 🧠$" \
    "^# GTD Enhanced Management Dashboard" \
    "02-enhanced-task-processing.md"

extract_template "Enhanced Management Dashboard" \
    "^# GTD Enhanced Management Dashboard 🎯$" \
    "^# GTD Enhanced Weekly Review" \
    "11-enhanced-management-dashboard.md"

extract_template "Enhanced Weekly Review" \
    "^# GTD Enhanced Weekly Review 📅$" \
    "^# GTD Enhanced Next Actions Dashboard" \
    "08-enhanced-weekly-review.md"

extract_template "Enhanced Next Actions Dashboard" \
    "^# GTD Enhanced Next Actions Dashboard ⚡$" \
    "^---$" \
    "09-enhanced-next-actions-dashboard.md"

echo "=== Extraction Complete ==="
echo ""
echo "Individual templates extracted to $OUTPUT_DIR/:"
ls -la "$OUTPUT_DIR/" | grep "\.md$"
echo ""
echo "Total files created: $(ls -1 "$OUTPUT_DIR/" | wc -l)"
echo ""
echo "Usage options:"
echo "1. Use consolidated file (enhanced_gtd_templates.md) for desktop"
echo "2. Use individual templates for better mobile performance"
echo ""
echo "To use individual templates in Logseq:"
echo "1. Copy the .md files to your Logseq templates directory"
echo "2. Or insert them directly into your Logseq pages"
echo ""
echo "Note: The consolidated file remains unchanged."