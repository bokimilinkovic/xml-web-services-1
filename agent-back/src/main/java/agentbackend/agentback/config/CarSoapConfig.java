package agentbackend.agentback.config;

import agentbackend.agentback.soapClient.CarSoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CarSoapConfig {

    @Bean
    public Jaxb2Marshaller marshallerCar() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.car_rent.agent_api.wsdl");
        return marshaller;
    }

    @Bean
    public CarSoapClient carClient(Jaxb2Marshaller marshallerCar) {
        CarSoapClient client = new CarSoapClient();
        client.setDefaultUri("http://localhost:8080/cars-ads/ws");
        client.setMarshaller(marshallerCar);
        client.setUnmarshaller(marshallerCar);
        return client;
    }

}
