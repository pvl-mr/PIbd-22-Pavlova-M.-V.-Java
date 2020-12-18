package com.company;

import com.company.Parking;
import com.company.Boat;
import com.company.IDopDet;

import javax.swing.*;
import java.awt.*;

public class PanelParking extends JPanel {
    private Parking<Boat, IDopDet> parking;

    public PanelParking(Parking<Boat, IDopDet> parking) {
        this.parking = parking;
    }

    protected void paintComponent(Graphics g) {
        if (parking != null) {
            parking.Draw(g);
        }
    }
}
