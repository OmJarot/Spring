package spring_dasar.Configuration.Component.ComponentDependencyInjection.ConstructorComponentDependency;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    @Getter
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {//jika menggunakan component untuk dependency injection akan dicari kan otomatis paramater yang sesuai
        this.productRepository = productRepository;
    }
}
