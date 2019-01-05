# ontologyserver

## Introduction



## server接口列表


1. `getmybuyrecordbypage`    GET

`/getmybuyrecordbypage/{buyer}/{pagesize}/{pagenumber}`

查询我的购买记录


请求例子

```http
http://127.0.0.1:8585/api/v1/buyers/getmywithdrawrecordbypage/sss/3/1
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
			"txTime": 11,
			"txHash": "xxxxx",
			"buyer": "sss",
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
http://127.0.0.1:8585/api/v1/buyers/getbuyrecordbypage/3/1
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
			"txTime": 11,
			"txHash": "xxxxx",
			"buyer": "sss",
			"price": 1.1,
			"round": 1
		}]
	}
}
```

3. `getmywithdrawrecordbypage`   GET


查询我的提现记录

请求例子
```http request
http://127.0.0.1:8585/api/v1/buyers/getmywithdrawrecordbypage/sss/3/1
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
			"txTime": 11,
			"txHash": "xxxxx",
			"buyer": "sss",
			"price": 1.1,
			"round": 1
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
http://127.0.0.1:8585/api/v1/buyers/saveinvitor
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
http://127.0.0.1:8585/api/v1/buyers/getinvitorbyaddress/aaaaa
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
http://127.0.0.1:8585/api/v1/buyers/gettotalbyinvitor/sss
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
http://127.0.0.1:8585/api/v1/buyers/getwinnerbypage/3/1
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
