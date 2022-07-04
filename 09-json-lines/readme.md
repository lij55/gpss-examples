# Introduction
This example is to load the message that has more than one json object. the message format is jsonline or ndjson.

# Produce sample json message

```bash
for i in `seq 1 10`;do kafkacat -P -b kafkahost -t mdjson simple.json;done;
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
