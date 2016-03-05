package br.edu.furb.agendamento.data.persistent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.hibernate.cfg.Configuration;

/**
 * Sempre vai criar o SessionFactory já que a cada operação (pra ficar
 * persistente no arquivo) é necessário executar um Shutdown do Hypersonic. Para
 * manter o isolamento e isonomia das sessões, todas elas devem ser isoladas e
 * caso a base de dados não existe na inicialização da sessão, deve ser criada a
 * partir das constantes CONTENT_fileScript e CONTENT_fileProperties
 * 
 * @author Claor Bauer, João Maas
 * 
 */
public class HibernateUtil {

    private static String databaseDirectory = null;

    private static final String KEY_DATABASE_DIRECTORY = "br.edu.furb.wae.databaseDirectory";
    private static final String KEY_GENERATE_DATABASE = "br.edu.furb.wae.generateDatabase";

    public static String getDatabaseDirectory() {
        if (databaseDirectory == null) {
            String directory = System.getProperty(KEY_DATABASE_DIRECTORY, "");
            if (directory.equals("")) {
                System.err.println("Atenção. Chave br.edu.furb.wae.databaseDirectory não configurada.");
            } else if (!directory.endsWith("/")) {
                directory += "/";
            }
            databaseDirectory = directory;
        }
        return databaseDirectory;
    }

    public static boolean regenerateDatabase() {
        String property = System.getProperty(KEY_GENERATE_DATABASE, "");
        if (property.equals("")) {
            return false;
        } else {
            return Boolean.parseBoolean(property);
        }
    }

    private static final String FILE_fileScript = "db.script";
    private static final String FILE_fileProperties = "db.properties";

    public static Configuration createSessionConfiguration() {
        try {
            return new Configuration()/**/
            .setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")/**/
            .setProperty("hibernate.connection.url", "jdbc:hsqldb:file:" + getDatabaseDirectory() + "db")/**/
            .setProperty("hibernate.connection.username", "sa")/**/
            .setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")/**/
            .setProperty("show_sql", "true")/**/
            .setProperty("format_sql", "true")/**/
            .setProperty("hbm2ddl.auto", "")/**/
            .addResource("br/edu/furb/metalurgica/data/persistent/Wid.hbm.xml")/**/
            .addResource("br/edu/furb/metalurgica/data/persistent/WidItem.hbm.xml")/**/
            .addResource("br/edu/furb/metalurgica/data/persistent/WidHistory.hbm.xml")/**/
            .addResource("br/edu/furb/metalurgica/data/persistent/Entity.hbm.xml")/**/
            .addResource("br/edu/furb/metalurgica/data/persistent/TrilhaAuditoria.hbm.xml")/**/
            .addResource("br/edu/furb/metalurgica/data/persistent/TrilhaAuditoria.hbm.xml"); /**/
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static boolean fileExists(String file) {
        File f = new File(file);
        try {
            return f.exists();
        } finally {
            f = null;
        }

    }

    private static final String CONTENT_fileScript = /**/
    "CREATE SCHEMA PUBLIC AUTHORIZATION DBA" + "\n" + /**/
    "CREATE USER SA PASSWORD \"\"" + "\n" + /**/
    "GRANT DBA TO SA" + "\n" + /**/
    "SET WRITE_DELAY 10" + "\n" + /**/
    "SET SCHEMA PUBLIC";

    private static final String CONTENT_fileProperties = /**/
    "#HSQL Database Engine 1.8.0.10" + "\n" + /**/
    "hsqldb.script_format=0" + "\n" + /**/
    "runtime.gc_interval=0" + "\n" + /**/
    "sql.enforce_strict_size=false" + "\n" + /**/
    "hsqldb.cache_size_scale=8" + "\n" + /**/
    "readonly=false" + "\n" + /**/
    "hsqldb.nio_data_file=true" + "\n" + /**/
    "hsqldb.cache_scale=14" + "\n" + /**/
    "version=1.8.0" + "\n" + /**/
    "hsqldb.default_table_type=memory" + "\n" + /**/
    "hsqldb.cache_file_scale=1" + "\n" + /**/
    "hsqldb.log_size=200" + "\n" + /**/
    "modified=no" + "\n" + /**/
    "hsqldb.cache_version=1.7.0" + "\n" + /**/
    "hsqldb.original_version=1.8.0" + "\n" + /**/
    "hsqldb.compatible_version=1.8.0";

    public static void checkDatabaseFiles() {
        String directory = getDatabaseDirectory();
        checkOrCreateFile(directory + FILE_fileScript, CONTENT_fileScript);
        checkOrCreateFile(directory + FILE_fileProperties, CONTENT_fileProperties);
    }

    private static void checkOrCreateFile(String fileName, String content) {
        if (!fileExists(fileName)) {
            System.out.println("Gerando " + fileName + "...");
            try {
                Writer output = new BufferedWriter(new FileWriter(fileName));
                try {
                    output.write(content);
                } finally {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
