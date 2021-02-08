# Introduction
This example is to load the value of each json message from Kafka topic into a single json column of target table.

# Produce sample json message

```bash
cat *.jsonl | kafkacat -P -b kafkahost -t ogg-cdc
```

# Create target table
```sql
CREATE TABLE ogg_cdc(
   id numeric,
   name varchar (50),
   birthday date,
   ts timestamp
);
```

# Load with gpsscli
```bash
gpsscli load --quit-at-eof ogg-cdc.yaml
```

# Reference
- https://github.com/pdeemea/kafka-gpss-replication