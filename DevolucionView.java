import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DevolucionView extends JFrame {
    private final JTextField txtObjetoId = new JTextField();
    private final JTextField txtPropietario = new JTextField();
    private final JTextField txtVerificacion = new JTextField();
    private final JButton btnDevolver = new JButton("Registrar devolución");

    public DevolucionView() {
        setTitle("Devolución de objeto");
        setSize(420, 220);
        setLayout(new GridLayout(4, 2, 5, 5));
        add(new JLabel("ID del objeto:"));
        add(txtObjetoId);
        add(new JLabel("Propietario:"));
        add(txtPropietario);
        add(new JLabel("Datos de verificación:"));
        add(txtVerificacion);
        add(new JLabel());
        add(btnDevolver);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public String getObjetoId() {
        return txtObjetoId.getText().trim();
    }

    public String getPropietario() {
        return txtPropietario.getText().trim();
    }

    public String getVerificacion() {
        return txtVerificacion.getText().trim();
    }

    public void agregarDevolucionListener(ActionListener listener) {
        btnDevolver.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtObjetoId.setText("");
        txtPropietario.setText("");
        txtVerificacion.setText("");
    }
}
