package com.example.gli.Exer.Day14.Exer4;

public class MyRectangle extends GeometricObject{
    private double width;//宽
    private double heigth;//高
    public MyRectangle(String color , double weight , double width , double heigth){
        super(color,weight);
        this.heigth = heigth;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    @Override
    public double findArea() {
        return heigth*width;
    }
}
