import java.time.LocalDate;
import java.util.List;

public class DevolucionController {
    private final ObjetoController objetoController;
    private final DevolucionDAO devolucionDAO;
    private final DevolucionView view;

    public DevolucionController(
            ObjetoController objetoController,
            DevolucionDAO devolucionDAO,
            DevolucionView view) {
        this.objetoController = objetoController;
        this.devolucionDAO = devolucionDAO;
        this.view = view;
        view.agregarDevolucionListener(e -> registrarDesdeVista());
    }

    public boolean verificarPropietario(int objetoId, String verificacion) {
        if (objetoId <= 0 || verificacion == null || verificacion.trim().isEmpty()) {
            return false;
        }
        Objeto objeto = objetoController.buscarPorId(objetoId);
        return objeto != null && Objeto.ESTADO_DISPONIBLE.equals(objeto.getEstado());
    }

    public boolean registrarDevolucion(int objetoId, String propietario, String verificacion) {
        if (propietario == null || propietario.trim().isEmpty()
                || !verificarPropietario(objetoId, verificacion)) {
            return false;
        }

        Devolucion devolucion = new Devolucion(
                0,
                objetoId,
                propietario.trim(),
                verificacion.trim(),
                LocalDate.now()
        );

        return devolucionDAO.registrarDevolucion(devolucion);
    }

    public List<Devolucion> consultarDevoluciones() {
        return devolucionDAO.consultarTodas();
    }

    public Devolucion buscarDevolucionPorId(int id) {
        if (id <= 0) {
            return null;
        }
        return devolucionDAO.buscarPorId(id);
    }

    private void registrarDesdeVista() {
        try {
            int objetoId = Integer.parseInt(view.getObjetoId());
            boolean registrada = registrarDevolucion(
                    objetoId,
                    view.getPropietario(),
                    view.getVerificacion()
            );

            view.mostrarMensaje(
                    registrada
                    ? "Devolución registrada correctamente. El objeto ahora está DEVUELTO."
                    : "No se pudo registrar la devolución. Verifique el ID, el estado del objeto y los datos ingresados."
            );

            if (registrada) {
                view.limpiarCampos();
            }
        } catch (NumberFormatException e) {
            view.mostrarMensaje("El ID del objeto debe ser un número entero válido.");
        }
    }
}
