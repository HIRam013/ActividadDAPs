import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Datos extends JFrame {
    private JPanel panel;
    private JTextField productoField;
    private JComboBox tipoBox;
    private JButton eliminarButton;
    private JButton continuarButton;
    private JRadioButton hpRadioButton;
    private JRadioButton dellRadioButton;
    private JRadioButton matacoRadioButton;
    private JRadioButton prideRadioButton;
    private JCheckBox minatitlanCheckBox;
    private JCheckBox coatzacoalcosCheckBox;
    private JCheckBox tabascoCheckBox;
    private JTextField cantidadField;
    ArrayList<String> datos = new ArrayList<String>();
    public static String nombre, tipo, cantidadString;
    public static  int cantidad;
    public static  String proveedor = "";
    public static  String sucursal = "";
    private boolean hayDatos = false;
    private boolean hayProveedor = false;
    private boolean haySucursal = false;
    ButtonGroup groupButton;
    confirmarPedido ventana;

    public Datos(){
        setContentPane(panel);
        setSize(1360, 770);
        setTitle("DDTECH");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        groupButton= new ButtonGroup();
        groupButton.add(hpRadioButton);
        groupButton.add(dellRadioButton);
        groupButton.add(matacoRadioButton);
        groupButton.add(prideRadioButton);
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerDatos(e);
                verificarProveedor(e);
                verificarSucursal(e);
                verificarCampos();
                imprimir();
            }
        });
        hpRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getProveedor(hpRadioButton.getLabel());
            }
        });
        dellRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getProveedor(dellRadioButton.getLabel());
            }
        });
        matacoRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getProveedor(matacoRadioButton.getLabel());
            }
        });
        prideRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getProveedor(prideRadioButton.getLabel());
            }
        });
        minatitlanCheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getSucursal(minatitlanCheckBox.getLabel());
            }
        });
        coatzacoalcosCheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getSucursal(coatzacoalcosCheckBox.getLabel());
            }
        });
        tabascoCheckBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getSucursal(tabascoCheckBox.getLabel());
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productoField.setText("");
                tipoBox.setSelectedItem("Seleccione una opción");
                cantidadField.setText("");
                cantidad = 0;
                groupButton.clearSelection();
                minatitlanCheckBox.setSelected(false);
                coatzacoalcosCheckBox.setSelected(false);
                tabascoCheckBox.setSelected(false);
                sucursal = "";
            }
        });
    }

    public void obtenerDatos(ActionEvent evt){
        //NOMBRE
        if(productoField.getText().isEmpty()){
            hayDatos = false;
        }else{
            nombre = productoField.getText();
        }

        if(tipoBox.getSelectedItem().equals("Gamer")){
            tipo = tipoBox.getSelectedItem().toString();
        }else if(tipoBox.getSelectedItem().equals("Oficina")){
            tipo = tipoBox.getSelectedItem().toString();
        }else if(tipoBox.getSelectedItem().equals("Laptop")){
            tipo = tipoBox.getSelectedItem().toString();
        }else{
            hayDatos = false;
        }

        if(cantidadField.getText().contains(".")){
            JOptionPane.showMessageDialog(this.panel, "numero incorrecto, debe ser entero", "Problema en cantidad", JOptionPane.WARNING_MESSAGE);
        }else{
            if(cantidadField.getText().isEmpty()){
                hayDatos = false;
            }else{
                cantidadString = cantidadField.getText();
                cantidad = Integer.parseInt(cantidadString);
                if(cantidad < 0){
                    JOptionPane.showMessageDialog(this.panel, "No se aceptan numeros negativos", "Problema cantidad", JOptionPane.WARNING_MESSAGE);
                }else if(cantidad == 0){
                    hayDatos = false;
                }
            }
            hayDatos = true;
        }
    }

    public void getProveedor(String nombreProveedor){
        proveedor = nombreProveedor;
    }

    public void verificarProveedor(ActionEvent evt){
        if(proveedor != "") {
            hayProveedor = true;
        }
    }

    public void getSucursal(String nombreSucursal){
        sucursal = sucursal + ", "+ nombreSucursal;
    }

    public void verificarSucursal(ActionEvent evt){
        if(sucursal != "") {
            haySucursal = true;
        }
    }

    public void imprimir(){
        if(hayDatos == true && haySucursal == true && hayProveedor == true){
            ventana = new confirmarPedido();
            this.setVisible(false);
        }
    }

    public void verificarCampos(){
        if(hayDatos != true || haySucursal != true || hayProveedor != true){
            JOptionPane.showMessageDialog(this.panel, "Favor de revisar que los campos esten completos", "Faltan Datos", JOptionPane.WARNING_MESSAGE);
        }
    }
}
