package com.github.legal.common.util.json;

import com.github.legal.common.bean.HeAccessToken;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * @author luohao
 */
public class HeAccessTokenAdapter implements JsonDeserializer<HeAccessToken> {

    @Override
    public HeAccessToken deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        HeAccessToken accessToken = new HeAccessToken();
        JsonObject accessTokenJsonObject = json.getAsJsonObject();

        if (accessTokenJsonObject.get("access_token") != null && !accessTokenJsonObject.get("access_token").isJsonNull()) {
            accessToken.setAccessToken(GsonHelper.getAsString(accessTokenJsonObject.get("access_token")));
        }

        if (accessTokenJsonObject.get("expires_in") != null && !accessTokenJsonObject.get("expires_in").isJsonNull()) {
            accessToken.setExpiresIn(GsonHelper.getAsPrimitiveInt(accessTokenJsonObject.get("expires_in")));
        }

        return accessToken;
    }

}
