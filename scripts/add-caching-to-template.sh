#!/bin/bash

# Script to add caching to queries in a template file

TEMPLATE_FILE="$1"

if [ -z "$TEMPLATE_FILE" ]; then
  echo "Usage: $0 <template-file.md>"
  exit 1
fi

if [ ! -f "$TEMPLATE_FILE" ]; then
  echo "Error: File $TEMPLATE_FILE not found"
  exit 1
fi

echo "🔧 Adding caching to queries in $TEMPLATE_FILE"
echo "=============================================="

# Create backup
BACKUP_FILE="${TEMPLATE_FILE}.backup.$(date +%Y%m%d%H%M%S)"
cp "$TEMPLATE_FILE" "$BACKUP_FILE"
echo "Backup created: $BACKUP_FILE"

# Count queries before
QUERIES_BEFORE=$(grep -c "{{query" "$TEMPLATE_FILE")
echo "Queries before: $QUERIES_BEFORE"

# Add caching to simple count queries
echo "Adding caching to count queries..."
sed -i '' 's/{{query {:query \[:find (count ?b)/{{query {:query \[:find (count ?b)/g' "$TEMPLATE_FILE"
sed -i '' 's/:view :text}}}/:view :text :cache-enabled true :cache-ttl 300}}}/g' "$TEMPLATE_FILE"

# Add caching to pull queries
echo "Adding caching to pull queries..."
sed -i '' 's/{{query {:query \[:find (pull ?b/{{query {:query \[:find (pull ?b/g' "$TEMPLATE_FILE"
sed -i '' 's/:limit [0-9]*}}}/& :cache-enabled true :cache-ttl 600}/g' "$TEMPLATE_FILE"

# Add caching to complex queries with titles
echo "Adding caching to titled queries..."
sed -i '' 's/{{query {:title "\([^"]*\)"/{{query {:title "\1" :cache-enabled true :cache-ttl 600/g' "$TEMPLATE_FILE"

# Count queries after
QUERIES_AFTER=$(grep -c "{{query" "$TEMPLATE_FILE")
CACHED_QUERIES=$(grep -c ":cache-enabled true" "$TEMPLATE_FILE")

echo ""
echo "✅ Caching added successfully!"
echo "============================="
echo "Queries before: $QUERIES_BEFORE"
echo "Queries after: $QUERIES_AFTER"
echo "Cached queries: $CACHED_QUERIES"
echo ""
echo "Changes made:"
echo "1. Added :cache-enabled true to all queries"
echo "2. Added :cache-ttl 300 to count queries"
echo "3. Added :cache-ttl 600 to pull queries"
echo "4. Added caching to titled queries"
echo ""
echo "Backup saved to: $BACKUP_FILE"
echo "Original file updated: $TEMPLATE_FILE"