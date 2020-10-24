package com.company;

import java.awt.*;

public class SeparationLines implements IDopDet{

    private Detail countLines;
    private int size = 10;
    private int floatSize = 10;

    public SeparationLines() {
        countLines = Detail.toNum(0);
    }

    public void setNumberOfDetails(int numFloat) {
        if (numFloat > 3) {
            numFloat = 3;
        }
        if (numFloat < 0) {
            numFloat = 0;
        }
        countLines = Detail.toNum(numFloat);
    }

    public void draw(int startPosX, int startPosY, Color color, Graphics2D g2) {
        if (countLines == Detail.ONE) {
            drawLine1(startPosX, startPosY, g2, color);
        }
        else if(countLines == Detail.TWO) {
            drawLine2(startPosX, startPosY, g2, color);
        } else if(countLines == Detail.THREE){
            drawLine3(startPosX, startPosY, g2, color);
        }
    }

    private void drawLine1(int startPosX, int startPosY, Graphics2D g2, Color color) {
        g2.setColor(Color.GRAY);
        g2.drawLine(startPosX + 8*size, startPosY + 2*size+floatSize, startPosX + 8*size, startPosY + 9*size+floatSize );
    }

    private void drawLine2(int startPosX, int startPosY, Graphics2D g2, Color color) {
        g2.setColor(Color.GRAY);
        g2.drawLine(startPosX + 13*size, startPosY + 2*size+floatSize, startPosX + 13*size, startPosY + 9*size+floatSize);
        drawLine1(startPosX, startPosY, g2, color);
    }

    private void drawLine3(int startPosX, int startPosY,Graphics2D g2, Color color) {
        g2.setColor(Color.GRAY);
        g2.drawLine(startPosX + 17*size, startPosY + 3*size+floatSize+5, startPosX + 17*size, startPosY + 8*size+floatSize-5);
        drawLine2(startPosX, startPosY, g2, color);
    }


}
