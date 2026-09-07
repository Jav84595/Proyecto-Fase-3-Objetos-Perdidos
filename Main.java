import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistroUsuarioView registroUsuarioView = new RegistroUsuarioView();
            LoginView loginView = new LoginView();
            new UsuarioController(registroUsuarioView, loginView);

            RegistroObjetoView registroObjetoView = new RegistroObjetoView();
            ConsultaObjetoView consultaObjetoView = new ConsultaObjetoView();
            ObjetoController objetoController =
                    new ObjetoController(registroObjetoView, consultaObjetoView);

            DevolucionView devolucionView = new DevolucionView();
            new DevolucionController(objetoController, devolucionView);

            registroUsuarioView.setLocation(20, 20);
            loginView.setLocation(390, 20);
            registroObjetoView.setLocation(20, 280);
            consultaObjetoView.setLocation(440, 220);
            devolucionView.setLocation(760, 20);

            registroUsuarioView.setVisible(true);
            loginView.setVisible(true);
            registroObjetoView.setVisible(true);
            consultaObjetoView.setVisible(true);
            devolucionView.setVisible(true);
        });
    }
}
