import java.net.*;
import java.io.*;

    public class Client {

        public static void main(String[] args) {
            // String hostname = "192.168.77.104";
            String hostname = "localhost";
            int port = 6969;
            System.out.println("Client Is trying to connect to "+ hostname+ ":" + port);

            try (Socket socket = new Socket(hostname, port)) {

                InputStream input = socket.getInputStream();
                InputStreamReader reader = new InputStreamReader(input);

                int character;
                StringBuilder data = new StringBuilder();

                while ((character = reader.read()) != -1) {
                    data.append((char) character);
                }

                System.out.println(data);


            } catch (UnknownHostException ex) {

                System.out.println("Server not found: " + ex.getMessage());

            } catch (IOException ex) {

                System.out.println("I/O error: " + ex.getMessage());
            }
        }
    }
