import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersistenciaGremio {

    private static final String CARPETA = "datos_gremio";

    public PersistenciaGremio() {
        crearCarpetaSiNoExiste();
    }

    // Crear carpeta si no existe
    private void crearCarpetaSiNoExiste() {
        File carpeta = new File(CARPETA);
        if (!carpeta.exists()) {
            carpeta.mkdir();
            System.out.println("[IO] Carpeta '" + CARPETA + "' creada.");
        }
    }

    // Guardar roster
    public void guardarRoster(ArrayList<Personaje> roster) throws IOException {
        File archivo = new File(CARPETA + "/roster.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Personaje p : roster) {
                writer.write(p.getNombre() + "," + p.getNivel() + "," + p.getPuntosVida());
                writer.newLine();
            }
        }
        System.out.println("[IO] Roster guardado: " + roster.size() + " personajes.");
    }

    // Cargar roster
    public ArrayList<String> cargarRoster() throws IOException {
        File archivo = new File(CARPETA + "/roster.txt");
        ArrayList<String> lineas = new ArrayList<>();
        if (!archivo.exists()) {
            System.out.println("[IO] roster.txt no encontrado.");
            return lineas;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    lineas.add(linea);
                }
            }
        }
        System.out.println("[IO] Roster cargado: " + lineas.size() + " registros.");
        return lineas;
    }

    // Guardar inventario
    public void guardarInventario(HashMap<String, Integer> inventario) throws IOException {
        File archivo = new File(CARPETA + "/inventario.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, Integer> e : inventario.entrySet()) {
                writer.write(e.getKey() + "," + e.getValue());
                writer.newLine();
            }
        }
        System.out.println("[IO] Inventario guardado: " + inventario.size() + " items.");
    }

    // Cargar inventario
    public HashMap<String, Integer> cargarInventario() throws IOException {
        File archivo = new File(CARPETA + "/inventario.txt");
        HashMap<String, Integer> inventario = new HashMap<>();
        if (!archivo.exists()) {
            System.out.println("[IO] inventario.txt no encontrado.");
            return inventario;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] partes = linea.split(",");
                    String item = partes[0];
                    int cantidad = Integer.parseInt(partes[1]);
                    inventario.put(item, cantidad);
                }
            }
        }
        System.out.println("[IO] Inventario cargado: " + inventario.size() + " items.");
        return inventario;
    }

    // Agregar entrada a bitácora (append)
    public void agregarEntradaBitacora(String entrada) throws IOException {
        File archivo = new File(CARPETA + "/bitacora.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(entrada);
            writer.newLine();
        }
    }

    // Mostrar bitácora completa
    public void mostrarBitacora() throws IOException {
        File archivo = new File(CARPETA + "/bitacora.txt");
        if (!archivo.exists()) {
            System.out.println("[IO] La bitácora está vacía.");
            return;
        }
        System.out.println("\n=== Bitácora de Batallas ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numero = 1;
            while ((linea = reader.readLine()) != null) {
                System.out.println(numero++ + ". " + linea);
            }
        }
    }
}
