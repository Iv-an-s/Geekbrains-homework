package part2.lesson7method;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private final int PORT = 8189;

    private List<ClientHandler> clients;
    private AuthService authService;

    public AuthService getAuthService(){
        return authService;
    }

    public MyServer(){
        try (ServerSocket server = new ServerSocket(PORT)){
            authService = new BaseAuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true){
                System.out.println("Server is waiting for connections...");
                Socket socket = server.accept();
                System.out.println("Client is connected: " + socket.toString());
                new ClientHandler(this, socket);
            }

        }catch (IOException e){
            System.out.println("Error with the server");
        }finally {
            if (authService!= null){
                authService.stop();
            }
        }
    }

    public synchronized boolean isNickBusy(String nick){
        for (ClientHandler o : clients){
            if (o.getName().equals(nick)){
                return true;
            }
        }
        return false;
    }

    public synchronized void broadcastMsg (String msg){
        for (ClientHandler o : clients){
            o.sendMsg(msg);
        }
    }

    public synchronized void sendPrivateMessage (String nick, String message){
        for (ClientHandler o : clients){
            if (o.getName().equals(nick)){
                o.sendMsg(message);
            }
        }
    }

    public synchronized void unsubscribe (ClientHandler o){
        clients.remove(o);
    }

    public synchronized void subscribe (ClientHandler o){
        clients.add(o);
    }
}
