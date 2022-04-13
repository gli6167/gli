package com.example.gli;

import org.junit.Test;

public class XiangMu1 {

//    创建一个 Customer ，名字叫 Jane Smith, 他有一个账号为 1000，余额为 2000 元，
//    年利率为 1.23％ 的账户。
//            （2） 对 Jane Smith 操作。
//    存入 100 元，再取出 960 元。再取出 2000 元。
//    打印出 Jane Smith 的基本信息

    @Test
    public void mian(){
      Customer cast = new Customer("Smith","Jane");
      Account acco = new Account(1000,2000,0.0123);

        cast.setAccount(acco);

        cast.getAccount().deposit(100);
        cast.getAccount().wirhdraw(980);
        cast.getAccount().wirhdraw(2000);
        System.out.println("Customer [" + cast.getFirstName() + " ," + cast.getLastName() + "] has a account id is " + cast.getAccount().getId() + "\t balance is:" + cast.getAccount().getBalance()
                + "\tannuallnterestRate is:" + cast.getAccount().getAnnuallnterestRate() * 100 + "%");

    }
}
//模拟账户类
class Account{
    private int id; //账号
    private  double  balance;  //余额
    private  double annuallnterestRate;  //年利率
    public Account (int id , double balance , double annuallnterestRate){
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setBalance (double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public void setAnnuallnterestRate(double annuallnterestRate){
        this.annuallnterestRate = annuallnterestRate;
    }
    public double getAnnuallnterestRate(){
        return annuallnterestRate;
    }
    public void wirhdraw(double amount){
        if (balance < amount){
            System.out.println("余额不足，取款失败");
            return;
        }
         balance -= amount;
        System.out.println("成功取出：" + amount + "账户余额：" + balance);
    }
    public void deposit(double amount){
        balance += amount;
        System.out.println("成功存入：" + amount + "账户余额" + balance);
    }
}
//顾客类
class Customer{
    private String firstName;  // 名
    private String lastName;   //姓
    private Account account;  // 账户
    public Customer(String f , String l){
        this.firstName = f;
        this.lastName = l;
    }
//    public void setFirstName(String firstName){
//        this.firstName = firstName;
//    }
    public String getFirstName(){
        return firstName;
    }
//    public void setLastName(String lastName){
//        this.lastName = lastName;
//    }
    public String getLastName(){
        return lastName;
    }
    public void setAccount(Account account){
        this.account = account;
    }
    public Account getAccount(){
        return account;
    }
}