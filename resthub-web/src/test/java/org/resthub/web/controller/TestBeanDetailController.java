package org.resthub.web.controller;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.junit.Test;
import org.resthub.web.test.AbstractWebResthubTest;

import com.sun.jersey.api.client.WebResource;

public class TestBeanDetailController extends AbstractWebResthubTest {
    
    @Test
    public void testFindAllBeans() {
    	WebResource r = resource().path("beans");
        String response = r.type(MediaType.APPLICATION_XML).get(String.class);
        System.out.print(response + "\n");
    }

}
