package com.jnshu.serviceimpl;

import com.jnshu.service.CalculatorService;
import org.oasisopen.sca.annotation.Reference;

public class CalculatorServiceImpl implements CalculatorService {

    private AddServiceImpl addService;
    private SubtractServiceImpl subtractService;
    private MultiplyServiceImpl multiplyService;
    private DivideServiceImpl divideService;

    /**
     * 引用其他组件IAdd，ISubtract，IMultiply,IDivide
     *  @Reference 进行注入说明引用其他组件 会和.composite文件进行配置
     */
    public AddServiceImpl getAddService(){
        return addService;
    }
    @Reference
    public void setAddService(AddServiceImpl addService){
        this.addService=addService;
    }

    public SubtractServiceImpl getSubtractService(){
        return subtractService;
    }
    @Reference
    public void setSubtractService(SubtractServiceImpl subtractService){
        this.subtractService=subtractService;
    }

    public MultiplyServiceImpl getMultiplyService(){
        return multiplyService;
    }
    @Reference
    public void setMultiplyService(MultiplyServiceImpl multiplyService){
        this.multiplyService=multiplyService;
    }

    public DivideServiceImpl getDivideService(){
        return divideService;
    }
    @Reference
    public void setDivideService(DivideServiceImpl divideService){
        this.divideService=divideService;
    }

    public double add(double n1, double n2) {
        return addService.add(n1,n2);
    }

    public double subtract(double n1, double n2) {
        return subtractService.subtract(n1,n2);
    }

    public double multiply(double n1, double n2) {
        return multiplyService.multiply(n1,n2);
    }

    public double divide(double n1, double n2) {
        return divideService.divide(n1,n2);
    }
}
