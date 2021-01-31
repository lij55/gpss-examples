# Introduction
This example is to load the value of each json message from Kafka topic into a single json column of target table.

# Produce sample json message

```bash
cat *.json | kafkacat -P -b kafkahost -t simplejson
```

# Create target table
```bash
psql -c "drop table if exists simplejson;"
psql -c "create table simplejson(data json);"
```

# load with gpkafka
```bash
gpsscli load --quit-at-eof json.yaml
```
