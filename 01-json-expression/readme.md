# generate message for kafka
```bash
cat sensor_10.json |kafkacat -P -b kafkahost -t sensor
```

# create target table
```bash
psql -f ddl.sql
```

# load with gpkafka
gpkafka load --quit-at-eof sensor.yaml
