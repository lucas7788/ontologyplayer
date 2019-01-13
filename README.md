# ontologyserver

## Introduction

## 增加的接口列表

1. `getrecentactivity`

查询最近的活动

请求例子

```http
http://127.0.0.1:8585/api/v1/ong/getrecentactivity
```

结果

```json
{
    "Action": "getrecentactivity",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": {
        "isShow": 1,
        "activeTime": 1547431200,
        "activeName": "1个ong购买1000个ong活动预告",
        "activeContent": "1个ong购买1000个ong活动开始了"
    }
}
```

## server接口列表


1. `getmybuyrecordbypage`    GET

`/getmybuyrecordbypage/{buyer}/{pagesize}/{pagenumber}`

查询我的购买记录


请求例子

```http
http://139.219.128.220:8585/api/v1/ong/getmybuyrecordbypage/AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA/3/1
```

响应结果
```json
{
	"Action": "getmybuyrecordbypage",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": [{
			"txTime": 1546694658,
			"txHash": "c9540be8803ed3861a1589e032edba0e8444eb143f31fcf4b014cac00533b07a",
			"buyer": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",
			"price": 1.4,
			"round": 1
		}, {
			"txTime": 1546694631,
			"txHash": "b709b8509aa5177227795261522c194bb7239aec2c439b1fd447ea630b11f3fb",
			"buyer": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",
			"price": 1.3,
			"round": 1
		}, {
			"txTime": 1546691196,
			"txHash": "e4b3b6ac85452cf03d50343a5620f424387de40da6d678a642315c6d2175f48f",
			"buyer": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",
			"price": 1.1,
			"round": 1
		}]
	}
}
```

2. `getbuyrecordbypage`   GET

`/getbuyrecordbypage/{pageSize}/{pageNumber}`

按页查询购买记录

请求例子

```http request
http://139.219.128.220:8585/api/v1/ong/getbuyrecordbypage/3/1
```

响应结果

```json
{
	"Action": "getbuyrecordbypage",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": [{
			"txTime": 1546694658,
			"txHash": "c9540be8803ed3861a1589e032edba0e8444eb143f31fcf4b014cac00533b07a",
			"buyer": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",
			"price": 1.4,
			"round": 1
		}, {
			"txTime": 1546694631,
			"txHash": "b709b8509aa5177227795261522c194bb7239aec2c439b1fd447ea630b11f3fb",
			"buyer": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",
			"price": 1.3,
			"round": 1
		}, {
			"txTime": 1546693193,
			"txHash": "23232bccc1f394049782104c47cf24bb6e842deb4c833b35936fc3fe5791fd6d",
			"buyer": "AMAqR8Y8JWngDk5QsoGpa7vPhu5Tu5KKeS",
			"price": 1.2,
			"round": 1
		}]
	}
}
```

3. `getmywithdrawrecordbypage`   GET


查询我的提现记录

请求例子
```http request
http://127.0.0.1:8585/api/v1/ong/getmywithdrawrecordbypage/sss/3/1
```


响应结果
```json
{
	"Action": "getmywithdrawrecordbypage",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": [{
			"address": "AbPRaepcpBAFHz9zCj4619qch4Aq5hJARA",
			"dividend": 0.4400,
			"inviteDividend": 0.0210,
			"round": 1,
			"txTime": 1546691529,
			"txHash": "950a1a8d2e28505b205aaca6cf8d362d66aa7c4010caba0d69856bedf5c0ce8a"
		}]
	}
}
```

4. `saveinvitor`     POST

保存邀请人和被邀请人
address 被邀请人地址
invitor 邀请人地址

例子
请求
```http request
http://139.219.128.220:8585/api/v1/ong/saveinvitor
```

参数
```json
{
  "address": "aaaaa",
  "invitor": "sss"
}
```

响应

```
{
    "Action": "saveinvitor",
    "Error": 0,
    "Desc": "SUCCESS",
    "Version": "1.0",
    "Result": {
        "Result": 1
    }
}
```


5. `getinvitorbyaddress/{address}`

查询某个地址的邀请人


请求例子

```http request
http://139.219.128.220:8585/api/v1/ong/getinvitorbyaddress/aaaaa
```

```json
{
	"Action": "getinvitorbyaddress",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": {
			"address": "aaaaa",
			"invitor": "sss"
		}
	}
}
```

6. `gettotalbyinvitor`   GET

查询某个地址的总邀请人数

请求
```http request
http://139.219.128.220:8585/api/v1/buyers/gettotalbyinvitor/sss
```

响应
```json
{
	"Action": "gettotalbyinvitor",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": 1
	}
}
```

7. `/getwinnerbypage/{pageSize}/{pageNumber}`

查询中奖纪录

例子
```http request
http://139.219.128.220:8585/api/v1/buyers/getwinnerbypage/3/1
```

响应
```json
{
	"Action": "getwinnerbypage",
	"Error": 0,
	"Desc": "SUCCESS",
	"Version": "1.0",
	"Result": {
		"Result": [{
			"lastBuyer": "xxx",
			"lastBuyerDividend": 11.1100,
			"holdKeyMost": "sss",
			"holdKeyMostDividend": 22.2200,
			"mostActive": "sssssss",
			"mostActiveDividend": 33.3300,
			"round": 1
		}]
	}
}
```


## 合约接口列表

1. `buyKey`

购买key

参数

account , ByteArray

2. `withdrawFee`

提取手续费

参数
account, ByteArray

3. `getDividendBalance`

查询分红接口

参数

account, ByteArray
round, Integer

4. `getLastBuyer`

查询最后一个购买的玩家

5. `getBonusBalance`

查询奖金池余额

6. `getBonusPrice`

查询key的价格

7. `getRoundGameStatus`

查询游戏状态

8. `getDividendBalance`

查询分红余额

account ByteArray

9. `getCurrentRemainingTime`

查询游戏结束剩余时间

10. `getHolderMostKeyValue`

查询持有Key价值最多的玩家

11. `getMostActivePlayer`

参数
round integer

查询购买次数最多的玩家,也就是最活跃的玩家
