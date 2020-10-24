package com.company;

import java.awt.*;

public class Catamaran extends Boat{


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
        Graphics2D g2 = (Graphics2D) g;
        super.drawTransport(g2);

        if (extraDet != null) {
            extraDet.draw(startPosX, startPosY, Color.ORANGE, g2);
        }

    }

    public void setTypeDetails(TypeOfDet detailsType) {
        if (detailsType == TypeOfDet.FLOAT_TYPE1) {
            extraDet = new FloatOfCatamaran();
        } else if (detailsType == TypeOfDet.FLOAT_TYPE2) {
            extraDet = new FloatOfCatamaran_2();
        } else if (detailsType == TypeOfDet.FLOAT_TYPE3) {
            extraDet = new FloatOfCatamaran_3();
        }
    }

    public void setNumDetails(int n) {
        if (extraDet != null)
            extraDet.setNumberOfDetails(n);
    }


}
