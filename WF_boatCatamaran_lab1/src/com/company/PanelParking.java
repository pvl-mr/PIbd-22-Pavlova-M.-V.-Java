package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelParking extends JPanel {
    private final ParkingCollection parkingCollection;
    private String selectedItem = null;

    public PanelParking(ParkingCollection parkingCollection) {
        this.parkingCollection = parkingCollection;
    }

    protected void paintComponent(Graphics g) {
        if (selectedItem != null && parkingCollection != null) {
            parkingCollection.get(selectedItem).Draw(g);
        }
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
}
