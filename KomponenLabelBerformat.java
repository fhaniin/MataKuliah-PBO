package setelahuts;

import javax.swing.*;
import java.awt.*;
public class KomponenLabelBerformat {
public static void main(String[] args) {
JFrame frame = new JFrame("Membuat Label");
JLabel label = new JLabel("Pemrograman Berorientasi Objek");
label.setForeground(Color.yellow);
label.setBackground(Color.blue);
label.setOpaque(true);
label.setFont(new Font("SansSerif", Font.BOLD, 14));
frame.getContentPane().add(label);
frame.pack();
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}