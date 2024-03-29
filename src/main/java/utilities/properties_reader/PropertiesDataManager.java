package utilities.properties_reader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

public class PropertiesDataManager {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String DEFAULT_FILE_PATH = System.getProperty("src/main/resources/Config.properties");
    private static final Properties properties = new Properties();

    private static Properties readProperties(String filePathContentRoot) {
        try {
            InputStream fileInputStream = new FileInputStream((PROJECT_PATH + filePathContentRoot));
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()) + "\n");
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String key, String filePathContentRoot) {
        return readProperties(filePathContentRoot).getProperty(key).trim();
    }

    public static String getProperty(String key) {
        return readProperties(PROJECT_PATH + DEFAULT_FILE_PATH).getProperty(key).trim();
    }

    public static void setProperty(String key, String value, String filePathContentRoot) {
        try {
            OutputStream fileOutputStream = new FileOutputStream((PROJECT_PATH + filePathContentRoot));
            properties.put(key, value.trim());
            properties.store(fileOutputStream, null);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }


}