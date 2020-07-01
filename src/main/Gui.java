
package main;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.LineBorder;



public class Gui {


    private static JScrollPane scrollPane;


    public HashMap<String, int[]> Citymap = new HashMap<String, int[]>();


    JFrame f = new JFrame("One Day Project it21808");
    JButton b = new JButton ("Show Data");
    final JTextArea ta_out = new JTextArea();
    final PrintStream standardOut;


    JLabel out1 = new JLabel("Output");

    public Gui(int frameWidth, int frameHeight)
    {
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setBounds(50,50,150,72);


        out1.setBounds(50, 135, 150, 20);

        f.add(out1);


        f.add(b);
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ta_out.setBounds(50, 155, 550, 300);
        ta_out.setBorder(new LineBorder(Color.BLACK));
        ta_out.setEditable(false);

        scrollPane.setBounds(50, 155, 550, 300);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getViewport().add(ta_out);

        f.add(scrollPane);

        PrintStream printStream = new PrintStream(new CustomOutputStream(ta_out));
        standardOut = System.out;
        System.setOut(printStream);
        System.setErr(printStream);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (String name: Citymap.keySet()){
                    String key = name;
                    int[] value = Citymap.get(name);
                    System.out.println(key + " " + value[0] + " " + value[1]);
                }
            }
        });
        f.setSize(frameWidth,frameHeight);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        f.setLayout(null);
        f.setVisible(true);
    }


    public HashMap<String, int[]> getCitymap() {
        return Citymap;
    }

    public void setCitymap(HashMap<String, int[]> citymap) {
        Citymap = citymap;
    }
}
