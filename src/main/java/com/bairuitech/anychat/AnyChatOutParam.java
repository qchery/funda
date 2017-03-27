package com.bairuitech.anychat;        // 不能修改包的名称

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

    public int GetIntValue() {
        return iValue;
    }

    public void SetIntValue(int v) {
        iValue = v;
    }

    public double GetFloatValue() {
        return fValue;
    }

    public void SetFloatValue(double f) {
        fValue = f;
    }

    public String GetStrValue() {
        return szValue;
    }

    public void SetStrValue(String s) {
        szValue = s;
    }

    public int[] GetIntArray() {
        return intArray;
    }

    public void SetIntArray(int[] a) {
        intArray = a;
    }

    public byte[] GetByteArray() {
        return byteArray;
    }

    public void SetByteArray(byte[] b) {
        byteArray = b;
    }
}

