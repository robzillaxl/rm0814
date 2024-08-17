package com.robzilla.toolrental.model;

public interface Tool {

    enum ToolType {
        LADDER,
        CHAINSAW,
        JACKHAMMER
    }

    ToolType getToolType();
    String getBrand();

}
