package com.company;

import java.awt.*;

public class Boat extends SwimmingTransport {

    protected int boatWidth = 385;
    protected int boatHeight = 150;

    public Boat(int maxSpeed, float weight, Color mainColor)
    {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
    }

    protected Boat(int maxSpeed, float weight, Color mainColor, int carWidth, int carHeight)
    {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.boatWidth = carWidth;
        this.boatHeight = carHeight;
    }

    @Override
    public void moveTransport(Direction direction)
    {
        float step = maxSpeed * 100 / weight;
        switch (direction)
        {
            // вправо
            case Right:
                if (startPosX + step < pictureWidth - boatWidth)
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
                if (startPosY - step > 0)
                {
                    startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (startPosY + step < pictureHeight - boatHeight)
                {
                    startPosY += step;
                }
                break;
        }
    }

    @Override
    public void drawTransport(Graphics g)
    {
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
    }
}
