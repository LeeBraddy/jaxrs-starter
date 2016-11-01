package llb.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lee on 10/31/16.
 */
@ApiModel(description = "Greeting from the JAX-RS application")
public class HelloMessage {
    @ApiModelProperty(value = "Message text", required = true)
    public String message;
    @ApiModelProperty("Someone's name")
    public String name;
}
