package com.jnshu.client;


import com.jnshu.service.CalculatorRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TuscanyClient {
    public static void main(String[] args) throws RemoteException {
        //创建一个对象
        CalculatorRMI c=null;
        try {
            //这里给这个对象赋值，远程的CalculatorRMIService ，本地和远程就关联起来了
            c= (CalculatorRMI) Naming.lookup("//127.0.0.1:8099/CalculatorRMIService");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        assert c != null;

        System.out.println("3 + 2 = "+c.add(3, 2));
        System.out.println("3 - 2 = "+c.subtract(3, 2));
        System.out.println("3 * 2 = "+c.multiply(3, 2));
        System.out.println("3 / 2 = "+c.divide(3, 2));
    }
}
