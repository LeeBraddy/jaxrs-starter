package llb.server;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lee on 10/31/16.
 */
@ApplicationPath("api")
public class Server extends Application {
    public Server() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        //beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/jaxrs-starter/api");
        beanConfig.setResourcePackage("llb.resource");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();

        s.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        s.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        s.add(llb.server.CorsFilter.class);
        s.add(llb.server.LoggedRequestFilter.class);
        s.add(llb.server.LoggedResponseFilter.class);
        s.add(llb.resource.ExampleResource.class);

        return s;
    }
}
