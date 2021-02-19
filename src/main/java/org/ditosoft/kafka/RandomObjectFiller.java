package org.ditosoft.kafka;

import javax.validation.constraints.Size;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomObjectFiller {

    private Random random = new Random();

    public <T> T createAndFill(Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        for(Field field: clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = getRandomValueForField(field);
            field.set(instance, value);
        }
        return instance;
    }

    private Object getRandomValueForField(Field field) throws Exception {
        int size = 0;
        Class<?> type = field.getType();
        if (field.getAnnotation(Size.class) != null){
            //System.out.println("El tamaño maximo es:" + field.getAnnotation(Size.class).max());
            size = field.getAnnotation(Size.class).max();
        }
        // Note that we must handle the different types here! This is just an
        // example, so this list is not complete! Adapt this to your needs!
        if(type.isEnum()) {
            Object[] enumValues = type.getEnumConstants();
            return enumValues[random.nextInt(enumValues.length)];
        } else if(type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return random.nextInt((int)Math.pow(10, size)-1);
        } else if(type.equals(Long.TYPE) || type.equals(Long.class)) {
            return random.nextLong();
        } else if(type.equals(Double.TYPE) || type.equals(Double.class)) {
            return random.nextDouble();
        } else if(type.equals(Float.TYPE) || type.equals(Float.class)) {
            return random.nextFloat();
        } else if(type.equals(String.class)) {
            return UUID.randomUUID().toString();
        } else if(type.equals(BigInteger.class)){
            return BigInteger.valueOf(random.nextInt());
        } else if(type.equals(Date.class)){
            return new Date();
        } else if(type.equals(boolean.class)){
            return true;
        }
        return createAndFill(type);
    }
}