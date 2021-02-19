package org.ditosoft.kafka;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Consumer {


    @Incoming("autorizations-generated")
    public void process(Authorization authorization) {
        System.out.println("La autorizacion a procesar es "+ authorization.toString());
    }


}