package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBoat {

    public JFrame contentFrame;

    private JButton toLeft;
    private JButton toUp;
    private JButton toRight;
    private JButton toDown;
    private JButton createBoat;
    private JButton createCatamaran;
    private JMenu menuTypeDetails;
    private JSpinner spinnerForFloats;
    private TypeOfDet detailsType;

    private ITransport boat;
    private PanelBoat panelForBoat;

    public FormBoat() {
       initialize();
    }

    public void initialize() {
        panelForBoat = new PanelBoat();

        contentFrame = new JFrame();
        contentFrame.setTitle("Catamaran or boat?");
        contentFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        contentFrame.setBounds(100, 100, 1500, 700);
        spinnerForFloats = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
        spinnerForFloats.setBounds(1300, 100,100, 50);
        contentFrame.getContentPane().add(spinnerForFloats);

        toLeft = new JButton("Left");
        toLeft.setBackground(new Color(165, 165, 201));
        toLeft.setActionCommand("bLeft");
        toLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boat.moveTransport(Direction.Left);
                contentFrame.repaint();
            }
        });
        toLeft.setBounds(1100, 550, 100, 50);
        contentFrame.getContentPane().add(toLeft);

        toUp = new JButton("Up");
        toUp.setBackground(new Color(165, 165, 201));
        toUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boat.moveTransport(Direction.Up);
                contentFrame.repaint();
            }
        });
        toUp.setBounds(1200, 500, 100, 50);
        contentFrame.getContentPane().add(toUp);

        toRight = new JButton("Right");
        toRight.setBackground(new Color(165, 165, 201));
        toRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boat.moveTransport(Direction.Right);
                contentFrame.repaint();
            }
        });
        toRight.setBounds(1300, 550, 100, 50);
        contentFrame.getContentPane().add(toRight);

        toDown = new JButton("Down");
        toDown.setBackground(new Color(165, 165, 201));
        toDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boat.moveTransport(Direction.Down);
                contentFrame.repaint();
            }
        });
        toDown.setBounds(1200, 550, 100, 50);
        contentFrame.getContentPane().add(toDown);

        createBoat = new JButton("Boat");
        createBoat.setBackground(new Color(165, 165, 201));
        createBoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boat = new Boat((int) (Math.random() * 800 + 500),
                        (int) (Math.random() * 4000 + 2000),
                        Color.ORANGE);
                boat.setPosition((int) (Math.random() * 200), (int) (Math.random() * 200), contentFrame.getContentPane().getWidth(), contentFrame.getContentPane().getHeight());
                panelForBoat.setBoat(boat);
                contentFrame.repaint();
            }
        });
        createBoat.setBounds(1200, 50,100, 50);
        contentFrame.getContentPane().add(createBoat);

        createCatamaran = new JButton("Catamaran");
        createCatamaran.setBackground(new Color(165, 165, 201));
        createCatamaran.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boat = new Catamaran((int) (Math.random() * 800 + 500),
                        (int) (Math.random() * 4000 + 2000),
                        new Color(255, 207, 135),
                        Color.ORANGE,
                        true);

                ((Catamaran) boat).setTypeDetails(detailsType);
                ((Catamaran) boat).setNumDetails((int) spinnerForFloats.getValue());
                boat.setPosition((int) (Math.random() * 200), (int) (Math.random() * 200), contentFrame.getContentPane().getWidth(), contentFrame.getContentPane().getHeight());
                panelForBoat.setBoat(boat);
                contentFrame.repaint();
            }
        });
        createCatamaran.setBounds(1300, 50,100, 50);
        contentFrame.getContentPane().add(createCatamaran);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(165, 165, 201));
        menuBar.setBounds(1200, 100,100, 50);
        contentFrame.getContentPane().add(menuBar);

        menuTypeDetails = new JMenu("Детали");

        JMenuItem itemOldRadar = new JMenuItem("Поплавки 1-го типа");
        itemOldRadar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailsType = TypeOfDet.FLOAT_TYPE1;
                menuTypeDetails.setText("Поплавки 1-го типа");
            }
        });
        menuTypeDetails.add(itemOldRadar);

        JMenuItem itemNewRadar = new JMenuItem("Поплавки 2-го типа");
        itemNewRadar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailsType = TypeOfDet.FLOAT_TYPE2;
                menuTypeDetails.setText("Поплавки 2-го типа");

            }
        });
        menuTypeDetails.add(itemNewRadar);

        JMenuItem itemLines = new JMenuItem("Поплавки 3-го типа");
        itemLines.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailsType = TypeOfDet.FLOAT_TYPE3;
                menuTypeDetails.setText("Поплавки 3-го типа");
            }
        });
        menuTypeDetails.add(itemLines);
        menuBar.add(menuTypeDetails);
        contentFrame.getContentPane().add(panelForBoat);
    }

    public void setBoat(ITransport boat) {
        this.boat = boat;
        boat.setPosition((int) (Math.random() * 200), (int) (Math.random() * 200), contentFrame.getContentPane().getWidth(), contentFrame.getContentPane().getHeight());
        panelForBoat.setBoat(boat);
        contentFrame.repaint();
    }




}
