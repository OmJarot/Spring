package SpringDasar.DependencyInjection.Cyclic;

import lombok.Getter;

public class CyclicA {
    @Getter
    private CyclicB cyclicB;

    public CyclicA(CyclicB cyclicB) {
        this.cyclicB = cyclicB;
    }
}
