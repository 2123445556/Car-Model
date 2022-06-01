import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultTextUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener {
    JFrame frame;
    JMenuItem item1;
    JMenuItem item2;
    JPanel panel;
    JScrollPane scroll;
    JTable table;
    DefaultTableModel model;
    Object[] columns = {"Image", "Brand", "Package", "Color", "Location", "Price"};
    ArrayList<Car> ref;
    JMenuItem item7;
    Car nar;
    ArrayList<Car> c;
    int nm = 0;
    DefaultTableModel model1;
    JTable table2;



    // Constructs the Frame that will be used to display the list of cars.
    public Frame(){
        // The arraylist is initialized and contains all the default cars the dealership would have and
        ref = new ArrayList<Car>();
        c = new ArrayList<Car>();
        ImageIcon j = new ImageIcon("src/d652f441-4f18-42a3-857b-8fb855515bab.jpeg");
        Image image = j.getImage();
        Image newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Toyota", "Standard", "Black", "Miami, FL", 7000.0 ));
        j = new ImageIcon("src/images.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);  // transform it back
        c.add(new Car(j, "Chevrolet", "Standard", "Grey", "Miami, FL", 7500.0 ));
        j = new ImageIcon("src/honda.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Honda", "Standard", "White", "Miami, FL", 8000.0 ));
        j = new ImageIcon("src/porsche.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Porsche", "Premium", "Black", "Miami, FL", 20000.0 ));
        j = new ImageIcon("src/lexus.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Lexus", "Deluxe", "White", "Miami, FL", 10000.0 ));
        j = new ImageIcon("src/ford.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Ford", "Premium", "Black", "Miami, FL", 30000.0 ));
        j = new ImageIcon("src/volks.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Volkswagen", "Deluxe", "White", "Miami, FL", 10000.0 ));
        j = new ImageIcon("src/mustang.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Ford", "Deluxe", "Black", "Miami, FL", 20000.0 ));
        j = new ImageIcon("src/download.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Kia", "Standard", "Red", "Miami, FL", 7000.0 ));
        j = new ImageIcon("src/nuova-porsche-911-gt3-2021.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Porsche", "Premium", "Blue", "Miami, FL", 10000.0 ));
        j = new ImageIcon("src/kia.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Kia", "Deluxe", "Green", "Miami, FL", 100000.0 ));
        j = new ImageIcon("src/volks.jpeg");
        image = j.getImage();
        newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH);
        j = new ImageIcon(newimg);
        c.add(new Car(j, "Volkswagen", "Deluxe", "White", "Miami, FL", 10000.0 ));
        c.add(new Car(j, "Volkswagen", "Premium", "White", "Miami, FL", 7000.0 ));
        c.add(new Car(j, "Volkswagen", "Deluxe", "White", "Miami, FL", 10000.0 ));
        c.add(new Car(j, "Volkswagen", "Premium", "White", "Miami, FL", 8000.0 ));
        ref = c;
        frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBackground(Color.DARK_GRAY);
        nar = new Car();


        // Creates the Menu bar that contains the options to add or remove a car either manually or based
        // on a certain aspect of the car.
        JMenuBar m = new JMenuBar();
        JMenu n = new JMenu("Filter");
        item1 = new JMenuItem("Remove by Color");
        item1.addActionListener(this :: actionPerformed);

        item2 = new JMenuItem("Remove by Package");
        item2.addActionListener(this :: actionPerformed);



        item7 = new JMenuItem("Display by Brand");
        item7.addActionListener(this :: actionPerformed);

        n.add(item1);
        n.add(item2);
        n.add(item7);
        m.add(n);

        JMenu menu = new JMenu("Specific");
        JMenuItem item8 = new JMenuItem("Remove a car");
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                int k = 0;
                if(table2 != null) {
                    k = table2.getSelectedRow();
                }
                if(i >= 0) {
                    model.removeRow(k);
                    c.remove(k);
                    JOptionPane.showMessageDialog(null, "Car has been removed!");
                }
                else if(k >= 0){
                    model1.removeRow(k);
                    c.remove(k);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select a car on the table to be removed!");
                }
            }
        });
        JMenu bn = new JMenu();
        m.add(bn);
        // This menu Item is to purchase a car from the dealership and has a method that displays a message
        // to the user for purchasing the car.
        JMenuItem item9 = new JMenuItem("Purchase a car");
        item9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                int k = 0;
                if(table2 != null) {
                    k = table2.getSelectedRow();
                }
                if(i >= 0) {
                    model.removeRow(i);
                    c.remove(i);
                    JOptionPane.showMessageDialog(null, "Congratulations you now own this car");
                    nm++;
                    bn.setText("Cars purchased: " + nm);
                }
                else if(k >= 0){
                    model1.removeRow(k);
                    c.remove(k);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select a car on the table to be purchases!");
                }
            }
        });
        // Adds a car by asking you a set of questions about the car.
        JMenuItem item10 = new JMenuItem("Add a car");
        item10.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                         String ve = JOptionPane.showInputDialog(null, "Enter Brand", "Adding a car", JOptionPane.PLAIN_MESSAGE).toString();
                                         String vc = JOptionPane.showInputDialog(null, "Enter Package", "Adding a car", JOptionPane.PLAIN_MESSAGE).toString();
                                         String vm = JOptionPane.showInputDialog(null, "Enter Color", "Adding a car", JOptionPane.PLAIN_MESSAGE).toString();
                                         String vn = JOptionPane.showInputDialog(null, "Enter Location", "Adding a car", JOptionPane.PLAIN_MESSAGE).toString();
                                         double vu = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Price", "Adding a car", JOptionPane.PLAIN_MESSAGE));
                                         c.add(new Car("None", ve, vc, vm, vn, vu));
                                         Object[] row = {"None", ve, vc, vm, vn, vu};
                                         model.addRow(row);
                                         if(model1 != null){
                                             model1.addRow(row);
                                         }
                                     }
                                 });
        menu.add(item9);
        menu.add(item8);
        menu.add(item10);
        m.add(menu);




        model = new DefaultTableModel()
        {

            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        model.setColumnIdentifiers(columns);
        // adds all the information in the arraylist to the JTable.

        for(int i = 0; i < c.size(); i++){
            Car temp = c.get(i);
            Object na = temp.getImage();
            String id = temp.getBrand();
            String bal = temp.getPackage();
            String fre = temp.getColor();
            String date = temp.getLocation();
            double l = temp.getPrice();
            Object[] row = {na, id, bal, fre, date, l};
            model.addRow(row);

        }








            panel = new JPanel();
            panel.setBackground(Color.DARK_GRAY);
            panel.setBounds(0, 0, 600, 500);
            panel.setLayout(new BorderLayout());
            scroll = new JScrollPane();
            scroll.setBounds(224, 48, 297, 339);
            panel.add(scroll);


            table = new JTable();
            table.setModel(model);
            scroll.setViewportView(table);
            table.setRowHeight(100);
            frame.setJMenuBar(m);
            frame.getContentPane().add(panel);

            frame.setVisible(true);









    }
   // The method controls what car to remove depending on what the user chooses to sort the list of cars
    // by such as through color, brand, or package type.
    @Override
    public void actionPerformed(ActionEvent e) {
        // Color Removal
        if(e.getSource() == item1){
            Object[] options = {"Black", "White", "Blue", "Red", "Green", "Grey"};
            Object selectionObject = JOptionPane.showInputDialog(null, "Please select the Color of the car.", "Color", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            String selectionString = selectionObject.toString();

            for(int i = 0 ; i < table.getRowCount(); i++){
                if(c.get(i).getColor().equals(selectionString)){
                    if (model1 != null) {
                        model1.removeRow(i);
                    }
                    model.removeRow(i);
                    c.remove(i);

                }
            }            if (model1 != null) {
                model1.fireTableDataChanged();
            }
            model.fireTableDataChanged();
        }
        // Package removal
        if(e.getSource() == item2){
            Object[] options = {"Standard", "Deluxe", "Premium"};
            Object selectionObject = JOptionPane.showInputDialog(null, "Please select the Package of the car to remove.", "Package", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            String selectionString = selectionObject.toString();
            for(int i = 0; i < table.getRowCount(); i++){
                if(c.get(i).getPackage().equals(selectionString)){
                    if (model1 != null) {
                        model1.removeRow(i);
                    }
                    model.removeRow(i);
                    c.remove(i);

                }
                if (model1 != null) {
                    model1.fireTableDataChanged();
                }
                model.fireTableDataChanged();
            }

        }

        // Brand Removal
        if(e.getSource() == item7){
            Object[] options = {"Porsche", "Volkswagen", "Lexus", "Kia", "Ford", "Honda", "Toyota", "Chevrolet"};
            Object selectionObject = JOptionPane.showInputDialog(null, "Please select the brand of the car to display.", "Brand", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            String selectionString = selectionObject.toString();
            model1 = new DefaultTableModel()
            {
                //  Returning the Class of each column will allow different
                //  renderers to be used based on Class
                public Class getColumnClass(int column)
                {
                    return getValueAt(0, column).getClass();
                }
            };
            model1.setColumnIdentifiers(columns);
            for(int i = 0; i < c.size(); i++){
                if(c.get(i).getBrand().equals(selectionString)) {
                    Car temp = c.get(i);
                    Object na = temp.getImage();
                    String id = temp.getBrand();
                    String bal = temp.getPackage();
                    String fre = temp.getColor();
                    String date = temp.getLocation();
                    double l = temp.getPrice();
                    Object[] row = {na, id, bal, fre, date, l};
                    model1.addRow(row);
                }

            }
            table2 = new JTable(model1);
            table2.setRowHeight(100);
            scroll.setViewportView(table2);

        }




    }
}
