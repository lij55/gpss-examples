
# kafka command
## Increase partition number
```bash
kafka-topics  --zookeeper localhost:2181 --alter --topic simplejson --partitions 40
```