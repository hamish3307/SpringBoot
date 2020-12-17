package com.test.springboot.java8.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @描述:
 * @Date: 2020/12/12 下午1:58
 * @Author: hha
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",  8080);
        Scanner scanner = new Scanner(System.in);
        socket.getOutputStream().write(scanner.nextLine().getBytes());
    }

}