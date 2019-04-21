package com.andrewwish.b2c.sale.api;

public interface Message<Payload> {

    String getKey();
    Payload getPayload();
}
