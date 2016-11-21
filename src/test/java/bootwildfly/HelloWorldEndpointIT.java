package bootwildfly;

import com.jz.helloworld.v1.HelloWorldRequest;
import com.jz.helloworld.v1.HelloWorldResponse;
import com.jz.helloworld.v1.ObjectFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.StringUtils;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

public class HelloWorldEndpointIT {

    protected WebServiceTemplate webServiceTemplate;
    protected String routeUrl;

    @Before
    public void set_up() throws Exception {
        webServiceTemplate = new WebServiceTemplate();

        Jaxb2Marshaller m = new Jaxb2Marshaller();
        m.setContextPath(ObjectFactory.class.getPackage().getName());
        m.afterPropertiesSet();


        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
        messageSender.afterPropertiesSet();

        webServiceTemplate.setMarshaller(m);
        webServiceTemplate.setUnmarshaller(m);
        webServiceTemplate.setMessageSender(messageSender);

        webServiceTemplate.afterPropertiesSet();

        routeUrl = System.getProperty("routeUrl");
        if (StringUtils.isEmpty(routeUrl)) {
            routeUrl = "http://localhost:8080";
        }
    }

    @Test
    public void simple_test() {
        String name = "NAME";

        HelloWorldRequest request = new HelloWorldRequest();
        request.setName(name);

        HelloWorldResponse response = (HelloWorldResponse) webServiceTemplate.marshalSendAndReceive(routeUrl + "/ws", request);

        Assert.assertEquals("Hello " + name + "!", response.getMessage());
    }
}