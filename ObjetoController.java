import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ObjetoController {
    private ArrayList<Objeto> objetos = new ArrayList<>();
    private RegistroObjetoView registroView;
    private ConsultaObjetoView consultaView;
    private int siguienteId = 1;

    public ObjetoController(RegistroObjetoView registroView, ConsultaObjetoView consultaView) {
        this.registroView = registroView;
        this.consultaView = consultaView;
        registroView.agregarRegistroListener(e -> registrarDesdeVista());
        consultaView.agregarBusquedaListener(e ->
                consultaView.mostrarObjetos(buscarObjetos(consultaView.getTextoBusqueda())));
    }

    public boolean registrarObjeto(String nombre, String descripcion, String lugar, String fecha) {
        if (nombre.isEmpty() || lugar.isEmpty()) {
            return false;
        }
        try {
            LocalDate fechaEncontrado = LocalDate.parse(fecha);
            objetos.add(new Objeto(siguienteId++, nombre, descripcion, lugar, fechaEncontrado));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public List<Objeto> buscarObjetos(String texto) {
        ArrayList<Objeto> encontrados = new ArrayList<>();
        String criterio = texto.toLowerCase();
        for (Objeto objeto : objetos) {
            if (objeto.getNombre().toLowerCase().contains(criterio)
                    || objeto.getLugarEncontrado().toLowerCase().contains(criterio)) {
                encontrados.add(objeto);
            }
        }
        return encontrados;
    }

    public Objeto buscarPorId(int id) {
        for (Objeto objeto : objetos) {
            if (objeto.getId() == id) {
                return objeto;
            }
        }
        return null;
    }

    private void registrarDesdeVista() {
        boolean registrado = registrarObjeto(registroView.getNombreObjeto(),
                registroView.getDescripcion(), registroView.getLugar(), registroView.getFecha());
        registroView.mostrarMensaje(registrado
                ? "Objeto registrado temporalmente."
                : "Revise el nombre, lugar y formato de fecha.");
        if (registrado) {
            registroView.limpiarCampos();
        }
    }
}
