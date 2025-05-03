package spring_dasar.Configuration.FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("paymentComponentClient")
public class PaymentGatewayClientFactoryBean implements FactoryBean<PaymentGatewayClient> {

    @Override
    public PaymentGatewayClient getObject() throws Exception {//object beannya diambil dari sini
        PaymentGatewayClient paymentGatewayClient = new PaymentGatewayClient();
        paymentGatewayClient.setEndPoint("https://example.com");
        paymentGatewayClient.setPrivateKey("private");
        paymentGatewayClient.setPublicKey("public");
        return paymentGatewayClient;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymentGatewayClient.class;
    }
}
