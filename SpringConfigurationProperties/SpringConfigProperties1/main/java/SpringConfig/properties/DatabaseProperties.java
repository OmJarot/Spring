package SpringConfig.properties;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DatabaseProperties {

    private String username;

    private String password;

    private String database;

    private String url;

    //mendukung data collection juga
    private List<String> whitelistTables;//untuk memembuat isi datanya di SpringConfig.properties, cth: application.database.whitelist-tables=a,b,c atau bisa menggunakan index application.database.whitelist-tables[0]=a

    private Map<String, Integer> maxTablesSize;//untuk mengisi data map, cth: application.database.maxTableSize.product=100, application.database.maxTableSize.customer=100

}
