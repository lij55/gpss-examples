# Introduction
This example is to show how store the message that issue an expression failure. Expression failure is not format error. the data format is correct for external tabe but it failed to run the expression. For example, json column missed some fields. we choose a 'divided by 0' failure.


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
gpsscli load --quit-at-eof -s sensor.yaml
```

# Check failed data
The bad data is saved in backup table with name `gpssbackup_JOBID`.
run `gpsscli dryrun sensor.yaml` and it will print the name of jobid. Following SQL will give the detailed failure
```sql

test=# select * from gpssbackup_e0c5991570303703450bbac2ee8816bc;
                                                    data                                                    |      gpss_save_timestamp      | gpss_expression_error 
------------------------------------------------------------------------------------------------------------+-------------------------------+-----------------------
 {"device": "agkNtzFnHIVASYNvo", "humidity": 91.3, "temperature": 9, "time": "2019-09-24T15:33:57.054175"}  | 2022-07-04 07:51:17.798469+00 | division by zero
 {"device": "LcZQGnVXhORIKxWY", "humidity": 46.289, "temperature": 9, "time": "2019-09-24T15:33:57.054561"} | 2022-07-04 07:51:17.798469+00 | division by zero
(2 rows)

```