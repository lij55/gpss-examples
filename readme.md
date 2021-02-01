# Introduction
This repo is about the examples of gpkafka/gpss. The examples are verified in gpss **1.5.0** and later. Each folder has a end-to-end example/demo use case of gpss.
GPSS deamon is needed to run those examples. It is enough to start it with following command:
```bash
gpss
```

# How to upgrade gpss
You may download the .gppkg cluster installer from https://network.pivotal.io/products/greenplum-streaming-server/ if the gpss version (output of `gpss --version`) is earlier than 1.5.0. You could run following command to upgrade gpss on master:
```bash
gppkg -u gpss-gpdb6-1.5.0-rhel7-x86_64.gppkg
```
You may install the rpm package if you need to run GPSS on a dedicated ETL server without Greenplum server installed.

# GPSS configure file
## Change listing port
GPSS need (at least) two ports to work, one for RPC call and the other one for segment connection. GPSS talks with segment in gpfdist protocol. Below is the example if we need to change the listenting port.
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

