# Introduction
This example shows how to load from partial partitions of a big topci which has a lot of partitions.
You need a topic that has more that 1 partitions.

This is the basic scale out solution if single GPSS couldn't handle all the traffics of a single topic

# Limitations
Because each job is running in different GPSS, it is not possible to detect whether the partition range has overlap or not.
Please pay attention not to duplicate or miss partitions.

# Start
```bash
gpsscli load *.yaml
```