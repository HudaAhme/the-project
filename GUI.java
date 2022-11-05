import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by students on 29/10/22.
 */
public class GUI extends JFrame {
    Controll c;
    private JPanel mainPanel;
    private JButton addproducteButton;
    private JButton MenuButton;
    private JButton deleteButton;
    private JButton saveToFileButton;
    private JPanel allCards;
    private JPanel c1;
    private JPanel c2;
    private JPanel c3;
    private JTextField tflavor;
    private JTextField tprice;
    private JButton addButton;
    private JTextArea textArea1;

    public GUI() {
        try {
            c=new Controll();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        addproducteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c1);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        MenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c2);
                allCards.repaint();
                allCards.revalidate();
                allCards.add(textArea1);
                FlavorAndPrice[] all= c.Display();
                String s="Flavor     price\n";
                for (FlavorAndPrice x:all) {
                    s=s+ x.getPrice()+" "+x.getPrice()+x.toString()+"\n";
                    System.out.println(s);
                }
                textArea1.setText(s);
            }




        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String f= tflavor.getText();
                double price=Double.parseDouble(tprice.getText());

                boolean added=c.AddloverrrsAndPrice(f,price);
                if (added) {
                    JOptionPane.showMessageDialog(null,"Done Add");
               tflavor.setText("");
                    tprice.setText("");



                }
                else
                    JOptionPane.showMessageDialog(null,"Error");

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tprice.setText("   ");
                tflavor.setText("  ");
               // textArea1.setText("  ");
                JOptionPane.showMessageDialog(null,"Done Deleted  ");

            }
        });
        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{c.writelavorssAndprice();
                    JOptionPane.showMessageDialog(null,"Data was saved  ");

                }catch (FileNotFoundException e1){
                    JOptionPane.showMessageDialog(null,"some thing went wrong  ");

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
