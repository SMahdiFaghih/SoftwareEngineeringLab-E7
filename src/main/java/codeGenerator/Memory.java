package codeGenerator;

import java.util.ArrayList;

/**
 * Created by mohammad hosein on 6/27/2015.
 */
public class Memory {
    private ArrayList<_3AddressCode> codeBlock;
    private int lastTempIndex;
    private int lastDataAddress;
    private final int stratTempMemoryAddress = 500;
    private final int stratDataMemoryAddress = 200;
    private final int dataSize = 4;
    private final int tempSize = 4;

    public Memory() {
        codeBlock = new ArrayList<_3AddressCode>();
        setLastTempIndex(stratTempMemoryAddress);
        setLastDataAddress(stratDataMemoryAddress);

    }

    public int getTemp() {
        return getLastTempIndex();
    }

    public void changeTempIndex() {
        setLastTempIndex(getLastTempIndex() + tempSize);
    }


    public int getDateAddress() {
        return getLastDataAddress() - dataSize;
    }

    public void changeDataAddress() {
        setLastDataAddress(getLastDataAddress() + dataSize);
    }


    public int saveMemory() {
        codeBlock.add(new _3AddressCode());
        return codeBlock.size() - 1;
    }

    public void add3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        codeBlock.add(new _3AddressCode(op, opr1, opr2, opr3));
    }

    public void add3AddressCode(int i, Operation op, Address opr1, Address opr2, Address opr3) {
        codeBlock.remove(i);
        codeBlock.add(i, new _3AddressCode(op, opr1, opr2, opr3));
    }

    public int getCurrentCodeBlockAddress() {
        return codeBlock.size();
    }

    public void pintCodeBlock() {
        System.out.println("Code Block");
        for (int i = 0; i < codeBlock.size(); i++) {
            System.out.println(i + " : " + codeBlock.get(i).toString());
        }
    }

    public int getLastTempIndex() {
        return lastTempIndex;
    }

    public void setLastTempIndex(int lastTempIndex) {
        this.lastTempIndex = lastTempIndex;
    }

    public int getLastDataAddress() {
        return lastDataAddress;
    }

    public void setLastDataAddress(int lastDataAddress) {
        this.lastDataAddress = lastDataAddress;
    }
}

class _3AddressCode {
    private Operation operation;
    private Address Operand1;
    private Address Operand2;
    private Address Operand3;

    public _3AddressCode() {

    }

    public _3AddressCode(Operation op, Address opr1, Address opr2, Address opr3) {
        operation = op;
        Operand1 = opr1;
        Operand2 = opr2;
        Operand3 = opr3;
    }

    public String toString() {
        if (getOperation() == null) return "";
        
        StringBuffer res = new StringBuffer("(");
        res.append(getOperation().toString()).append(",");
        if (getOperand1() != null) res.append(getOperand1().toString());
        res.append(",");
        if (getOperand2() != null) res.append(getOperand2().toString());
        res.append(",");
        if (getOperand3() != null) res.append(getOperand3().toString());
        res.append(")");

        return res.toString();
    }

    public Address getOperand1()
    {
        return Operand1;
    }

    public Address getOperand2()
    {
        return Operand2;
    }

    public Address getOperand3()
    {
        return Operand3;
    }

    public Operation getOperation()
    {
        return operation;
    }
}
