package com.jnshu.service;

import org.oasisopen.sca.annotation.Remotable;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 计算器远程RMI接口
 * @author ajun
 * @e-mail zhaojun2066@gmail.com
 * @blog http://blog.csdn.net/ajun_studio
 * @version
 */

@Remotable
public interface CalculatorRMI extends Remote {
    double add(double n1,double n2) throws RemoteException;
    double divide(double n1,double n2) throws RemoteException;
    double multiply(double n1,double n2) throws RemoteException;
    double subtract(double n1,double n2) throws RemoteException;
}
