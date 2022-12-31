package com.bootcamp.pos.EzyPOS.util;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IdGenerator {
    private final Random RANDOM=new Random();
    private String RESOURCE="0123456789abcdefghijklmnopqrstuvwxyz";

    public String generateId(int length){
        StringBuilder simpleId=new StringBuilder();
        for (int i = 0; i < length; i++) {
            simpleId.append(RESOURCE.charAt(RANDOM.nextInt(35)));
        }
        return simpleId.toString();
    }
}
