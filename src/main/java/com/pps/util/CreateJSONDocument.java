package com.pps.util;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreateJSONDocument {
    public static void create() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", "1");
        jsonObject.put("description", "First default tasks");
        jsonObject.put("status", "To-do");
        jsonObject.put("createdAt", LocalDateTime.now().toString());
        jsonObject.put("updatedAt", LocalDateTime.now().toString());

        try {
            FileWriter fileWriter = new FileWriter("test.json");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + jsonObject);
    }
}
