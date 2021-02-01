# Introduction
This example is to load binary file from local disk of the server running GPSS.

# Create target table
```bash
psql -f ddl.sql
```

# Load with gpkafka
gpsscli load -s --quit-at-eof binary-file.yaml
