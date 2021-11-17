package com.rohit.handler;

import java.io.IOException;

//Decorator Pattern
public interface Handler<S> {
    void handle(S s) throws IOException;
}
