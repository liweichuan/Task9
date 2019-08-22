package com.jnshu.server;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class CalculatorRMIServer {
    public static void main(String[] args) {
        Node node= NodeFactory.newInstance().createNode("Calculator.composite");
        node.start();
        System.out.println("service启动。。。。。。。。。。。。。。");
    }
}
