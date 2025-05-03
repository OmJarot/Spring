package SpringDasar.FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component(value = "government")
public class GovernmentBean implements FactoryBean<Government> {
    @Override
    public Government getObject() throws Exception {//membuat beannya
        Government government = new Government();
        government.setA("a");
        government.setB("b");
        government.setC("c");
        return government;
    }

    @Override
    public Class<?> getObjectType() {
        return Government.class;
    }
}
