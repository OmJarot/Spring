package SpringConfig.ConfigurationProperties.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@ConfigurationProperties("application")
public class AppProperties {

    private String name;

    private Integer version;

    private Boolean productionMode;

    private DatabaseProperties database;

    private List<Role> defaultRoles;

    private Map<String, Role> roles;

    private Duration timeOut;

    private Date expired;
}
