package com.my.app.gen_java;

public class JavaPropertiesModel {

    private String type;
    private String name;

    private boolean isStatic;


    public JavaPropertiesModel(String type, String name, boolean isStatic) {
        this.type = type;
        this.name = name;
        this.isStatic = isStatic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }
}
