import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class confirmarPedido extends JFrame{
    private JButton cancelarButton;
    private JButton enviarButton;
    private JLabel productoLabel;
    private JLabel tipoLabel;
    private JLabel cantidadLabel;
    private JLabel proveedorLabel;
    private JLabel sucursalLabel;
    private JPanel panel;
    Datos datos = new Datos();

    public confirmarPedido() {
        setContentPane(panel);
        setTitle("DDTECH");
        setSize(1360,760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        cancelarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        productoLabel.setText(datos.nombre);
        tipoLabel.setText(datos.tipo);
        cantidadLabel.setText(datos.cantidadString);
        proveedorLabel.setText(datos.proveedor);
        sucursalLabel.setText(datos.sucursal);
        datos.setVisible(false);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Final ventaFinal = new Final();
            }
        });
    }
}
