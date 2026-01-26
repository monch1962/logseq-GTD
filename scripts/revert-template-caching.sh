#!/bin/bash

# Revert template caching changes back to original format

echo "Reverting template caching changes..."

# File to update
FILE="GTD_Templates/Organize/11-gtd-management-dashboard.md"

# Create backup
cp "$FILE" "$FILE.backup"

# Revert each cached-query back to original format
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/waiting-active-count\.clj") :cache-key "waiting-active-count" :ttl 600)}}/{{query (read-file "queries\/library\/dashboard\/waiting-active-count\.clj")}}/g' "$FILE"
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/overdue-follow-ups\.clj") :cache-key "overdue-count" :ttl 600 :view :text)}}/{{query (read-file "queries\/library\/dashboard\/overdue-follow-ups\.clj") :view :text}}/g' "$FILE"
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/someday-by-category\.clj") :cache-key "someday-by-category" :ttl 600)}}/{{query (read-file "queries\/library\/dashboard\/someday-by-category\.clj")}}/g' "$FILE"
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/high-interest-someday\.clj") :cache-key "high-interest-someday" :ttl 600)}}/{{query (read-file "queries\/library\/dashboard\/high-interest-someday\.clj")}}/g' "$FILE"
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/ready-for-consideration\.clj") :cache-key "ready-for-consideration" :ttl 600)}}/{{query (read-file "queries\/library\/dashboard\/ready-for-consideration\.clj")}}/g' "$FILE"
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/total-someday-items\.clj") :cache-key "total-someday-items" :ttl 600)}}/{{query (read-file "queries\/library\/dashboard\/total-someday-items\.clj")}}/g' "$FILE"
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/references-by-tag\.clj") :cache-key "references-by-tag" :ttl 600)}}/{{query (read-file "queries\/library\/dashboard\/references-by-tag\.clj")}}/g' "$FILE"
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/recent-references\.clj") :cache-key "recent-references" :ttl 600)}}/{{query (read-file "queries\/library\/dashboard\/recent-references\.clj")}}/g' "$FILE"
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/most-useful-references\.clj") :cache-key "most-useful-references" :ttl 600)}}/{{query (read-file "queries\/library\/dashboard\/most-useful-references\.clj")}}/g' "$FILE"
sed -i '' 's/{{query (cached-query #(read-file "queries\/library\/dashboard\/total-references\.clj") :cache-key "total-references" :ttl 600)}}/{{query (read-file "queries\/library\/dashboard\/total-references\.clj")}}/g' "$FILE"

echo "Done! Backup saved to $FILE.backup"