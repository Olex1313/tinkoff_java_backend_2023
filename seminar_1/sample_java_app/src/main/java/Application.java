import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) throws IOException {
        var server = HttpServer.create(new InetSocketAddress(8080), 5);
        server.createContext("/hello", new HelloWorldHandler());
        server.setExecutor(Executors.newFixedThreadPool(8));
        server.start();
        System.out.println("Started server on port 8080");
    }


    static class HelloWorldHandler implements HttpHandler {

        private static final String RESPONSE = "Hello, world\n";

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            exchange.sendResponseHeaders(200, RESPONSE.length());
            OutputStream os = exchange.getResponseBody();
            os.write(RESPONSE.getBytes(StandardCharsets.UTF_8));
        }

    }

}
