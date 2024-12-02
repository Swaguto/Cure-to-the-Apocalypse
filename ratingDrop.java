/*
 * for rating dropdown system, added by rohith
 */
import java.awt.*; // imports
import java.awt.event.*;
import javax.swing.*;

public class ratingDrop extends JFrame implements ItemListener, ActionListener {
 
    // frame
    static JFrame f;
 
    // label
    static JLabel l, l1;
 
    // combobox
    static JComboBox c1;
 
    // textfield to add and delete items
    static JTextField tf;
 
    // main class
    public static void main(String[] args)
    {
        start();
    }

    public static void start() {
        // create a new frame
        f = new JFrame("Rating");
 
        // create a object
        ratingDrop s = new ratingDrop();
 
        // set layout of frame
        f.setLayout(new FlowLayout());
 
        // ratings
        String s1[] = { "1", "2", "3", "4", "5" };
 
        // create checkbox
        c1 = new JComboBox(s1);
 
        // create textfield
        
 
        // create add and remove buttons
        JButton b = new JButton("CONFIRM");
        
 
        // add action listener
        b.addActionListener(s);
       
 
        // add ItemListener
        c1.addItemListener(s);
 
        // create labels
        l = new JLabel("Select your rating: ");
        l1 = new JLabel("");
 
        // set color of text
        l.setForeground(Color.red);
        l1.setForeground(Color.blue);
 
        // create a new panel
        JPanel p = new JPanel();
 
        p.add(l);
 
        // add combobox to panel
        p.add(c1);
 
        p.add(l1);
        p.add(b);
        
 
        f.setLayout(new FlowLayout());
 
        // add panel to frame
        f.add(p);
 
        // set the size of frame
        f.setSize(400, 100);
 
        f.show();
    }
    // if button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("CONFIRM")) {
            f.dispose();
        }
        else {
            c1.removeItem(tf.getText());
        }
    }
 
    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == c1) {
 
            l1.setText(c1.getSelectedItem() + " selected");
        }
    }
}
