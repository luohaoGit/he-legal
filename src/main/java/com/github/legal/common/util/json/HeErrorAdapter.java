package com.github.legal.common.util.json;

import com.github.legal.common.bean.result.HeError;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @author luohao.
 */
public class HeErrorAdapter implements JsonDeserializer<HeError> {

    @Override
    public HeError deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        HeError.HeErrorBuilder errorBuilder = HeError.builder();
        JsonObject wxErrorJsonObject = json.getAsJsonObject();

        if (wxErrorJsonObject.get("ret") != null && !wxErrorJsonObject.get("ret").isJsonNull()) {
            errorBuilder.ret(GsonHelper.getAsPrimitiveInt(wxErrorJsonObject.get("ret")));
        }
        if (wxErrorJsonObject.get("msg") != null && !wxErrorJsonObject.get("msg").isJsonNull()) {
            errorBuilder.msg(GsonHelper.getAsString(wxErrorJsonObject.get("msg")));
        }

        return errorBuilder.build();
    }

}
