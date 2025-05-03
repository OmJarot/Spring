package spring_dasar.Configuration.Component.ComponentDependencyInjection.ConstructorComponentDependency;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MultiComponent {
    //jika terdapat mulit constructor kita harus menandati constructor mana yang akan di gunakan

    @Getter
    private ProductRepository productRepository;

    @Autowired//memberitahu ini adalah constructor yang akan digunakan si bean
    public MultiComponent(ProductRepository productRepository) {//jika menggunakan component untuk dependency injection akan dicari kan otomatis paramater yang sesuai
        this.productRepository = productRepository;
    }

    public MultiComponent(ProductRepository productRepository, String name) {//jika menggunakan component untuk dependency injection akan dicari kan otomatis paramater yang sesuai
        this.productRepository = productRepository;
    }
}
