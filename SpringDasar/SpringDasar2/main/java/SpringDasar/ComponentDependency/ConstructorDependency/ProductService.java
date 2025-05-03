package SpringDasar.ComponentDependency.ConstructorDependency;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Getter
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {//otomatis mencarikan bean yang cocok
        this.productRepository = productRepository;
    }
}
