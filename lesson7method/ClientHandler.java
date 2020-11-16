package part2.lesson7method;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;

            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";

            new Thread(() -> {
                try{
                    authentication();
                    readMessages();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента", e);
        }
    }

    public void authentication () throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")){
                String [] credentials = str.split("\\s");
                String nick = myServer.getAuthService().getNickByLoginPass(credentials[1], credentials[2]);
                if (nick != null) {
                    if (!myServer.isNickBusy (nick)){
                        sendMsg ("/auth OK " + nick);
                        name = nick;
                        myServer.subscribe(this);
                        myServer.broadcastMsg(name + " entered the chat");
                        return;
                    }else {
                        sendMsg("Учетная запись уже используется");
                    }
                }else{
                    sendMsg("Incorrect login or password");
                }
            }
        }
    }

    public void readMessages() throws IOException{
        while (true){
            String strFromClient = in.readUTF();
            System.out.println(String.format("from %s: %s", name, strFromClient));
            if (strFromClient.equals("/end")){
                this.closeConnection();
                return;
            }
            if (strFromClient.startsWith("/w")){
                String [] values = strFromClient.split("\\s");
                StringBuilder sb = new StringBuilder();
                for (int i = 2; i < values.length; i++) {
                    sb.append(values[i]).append(" ");
                }
                myServer.sendPrivateMessage(values[1], sb.toString());

            }else{
                myServer.broadcastMsg(String.format("from %s: %s", name, strFromClient));
            }
        }
    }

    public void sendMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        myServer.broadcastMsg(String.format("%s leaved the chat", name));
        myServer.unsubscribe(this);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

