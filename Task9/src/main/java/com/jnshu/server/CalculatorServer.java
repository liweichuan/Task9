//package com.jnshu.server;
//
//import com.jnshu.service.CalculatorService;
//import com.jnshu.serviceimpl.CalculatorServiceImpl;
//import org.apache.tuscany.sca.node.Node;
//import org.apache.tuscany.sca.node.NodeFactory;
//
//import java.io.IOException;
//
//public class CalculatorServer {
//    public static void main(String[] args) throws IOException {
//        Node node = NodeFactory.newInstance().createNode("Calculator.composite");
//        node.start();
//        System.out.println("service启动");
//        CalculatorService c = node.getService(CalculatorServiceImpl.class,"CalculatorServiceComponent");
//        System.out.println(c.add(2, 2));
//        System.out.println("3 + 2 = " + c.add(3, 2));
//        System.out.println("3 - 2 = " + c.subtract(3, 2));
//        System.out.println("3 * 2 = " + c.multiply(3, 2));
//        System.out.println("3 / 2 = " + c.divide(3, 2));
//        node.stop();
//    }
//}
