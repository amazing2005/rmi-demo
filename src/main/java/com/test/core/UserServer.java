package com.test.core;

public class UserServer extends User  {

    public static void main(String[] args) {
        UserServer userServer = new UserServer();

        userServer.setAge(18);
        UserSkeleton userSkeleton = new UserSkeleton(userServer);
        userSkeleton.start();

    }
}
