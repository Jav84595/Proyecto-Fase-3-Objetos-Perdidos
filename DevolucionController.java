import java.time.LocalDate;
import java.util.ArrayList;

public class DevolucionController {
    private ArrayList<Devolucion> devoluciones = new ArrayList<>();
    private ObjetoController objetoController;
    private DevolucionView view;
    private int siguienteId = 1;

    public DevolucionController(ObjetoController objetoController, DevolucionView view) {
        this.objetoController = objetoController;
        this.view = view;
        view.agregarDevolucionListener(e -> registrarDesdeVista());
    }

    public boolean registrarDevolucion(int objetoId, String propietario, String verificacion) {
        Objeto objeto = objetoController.buscarPorId(objetoId);
        if (objeto == null || !objeto.getEstado().equals("DISPONIBLE")
                || propietario.isEmpty() || verificacion.isEmpty()) {
            return false;
        }
        devoluciones.add(new Devolucion(siguienteId++, objetoId, propietario,
                verificacion, LocalDate.now()));
        objeto.setEstado("DEVUELTO");
        return true;
    }

    private void registrarDesdeVista() {
        try {
            int objetoId = Integer.parseInt(view.getObjetoId());
            boolean registrada = registrarDevolucion(objetoId,
                    view.getPropietario(), view.getVerificacion());
            view.mostrarMensaje(registrada
                    ? "Devolución registrada temporalmente."
                    : "No se pudo registrar la devolución.");
            if (registrada) {
                view.limpiarCampos();
            }
        } catch (NumberFormatException e) {
            view.mostrarMensaje("El ID del objeto debe ser un número.");
        }
    }
}
