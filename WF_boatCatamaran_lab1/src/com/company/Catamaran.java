package com.company;

import java.awt.*;

public class Catamaran {

    private int startPosX;
    private int startPosY;
    private int windowWidth;
    private int windowHeight;

    private final int boatWidth = 650;
    private final int boatHeight = 150;
    public int weight;
    public int maxSpeed;
    private FloatOfCatamaran extraFloat;

    public Color mainColor;
    public Color dopColor;
    public boolean sideFloats;

    public Catamaran(int maxSpeed, int weight, Color mainColor, Color dopColor, boolean sideFloats) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.dopColor = dopColor;
        this.sideFloats = sideFloats;
        extraFloat = new FloatOfCatamaran();
    }

    public void setPosition(int x, int y, int width, int height) {
        windowHeight = height;
        windowWidth = width;
        startPosX = x;
        startPosY = y;
        extraFloat.setPosition(x, y);
    }

    public void setCountFloat(int num){
        extraFloat.setNumFloat(num);
    }

    public void moveTransport(Direction direction)
    {
        float step = maxSpeed * 100 / weight;

        switch (direction)
        {
            // вправо
            case Right:

                if (startPosX + step < windowWidth - boatWidth)
                {
                    startPosX += step;
                }
                break;
            //влево
            case Left:
                if (startPosX - step > 0)
                {
                    startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if(startPosY - step > 0)
                {
                    startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (startPosY + step < windowHeight - boatHeight)
                {
                    startPosY += step;
                }
                break;
        }
        extraFloat.setPosition(startPosX, startPosY);
    }

    public void drawTransport(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10.0f));
        Polygon p1 = new Polygon();
        int size = 10;
        int floatSize = 2*size;
        p1.addPoint(startPosX + 2*size, startPosY + 3*size+floatSize);
        p1.addPoint(startPosX + 8*size, startPosY + size+floatSize);
        p1.addPoint(startPosX + 13*size, startPosY + size+floatSize);
        p1.addPoint(startPosX + 21*size, startPosY + 9*size/2+floatSize);
        p1.addPoint(startPosX + 13*size, startPosY + 8*size+floatSize);
        p1.addPoint(startPosX + 8*size, startPosY + 8*size+floatSize);
        p1.addPoint(startPosX + 2*size, startPosY + 6*size+floatSize);
        g2.setColor(mainColor);
        g2.fillPolygon(p1);

        if (sideFloats) {
            extraFloat.draw(dopColor, g2);
        }

    }

}
