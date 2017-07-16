package org.academiadecodigo.bootcamp.registerexercisemaven;

import org.academiadecodigo.bootcamp.registerexercisemaven.service.Service;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by codecadet on 03/07/17.
 */
public class ServiceRegistryTest {

    private ServiceRegistry serviceRegistry;
    private Service service;

    @Before
    public void setUp() {
        serviceRegistry=ServiceRegistry.getInstance();
        service = Mockito.mock(Service.class);
        when(service.getName()).thenReturn("servicename");
    }

    @Test
    public void testGetService() {
        assertNull(serviceRegistry.getService("randomstring"));
        serviceRegistry.addService(service);
        assertSame(serviceRegistry.getService("servicename"),service);
    }

    @Test
    public void testAddService() {
        assertNull(serviceRegistry.getService("servicename"));
        serviceRegistry.addService(service);
        assertSame(serviceRegistry.getService("servicename"),service);
    }

    @Test
    public void testRemoveService(){
        serviceRegistry.removeService(service);
        assertNull(serviceRegistry.getService("servicename"));
    }

    @Test
    public void testGetInstance(){
        assertSame(serviceRegistry,ServiceRegistry.getInstance());
    }

    @After
    public void cleanRegistry(){
        serviceRegistry.removeService(service);
    }

}
