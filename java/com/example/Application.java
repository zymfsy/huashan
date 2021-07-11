package com.example;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    private static Map<String,List<String>> reload(String path) throws IOException {
        File[] files = new File(path).listFiles();
        Map<String,List<String>> map = new HashMap<>();
        assert files != null;
        for (File file : files) {
            List<String> sections = Files.readAllLines(file.toPath());
            sections = sections.stream().map(String::trim).collect(Collectors.toList());
            sections.removeIf(StringUtils::isEmpty);
            String title = file.getName().substring(0, file.getName().indexOf("."));
            map.put(title,sections);
        }
        return map;
    }
    public static void main(String[] args) {
        try {
            Map<String, List<String>> reload = reload("F:\\文档\\Markdown\\spring");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

