package com.jnshu.server;


import com.jnshu.serviceimpl.CalculatorRMIImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 注册RMI服务类
 * @author ajun
 * @e-mail zhaojun2066@gmail.com
 * @blog http://blog.csdn.net/ajun_studio
 * @version 创建时间：2012-7-25  下午9:29:47
 */
public class RuscanyServer {

    /**
     * @param args
     * @throws RemoteException
     * @throws AlreadyBoundException
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        CalculatorRMIImpl rmi = new CalculatorRMIImpl();
        //端口号8099
        Registry rmiRegistry = LocateRegistry.createRegistry(8099);
        //为rmi绑定的服务的名字为CalculatorRMIService
        rmiRegistry.bind("CalculatorRMIService", rmi);
    }
}
