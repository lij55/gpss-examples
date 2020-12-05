# Produce sample json message

```bash
cat *.json | kafkacat -P -b kafkahost -t simplejson
```

# Create target table
```sql
drop table if exists simplejson;
create table simplejson (data json);
```

# load with gpkafka
```bash
gpsscli load -s json.yaml
```
