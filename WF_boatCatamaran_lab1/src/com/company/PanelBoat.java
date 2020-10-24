package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelBoat extends JPanel {

    ITransport boat;

    public PanelBoat(ITransport boat) {
        this.boat = boat;
    }

    public void paint(Graphics g) {
        super.paint(g);
        boat.drawTransport(g);
    }


}
