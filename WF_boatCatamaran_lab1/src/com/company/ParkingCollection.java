package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParkingCollection {
    private final Map<String, Parking<ITransport, IDopDet>> parkingStages;
    private final int pictureWidth;
    private final int pictureHeight;

    public ParkingCollection(int pictureWidth, int pictureHeight) {
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
        parkingStages = new HashMap<>();
    }

    public Set<String> getKeys() {
        return parkingStages.keySet();
    }

    public void addParking(String name)
    {
        if (parkingStages.containsKey(name))
        {
            return;
        }
        parkingStages.put(name, new Parking<>(pictureWidth, pictureHeight));

    }

    public Parking<ITransport, IDopDet> get(String name) {
        if (parkingStages.containsKey(name))
        {
            return parkingStages.get(name);
        }
        return null;
    }

    public void deleteParking(String name) {
        parkingStages.remove(name);
    }

    public ITransport get(String name, int index) {
        if (parkingStages.containsKey(name)) {
            return parkingStages.get(name).get(index);
        }
        return null;
    }
}
