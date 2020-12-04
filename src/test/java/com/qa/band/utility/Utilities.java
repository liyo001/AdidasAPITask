package com.qa.band.utility;

import java.io.File;
import java.net.URL;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class Utilities {

    public static String alterJson(Map<String, String> jsonValues) {
        String jsonString = null;
        try {
            File appDir = new File(System.getProperty("user.dir"));
            URL uri = new URL(appDir.toURI()
                    + "/src/test/resources/Config/createPet.json");
            jsonString = Resources.toString(uri, Charsets.UTF_8);
            for (Map.Entry<String, String> keyVal : jsonValues.entrySet()) {
                jsonString = jsonString.replaceAll(keyVal.getKey(),
                        keyVal.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}
