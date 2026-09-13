import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        try {
            ConexionBD.inicializarBaseDatos();
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se pudo iniciar la base de datos.\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        SwingUtilities.invokeLater(() -> {
            RegistroUsuarioView registroUsuarioView = new RegistroUsuarioView();
            LoginView loginView = new LoginView();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            new UsuarioController(usuarioDAO, registroUsuarioView, loginView);

            RegistroObjetoView registroObjetoView = new RegistroObjetoView();
            ConsultaObjetoView consultaObjetoView = new ConsultaObjetoView();
            ObjetoDAO objetoDAO = new ObjetoDAO();
            ObjetoController objetoController = new ObjetoController(
                    registroObjetoView,
                    consultaObjetoView,
                    objetoDAO
            );

            DevolucionView devolucionView = new DevolucionView();
            DevolucionDAO devolucionDAO = new DevolucionDAO();
            new DevolucionController(
                    objetoController,
                    devolucionDAO,
                    devolucionView
            );

            registroUsuarioView.setLocation(20, 20);
            loginView.setLocation(390, 20);
            registroObjetoView.setLocation(20, 280);
            consultaObjetoView.setLocation(440, 280);
            devolucionView.setLocation(760, 20);

            registroUsuarioView.setVisible(true);
            loginView.setVisible(true);
            registroObjetoView.setVisible(true);
            consultaObjetoView.setVisible(true);
            devolucionView.setVisible(true);
        });
    }
}
