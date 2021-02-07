# Introduction
This example is to demo the merge mode, which is similar to `upsert`.
Both file source and Kafka source support merge operation.

# Create target table
```bash
psql -f ddl.sql
```

# Load with gpkafka
gpsscli load -s --quit-at-eof merge.yaml
