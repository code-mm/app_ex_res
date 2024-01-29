package com.my.app.gen_java;

import java.util.List;

public class JavaModel {

    private String packageName;

    private String className;

    private List<JavaPropertiesModel> properties;


    public JavaModel(String packageName, String className, List<JavaPropertiesModel> properties) {
        this.packageName = packageName;
        this.className = className;
        this.properties = properties;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<JavaPropertiesModel> getProperties() {
        return properties;
    }

    public void setProperties(List<JavaPropertiesModel> properties) {
        this.properties = properties;
    }
}
