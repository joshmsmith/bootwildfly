package bootwildfly;


import com.jz.helloworld.v1.HelloWorldRequest;
import com.jz.helloworld.v1.HelloWorldResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldEndpointTest {

    protected HelloWorldEndpoint helloWorldEndpoint;

    @Before
    public void set_up() {
        helloWorldEndpoint = new HelloWorldEndpoint();
    }

    @Test
    public void simple_test() {
        String name = "NAME";

        HelloWorldRequest request = new HelloWorldRequest();
        request.setName(name);

        HelloWorldResponse response = helloWorldEndpoint.sayHello(request);

        Assert.assertEquals("Hello " + name + "!", response.getMessage());

    }
}
