pragma solidity ^0.8.0;

//引用类型: 为值提供数据位置 .
//引用类型有三种: 结构, 数组 和 映射
contract QuoteType {
	function QuoteType(){

	}
	//数据位置: 引用类型必须显示的提供该类型的数据存储位置.
	//引用类型总是创建数据的独立副本
	//memory: 存储函数参数的位置. 生存期仅限于外部函数调用
	//storage: 存储状态变量的位置. 仅限于合同有效期
	//calldata: 存储函数参数的位置. 对于外部函数的参数是必须的,但也可用于其他变量. 仅限于外部函数调用
	uint[] x;
	function buy(uint[] memory values)public{
		x =value;
		uint[] storage y = x;
		g(x);
		h(x);
	}
	function g(uint[] storage)internal pure{

	}
	function h(uint[] storage)public pure{

	}

	//结构: 用来表示实际界对象的自定义类型. 结构通常用作架构或用于表示记录
	struct Items_Schema{
		uint _id;
		uint _price;
		string _name;
		string _desc;
	}

	//映射. 通常使用映射来建模实际对象,并执行快速数据查找. 键=>值
	mapping(uint256 => Items_Schema)public items;
	uint item_id=0;
	function listItem(uint256 memory _price, string memory _name)public {
		item_id+=1;
		item[vehicle_id] = Items_Schema(item_id,_price,_name);
	}



	//数组.可以固定大小,也可以动态大小. 可以是任何类型:数值, 结构, 映射
	uint[] intemIds;//动态大小
	uint[3] price=[1,2,3];//固定大小
	uint[] price=[1,2,3];//固定大小.

	bytes32[] itemNames;
	itemNames.push( bytes32("hahah") );//添加.
	itemNames.length;//1
	itemNames.pop;//删除.从数组末尾删除元素



}
