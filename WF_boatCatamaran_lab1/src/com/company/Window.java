package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {

    public JFrame contentFrame;
    private JPanel panelForButton;
    private JPanel panelForBoat;
    private JPanel contentPane;

    private JButton toLeft;
    private JButton toUp;
    private JButton toRight;
    private JButton toDown;
    private JButton createBoat;
    private JButton createCatamaran;
    private JSpinner spinnerForFloats;
    private JMenu menuTypeDetails;
    private TypeOfDet detailsType;

    private ITransport boat;

    public Window() {
       initialize();
    }

    public void initialize() {
        contentFrame = new JFrame();
        contentFrame.setTitle("Catamaran or boat?");
        contentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentFrame.setBounds(100, 100, 1500, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        spinnerForFloats = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
        spinnerForFloats.setBounds(1300, 100,100, 50);
        contentPane.add(spinnerForFloats);

        toLeft = new JButton("Left");
        toLeft.setBackground(new Color(165, 165, 201));
        toLeft.setActionCommand("bLeft");
        toLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boat.moveTransport(Direction.Left);

                panelForBoat.repaint();
            }
        });
        toLeft.setBounds(1100, 550, 100, 50);
        contentPane.add(toLeft);

        toUp = new JButton("Up");
        toUp.setBackground(new Color(165, 165, 201));
        toUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boat.moveTransport(Direction.Up);
                panelForBoat.repaint();
            }
        });
        toUp.setBounds(1200, 500, 100, 50);
        contentPane.add(toUp);

        toRight = new JButton("Right");
        toRight.setBackground(new Color(165, 165, 201));
        toRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boat.moveTransport(Direction.Right);
                panelForBoat.repaint();
            }
        });
        toRight.setBounds(1300, 550, 100, 50);
        contentPane.add(toRight);

        toDown = new JButton("Down");
        toDown.setBackground(new Color(165, 165, 201));
        toDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boat.moveTransport(Direction.Down);
                panelForBoat.repaint();
            }
        });
        toDown.setBounds(1200, 550, 100, 50);
        contentPane.add(toDown);

        createBoat = new JButton("Boat");
        createBoat.setBackground(new Color(165, 165, 201));
        createBoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boat = new Boat((int) (Math.random() * 800 + 500),
                        (int) (Math.random() * 4000 + 2000),
                        Color.ORANGE);


                boat.setPosition((int) (Math.random() * 200), (int) (Math.random() * 200), contentPane.getWidth(), contentPane.getHeight());
                panelForBoat = new PanelBoat(boat);
                panelForBoat.setBounds(5, 5, 1050, 650);
                panelForBoat.setBackground(new Color(165, 165, 201));
                contentFrame.getContentPane().add(panelForBoat);
                panelForBoat.repaint();
            }
        });
        createBoat.setBounds(1200, 50,100, 50);
        contentPane.add(createBoat);

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

                boat.setPosition((int) (Math.random() * 200), (int) (Math.random() * 200), contentPane.getWidth(), contentPane.getHeight());
                panelForBoat = new PanelBoat(boat);
                panelForBoat.setBounds(5, 5, 1050, 650);
                panelForBoat.setBackground(new Color(165, 165, 201));
                contentFrame.getContentPane().add(panelForBoat);
                panelForBoat.repaint();
            }
        });
        createCatamaran.setBounds(1300, 50,100, 50);
        contentPane.add(createCatamaran);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(165, 165, 201));
        menuBar.setBounds(1200, 100,100, 50);
        contentPane.add(menuBar);

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

    }


}
