package com.jnshu.client;

import com.jnshu.service.CalculatorService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculatorClient {
    public static void main(String[] args) {
        //创建一个对象
        CalculatorService c=null;
        try {
            //这里给这个对象赋值，远程的CalculatorRMIService ，本地和远程就关联起来了
         c= (CalculatorService) Naming.lookup("//127.0.0.1:8099/CalculatorRMIService");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        assert c != null;
        //使用本地的对象调用远程的服务的方法
        System.out.println("3+3="+c.add(3,3));
        System.out.println("9-3="+c.subtract(9,3));
        System.out.println("2*3="+c.multiply(2,3));
        System.out.println("18/3="+c.divide(18,3));
        System.out.println("客户端调用结束。。。。。。。。。。。。。。。。。。");
    }
}
