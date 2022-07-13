package com.example.juc.多线程锁;

import java.time.Period;
import java.util.concurrent.TimeUnit;

/**
 * 8锁演示
 * 1.标准访问, 先 SMS 还是 Email
 *      -----sendSMS()
 * -----sendEmail()
 *
 * 2. 停 4 秒在短信方法, 先打印短信还是邮件
 * -----sendSMS()
 * -----sendEmail()
 *
 * 3. 停 4 秒在短信方法,新增普通的 hello 方法,先打短信还是 hello
 * -----getHello()
 * -----sendSMS()
 *
 * 4. 停 4 秒在短信方法,现有两部手机, 先打印短信还是邮件
 * -----sendEmail()
 * -----sendSMS()
 *
 * 5. 2个静态同步方法 1 部手机, 先短信还是邮件
 * -----sendSMS()
 * -----sendEmail()
 *
 * 5. 2个静态同步方法 2 部手机, 先短信还是邮件
 * -----sendSMS()
 * -----sendEmail()
 *
 * 5. 1个静态同步方法,一个普通同步方法,  2 部手机, 先短信还是邮件
 * -----sendEmail()
 * -----sendSMS()
 *
 * @author wubingyin
 * @date 2022/07/11
 */
public class LockDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Pthone pthone = new Pthone();
        Pthone pthone2 = new Pthone();

        new Thread(
                ()->{
                    try {
                        pthone.sendSMS();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ,"AA").start();

        Thread.sleep(100);

        new Thread(
                ()->{
                    pthone2.sendEmail();
//                    pthone.getHello();
//                    pthone2.sendEmail();
                }
                ,"BB").start();
    }

}
class Pthone{
    public static synchronized  void  sendSMS() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("-----sendSMS()");
    }
    public void  sendEmail() {
        System.out.println("-----sendEmail()");
    }
    public   void  getHello() {
        System.out.println("-----getHello()");
    }
}
