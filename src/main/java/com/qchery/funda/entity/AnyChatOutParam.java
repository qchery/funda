package com.qchery.funda.entity;

/**
 * 通用函数返回参数类
 * AnyChat内核调用Set方法设置参数，上层应用通过Get方法获取值
 */
public class AnyChatOutParam {
    private int iValue = 0;
    private String szValue = "";
    private int[] intArray;
    private byte[] byteArray;
    private double fValue = 0.0;

    public int getiValue() {
        return iValue;
    }

    public void setiValue(int iValue) {
        this.iValue = iValue;
    }

    public String getSzValue() {
        return szValue;
    }

    public void setSzValue(String szValue) {
        this.szValue = szValue;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public void setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    public double getfValue() {
        return fValue;
    }

    public void setfValue(double fValue) {
        this.fValue = fValue;
    }
}

