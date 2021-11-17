package com.rohit;

import com.rohit.handler.Handler;
import com.rohit.handler.PrintingHandler;
import com.rohit.handler.TransmogrifyHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedBlockingServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Handler<Socket> handler = new PrintingHandler<>(
                new TransmogrifyHandler()
        );

        while(true) {
            Socket s = ss.accept();
            handler.handle(s);
        }
    }

//  Since we are using the PrintHandler this is redundant
//    private static void handle(Socket s) throws IOException {
//        new PrintingHandler<>(
//                new TransmogrifyHandler()
//        ).handle(s);
//
//        System.out.println("Connection accepted: " + s);
//        try {
//            new TransmogrifyHandler().handle(s);
//        } finally {
//            System.out.println("Disconnected: " + s);
//        }
//    }
}
