package ru.lebedev.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyHelper {
    private static PropertyHelper propertyHelper;
    private final Properties properties;

    private PropertyHelper() {
        this.properties = new Properties();
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String appConfigPath = rootPath + "settings.properties";

        try (FileInputStream fileInputStream = new FileInputStream(appConfigPath)) {
            this.properties.load(fileInputStream);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertyHelper getInstance() {
        if (propertyHelper == null) {
            propertyHelper = new PropertyHelper();
        }
        return propertyHelper;
    }

    public Properties getProperties() {
        return properties;
    }

}
