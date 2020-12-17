package com.test.springboot.java8.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @描述: Socket服务端
 * @Date: 2020/12/12 下午1:57
 * @Author: hha
 */
public class Server {

    public static void main(String[] args) throws IOException {

        byte[] content = new byte[2048];

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("serverSocket is ok");

        System.out.println("wait connection");

        while (true) {
            // 会阻塞
            Socket accept = serverSocket.accept();
            System.out.println("connection success");
            new Thread(() -> {
                try {
                    System.out.println("wait data");
                    accept.getInputStream().read(content);
                    System.out.println("data success，content = " + new String(content));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
