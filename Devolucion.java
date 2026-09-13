import java.time.LocalDate;

public class Devolucion {
    private int id;
    private int objetoId;
    private String nombrePropietario;
    private String informacionVerificacion;
    private LocalDate fechaDevolucion;

    public Devolucion(int id, int objetoId, String nombrePropietario,
            String informacionVerificacion, LocalDate fechaDevolucion) {
        this.id = id;
        this.objetoId = objetoId;
        this.nombrePropietario = nombrePropietario;
        this.informacionVerificacion = informacionVerificacion;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getId() {
        return id;
    }

    public int getObjetoId() {
        return objetoId;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getInformacionVerificacion() {
        return informacionVerificacion;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
}