package com.rohit.handler;

import com.rohit.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.Socket;

public class TransmogrifyHandler implements Handler<Socket> {

    @Override
    public void handle(Socket s) throws IOException {
        try(
                s;
                InputStream is = s.getInputStream();
                OutputStream out = s.getOutputStream()
        )
        {
            int data;
            while ((data = is.read()) != -1) {
                out.write(Util.transmogrify(data));
            }
        } catch(IOException ie) {
            throw new UncheckedIOException(ie);
        } finally {
            System.out.println("Disconnection socket: " + s);
        }
    }
}
