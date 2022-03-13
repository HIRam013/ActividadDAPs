import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Final extends JFrame{
    private JPanel panel;
    private JButton salirButton;
    private JPanel panelFinal;

    public Final() {
        setContentPane(panelFinal);
        setTitle("DDTECH");
        setSize(1360,760);
        setVisible(true);
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
