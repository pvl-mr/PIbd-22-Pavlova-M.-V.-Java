package com.company;

import com.company.ITransport;

import javax.swing.*;
import java.awt.*;

public class PanelBoat extends JPanel {

    private ITransport boat;

    public void paintComponent(Graphics g) {
        if (boat != null) {
            boat.drawTransport(g);
        }
    }

    public void setBoat(ITransport boat) {
        this.boat = boat;
    }

    public ITransport getBoat() {
        return boat;
    }
}
