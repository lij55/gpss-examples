# generate message for kafka
```bash
cat messages.txt |kafkacat -P -b kafkahost -t key-value-meta -K '|'
```

# create target table
```bash
psql -f ddl.sql
```

# load with gpkafka
gpkafka load --quit-at-eof key-value-meta.yaml
