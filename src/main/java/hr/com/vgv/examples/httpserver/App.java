package hr.com.vgv.examples.httpserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    String request = new String(Arrays.copyOfRange(buffer, 0, size + 1));
                    System.out.print(request);
                    if (!request.isEmpty()) {
                        StringTokenizer tokenizer = new StringTokenizer(request);
                        String method = tokenizer.nextToken();
                        String path = tokenizer.nextToken();

                        if (method.equals("GET") &&
                            matches("/world/\\w+", path))
                        {
                            String id = path.split("/")[2];
                            System.out.println(id);
                            output.write("HTTP/1.1 200 OK\r\n\r\nHello World!".getBytes());
                        } else {
                            output.write("HTTP/1.1 400 BAD REQUEST\r\n\r\n".getBytes());
                        }
                    }
                }
            }
        }
    }

    private static boolean matches(String regex, String text) {
        //"/world/w+"
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()){
            return true;
        }
        return false;
    }
}
