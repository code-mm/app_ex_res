package com.my.app.gen_java;

import com.my.app.GenGraphql;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.apache.commons.collections4.map.HashedMap;

import java.io.*;
import java.util.*;
import java.lang.*;

@SuppressWarnings("all")
public class GaenApp {
    public static final Random random = new Random();

    public static String getType() {
        int i = random.nextInt(4);
        if (i == 0) {
            return "String";
        }
        if (i == 1) {
            return "Integer";
        }
        if (i == 2) {
            return "Boolean";
        }
        if (i == 3) {
            return "Double";
        }
        if (i == 4) {
            return "Long";
        }
        return "Float";
    }


    public static final String APP = "pflbs";
    public static final String _CLASS = APP.toUpperCase(Locale.ROOT);
    public static final String OUT_PATH = "out";

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < random.nextInt(500); i++) {
            gen("com."+APP+"." + GenGraphql.getName().toLowerCase());
        }
    }


    public static void gen(String packageName) throws Exception {
        for (int i = 0; i < 10+random.nextInt(90); i++) {
            String className = _CLASS + GenGraphql.getName();
            List<JavaPropertiesModel> propertiesModels = new ArrayList<>();
            for (int j = 0; j < 2+random.nextInt(80); j++) {
                propertiesModels.add(new JavaPropertiesModel(getType(), GenGraphql.getName(), false));
            }
            Configuration config = new Configuration();
            config.setObjectWrapper(new DefaultObjectWrapper());
            Template template = config.getTemplate("flt/java.flt", "UTF-8");

            JavaModel javaModel = new JavaModel(packageName, className, propertiesModels);

            String outPath = OUT_PATH + "/" +APP+"/"+ packageName.replace(".", "/");
            File file = new File(outPath);
            if (!file.exists()) {
                file.mkdirs();
            }

            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath + "/" + className + ".java"), "UTF-8"));
            template.process(javaModel, out);
            out.flush();
            out.close();
        }
    }
}