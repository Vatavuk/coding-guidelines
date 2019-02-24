package hr.com.vgv.examples.business_logic;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class App {

    public static void main(String... args) throws Exception {
        final Integer port = 8080;
        System.out.println("Server started on port " + port);

        try(ServerSocket server = new ServerSocket(port)) {
            while(true) {
                try (Socket socket = server.accept();
                     InputStream input = socket.getInputStream();
                     OutputStream output = socket.getOutputStream()
                ) {

                    byte[] buffer = new byte[10000];
                    int size = input.read(buffer);
                    String request = new String(Arrays.copyOfRange(buffer, 0, size));
                    System.out.print(request);

                    output.write("HTTP/1.1 200 OK\r\n\r\nHello World!".getBytes());
                }
            }
        }
    }
}
