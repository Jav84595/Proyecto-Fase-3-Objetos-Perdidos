import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {
    private JTextField txtUsuario = new JTextField();
    private JPasswordField txtContrasena = new JPasswordField();
    private JButton btnIngresar = new JButton("Ingresar");

    public LoginView() {
        setTitle("Inicio de sesión");
        setSize(350, 160);
        setLayout(new GridLayout(3, 2, 5, 5));
        add(new JLabel("Usuario:"));
        add(txtUsuario);
        add(new JLabel("Contraseña:"));
        add(txtContrasena);
        add(new JLabel());
        add(btnIngresar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getNombreUsuario() {
        return txtUsuario.getText().trim();
    }

    public String getContrasena() {
        return new String(txtContrasena.getPassword());
    }

    public void agregarLoginListener(ActionListener listener) {
        btnIngresar.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
