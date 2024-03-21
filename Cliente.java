import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {
    public static void main(String[] args) {
        // Reemplaza esto con la dirección IP del servidor.
        String serverAddress = "192.168.1.100"; // Ejemplo de dirección IP, cambia esto por la IP de tu servidor.
        int serverPort = 11111; // El puerto debe coincidir con el servidor.

        try {
            // Crear un socket y conectarse al servidor.
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Conectado al servidor en " + serverAddress + " en el puerto " + serverPort);

            // Leer la respuesta del servidor.
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = input.readLine();
            System.out.println("Respuesta del servidor: " + serverResponse);

            // Cerrar la conexión.
            socket.close();
        } catch (IOException e) {
            System.err.println("No se pudo conectar al servidor: " + e.getMessage());
        }
    }
}
