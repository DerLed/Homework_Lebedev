package com.lebedev.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class Property {
    private static Property property;
    private final Properties properties;

    private Property() {
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
