package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

public class GsonExample2 {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();


        try (Reader reader = new FileReader("untitled/json/staff.json")) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            if (jsonElement.isJsonArray()) {
                Type staffListType = new TypeToken<List<Staff>>(){}.getType();
                List<Staff> staffList = gson.fromJson(jsonElement, staffListType);
                for (Staff staff : staffList) {
                    System.out.println(staff);
                }

            } else if (jsonElement.isJsonObject()) {
                Staff staff = gson.fromJson(jsonElement, Staff.class);
                System.out.println(staff);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
