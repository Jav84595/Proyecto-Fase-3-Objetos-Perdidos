public class Usuario {
    private final int id;
    private final String nombre;
    private final String nombreUsuario;
    private final String contrasenaHash;

    public Usuario(String nombre, String nombreUsuario, String contrasenaHash) {
        this(0, nombre, nombreUsuario, contrasenaHash);
    }

    public Usuario(int id, String nombre, String nombreUsuario, String contrasenaHash) {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaHash = contrasenaHash;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    @Override
    public String toString() {
        return nombre + " (" + nombreUsuario + ")";
    }
}
