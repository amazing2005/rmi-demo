package com.test.core;

import java.io.IOException;

public class UserClient {

    public static void main(String[] args) throws IOException {
        User user = new UserStub();
        int age = user.getAge();
        System.out.println("age="+age);
    }
}
