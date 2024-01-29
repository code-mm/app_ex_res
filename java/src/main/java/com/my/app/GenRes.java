package com.my.app;

import com.apifan.common.random.RandomSource;

import java.io.File;
import java.io.PrintStream;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class GenRes {


    public static final String TARGET= "pflbs";

    public static final String PREFIX = TARGET.toLowerCase()+"_app_";
    public static final Random random = new Random();
    public static final String BASE_PATH = "/Users/maohuawei/src/yc/android-app-resources/res_"+TARGET+"/";
    public static final String PACKAGE_PREFIX = "com."+TARGET+".";
    public static final int COLOR = 10000;
    public static final int STRING = 12000;
    public static final int MANIFEST = 200;

    public static void main(String[] args) throws Exception {
        genColor();
        genString();
        genManifest();
    }
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
        return PACKAGE_PREFIX + s1 + a1 + "." + s2 + a2 + "." + s3 + a3 + "." + RandomSource.personInfoSource().randomEnglishName().replace(" ", "");
    }

    public static String getValue() {
        int i = random.nextInt(10);
        if (i == 0) {
            return RandomSource.languageSource().randomTangPoem().getContent()[0];
        } else if (i == 1) {
            return RandomSource.languageSource().randomChineseIdiom();
        } else if (i == 2) {
            return RandomSource.languageSource().randomChinese(4);
        } else if (i == 3) {
            return RandomSource.personInfoSource().randomEnglishName();
        } else if (i == 4) {
            return RandomSource.personInfoSource().randomFemaleChineseName();
        } else if (i == 5) {
            return RandomSource.personInfoSource().randomMaleChineseName();
        }
        return UUID.randomUUID().toString().substring(0, 6).toLowerCase();
    }


    public static String getName() {
        int i = random.nextInt(10);
        if (i == 1) {
            return RandomSource.personInfoSource().randomEnglishName().toLowerCase().replaceAll(" ", "_");
        } else if (i == 2) {
            return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 2).toLowerCase();
        } else if (i == 3) {
            return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 3).toLowerCase();
        } else if (i == 4) {
            return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 4).toLowerCase();
        } else if (i == 5) {
            return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 5).toLowerCase();
        } else if (i == 6) {
            return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toLowerCase();
        } else if (i == 7) {
            return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 7).toLowerCase();
        } else if (i == 8) {
            return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 8).toLowerCase();
        } else if (i == 9) {
            return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 9).toLowerCase();
        } else if (i == 10) {
            return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 10).toLowerCase();
        }
        return PREFIX + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toLowerCase();
    }

    private static void genColor() throws Exception {
        StringBuilder r = new StringBuilder();
        r.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        r.append("<resources>");
        Set<String> names = new TreeSet<>();
        for (int i = 0; i < COLOR; i++) {
            names.add(getName());
        }
        for (String name : names) {
            r.append("<color name=\"" + name + "\">" + RandomSource.otherSource().randomHexColor() + "</color>").append("\n");
        }
        r.append("</resources>");
        System.out.println(r.toString());

        if(!new File(BASE_PATH + "res/values/").exists()){
            new File(BASE_PATH + "res/values/").mkdirs();
        }

        PrintStream ps = new PrintStream(BASE_PATH + "res/values/colors.xml");
        ps.println(r.toString());
        ps.close();
    }
    public static void genString() throws Exception {
        StringBuilder r = new StringBuilder("<resources>\n");
        Set<String> names = new TreeSet<>();
        for (int i = 0; i < STRING; i++) {
            names.add(getName());
        }
        for (String name : names) {
            r.append("<string name=\"" + name + "\">" + getValue() + "</string>").append("\n");
        }
        r.append("</resources>");
        System.out.println(r.toString());
        PrintStream ps = new PrintStream(BASE_PATH + "res/values/strings.xml");
        ps.println(r.toString());
        ps.close();
    }

    public static void genManifest() throws Exception {
        StringBuilder r = new StringBuilder();
        r.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\n");
        r.append("<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\">").append("\n");
        r.append("<application>").append("\n");
        Set<String> names = new TreeSet<>();
        for (int i = 0; i < MANIFEST; i++) {
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
        PrintStream ps = new PrintStream(BASE_PATH + "AndroidManifest.xml");
        ps.println(r.toString());
        ps.close();
    }
}
