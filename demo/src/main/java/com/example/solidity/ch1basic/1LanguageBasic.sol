//pragma 检查版本是否与所需版本匹配
pragma solidity ^0.8.0;

//contract ContractName 必须以此开头
contract LanguageBasic {
    //uint 表示 256 位无符号整数
    uint price;
    //类型为 address 的变量.存储 20 字节的 ETH 地址.
    address public seller;
    //onlySeller 用于说明只有卖方才能列出商品, 使用修饰符onlySeller 的函数定义
    modifier onlySeller(){
        require(
            msg.sender == seller,
            "只有卖家才能列出商品"
        );
        _;//表示函数体插入的位置
    }


    //声明了一个函数, 并且可见性为 public. {public ,private, internal , external}
    //函数可以内部调用, 也可以从另一个合同调用
    function buyCoint(uint price)public{
        //
    }
    function buyCoint(uint price)public returns (uint){
        //
    }
    //pure: 不允许修改或访问状态的函数   view:不允许修改状态的函数     payable:可以接收 Ether 的函数
    function buyCoint(uint price)public view onlySeller{
        //
    }
    function LanguageBasic(){
        price = 0.00001;
    }

    //event: 事件. 事件描述了合同中采取的操作. 与函数类似,事件具有在调用事件时需要指定的参数
    event PurchasedItem(address buyer, uint price);
    //调用事件, 必须使用关键字 emit + 事件名 + 参数
    //调用事件, 事件会被捕获为事务日志中的事务, 事务日志是区块链中的一种特殊数据结构. 这些日志与合同地址关联,已合并到区块链中,且保持不变.
    //无法从合同中访问日志 及其 事件数据,且无法修改他.
    function buy() public {
        emit PurchasedItem(msg.sender,msg.value);
    }

}
