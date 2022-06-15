pragma solidity ^0.7.0;
//值类型.@author

contract ValueType2 {
    //整数范围 8~256 .
    //已签名: 包括负数和正数.  int
    //未签名: 只包含正数       uint
    //整数可以使用的操作符: 比较(>,<,==...) 位(&,|,^,~)  算术运算符(%,**指数)
    int32 price =25;
    uint256 balance = 1000 ;

    balance - price ; //975
    2*price=50;
    price%2;//1


    //布尔
    bool forSale;
    bool purchased;
    function sale() public return (bool success) {
        if(balance>10 & balance> price){
            return true;
        }
        if(price > balance){
            return false;
        }
    }

    //字符串. 可以配合转义字符: \n换行 \r回车 \t(tab)
	String shippend = "shipeed";
	String shippend = 'shipeed';
	String newIntem = "new""Item";

	//地址: address   和   address payable 两种
	//address payable类型是 Ether 发送到的地址,包含了 transfer 和 send
	address public seller;
	address payable public buyer;
	function transfer(address buyer,uint price){
		buyer.transfer(price);
	}

	//枚举: 必须选择一个.可以在合同或库定义中声明枚举
	enum Status{
		Pending,
		Shipped,
		Delivered
	}
	Status public status;
	constructor() public{
		status = Status.Pending;
}

    function ValueType2(){

    }
}
