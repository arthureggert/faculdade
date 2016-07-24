package constants;

public class AConstants {

	public static final String[] SPRING_BEANS_PACKAGE = {"config","dataminig.daos"} ;

	public static final String[] JPA_PACKAGE_SCAN = { "dataminig.tables" };
	
	public static final String USER_HOME = System.getProperty("user.home");

	public static final String SYSTEM_PROP = "cal2note.properties";
	
	public static final String PROP_FILE_PATH = String.format("%s/Dropbox/Arquivos/%s", USER_HOME , SYSTEM_PROP);
	
	public static final String SERVICE_ACCOUNT_ID = "serviceAccountId";
	
	public static final String SERVICE_ACCOUNT_SCOPE = "serviceAccountScopes";
	
	public static final String PRIVATE_KEY_P12_FILE = "accountPrivateKeyFromP12File";
	
	public static final int EXIT = 0;
	
	public static final int HIDE = 1;
	
}
