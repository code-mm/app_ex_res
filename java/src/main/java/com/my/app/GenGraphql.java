package com.my.app;

import com.apifan.common.random.RandomSource;

import java.io.PrintStream;
import java.util.Random;

public class GenGraphql {


    public static final Random random = new Random();

    public static String getType() {

        int i = random.nextInt(4);

        if (i == 0) {
            return "String";
        }

        if (i == 1) {
            return "Int";
        }

        if (i == 2) {
            return "Boolean";
        }
        if (i == 3) {
            return "String";
        }
        return "Float";
    }

    public static String getName() {
        return RandomSource.personInfoSource().randomEnglishName().replace(" ", "");
    }

    public static void main(String[] args) throws Exception {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < 1500; i++) {
            r.append("type CYJCS_" + getName() + "{").append("\n");
            for (int j = 0; j < 5+random.nextInt(50); j++) {
                r.append(getName() + ":" + getType()).append("\n");
            }
            r.append("}").append("\n");
        }
        System.out.println(r.toString());

        PrintStream ps = new PrintStream("graphqls/cyjcs.graphqls");
        ps.println(r.toString());
        ps.close();
    }
}
