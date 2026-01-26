#!/bin/bash

# Logseq GTD Template System - Basic Validation Script
# Tests template structure and query library integration

echo "=== Logseq GTD Template System Validation ==="
echo "Date: $(date)"
echo ""

# Check template structure
echo "1. Checking template structure..."
TEMPLATE_COUNT=$(find GTD_Templates -name "*.md" -type f | grep -v "Starter_Kit" | wc -l)
echo "   Found $TEMPLATE_COUNT templates in GTD_Templates/"

# Check for template:: headers
echo "2. Checking template headers..."
MISSING_HEADERS=0
for template in GTD_Templates/*/*.md; do
    if ! grep -q "template::" "$template"; then
        echo "   ❌ Missing template:: header: $template"
        MISSING_HEADERS=$((MISSING_HEADERS + 1))
    fi
done
echo "   Templates with headers: $((TEMPLATE_COUNT - MISSING_HEADERS))/$TEMPLATE_COUNT"

# Check query library components
echo "3. Checking query library..."
QUERY_COUNT=$(find queries/library -name "*.clj" -type f | wc -l)
echo "   Found $QUERY_COUNT query library components"

# Check templates using library queries
echo "4. Checking template query usage..."
LIBRARY_USAGE=0
INLINE_QUERIES=0
for template in GTD_Templates/*/*.md; do
    if grep -q "read-file.*queries/library" "$template"; then
        LIBRARY_USAGE=$((LIBRARY_USAGE + 1))
    fi
    if grep -q "query {" "$template"; then
        INLINE_QUERIES=$((INLINE_QUERIES + 1))
    fi
done
echo "   Templates using library queries: $LIBRARY_USAGE/$TEMPLATE_COUNT"
echo "   Templates with inline queries: $INLINE_QUERIES/$TEMPLATE_COUNT"

# Check Starter Kit
echo "5. Checking Starter Kit..."
STARTER_COUNT=$(find GTD_Templates/Starter_Kit -name "*.md" -type f | wc -l)
echo "   Found $STARTER_COUNT Starter Kit templates"

# Summary
echo ""
echo "=== Summary ==="
echo "Total templates: $TEMPLATE_COUNT"
echo "Query library components: $QUERY_COUNT"
echo "Migration progress: $LIBRARY_USAGE/$TEMPLATE_COUNT templates updated"
echo "Remaining work: $INLINE_QUERIES templates need updating"

if [ $MISSING_HEADERS -gt 0 ]; then
    echo "⚠️  Warning: $MISSING_HEADERS templates missing headers"
fi

if [ $INLINE_QUERIES -gt 0 ]; then
    echo "📋 Next steps: Update $INLINE_QUERIES templates to use library queries"
fi

echo ""
echo "Validation complete!"