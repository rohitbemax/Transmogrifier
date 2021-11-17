package com.rohit;

import com.rohit.handler.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedBlockingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
//        UncheckedIOExceptionConverterHandler<Socket> handler = new UncheckedIOExceptionConverterHandler<>(
//                new PrintingHandler<>(
//                        new TransmogrifyHandler()
//                )
//        );

        Handler<Socket> handler = new ThreadedHandler<>(
                new PrintingHandler<>(
                        new TransmogrifyHandler()
                )
        );

        while(true) {
            Socket s = ss.accept();
            handler.handle(s);
        }
    }

//    private static void handle(Socket s) throws IOException {
//        new Thread(() -> {
//            System.out.println("Connection accepted: " + s);
//
//        }).start();
//    }

//    private static int transmogrify(int data) {
//        return Character.isLetter(data) ? (data ^ ' ') : data;
//    }
}