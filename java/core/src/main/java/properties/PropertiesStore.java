package properties;

import java.util.Properties;

public class PropertiesStore {
    @PropertiesHolder(file="app.properties", autoLoad=true)
    private static Properties appProps;
 
    @PropertiesHolder(file="security.properties")
    private static Properties securityProps;
 
    public static Properties getAppProps() {
        return appProps;
    }
    public static Properties getSecurityProps() {
        return securityProps;
    }
    protected static void setAppProps(Properties appProps) {
        PropertiesStore.appProps = appProps;
    }
    protected static void setSecurityProps(Properties securityProps) {
        PropertiesStore.securityProps = securityProps;
    }
}
