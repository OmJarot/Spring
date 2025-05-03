package Data;

import lombok.Getter;

public class DooBar {
    @Getter
    private Doo doo;
    @Getter
    private Bar bar;

    public DooBar(Doo doo, Bar bar) {
        this.doo = doo;
        this.bar = bar;
    }
}
