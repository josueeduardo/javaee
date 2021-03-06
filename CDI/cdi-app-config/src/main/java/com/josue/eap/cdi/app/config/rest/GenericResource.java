/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josue.eap.cdi.app.config.rest;

import com.josue.eap.cdi.app.config.rest.cfg.Config;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Josue
 */
@Path("generic")
@Stateless
public class GenericResource {

    private static final Logger LOG = Logger.getLogger(GenericResource.class.getName());

    @Inject
    @Config(key = "email")
    private String email;

    @Inject
    @Config(key = "name")
    private String name;

    @Inject
    @Config(key = "age")
    private int age;

    @Inject
    @Config
    private Properties props;

    @GET
    @Produces("text/plain")
    public String getText() {
        LOG.log(Level.INFO, "Email={0} Name={1} Age={2}", new Object[]{email, name, age});
        return "Email=" + email + " Name=" + name + " Age=" + age;
    }

    @GET
    @Path("all")
    @Produces("text/plain")
    public String getllProps() {
        String all = "";

        for (Object key : props.keySet()) {
            String keyString = String.valueOf(key);
            String val = props.getProperty(keyString);

            all += key + "=" + val + "\n";
        }
        LOG.log(Level.INFO, "ALL: {0}", all);

        return "".equals(all) ? "NO PROPERTIES" : "ALL PROPERTIES: \n" + all;
    }

}
