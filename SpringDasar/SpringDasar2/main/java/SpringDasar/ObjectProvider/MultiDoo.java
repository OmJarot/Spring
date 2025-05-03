package SpringDasar.ObjectProvider;

import Data.Doo;
import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MultiDoo {

    @Getter
    private List<Doo> doos;

    public MultiDoo(ObjectProvider<Doo> doos) {
        this.doos = doos.stream().toList();//mengambil semua bean doo
    }
}
