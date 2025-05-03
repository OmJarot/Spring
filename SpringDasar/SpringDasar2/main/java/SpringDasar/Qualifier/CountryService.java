package SpringDasar.Qualifier;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CountryService {
    @Getter
    private CountryRepository countryRepository1;

    @Getter
    private CountryRepository countryRepository2;

    public CountryService(@Qualifier("countryRepository1") CountryRepository countryRepository1, @Qualifier("countryRepository2")CountryRepository countryRepository2) {
        this.countryRepository1 = countryRepository1;
        this.countryRepository2 = countryRepository2;
    }
}
