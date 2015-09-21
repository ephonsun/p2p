cslc_cashback
id:Long,accountid:Long,bankcardid:Long,paychannel:Byte,status:Byte,amount:Double,bonus:Double,fee:Double,createtime:Date,submittime:Date,selfitemid:String,income:Double

<sqlMap resource="com/cslc/dao/cashback/Cashback.xml" />

CREATE TABLE `cashback` (
  `accountid` bigint(40) default NULL,
  `submittime` datetime default NULL,
  `paychannel` tinyint(2) default NULL,
  `amount` decimal(16,2) default NULL,
  `income` decimal(16,2) default NULL,
  `createtime` datetime default NULL,
  `bankcardid` bigint(40) default NULL,
  `bonus` decimal(16,2) default NULL,
  `fee` decimal(16,2) default NULL,
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `status` tinyint(2) default NULL,
  `selfitemid` varchar(200) default NULL
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000000000000001 DEFAULT CHARSET=utf8;