import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConsultaObjetoView extends JFrame {
    private JTextField txtBusqueda = new JTextField(20);
    private JButton btnBuscar = new JButton("Buscar");
    private JTextArea areaResultados = new JTextArea();

    public ConsultaObjetoView() {
        setTitle("Consulta de objetos");
        setSize(500, 300);
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.add(txtBusqueda);
        panelBusqueda.add(btnBuscar);
        areaResultados.setEditable(false);
        add(panelBusqueda, BorderLayout.NORTH);
        add(new JScrollPane(areaResultados), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getTextoBusqueda() {
        return txtBusqueda.getText().trim();
    }

    public void agregarBusquedaListener(ActionListener listener) {
        btnBuscar.addActionListener(listener);
    }

    public void mostrarObjetos(List<Objeto> objetos) {
        areaResultados.setText("");
        for (Objeto objeto : objetos) {
            areaResultados.append(objeto + System.lineSeparator());
        }
        if (objetos.isEmpty()) {
            areaResultados.setText("No se encontraron objetos.");
        }
    }
}
