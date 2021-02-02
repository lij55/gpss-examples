# Introduction
This repo is about the examples of gpkafka/gpss. The examples are verified in gpss **1.5.0** and later. Each folder has an end-to-end example/demo use case of gpss.
GPSS deamon is needed to run these examples. It is enough to start it with following command:
```bash
gpss
```

# How to upgrade gpss
You may download the `.gppkg` installer from https://network.pivotal.io/products/greenplum-streaming-server/ if the gpss version (`gpss --version`) is earlier than 1.5.0. You could run following command to upgrade gpss on master:
```bash
gppkg -u gpss-gpdbX-1.a.b-rhelY-x86_64.gppkg
```
You may install the rpm package if you need to run GPSS on a dedicated ETL server without Greenplum server installed.

# GPSS configure file
GPSS provides some config parameters althoug the default parameter of gpss can work in most cases. The config file is in JSON format and you may start gpss with with config file by the following command:
```bash
gpss gpss.json
```
## Change the listening port
GPSS needs (at least) two ports to work, one for RPC call and the other one for segment connection (and another one for debug). GPSS talks with segments in gpfdist protocol. Below is the example if we need to change the listenting port.
```json
{
    "ListenAddress": {
        "Port": 6000
    },
    "Gpfdist": {
        "Port": 8088,
        }
}
```
If you changed the listening port of RPC call, you would also change the `--gpss-port` argument of gpsscli command line,for example:
```bash
gpsscli --gpss-port 6000 list
``` 

## Run GPSS in background
GPSS will wait infinitly if it runs in frondend. In order to run is as a daemon, you would need `nohup`. Below is the example:
```bash
nohup gpss -l /home/gpadmin/gpAdminLogs  gpss.json  &>/dev/null &
```
GPSS will store the verbose log in background. The default location is `/home/gpadmin/gpAdminLogs`. It can be changed by the `-l` option of gpss command line. The front end logs are no longger needed if GPSS runs in background so we can discard the front end logs.

## Rotate GPSS server logs
GPSS will save server log in format `gpss_DATE.log`. the date is in format of `yyyymmdd` which is the time when gpss starts. GPSS will write log to this file so long as it continue running.
If you need a daily or weekly rotated log files, you can send `USR2` signal to gpss process every day or every week. For example,
```bash
pkill -SIGUSR2 gpss
```
You can also refer to [this doc](https://gpdb.docs.pivotal.io/5230/greenplum-stream/instcfgmgt.html#logfiles) if you need to ingetrate it with `logrotate` service of Linux.

# External References
## Security GPSS
  This repo [pqiu/gpss-info](https://github.com/pf-qiu/gpss-info) has a lot of useful information related with setting up an SSL/TLS/Kerberos environment with GPSS, Greenplum and Kafka.
## GPSS data API plugins
  - [socket](https://github.com/DanielePalaia/gpss-socket)
  - [Pipe](https://github.com/DanielePalaia/gpss-pipe)
  - [RabbitMQ](https://github.com/DanielePalaia/gpss-rabbit-greenplum-connector)
  - [python example](https://github.com/xiaoxiaoHe-E/greenplum-gpss-example)
  - [Java example](https://gpdb.docs.pivotal.io/6-0/greenplum-stream/api/dev_client.html)
  Besides, there are a lot of useful project about gpss in [Daniele's repo](https://github.com/DanielePalaia). Have fun with them!
