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
## 游戏玩法

* 游戏规则

1. 购买Key
2. 最后一个购买Key的人赢得奖池中60%的奖金。

* 玩家购买Key的资金流向

1. 40%进入奖池
2. 40%分给前面已经购买Key的人。
3. 5%手续费。
4. 5%给邀请人，如果没有邀请人，则进入奖池
5. 10%给游戏股东
6. 第一个购买Key的人，玩家分红进入奖池。

* Key价格变化规则
1. Key的初始价格是1个ong.
2. 每有一个人购买Key,Key的价格增加1个ong。

* 玩家分红规则
1. 按照持有Key的价值分红，
例如，玩家Bob购买Key的价格是5个ong, 玩家Alice购买Key的价格是10个ong，则Bob和Alice在享受后面购买者的分红时，
是按照5：10的比例进行，也就是说购买时的价格越贵，则该Key的价值越高，享受的分红越多。
2. 在每一轮游戏中，玩家可以多次购买Key, 玩家Key的价值累加。

* 游戏结束规则

1. 第一个玩家购买Key后，如果1个小时内都没有人购买，则游戏结束
2. 每有一个玩家够买Key,游戏结束时间延长Key的价值*1分钟的时间。
例如：玩家Bob购买Key时的价格是10个ong，则游戏结束时间增加10*1分钟=10分钟
3. 每轮游戏最长结束时间不超过24小时。

* 奖池分配规则

1. 60%分给最后一个购买Key的人
2. 30%进入下一轮奖池
3. 10%用于奖励持有Key价值最多的用户，最后一个购买者除外。



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
