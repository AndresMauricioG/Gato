import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Gato> listaGatos = new ArrayList<>();
        int opcion;

        do {
            String menu = "----- Menú -----\n" +
                    "1. Agregar gato\n" +
                    "2. Consultar gato\n" +
                    "3. Consultar lista de gatos\n" +
                    "4. Salir";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu + "\n\nIngrese una opción:"));

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del gato:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del gato:"));
                    String raza = JOptionPane.showInputDialog("Ingrese la raza del gato:");

                    Gato gato = new Gato(nombre, edad, raza);
                    listaGatos.add(gato);

                    JOptionPane.showMessageDialog(null, "Gato agregado correctamente.");
                    break;
                case 2:
                    String nombreGato = JOptionPane.showInputDialog("Ingrese el nombre del gato a consultar:");

                    boolean encontrado = false;
                    for (Gato g : listaGatos) {
                        if (g.getNombre().equalsIgnoreCase(nombreGato)) {
                            JOptionPane.showMessageDialog(null, g.toString());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "No se encontró un gato con ese nombre.");
                    }
                    break;
                case 3:
                    if (listaGatos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay gatos registrados.");
                    } else {
                        StringBuilder lista = new StringBuilder("----- Lista de Gatos -----\n");
                        for (Gato g : listaGatos) {
                            lista.append(g.toString()).append("\n---------------------------\n");
                        }
                        JOptionPane.showMessageDialog(null, lista.toString());
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 4);
    }
}

