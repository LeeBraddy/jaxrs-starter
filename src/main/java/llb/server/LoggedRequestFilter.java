package llb.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by lee on 10/31/16.
 */
@Logged
public class LoggedRequestFilter implements ContainerRequestFilter {
    static final Logger logger = LoggerFactory.getLogger(LoggedRequestFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        logger.debug(
                "URL: {}, REQUEST HEADERS: {}",
                requestContext.getUriInfo().getAbsolutePath().toASCIIString(),
                requestContext.getHeaders()
        );
    }
}
