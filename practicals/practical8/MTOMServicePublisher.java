package practicals.practical8;

import javax.xml.ws.Endpoint;
import java.io.File;

public class MTOMServicePublisher {
    public static void main(String[] args) {

        /*
         * 1st argument is the publication URL
         * 2nd argument is a SIB instance
         */
        Endpoint.publish("http://localhost:9747/mtom", new MTOMServiceImplementation());
        System.out.println("\nMTOM Service is published on http://localhost:9747/mtom");
    }
}