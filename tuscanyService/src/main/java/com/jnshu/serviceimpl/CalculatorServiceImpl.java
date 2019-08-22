package com.jnshu.serviceimpl;

import com.jnshu.service.*;
import org.oasisopen.sca.annotation.Reference;

public class CalculatorServiceImpl implements CalculatorService {

    /**
     * 引用其他组件AddService，SubtractService，MultiplyService,DivideService
     * @Reference 说明引用其他组件 会和.composite文件进行配置
     */

    private AddService add;//加法组件
    private SubtractService subtract;//减法组件
    private MultiplyService multiply;//乘法组件
    private DivideService divide;//除法组件


    public AddService getAdd() {
        return add;
    }

    @Reference
    public void setAdd(AddService add) {
        this.add = add;
    }

    public SubtractService getSubtract() {
        return subtract;
    }

    @Reference
    public void setSubtract(SubtractService subtract) {
        this.subtract = subtract;
    }

    public MultiplyService getMultiply() {
        return multiply;
    }

    @Reference
    public void setMultiply(MultiplyService multiply) {
        this.multiply = multiply;
    }

    public DivideService getDivide() {
        return divide;
    }

    @Reference
    public void setDivide(DivideService divide) {
        this.divide = divide;
    }

    @Override
    public double add(double n1, double n2) {
        System.out.println("Server add");
        return this.add.add(n1, n2);
    }

    @Override
    public double subtract(double n1, double n2) {
        System.out.println("Server subtract");
        return this.subtract.subtract(n1, n2);
    }

    @Override
    public double divide(double n1, double n2) {
        System.out.println("Server divide");
        return this.divide.divide(n1, n2);
    }

    @Override
    public double multiply(double n1, double n2) {
        System.out.println("Server multiply");
        return this.multiply.multiply(n1, n2);
    }
}
