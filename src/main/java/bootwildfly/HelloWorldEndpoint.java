package bootwildfly;

import com.jz.helloworld.v1.HelloWorldRequest;
import com.jz.helloworld.v1.HelloWorldResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloWorldEndpoint {
    protected static final String NAMESPACE_URI = "http://jz.com/helloWorld/v1";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HelloWorldRequest")
    @ResponsePayload
    public HelloWorldResponse sayHello(@RequestPayload HelloWorldRequest request) {
        HelloWorldResponse response = new HelloWorldResponse();

        response.setMessage("Hello " + request.getName() + "!");
        return response;
    }
}
