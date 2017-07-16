package org.academiadecodigo.bootcamp.registerexercisemaven.service;

import java.util.HashMap;

/**
 * Created by codecadet on 29/06/17.
 */
public class ServiceRegistry {

    // static instance of this class
    private static ServiceRegistry instance = null;

    // private constructor so it's not possible to instantiate from outside
    private ServiceRegistry() {
        serviceHashMap=new HashMap<>();
    }

    // static method that returns the instance
    public static synchronized ServiceRegistry getInstance() {

        // the instance is created only the first time this method is called
        if(instance == null) {
            synchronized (ServiceRegistry.class) {
                if (instance == null) {
                    instance = new ServiceRegistry();
                }
            }
        }

        // it always returns the same instance, there is no way to have another one
        return instance;
    }

    private HashMap<String, Service> serviceHashMap;

    public Service getService(String s){
        return serviceHashMap.get(s);
    }

    public void addService(Service s){
        serviceHashMap.put(s.getName(),s);
    }

    public void removeService(Service s){serviceHashMap.remove(s.getName());}
}
