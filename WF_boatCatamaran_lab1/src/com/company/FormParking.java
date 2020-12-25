package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Stack;

public class FormParking {

    public JFrame contentFrame;
    private JPanel contentPane;
    private JButton bParkBoat;
    private JButton bParkCatamaran;
    private JLabel labelForTaking;
    private JLabel labelForPlacing;
    private JButton bTakeFromStack;
    private JButton bPutIntoStack;
    private JButton bAddParking;
    private JButton bDeleteParking;
    private JTextField textFieldPlacing;
    private JTextField textFieldParking;
    private ParkingCollection parkingCollection;
    private PanelParking parkingPanel;
    private JList<String> listBoxParking;
    private DefaultListModel<String> listParking;
    private Stack<Boat> stackBoat;

    public FormParking() {
        stackBoat = new Stack<>();
        listParking = new DefaultListModel<>();
        listBoxParking = new JList<>(listParking);
        contentFrame = new JFrame();
        contentPane = new JPanel();
        bParkBoat = new JButton("Park the boat");
        bParkCatamaran = new JButton("Park the catamaran");
        labelForTaking = new JLabel("Take transport");
        labelForPlacing = new JLabel("Place");
        bTakeFromStack = new JButton("Take from stack");
        bPutIntoStack = new JButton("Put into stack");
        bAddParking = new JButton("Добавить стоянку");
        bDeleteParking = new JButton("Удалить стоянку");
        textFieldParking = new JTextField();
        textFieldPlacing = new JTextField();
        parkingCollection = new ParkingCollection(1000, 1000);
        parkingPanel = new PanelParking(parkingCollection);
        initialize();
    }

    public void initialize() {

        contentFrame.setTitle("Parking");
        contentFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentFrame.setBounds(100, 100, 1150, 750);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        labelForTaking.setBounds(959, 185, 150, 50);
        labelForPlacing.setBounds(959, 220, 80, 50);
        textFieldPlacing.setBounds(1009, 230, 100, 25);
        bTakeFromStack.setBounds(959, 260, 159, 50);
        bPutIntoStack.setBounds(959, 320, 159, 50);
        contentPane.add(labelForTaking);
        contentPane.add(labelForPlacing);
        contentPane.add(bTakeFromStack);
        contentPane.add(textFieldPlacing);
        contentPane.add(bPutIntoStack);

        bParkBoat.setBounds(959, 27, 159, 54);
        bParkCatamaran.setBounds(959, 103, 159, 54);
        contentPane.add(bParkBoat);
        contentPane.add(bParkCatamaran);

        parkingPanel.setBounds(0, 0, 800, 800);
        contentPane.add(parkingPanel);

        bParkBoat.addActionListener(e -> bParkBoat_click());
        bParkCatamaran.addActionListener(e -> bParkCatamaran_Click());
        bTakeFromStack.addActionListener(e -> bTakeFromStack_click());
        bPutIntoStack.addActionListener(e -> bPutIntoStack_click());

        textFieldParking.setBounds(959, 420, 159, 20);
        contentPane.add(textFieldParking);

        listBoxParking.setBounds(959, 440, 159, 150);
        contentPane.add(listBoxParking);
        listBoxParking.addListSelectionListener(e -> {
            changeItemList();
        });

        bAddParking.setBounds(959, 590, 159, 54);
        bDeleteParking.setBounds(959, 650, 159, 54);
        contentPane.add(bAddParking);
        contentPane.add(bDeleteParking);

        bAddParking.addActionListener(e -> {
            addParking();
        });

        bDeleteParking.addActionListener(e -> {
            deleteParking();
        });

    }

    private void bParkBoat_click() {
        if (listBoxParking.getSelectedIndex() >= 0) {
            JColorChooser colorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(contentFrame, colorDialog);
            if (colorDialog.getColor() != null) {
                var boat = new Boat(100, 1000, colorDialog.getColor());
                if (parkingCollection.get(listBoxParking.getSelectedValue()).add(boat)) {
                    contentFrame.repaint();
                } else {
                    JOptionPane.showMessageDialog(contentFrame, "Парковка переполнена");
                }
            }
        }

    }

    private void bParkCatamaran_Click() {
        if (listBoxParking.getSelectedIndex() >= 0) {
            JColorChooser colorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(contentFrame, colorDialog);
            if (colorDialog.getColor() != null) {
                JColorChooser otherColorDialog = new JColorChooser();
                JOptionPane.showMessageDialog(contentFrame, otherColorDialog);
                if (otherColorDialog.getColor() != null) {
                    var catamaran = new Catamaran(100, 1000, colorDialog.getColor(), otherColorDialog.getColor(), true);
                    String selectedParking = listBoxParking.getSelectedValue();
                    if (parkingCollection.get(selectedParking).add(catamaran)) {
                        contentFrame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(contentFrame, "Стоянка переполнена");
                    }
                }
            }
        }
    }

    private void bTakeFromStack_click() {
        if (!stackBoat.empty()) {
            FormBoat formBoat = new FormBoat();
            formBoat.contentFrame.setVisible(true);
            formBoat.setBoat(stackBoat.pop());
            contentFrame.repaint();
        }
    }

    private void bPutIntoStack_click() {
        if (listBoxParking.getSelectedIndex() >= 0) {
            if (textFieldPlacing.getText() != "") {
                try {
                    Boat swimmingTransport = (Boat)parkingCollection.get(listBoxParking.getSelectedValue()).delete(Integer.parseInt(textFieldPlacing.getText()));
                    if (swimmingTransport != null) {
                        stackBoat.push(swimmingTransport);
                        contentFrame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(contentFrame, "Не существующий транспорт", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(contentFrame, "Не существующий транспорт", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(contentFrame, "Стоянка не выбрана", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void addParking() {
        if (!textFieldParking.getText().equals("")) {
            parkingCollection.addParking(textFieldParking.getText());
            reloadLevels();
            contentFrame.repaint();
        }
        else {
            JOptionPane.showMessageDialog(contentFrame, "Введите название стоянки", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteParking() {
        if (listBoxParking.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(contentFrame, "Удалить стоянку " + listBoxParking.getSelectedValue() + "?", "Удаление",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                parkingCollection.deleteParking(listBoxParking.getSelectedValue());
                reloadLevels();
                contentFrame.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(contentFrame, "Стоянка не выбрана", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reloadLevels() {
        int index = listBoxParking.getSelectedIndex();
        listParking.removeAllElements();
        int i = 0;
        for (String name : parkingCollection.getKeys()) {
            listParking.add(i, name);
            i++;
        }
        int itemsCount = listParking.size();
        if (itemsCount < 0 && (index < 0 || index >= itemsCount)) {
            listBoxParking.setSelectedIndex(0);
        }
        else if (index > 0 && index < itemsCount) {
            listBoxParking.setSelectedIndex(index);
        }
    }

    private void changeItemList() {
        parkingPanel.setSelectedItem(listBoxParking.getSelectedValue());
        contentFrame.repaint();
    }

}
