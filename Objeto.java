import java.time.LocalDate;

public class Objeto {
    private int id;
    private String nombre;
    private String descripcion;
    private String lugarEncontrado;
    private LocalDate fechaEncontrado;
    private String estado;

    public Objeto(int id, String nombre, String descripcion, String lugarEncontrado,
            LocalDate fechaEncontrado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lugarEncontrado = lugarEncontrado;
        this.fechaEncontrado = fechaEncontrado;
        this.estado = "DISPONIBLE";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLugarEncontrado() {
        return lugarEncontrado;
    }

    public LocalDate getFechaEncontrado() {
        return fechaEncontrado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + lugarEncontrado + " - " + estado;
    }
}
