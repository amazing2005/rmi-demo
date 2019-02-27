package com.test.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UserSkeleton extends Thread{

    private UserServer userServer;

    public UserSkeleton(UserServer userServer){
        this.userServer = userServer;
    }
    public void run(){
        ServerSocket serverSocket =null;
        try {
             serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();

            while (socket !=null){
                ObjectInputStream read = new ObjectInputStream(socket.getInputStream());
                String method = (String) read.readObject();
                System.out.println("server get data:"+method);
                if(method.equals("age")){
                    int age = userServer.getAge();
                    System.out.println("server set data:"+age);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeInt(age);
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket !=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
