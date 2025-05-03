package SpringDasar.DependencyInjection.Cyclic;

import lombok.Getter;

public class CyclicB {
    @Getter
    private CyclicC cyclicC;

    public CyclicB(CyclicC cyclicC) {
        this.cyclicC = cyclicC;
    }
}
