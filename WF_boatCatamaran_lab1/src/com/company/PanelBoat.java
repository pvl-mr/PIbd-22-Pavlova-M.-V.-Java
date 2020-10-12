package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelBoat extends JPanel {

    Catamaran boat;

    public PanelBoat(Catamaran boat) {
        this.boat = boat;
    }

    public void paint(Graphics g) {
        super.paint(g);
        boat.drawTransport(g);
    }


}
