package com.nestor.rest;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

/**
 * Created by sbt-velichko-aa on 18.04.2017.
 */
public class AddServiceTest {
    @Test
    public void addGet() throws Exception {
        AddService service = new AddService();
        Response output = service.addGet("10.116.179.181", "56f9c7ca-ea87-4e80-a06e-28609b13feff",
                "auto-slave-testplugin-8097", 140929431L, 149249474L);
        Assert.assertEquals(200, output.getStatus());
    }

    @Test
    public void addPost() throws Exception {
        AddService service = new AddService();
        Response output = service.addGet("10.116.179.181", "56f9c7ca-ea87-4e80-a06e-28609b13feff",
                "auto-slave-testplugin-8097", 149242431L, 149242474L);
        Assert.assertEquals(200, output.getStatus());
    }

    @Test
    public void deleteRow() throws Exception {
        AddService service = new AddService();
        Response output = service.addGet("10.116.179.181_testDelete", "56f9c7ca-ea87-4e80-a06e-28609b13feff_testDelete",
                "auto-slave-test_testDelete", 1492420929431L, 1492423349474L);
        Assert.assertEquals(200, output.getStatus());
        output = service.deleteRow("auto-slave-test_testDelete");
        Assert.assertEquals(200, output.getStatus());
    }

}