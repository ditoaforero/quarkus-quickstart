package org.ditosoft.kafka;


import io.quarkus.kafka.client.serialization.JsonbDeserializer;


public class AuthorizationDeserializer extends JsonbDeserializer<Authorization> {
    public AuthorizationDeserializer(){
        super(Authorization.class);
    }
}