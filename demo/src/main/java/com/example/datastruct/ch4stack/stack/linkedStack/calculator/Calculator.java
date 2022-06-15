package com.example.datastruct.ch4stack.stack.linkedStack.calculator;

import com.example.datastruct.ch4stack.stack.linkedStack.LinkedNode;
import com.example.datastruct.ch4stack.stack.linkedStack.LinkedStack;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static Pattern STRING_PATTER = Pattern.compile("\\s");
    public static void main(String[] args) {
        LinkedStack numStack =new LinkedStack<Integer>(new LinkedNode<>(-1));
        LinkedStack operStack =new LinkedStack<String>(new LinkedNode<>("-1"));
        String str = "3+2*6-2+5/5";
        int index=0;
        int res=0;
        while (true){
            if (index==str.length()){
                break;
            }
            char charAt = str.substring(index, index + 1).charAt(0);
            index++;

            if (isNum(charAt)){//是数字
                System.out.println(charAt+" 是一个数字");
                numStack.addLastByT(Character.getNumericValue(charAt));
            }else {// 是符号
                System.out.println(charAt+" 不是一个数字");
                if (StringUtils.isEmpty(operStack.peek())){//为空直接放入
                    operStack.addLastByT(String.valueOf(charAt));
                }else {//不为空,比较两个操作符
                    if (getOperLevel(String.valueOf(charAt)) > getOperLevel(String.valueOf(operStack.peek()))){//操作符大,继续放入
                        operStack.addLastByT(String.valueOf(charAt));
                    }else {//操作符小, 取出两个数字和操作符运算, 运算结果放入数字站, 操作符放入符栈
                        Integer num1 = (Integer) numStack.removeLastByT();
                        Integer num2 = (Integer) numStack.removeLastByT();
                        String oper = (String) operStack.removeLastByT();
                        res = getRes(num1, num2, oper);
                        numStack.addLastByT(res);
                        operStack.addLastByT(String.valueOf(charAt));
                    }
                }

            }
        }
        System.out.println(res);
    }

    public static Integer getRes(Integer num1,Integer num2,String oper){
        Integer res=0;
        switch (oper){
            case "+":
                res= num1+num2;
                break;
            case "-":
                res= num2-num1;
                break;
            case "*":
                res= num1*num2;
                break;
            case "/":
                res= num2/num1;
                break;
        }
        return res;
    }

    public static Integer getOperLevel(String oper){
        if (oper.equals("+") || oper.equals("-")){
            return 0;
        }else if (oper.equals("*") || oper.equals("/")){
            return 1;
        }else {
            return -1;
        }

    }

    public static boolean isNum(char ch){
        String patter = "[0-9]+";
        Pattern compile = Pattern.compile(patter);
        Matcher matcher = compile.matcher(String.valueOf(ch));
        return matcher.matches();
    }

}
