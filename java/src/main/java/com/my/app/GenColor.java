package com.my.app;

import com.apifan.common.random.RandomSource;

import java.io.PrintStream;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class GenColor {

    public static final Random random = new Random();

    public static String getName() {

        int i = random.nextInt(10);

        if (i == 1) {
            return RandomSource.personInfoSource().randomEnglishName().toLowerCase().replaceAll(" ", "_");
        } else if (i == 2) {
            return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 2).toLowerCase();
        } else if (i == 3) {
            return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 3).toLowerCase();
        } else if (i == 4) {
            return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 4).toLowerCase();
        } else if (i == 5) {
            return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 5).toLowerCase();
        } else if (i == 6) {
            return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toLowerCase();
        } else if (i == 7) {
            return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 7).toLowerCase();
        } else if (i == 8) {
            return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 8).toLowerCase();
        } else if (i == 9) {
            return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 9).toLowerCase();
        } else if (i == 10) {
            return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 10).toLowerCase();
        }
        return "cyzqb_" + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toLowerCase();
    }


    public static void main(String[] args) throws Exception {

        StringBuilder r = new StringBuilder();
        r.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        r.append("<resources>");

        Set<String> names = new TreeSet<>();
        for (int i = 0; i < 199; i++) {
            names.add(getName());
        }
        for (String name : names) {
            r.append("<color name=\"" + name + "\">" + RandomSource.otherSource().randomHexColor() + "</color>").append("\n");
        }

        r.append("</resources>");
        System.out.println(r.toString());

        PrintStream ps = new PrintStream("/Users/maohuawei/src/yc/android-app-resources/res_cyzqb/res/values/colors.xml");
        ps.println(r.toString());
        ps.close();


    }
}
