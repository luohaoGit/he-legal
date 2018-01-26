package com.github.legal.param;

import java.io.Serializable;

/**
 * Created by luohao on 26/01/2018.
 */
public class CommonResp implements Serializable{

    private String app_grant_type;
    private String access_token;
    private String open_id;
    private String scope;
    private String expires_in;
    private String state;
    private String sig;
    private String error;

    public String getApp_grant_type() {
        return app_grant_type;
    }

    public void setApp_grant_type(String app_grant_type) {
        this.app_grant_type = app_grant_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
