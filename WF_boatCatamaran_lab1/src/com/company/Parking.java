package com.company;

import java.awt.*;

public class Parking<T extends ITransport, T2 extends IDopDet> {
    private final Object[] places;

    private final int pictureWidth;

    private final int pictureHeight;

    private final int placeSizeWidth = 500;

    private final int placeSizeHeight = 170;

    public Parking(int picWidth, int picHeight) {
        int width = picWidth / placeSizeWidth;
        int height = picHeight / placeSizeHeight;
        places = new Object[width * height];
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }

    public boolean add(T boat) {
        int numberOfString = pictureHeight / placeSizeHeight;
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                boat.setPosition((i / numberOfString) *placeSizeWidth+10, (i % numberOfString)*placeSizeHeight+15, pictureWidth, pictureHeight);
                places[i] = boat;
                return true;
            }
        }
        return false;
    }

    public T delete(int index) {
        if (index >= places.length || index < 0 || places[index] == null) {
            return null;
        }
        Object pl = places[index];
        places[index] = null;
        return (T) pl;
    }

    public void Draw(Graphics g)
    {
        DrawMarking(g);

        for (int i = 0; i < places.length; i++) {
            if (places[i] != null) {
                ((T) places[i]).drawTransport(g);
            }

        }
    }

    private void DrawMarking(Graphics g)
    {

        for (int i = 0; i < pictureWidth / placeSizeWidth; i++)
        {
            for (int j = 0; j < pictureHeight / placeSizeHeight + 1; ++j)
            {//линия рамзетки места
                g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + placeSizeWidth / 2, j * placeSizeHeight);
            }
            g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, (pictureHeight / placeSizeHeight) * placeSizeHeight);
        }
    }

    public int countPlaces() {
        int numberOfPlaces = 0;
        for (int i = 0; i < places.length; i++) {
            if (places[i] != null) {
                numberOfPlaces++;
            }
        }
        return numberOfPlaces;
    }

    public boolean more(int number) {
        return countPlaces() > number;
    }

    public boolean less(int number) {
        return countPlaces() < number;
    }

}
