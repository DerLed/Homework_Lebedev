package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * Данный класс создает единственный способ обращения к файлу property во всей программе
 * так как в моей реализации это происходит в нескольких местах
 */
public final class Property {
    private static Property property;
    private final Properties properties;

    private Property() {
        this.properties = new Properties();
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String appConfigPath = rootPath + Constant.LEVEL_HERO_PROPERTIES_FILE_NAME + ".properties";

        try (FileInputStream fileInputStream = new FileInputStream(appConfigPath)) {
            this.properties.load(fileInputStream);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static Property getProperty() {
        if (property == null) {
            property = new Property();
        }
        return property;
    }

    public Properties getProperties() {
        return properties;
    }

}
