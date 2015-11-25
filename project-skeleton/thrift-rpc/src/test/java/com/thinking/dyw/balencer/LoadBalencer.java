package com.thinking.dyw.balencer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LoadBalencer {

    @Test
    public void roundRobinBalence(){
        List<Integer> services = new ArrayList<>();
        services.add(1);
        services.add(2);
        services.add(3);
        services.add(4);
        services.add(5);
        int i = services.size()-1;
        while (true) {
            i = (i+1) % services.size();
            System.out.println("i:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
