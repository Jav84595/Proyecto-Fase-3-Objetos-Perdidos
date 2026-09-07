import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistroObjetoView extends JFrame {
    private JTextField txtNombre = new JTextField();
    private JTextField txtDescripcion = new JTextField();
    private JTextField txtLugar = new JTextField();
    private JTextField txtFecha = new JTextField("2026-09-06");
    private JButton btnRegistrar = new JButton("Registrar objeto");

    public RegistroObjetoView() {
        setTitle("Registro de objeto encontrado");
        setSize(400, 240);
        setLayout(new GridLayout(5, 2, 5, 5));
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Descripción:"));
        add(txtDescripcion);
        add(new JLabel("Lugar:"));
        add(txtLugar);
        add(new JLabel("Fecha (AAAA-MM-DD):"));
        add(txtFecha);
        add(new JLabel());
        add(btnRegistrar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getNombreObjeto() {
        return txtNombre.getText().trim();
    }

    public String getDescripcion() {
        return txtDescripcion.getText().trim();
    }

    public String getLugar() {
        return txtLugar.getText().trim();
    }

    public String getFecha() {
        return txtFecha.getText().trim();
    }

    public void agregarRegistroListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtLugar.setText("");
    }
}
