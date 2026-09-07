public class Usuario {
    private String nombre;
    private String nombreUsuario;
    private String contrasenaHash;

    public Usuario(String nombre, String nombreUsuario, String contrasenaHash) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaHash = contrasenaHash;
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
}
