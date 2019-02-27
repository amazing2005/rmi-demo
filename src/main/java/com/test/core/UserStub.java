package com.test.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class UserStub extends User {

    private Socket socket;

    public UserStub() throws IOException {
        socket = new Socket("localhost",8888);
    }

    public int getAge(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject("age");
            System.out.println("client set data");
            outputStream.flush();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("client read data start");
            int age = objectInputStream.readInt();
            System.out.println("client read data:"+age);
            return  age;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
