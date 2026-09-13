import java.time.LocalDate;

public class Objeto {
    public static final String ESTADO_DISPONIBLE = "DISPONIBLE";
    public static final String ESTADO_DEVUELTO = "DEVUELTO";

    private int id;
    private String nombre;
    private String descripcion;
    private String lugarEncontrado;
    private LocalDate fechaEncontrado;
    private String estado;

    public Objeto(int id, String nombre, String descripcion, String lugarEncontrado,
            LocalDate fechaEncontrado) {
        this(id, nombre, descripcion, lugarEncontrado, fechaEncontrado, ESTADO_DISPONIBLE);
    }

    public Objeto(int id, String nombre, String descripcion, String lugarEncontrado,
            LocalDate fechaEncontrado, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lugarEncontrado = lugarEncontrado;
        this.fechaEncontrado = fechaEncontrado;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getLugarEncontrado() { return lugarEncontrado; }
    public LocalDate getFechaEncontrado() { return fechaEncontrado; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Nombre: " + nombre
                + " | Descripción: " + descripcion
                + " | Lugar: " + lugarEncontrado
                + " | Fecha: " + fechaEncontrado
                + " | Estado: " + estado;
    }
}
