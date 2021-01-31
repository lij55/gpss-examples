# Introduction
This example is to extract json field for each column.


# Produce sample json message
```bash
cat sensor_10.json |kafkacat -P -b kafkahost -t sensor
```

# Prepare target table
```bash
psql -f ddl.sql
```

# Load with gpkafka
```bash
gpsscli load --quit-at-eof -s json.yaml
```
