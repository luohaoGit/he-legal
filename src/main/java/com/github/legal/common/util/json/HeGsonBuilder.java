package com.github.legal.common.util.json;

import com.github.legal.common.bean.result.HeError;
import com.google.gson.Gson;

public class HeGsonBuilder {

    public static final com.google.gson.GsonBuilder INSTANCE = new com.google.gson.GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();
        INSTANCE.registerTypeAdapter(HeError.class, new HeErrorAdapter());
    }

    public static Gson create() {
        return INSTANCE.create();
    }

}
