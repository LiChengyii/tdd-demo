package com.junit.testing;

/**
 *
 * 1.git 代码管理工具使用
 * --1初始化仓库 git init
 * --2 添加代码 git add *
 * --3添加提交备注 git commit -m '第几次体骄傲代码'
 * --4 提交爱代码 git push
 * 5 git账号 注册一个

 */

import java.util.Objects;

public class Colour {


    public final static String DEFAULT_MODEL = "RGB";
    //Color model
    private String model;

    //Color value
    private int value;

    public Colour(String model, int red, int green, int blue){
        testColorValueRange(red, green, blue);
        if(model == null || DEFAULT_MODEL.equals(model)){
            value = 0xff000000 | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | blue & 0xFF;
        }else{
            value = 0;
        }

    }

    public Colour(int rgb) {
        value = 0xff000000 | rgb;
    }

    public int getRGB() {
        return value;
    }

    public int getRed() {
        return (getRGB() >> 16) & 0xFF;
    }

    public int getGreen() {
        return (getRGB() >> 8) & 0xFF;
    }

    public int getBlue() {
        return getRGB() & 0xFF;
    }

    public String toString() {
        return getClass().getName() + ",RGB(" + getRed() + "," + getGreen() + "," + getBlue() + "),0x"
                + Integer.toHexString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Colour colour1 = (Colour) o;
        return value == colour1.value &&
                Objects.equals(model, colour1.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, value);
    }


    private static void testColorValueRange(int r, int g, int b) {
        boolean rangeError = false;
        String badComponentString = "";
        if ( r < 0 || r > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Red";
        }
        if ( g < 0 || g > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Green";
        }
        if ( b < 0 || b > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Blue";
        }
        if ( rangeError == true ) {
            throw new IllegalArgumentException("Color parameter outside of expected range:"
                    + badComponentString);
        }
    }

    public static void main(String args[]) {
        System.out.println(new Colour(Colour.DEFAULT_MODEL, 255, 0, 0).toString()); //红
        System.out.println(new Colour(Colour.DEFAULT_MODEL, 0, 255, 0).toString()); //绿
        System.out.println(new Colour(Colour.DEFAULT_MODEL, 0, 0, 255).toString()); //蓝
        System.out.println(new Colour(Colour.DEFAULT_MODEL, 255, 255, 255).toString()); //白
    }
}