import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ConsultaObjetoView extends JFrame {
    private JTextField txtBusqueda = new JTextField(20);
    private JButton btnBuscar = new JButton("Buscar");
    private JButton btnMostrarTodos = new JButton("Mostrar todos");
    private JTextArea areaResultados = new JTextArea();

    public ConsultaObjetoView() {
        setTitle("Consulta de objetos");
        setSize(650, 350);
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.add(new JLabel("Nombre o lugar:"));
        panelBusqueda.add(txtBusqueda);
        panelBusqueda.add(btnBuscar);
        panelBusqueda.add(btnMostrarTodos);
        areaResultados.setEditable(false);
        areaResultados.setLineWrap(true);
        areaResultados.setWrapStyleWord(true);
        add(panelBusqueda, BorderLayout.NORTH);
        add(new JScrollPane(areaResultados), BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public String getTextoBusqueda() { return txtBusqueda.getText().trim(); }
    public void agregarBusquedaListener(ActionListener listener) { btnBuscar.addActionListener(listener); }
    public void agregarConsultaListener(ActionListener listener) { btnMostrarTodos.addActionListener(listener); }
    public void mostrarObjetos(List<Objeto> objetos) {
        areaResultados.setText("");
        if (objetos == null || objetos.isEmpty()) {
            areaResultados.setText("No se encontraron objetos.");
            return;
        }
        for (Objeto objeto : objetos) areaResultados.append(objeto + System.lineSeparator());
    }
}
