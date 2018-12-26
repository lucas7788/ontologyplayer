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
			"blockTime": 111,
			"txHash": "sssssss",
			"buyer": "sss",
			"price": 2,
			"round": 1
		}, {
			"blockTime": 111,
			"txHash": "sssssss",
			"buyer": "sss",
			"price": 1,
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
			"blockTime": 111,
			"txHash": "sssssss",
			"buyer": "sss",
			"price": 2,
			"round": 1
		}, {
			"blockTime": 111,
			"txHash": "sssssss",
			"buyer": "sss",
			"price": 1,
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
			"blockTime": 111,
			"txHash": "sssssss",
			"buyer": "sss",
			"price": 2,
			"round": 1
		}, {
			"blockTime": 111,
			"txHash": "sssssss",
			"buyer": "sss",
			"price": 1,
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
round Integer

9. `getCurrentRemainingTime`

查询游戏结束剩余时间

10. `getHolderMostKeyValue`

查询持有Key价值最多的玩家
