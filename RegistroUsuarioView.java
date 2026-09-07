import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistroUsuarioView extends JFrame {
    private JTextField txtNombre = new JTextField();
    private JTextField txtUsuario = new JTextField();
    private JPasswordField txtContrasena = new JPasswordField();
    private JButton btnRegistrar = new JButton("Registrar");

    public RegistroUsuarioView() {
        setTitle("Registro de usuario");
        setSize(350, 200);
        setLayout(new GridLayout(4, 2, 5, 5));
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Usuario:"));
        add(txtUsuario);
        add(new JLabel("Contraseña:"));
        add(txtContrasena);
        add(new JLabel());
        add(btnRegistrar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getNombre() {
        return txtNombre.getText().trim();
    }

    public String getNombreUsuario() {
        return txtUsuario.getText().trim();
    }

    public String getContrasena() {
        return new String(txtContrasena.getPassword());
    }

    public void agregarRegistroListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
    }
}
