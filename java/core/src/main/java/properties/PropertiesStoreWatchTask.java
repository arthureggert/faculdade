package properties;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class PropertiesStoreWatchTask extends TimerTask {
    private String propsFile;
    private long lastMod;
    private String fieldName;
    private final static Timer timer = new Timer();
    private static final long INITIAL_DELAY = 1000 * 60 * 5;
    private static final long INTERVAL  = 1000 * 60 * 5;
 
    private PropertiesStoreWatchTask(long lastMod, String fieldName, String propsFileName) {
        this.propsFile = propsFileName;
        this.lastMod = lastMod;
        this.fieldName = fieldName;
    }
    @Override
    public void run() {
        //check last modified time.
        long newModTime = new File(this.propsFile).lastModified();
        if( newModTime > this.lastMod ) {
            try {
                PropertiesLoader.loadProperties(this.fieldName, this.propsFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.lastMod = newModTime;
        }
    }
    protected static void watch(String fieldName, String propsFileName, PropertiesHolder propsHolder) {
        File propsFile = new File(propsFileName);
        long lastMod = propsFile.lastModified();
        timer.scheduleAtFixedRate( new PropertiesStoreWatchTask( lastMod, fieldName, propsFileName ) , INITIAL_DELAY, INTERVAL );
    }
}
