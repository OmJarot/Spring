package SpringDasar.DependencyInjection.Cyclic;

import lombok.Getter;

public class CyclicC {
    @Getter
    private CyclicA cyclicA;

    public CyclicC(CyclicA cyclicA) {
        this.cyclicA = cyclicA;
    }
}
