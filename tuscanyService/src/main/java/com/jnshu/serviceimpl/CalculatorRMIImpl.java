package com.jnshu.serviceimpl;

import com.jnshu.service.CalculatorRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * 计算器RMI服务类
 * @author ajun
 * @e-mail zhaojun2066@gmail.com
 * @blog http://blog.csdn.net/ajun_studio
 * @version
 */

public class CalculatorRMIImpl extends UnicastRemoteObject implements CalculatorRMI {


//    private static final long serialVersionUID = -6698638302125311021L;

    public CalculatorRMIImpl() throws RemoteException {
        super();
    }


    @Override
    public double add(double n1, double n2) throws RemoteException {
        return n1+n2;
    }

    @Override
    public double subtract(double n1, double n2) throws RemoteException {
        return n1-n2;
    }

    @Override
    public double divide(double n1, double n2) throws RemoteException {
        return n1/n2;
    }

    @Override
    public double multiply(double n1, double n2) throws RemoteException {
        return n1*n2;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
