import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) {
        // Definir el puerto en el que nuestro servidor estará escuchando.
        int port = 11111;

        try {
            // Crear un ServerSocket para escuchar en el puerto definido.
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor iniciado y escuchando en el puerto " + port);

            // El servidor se ejecuta indefinidamente.
            while (true) {
                try {
                    // Esperar una conexión de un cliente.
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Conexión aceptada desde " + clientSocket.getInetAddress());

                    // Escribir la fecha actual en la conexión.
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("La fecha y hora actual es: " + new Date().toString());

                    // Cerrar la conexión con el cliente.
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error al interactuar con el cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el servidor en el puerto " + port + ": " + e.getMessage());
        }
    }
}
