package llb.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * Created by lee on 10/31/16.
 */
@Logged
public class LoggedResponseFilter implements ContainerResponseFilter {
    static final Logger logger = LoggerFactory.getLogger(LoggedResponseFilter.class);

    @Override
    public void filter(
            ContainerRequestContext requestContext,
            ContainerResponseContext responseContext
    ) throws IOException {
        logger.debug(
                "URL: {}, RESPONSE HEADERS: {}",
                requestContext.getUriInfo().getAbsolutePath().toASCIIString(),
                responseContext.getHeaders().toString()
        );
    }
}
