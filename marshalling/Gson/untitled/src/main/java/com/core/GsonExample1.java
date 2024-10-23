package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GsonExample1 {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Staff staff = createStaffObject();
        String json = gson.toJson(staff);
        try (FileWriter writer = new FileWriter("untitled/json/staff.json")) {


            gson.toJson(staff, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Staff createStaffObject() {

        Staff staff = new Staff();

        staff.setName("oleg");
        staff.setAge(35);
        staff.setPosition(new String[]{"Founder", "SEO", "coder"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;

    }

}
