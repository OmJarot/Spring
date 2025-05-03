package spring_dasar.Configuration.FactoryBean;

import lombok.Data;

@Data
public class PaymentGatewayClient {//misalkan class ini adalah class orang lain, kita tidak bisa mengubahnya
//kelas orang lain, kita tidak bisa menambah annotation di classnya dll
    private String endPoint;

    private String publicKey;

    private String privateKey;

}
