package com.solvd.laba.filereader;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FIleReader {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(FIleReader.class);

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/lorem.txt");

        String content = null;
        try {
            content = StringUtils.lowerCase(FileUtils.readFileToString(file, StandardCharsets.UTF_8).replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", ""));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        String[] words = new String[0];
        if (content != null) {
            words = content.split(" ");
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, StringUtils.countMatches(content, word));
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Word:" + entry.getKey() + " - " + "value: " + entry.getValue());
        }

        File fileOutput = new File(System.getProperty("user.dir") + "/src/main/resources/fileOutput.txt");
        try {
            FileUtils.writeLines(fileOutput, list);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
