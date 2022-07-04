# Introduction
This example is to load the message that has more than one json object. the message format is jsonline or ndjson.

# Produce sample json message

```bash
for i in `seq 1 10`;do kafkacat -P -b kafkahost -t enhancedeli data_no_quote.txt;done;
```


```bash
for i in `seq 1 10`;do kafkacat -P -b kafkahost -t enhancedeli_quote data_quoted.txt;done;
```


# Create target table
```bash
psql -c "drop table if exists enhancedeli;"
psql -c "create table enhancedeli(d1 text, d2 text, d3 text, d4 text);"
```

# load with gpkafka
```bash
gpsscli load --quit-at-eof -s data_no_quote.yaml
```
```bash
gpsscli load --quit-at-eof -s data_quoted.yaml
```
