#!/bin/bash

# Fix cache formatting in query files

echo "Fixing cache formatting in query files..."

for file in queries/library/dashboard/*.clj; do
  echo "Processing $file"
  
  # Remove the incorrectly added cache lines
  sed -i '' '/:cache-enabled true/d' "$file"
  sed -i '' '/:cache-key "/d' "$file"
  sed -i '' '/:cache-ttl 300/d' "$file"
  sed -i '' '/:mobile-ttl 600/d' "$file"
  
  # Read the file and add cache configuration properly
  content=$(cat "$file")
  
  # Remove trailing whitespace and closing }
  content=$(echo "$content" | sed 's/^[[:space:]]*//' | sed 's/[[:space:]]*$//')
  content=$(echo "$content" | sed 's/}[[:space:]]*$//')
  
  # Add cache configuration and closing }
  echo "$content
 :cache-enabled true
 :cache-key \"$(basename "$file" .clj)\"
 :cache-ttl 300
 :mobile-ttl 600}" > "$file"
  
  echo "  Fixed $file"
done

echo "Done!"