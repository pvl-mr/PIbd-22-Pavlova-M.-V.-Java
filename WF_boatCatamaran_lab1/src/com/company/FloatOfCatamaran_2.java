package com.company;

import java.awt.*;

public class FloatOfCatamaran_2 implements IDopDet{

    private Detail countFloat;
    private int size;

    public FloatOfCatamaran_2() {
        countFloat = Detail.toNum(0);
    }

    public void setSize(int size_) {
        size = size_;
    }

    public void setNumberOfDetails(int numFloat) {
        if (numFloat > 3) {
            numFloat = 3;
        }
        if (numFloat < 0) {
            numFloat = 0;
        }
        countFloat = Detail.toNum(numFloat);
    }

    public void draw(int startPosX, int startPosY, Color color, Graphics2D g2) {
        setSize(10);
        if (countFloat == Detail.ONE) {
            drawFloat1(startPosX, startPosY, g2, color);
        }
        else if(countFloat == Detail.TWO) {
            drawFloat2(startPosX, startPosY, g2, color);
        } else if(countFloat == Detail.THREE){
            drawFloat3(startPosX, startPosY, g2, color);
        }
    }

    private void drawFloat1(int startPosX, int startPosY, Graphics2D g2, Color color) {
        Polygon rightF = new Polygon();
        rightF.addPoint(startPosX + 2*size, startPosY+size);
        rightF.addPoint(startPosX + 21*size, startPosY+size);
        rightF.addPoint(startPosX + 21*size, startPosY+3*size);
        rightF.addPoint(startPosX + 2*size, startPosY+3*size);
        g2.setColor(color);
        g2.fillPolygon(rightF);

    }

    private void drawFloat2(int startPosX, int startPosY, Graphics2D g2, Color color) {
        Polygon leftF = new Polygon();
        leftF.addPoint(startPosX + 2*size, startPosY+size+ 9*size);
        leftF.addPoint(startPosX + 21*size, startPosY+size+ 9*size);
        leftF.addPoint(startPosX + 21*size, startPosY+3*size+ 9*size);
        leftF.addPoint(startPosX + 2*size, startPosY+3*size+ 9*size);
        g2.setColor(color);
        g2.fillPolygon(leftF);
        drawFloat1(startPosX, startPosY, g2, color);
    }

    private void drawFloat3(int startPosX, int startPosY,Graphics2D g2, Color color) {
        Polygon leftF = new Polygon();
        leftF.addPoint(startPosX + 2*size, startPosY+size+ 11*size);
        leftF.addPoint(startPosX + 21*size, startPosY+size+ 11*size);
        leftF.addPoint(startPosX + 21*size, startPosY+3*size+ 11*size);
        leftF.addPoint(startPosX + 2*size, startPosY+3*size+ 11*size);
        g2.setColor(color);
        g2.fillPolygon(leftF);
        drawFloat2(startPosX, startPosY, g2, color);
    }


}
