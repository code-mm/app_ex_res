package com.my.app;

import com.apifan.common.random.RandomSource;

import java.io.PrintStream;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class GenManifest {

    public static final Random random = new Random();


    public static String getClassName() {
        int i = random.nextInt(8);
        String a1 = UUID.randomUUID().toString().replace("-", "").substring(0, i);
        i = random.nextInt(8);
        String a2 = UUID.randomUUID().toString().replace("-", "").substring(0, i);
        i = random.nextInt(8);
        String a3 = UUID.randomUUID().toString().replace("-", "").substring(0, i);


        String s1 = RandomSource.personInfoSource().randomEnglishName().substring(0, 1).toLowerCase();
        String s2 = RandomSource.personInfoSource().randomEnglishName().substring(0, 1).toLowerCase();
        String s3 = RandomSource.personInfoSource().randomEnglishName().substring(0, 1).toLowerCase();

        return s1 + a1 + "." + s2 + a2 + "." + s3 + a3 + "." + RandomSource.personInfoSource().randomEnglishName().replace(" ", "");
    }


    public static void main(String[] args) throws Exception {
        StringBuilder r = new StringBuilder();
        r.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\n");
        r.append("<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\">").append("\n");
        r.append("<application>").append("\n");

        Set<String> names = new TreeSet<>();
        for (int i = 0; i < 200; i++) {
            names.add(getClassName());
        }

        for (String name : names) {
            r.append("<activity\n" +
                    "                    android:name=\"" + name + "\"\n" +
                    "                    android:configChanges=\"keyboard|keyboardHidden|orientation|screenSize\"\n" +
                    "                    android:screenOrientation=\"portrait\" />").append("\n");
        }

        r.append("</application>").append("\n");
        r.append("</manifest>");

        System.out.println(r.toString());
        PrintStream ps = new PrintStream("/Users/maohuawei/src/yc/android-app-resources/res_cyzqb/AndroidManifest.xml");
        ps.println(r.toString());
        ps.close();
    }
}
