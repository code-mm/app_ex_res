package com.my.app;

import com.apifan.common.random.RandomSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.PrintStream;
import java.util.*;

public class GenStringMainApplication {
    public static String getName() {

        int i = random.nextInt(10);

        if(i==1){
            return RandomSource.personInfoSource().randomEnglishName().toLowerCase().replaceAll(" ","_");
        }else if(i==2){
            return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 2).toLowerCase();
        }else if(i==3){
            return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 3).toLowerCase();
        }else if(i==4){
            return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 4).toLowerCase();
        }else if(i==5){
            return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 5).toLowerCase();
        }else if(i==6){
            return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 6).toLowerCase();
        }else if(i==7){
            return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 7).toLowerCase();
        }else if(i==8){
            return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 8).toLowerCase();
        }else if(i==9){
            return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 9).toLowerCase();
        }else if(i==10){
            return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 10).toLowerCase();
        }
        return "cyzqb_" + UUID.randomUUID().toString().replace("-","").substring(0, 6).toLowerCase();
    }

    public static final Random random = new Random();

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

    public static void main(String[] args) throws Exception {
        StringBuilder r = new StringBuilder("<resources>\n");
        Set<String> names = new TreeSet<>();
        for (int i = 0; i < 3000; i++) {
            names.add(getName());
        }
        for (String name : names) {
            r.append("<string name=\"" + name + "\">" + getValue() + "</string>").append("\n");
        }
        r.append("</resources>");
        System.out.println(r.toString());
        PrintStream ps = new PrintStream("/Users/maohuawei/src/yc/android-app-resources/res_cyzqb/res/values/strings.xml");
        ps.println(r.toString());
        ps.close();

    }
}