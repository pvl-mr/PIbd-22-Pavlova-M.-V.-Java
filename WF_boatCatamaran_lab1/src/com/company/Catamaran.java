package com.company;

import java.awt.*;

public class Catamaran extends Boat {

    private IDopDet extraDet;
    public Color mainColor;
    public Color dopColor;
    public boolean sideFloats;

    public Catamaran(int maxSpeed, int weight, Color mainColor, Color dopColor, boolean sideFloats) {
        super(maxSpeed, weight, mainColor);
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.dopColor = dopColor;
        this.sideFloats = sideFloats;
    }

    public void drawTransport(Graphics g) {
        int startPosX = (int) this.startPosX;
        int startPosY = (int) this.startPosY;
        int size = 10;
        Graphics2D g2 = (Graphics2D) g;
        super.drawTransport(g2);

        if (sideFloats) {
            Polygon rightF = new Polygon();
            rightF.addPoint(startPosX + 2*size, startPosY+size);
            rightF.addPoint(startPosX + 21*size, startPosY+size);
            rightF.addPoint(startPosX + 22*size, startPosY+2*size);
            rightF.addPoint(startPosX + 21*size, startPosY+3*size);
            rightF.addPoint(startPosX + 2*size, startPosY+3*size);
            rightF.addPoint(startPosX + size, startPosY+2*size);
            g2.setColor(dopColor);
            g2.fillPolygon(rightF);
            Polygon leftF = new Polygon();
            leftF.addPoint(startPosX + 2*size, startPosY+size+ 9*size);
            leftF.addPoint(startPosX + 21*size, startPosY+size+ 9*size);
            leftF.addPoint(startPosX + 22*size, startPosY+2*size+ 9*size);
            leftF.addPoint(startPosX + 21*size, startPosY+3*size+ 9*size);
            leftF.addPoint(startPosX + 2*size, startPosY+3*size+ 9*size);
            leftF.addPoint(startPosX + size, startPosY+2*size+ 9*size);
            g2.setColor(dopColor);
            g2.fillPolygon(leftF);
        }

    }

    public void setTypeDetails(TypeOfDet detailsType) {
        if (detailsType == TypeOfDet.FLOAT_TYPE1) {
            extraDet = new FloatOfCatamaranRectangular();
        } else if (detailsType == TypeOfDet.FLOAT_TYPE2) {
            extraDet = new FloatOfCatamaranSharp();
        } else if (detailsType == TypeOfDet.FLOAT_TYPE3) {
            extraDet = new FloatOfCatamaranMixed();
        }
    }

    public void setNumDetails(int n) {
        if (extraDet != null)
            extraDet.setNumberOfDetails(n);
    }
}
