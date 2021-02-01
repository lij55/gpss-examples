# Introduction
This example is to load binary format of kafka message and process it with UDF.


# generate message for kafka
```bash
kafkacat -P -b kafkahost -t binary-message images/*
```

# Create target table
```bash
psql -f ddl.sql
```

# Load with gpkafka
gpsscli load -s --quit-at-eof binary-message.yaml
