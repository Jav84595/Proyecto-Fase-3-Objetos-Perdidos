import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class UsuarioController {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private RegistroUsuarioView registroView;
    private LoginView loginView;

    public UsuarioController(RegistroUsuarioView registroView, LoginView loginView) {
        this.registroView = registroView;
        this.loginView = loginView;
        registroView.agregarRegistroListener(e -> registrarDesdeVista());
        loginView.agregarLoginListener(e -> iniciarSesionDesdeVista());
    }

    public boolean registrarUsuario(String nombre, String usuario, String contrasena) {
        if (nombre.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
            return false;
        }
        for (Usuario registrado : usuarios) {
            if (registrado.getNombreUsuario().equalsIgnoreCase(usuario)) {
                return false;
            }
        }
        usuarios.add(new Usuario(nombre, usuario, generarHash(contrasena)));
        return true;
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        String hash = generarHash(contrasena);
        for (Usuario registrado : usuarios) {
            if (registrado.getNombreUsuario().equalsIgnoreCase(usuario)
                    && registrado.getContrasenaHash().equals(hash)) {
                return true;
            }
        }
        return false;
    }

    private void registrarDesdeVista() {
        boolean registrado = registrarUsuario(registroView.getNombre(),
                registroView.getNombreUsuario(), registroView.getContrasena());
        registroView.mostrarMensaje(registrado
                ? "Usuario registrado temporalmente."
                : "Revise los datos o el nombre de usuario.");
        if (registrado) {
            registroView.limpiarCampos();
        }
    }

    private void iniciarSesionDesdeVista() {
        boolean acceso = iniciarSesion(loginView.getNombreUsuario(), loginView.getContrasena());
        loginView.mostrarMensaje(acceso ? "Inicio de sesión correcto." : "Credenciales incorrectas.");
    }

    private String generarHash(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] resultado = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
            StringBuilder hash = new StringBuilder();
            for (byte valor : resultado) {
                hash.append(String.format("%02x", valor));
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No se pudo proteger la contraseña.", e);
        }
    }
}
