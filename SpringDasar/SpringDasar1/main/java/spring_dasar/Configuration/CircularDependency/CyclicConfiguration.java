package spring_dasar.Configuration.CircularDependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_dasar.Data.Cyclic.CyclicA;
import spring_dasar.Data.Cyclic.CyclicB;
import spring_dasar.Data.Cyclic.CyclicC;

@Configuration
public class CyclicConfiguration {

    @Bean
    public CyclicA cyclicA(CyclicB cyclicB){
        return new CyclicA(cyclicB);
    }

    @Bean
    public CyclicB cyclicB(CyclicC cyclicC){
        return new CyclicB(cyclicC);
    }

    @Bean
    public CyclicC cyclicC(CyclicA cyclicA){
        return new CyclicC(cyclicA);
    }

}
