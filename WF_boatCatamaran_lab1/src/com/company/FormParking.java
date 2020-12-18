package com.company;

import com.company.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FormParking {

    public JFrame contentFrame;
    private JPanel contentPane;
    private JButton bParkBoat;
    private JButton bParkCatamaran;
    private JLabel labelForTaking;
    private JLabel labelForPlacing;
    private JButton bTake;
    private JTextField textFieldPlacing;
    private Parking<Boat, IDopDet> parking;
    private PanelParking parkingPanel;

    public FormParking() {
        contentFrame = new JFrame();
        contentPane = new JPanel();
        bParkBoat = new JButton("Park the boat");
        bParkCatamaran = new JButton("Park the catamaran");
        labelForTaking = new JLabel("Take transport");
        labelForPlacing = new JLabel("Place");
        bTake = new JButton("Take");
        textFieldPlacing = new JTextField();
        parking = new Parking<Boat, IDopDet>(1000, 800);
        parkingPanel = new PanelParking(parking);
        initialize();
    }

    public void initialize() {

        contentFrame.setTitle("Parking");
        contentFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentFrame.setBounds(100, 100, 1150, 719);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        labelForTaking.setBounds(966, 185, 150, 50);
        labelForPlacing.setBounds(966, 220, 80, 50);
        textFieldPlacing.setBounds(1009, 230, 100, 25);
        bTake.setBounds(966, 260, 159, 54);
        contentPane.add(labelForTaking);
        contentPane.add(labelForPlacing);
        contentPane.add(bTake);
        contentPane.add(textFieldPlacing);

        bParkBoat.setBounds(959, 27, 159, 54);
        bParkCatamaran.setBounds(959, 103, 159, 54);
        contentPane.add(bParkBoat);
        contentPane.add(bParkCatamaran);

        parkingPanel.setBounds(0, 0, 800, 800);
        contentPane.add(parkingPanel);

        bParkBoat.addActionListener(e -> bParkBoat_click());
        bParkCatamaran.addActionListener(e -> bParkCatamaran_Click());
        bTake.addActionListener(e -> bTake_Click());

    }

    private void bParkBoat_click() {
        JColorChooser colorDialog = new JColorChooser();
        JOptionPane.showMessageDialog(contentFrame, colorDialog);
        if (colorDialog.getColor() != null) {
            var boat = new Boat(100, 1000, colorDialog.getColor());
            if (parking.add(boat)) {
                contentFrame.repaint();
            } else {
                JOptionPane.showMessageDialog(contentFrame, "Парковка переполнена");
            }
        }
    }

    private void bParkCatamaran_Click() {
        JColorChooser colorDialog = new JColorChooser();
        JOptionPane.showMessageDialog(contentFrame, colorDialog);
        if (colorDialog.getColor() != null) {
            JColorChooser otherColorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(contentFrame, otherColorDialog);
            if (otherColorDialog.getColor() != null) {
                var catamaran = new Catamaran(100, 1000, colorDialog.getColor(), otherColorDialog.getColor(), true);
                if (parking.add(catamaran)) {
                    contentFrame.repaint();
                } else {
                    JOptionPane.showMessageDialog(contentFrame, "Стоянка переполнена");
                }
            }
        }
    }

    private void bTake_Click() {
        if (textFieldPlacing.getText() != "") {
            var boat = parking.delete(Integer.parseInt(textFieldPlacing.getText()));
            if (boat != null) {
                FormBoat formBoat = new FormBoat();
                formBoat.contentFrame.setVisible(true);
                formBoat.setBoat(boat);
                contentFrame.repaint();
            }
        }
    }


}
