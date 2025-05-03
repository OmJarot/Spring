package spring_dasar.Configuration.Optional.ObjectProvider;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;
import spring_dasar.Data.Foo;

import java.util.List;

@Component
public class ObjectProviderFoo {

    @Getter
    private List<Foo> foos;

    public ObjectProviderFoo(ObjectProvider<Foo> foo) {
        foos = foo.stream().toList();//jika ada beannya maka akan diambil semua
    }
}
