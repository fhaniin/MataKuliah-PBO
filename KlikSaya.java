import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlikSaya {
    public static void main(String[] args) {
        // Membuat frame utama
        JFrame frame = new JFrame("Aplikasi GUI Sederhana");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Menggunakan layout manual

        // Membuat tombol
        JButton button = new JButton("Klik Saya");
        button.setBounds(100, 50, 100, 30); 

        // Membuat label
        final JLabel label = new JLabel("");
        label.setBounds(90, 100, 200, 30); 

        // Menambahkan ActionListener ke tombol
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol telah diklik!");
            }
        });

        // Menambahkan tombol dan label ke frame
        frame.add(button);
        frame.add(label);

        // Menampilkan frame
        frame.setVisible(true);
    }
}
