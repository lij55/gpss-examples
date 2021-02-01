# Introduction
This example is to use both KEY and VALUE of kafka message.


# Generate message for kafka
```bash
cat messages.txt |kafkacat -P -b kafkahost -t key-value-meta -K '|'
```

# Create target table
```bash
psql -f ddl.sql
```

# Load with gpkafka
gpsscli load -s --quit-at-eof key-value-meta.yaml
