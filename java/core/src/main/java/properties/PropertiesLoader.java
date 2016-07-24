package properties;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class PropertiesLoader {
	
    private static final String VAR_NAME = "APP_PROPS";

    public static void load() throws Exception {
        Field[] fields = PropertiesStore.class.getDeclaredFields();
        for(Field field:fields) {
            if( field.isAnnotationPresent(PropertiesHolder.class) ) {
                PropertiesHolder propsHolder = field.getAnnotation(PropertiesHolder.class);
                loadPropsAndWatch( field.getName(), propsHolder );
            }
        }
    }

    private static void loadPropsAndWatch(String fieldName, PropertiesHolder propsHolder) throws Exception {
        String propsFile = System.getProperty(VAR_NAME) + File.separator + propsHolder.file();
        loadProperties(fieldName, propsFile);
        if( propsHolder.autoLoad() ) {
            PropertiesStoreWatchTask.watch( fieldName, propsFile, propsHolder );
        }
    }

    
    protected static void loadProperties(String fieldName, String propsFile)
            throws Exception {
        String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        Method setter = PropertiesStore.class.getDeclaredMethod(setterName, Properties.class);
 
        Properties props = new Properties();
        props.load( new FileInputStream(new File(propsFile) ) );
 
        setter.invoke(null, props);
    }
}
