package SpringConfig.ConfigurationProperties.properties;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DatabaseProperties {

    private String username;

    private String password;

    private String url;

    private List<String> whitelistTables;

    private Map<String, Integer> maxTablesSize;

}
