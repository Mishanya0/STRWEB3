package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonExample11 {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Staff> staffList = Arrays.asList(createFirstStaff(), createSecondStaff());
        try (FileWriter writer = new FileWriter("untitled/json/staff.json")) {
            gson.toJson(staffList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Staff createFirstStaff() {
        Staff staff = new Staff();
        staff.setName("Oleg");
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
    private static Staff createSecondStaff() {
        Staff staff = new Staff();
        staff.setName("Anna");
        staff.setAge(30);
        staff.setPosition(new String[]{"Manager", "Marketing"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2015", new BigDecimal(9000));
            put("2017", new BigDecimal(11000));
            put("2020", new BigDecimal(13000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("marketing", "sales", "management"));

        return staff;
    }
}
