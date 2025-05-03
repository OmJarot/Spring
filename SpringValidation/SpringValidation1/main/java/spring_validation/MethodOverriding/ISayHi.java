package spring_validation.MethodOverriding;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ISayHi {

    //jika membuat interface, validation harus di buat di interfacenya, tidak boleh di class implementasinya, karena saat di jalankan spring nya akan error
    String sayHi(@NotBlank String name);

}
