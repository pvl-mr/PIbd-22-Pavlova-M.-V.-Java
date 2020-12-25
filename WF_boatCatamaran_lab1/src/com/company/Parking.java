package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Parking<T extends ITransport, T2 extends IDopDet> {

    private final List<T> places;
    private final int maxCount;

    private final int pictureWidth;

    private final int pictureHeight;

    private final int placeSizeWidth = 500;

    private final int placeSizeHeight = 170;

    public Parking(int picWidth, int picHeight) {
        int width = picWidth / placeSizeWidth;
        int height = picHeight / placeSizeHeight;
        maxCount = width * height;
        pictureWidth = picWidth;
        pictureHeight = picHeight;
        places = new ArrayList<>();
    }

    public boolean add(T boat) {
        if (places.size() < maxCount) {
            places.add(boat);
            return true;
        }
        return false;
    }

    public T delete(int index) {
        if (index < 0 || index > maxCount || places.get(index) == null) {
            return null;
        }
        T boat = places.get(index);
        places.remove(index);
        return boat;
    }

    public void Draw(Graphics g)
    {
        DrawMarking(g);
        int numberOfString = pictureHeight / placeSizeHeight;
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) != null) {
                places.get(i).setPosition((i / numberOfString) *placeSizeWidth+10, (i % numberOfString)*placeSizeHeight+15, pictureWidth, pictureHeight);
                places.get(i).drawTransport(g);
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
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i) != null) {
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

    public T get(int index) {
        if (index >= 0 && index < places.size()) {
            return places.get(index);
        }
        return null;
    }

}
