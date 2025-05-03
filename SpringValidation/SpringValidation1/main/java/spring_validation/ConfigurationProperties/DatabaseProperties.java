package spring_validation.ConfigurationProperties;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Validated
@ConfigurationProperties("application")
public class DatabaseProperties {
    //memastikan configuration nya valid
    //sebelum aplikasi dijalankan otomatis mengecek juga, jika tidak ada datanya
    //maka aplikasi tidak akan berjalan
    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
