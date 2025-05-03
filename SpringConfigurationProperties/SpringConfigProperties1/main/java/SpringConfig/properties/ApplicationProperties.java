package SpringConfig.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Setter
@Getter
//class ini akan otomatis dijadikan bean, jadi tidak perlu membuat beannya secara manual
@ConfigurationProperties("application")//akan auto binding dengan SpringConfig.properties, jika menggunakan profile file akan auto binding dengan filenya
public class ApplicationProperties {
    //field-field nya akan auto inject sesuai dengan variabel di propertiesnya
    //mvn compile, akan membuat meta data nya, filenya berada di target/classes/META-INF
    private String name;

    private Integer version;

    private Boolean productionMode;

    //mendukung data collection juga
    private DatabaseProperties database;//mendukung embedded SpringConfig.properties, fields didalamnya akan di isi otomatis sesuai dengan propertiesnya, mengisi datanya misal application.database.username

    //mendukung embeded collection juga
    private List<Role> defaultRoles;

    private Map<String, Role> roles;

    //Conversion, springboot akan otomatis menkonversi tipe data java seperti String, integer long, date, time ,dll
    private Duration timeOut;

    //custom conversion
    private Date expireDate;
}
