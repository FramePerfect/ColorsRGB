package com.example.colorsrgb;

public class ColorInfo {
    //Need rgb value and hex code

    private int red;
    private int green;
    private int blue;
    private String hex;

    //constructors
    public ColorInfo() {

    }

    public ColorInfo(int r, int g, int b, String h) {
        red = r;
        green = g;
        blue = b;
        hex = h;
    }

    //getters/setters

    public int getRed()
    {
        return red;
    }

    public int getGreen()
    {
        return green;
    }

    public int getBlue()
    {
        return blue;
    }

    public String getHex()
    {
        return hex;
    }

    public void setRed(int red)
    {
        this.red = red;
    }

    public void setGreen(int green)
    {
        this.green = green;
    }

    public void setBlue(int blue)
    {
        this.blue = blue;
    }

    public void setHex(String hex)
    {
        this.hex = hex;
    }
}