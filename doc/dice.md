
# 接口列表

## 保存下注记录   POST
```
http://127.0.0.1:8585/api/v1/ong/saveBetRecord
```

参数
```json
{
  "list": ["AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
}
```

响应
```json
{
    "Action": "insertbetrecord",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": 1
}
```

## 查询下注记录   GET

```http request
http://127.0.0.1:8585/api/v1/ong/getBetRecord/AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA/10/1
```

响应
```json
{
    "Action": "getmybetrecord",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": [
        {
            "betTime": "2019-01-21 21:53:32.0",
            "address": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",
            "betType": 1,
            "betAmount": 1
        }
    ]
}
```

## 保存开奖记录   POST
```http request
http://127.0.0.1:8585/api/v1/ong/saveOpenRecord
```

参数
```json
{
  "num1": 1,
  "num2":2,
  "num3":3,
  "address":"AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA"
}
```

响应
```json
{
    "Action": "insertopenrecord",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": 1
}
```

## 查询开奖记录  GET
```http request
http://127.0.0.1:8585/api/v1/ong/getOpenRecord/AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA/10/1
```

响应
```json
{
    "Action": "getmyopenrecord",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": [
        {
            "num1": 1,
            "num2": 2,
            "num3": 3,
            "address": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA"
        }
    ]
}
```

## 保存投资记录    POST
```http request
http://127.0.0.1:8585/api/v1/ong/saveInvestRecord
```

参数
```json
{
 
  "amount":3,
  "address":"AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA"
}
```
响应
```json
{
    "Action": "insertinvestrecord",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": 1
}
```

## 查询投资记录  GET
```http request
http://127.0.0.1:8585/api/v1/ong/getInvestRecord/AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA/10/1
```

响应

```json
{
    "Action": "getmyinvestrecord",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": [
        {
            "investTime": "2019-01-22 10:06:28.0",
            "address": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",
            "amount": 3
        }
    ]
}
```

## 保存退出记录   POST
```http request
http://127.0.0.1:8585/api/v1/ong/saveQuitRecord
```

参数
```json
{
  "amount":3,
  "address":"AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA"
}
```

响应
```json
{
    "Action": "insertquitrecord",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": 1
}
```

## 查询退出记录
```http request
http://127.0.0.1:8585/api/v1/ong/getQuitRecord/AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA/10/1
```

响应
```json
{
    "Action": "getmyquitrecord",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": [
        {
            "quitTime": "2019-01-22 10:12:24.0",
            "address": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",
            "amount": 3
        }
    ]
}
```