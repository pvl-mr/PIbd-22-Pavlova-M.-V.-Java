package com.company;

import java.awt.*;

public class FloatOfCatamaran {

    private Float countFloat;

    private int startPosX, startPosY, size;

    public FloatOfCatamaran() {
        countFloat = Float.toFloat(0);
    }

    public void setSize(int size_) {
        size = size_;
    }

    public void setPosition(int posX, int posY){
        startPosX = posX;
        startPosY = posY;
    }

    public void setNumFloat(int numFloat) {
        countFloat = Float.toFloat(numFloat);
    }

    public void draw(Color color, Graphics2D g2) {
        setSize(10);
        if (countFloat == Float.ONE) {
            drawFloat1(g2, color);
        }
        else if(countFloat == Float.TWO) {
            drawFloat2(g2, color);
        } else if(countFloat == Float.THREE){
            drawFloat3(g2, color);
        }
    }

    private void drawFloat1(Graphics2D g2, Color color) {
        Polygon rightF = new Polygon();
        rightF.addPoint(startPosX + 2*size, startPosY+size);
        rightF.addPoint(startPosX + 21*size, startPosY+size);
        rightF.addPoint(startPosX + 22*size, startPosY+2*size);
        rightF.addPoint(startPosX + 21*size, startPosY+3*size);
        rightF.addPoint(startPosX + 2*size, startPosY+3*size);
        rightF.addPoint(startPosX + size, startPosY+2*size);
        g2.setColor(color);
        g2.fillPolygon(rightF);

    }

    private void drawFloat2(Graphics2D g2, Color color) {
        Polygon leftF = new Polygon();
        leftF.addPoint(startPosX + 2*size, startPosY+size+ 9*size);
        leftF.addPoint(startPosX + 21*size, startPosY+size+ 9*size);
        leftF.addPoint(startPosX + 22*size, startPosY+2*size+ 9*size);
        leftF.addPoint(startPosX + 21*size, startPosY+3*size+ 9*size);
        leftF.addPoint(startPosX + 2*size, startPosY+3*size+ 9*size);
        leftF.addPoint(startPosX + size, startPosY+2*size+ 9*size);
        g2.setColor(color);
        g2.fillPolygon(leftF);
        drawFloat1(g2, color);
    }

    private void drawFloat3(Graphics2D g2, Color color) {
        Polygon leftF = new Polygon();
        leftF.addPoint(startPosX + 2*size, startPosY+size+ 11*size);
        leftF.addPoint(startPosX + 21*size, startPosY+size+ 11*size);
        leftF.addPoint(startPosX + 22*size, startPosY+2*size+ 11*size);
        leftF.addPoint(startPosX + 21*size, startPosY+3*size+ 11*size);
        leftF.addPoint(startPosX + 2*size, startPosY+3*size+ 11*size);
        leftF.addPoint(startPosX + size, startPosY+2*size+ 11*size);
        g2.setColor(color);
        g2.fillPolygon(leftF);
        drawFloat2(g2, color);
    }


}
