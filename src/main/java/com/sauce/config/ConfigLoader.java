package com.sauce.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public final class ConfigLoader {

    private static final Properties prop = new Properties();

    static {
        try (FileInputStream fis =
                     new FileInputStream(Paths.get("src", "main", "resources", "qa.properties")
                             .toAbsolutePath()
                             .toString()
                     )) {

            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }


}
