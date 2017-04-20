package controllers;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by PAVILION-DV6 on 18/4/2017.
 */
@Provider
public class CrossDomain implements ContainerResponseFilter {

    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        containerRequestContext.getHeaders().putSingle("Access-Control-Allow-Origin","*");
        containerRequestContext.getHeaders().putSingle("Access-Control-Allow-Methods","GET, POST");
        containerRequestContext.getHeaders().putSingle("Access-Control-Allow-Headers","content-type");
    }
}
