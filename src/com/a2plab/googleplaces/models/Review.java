package com.a2plab.googleplaces.models;

import java.io.Serializable;
import java.util.List;

import com.google.api.client.util.Key;

public class Review implements Serializable {

    private static final long serialVersionUID = -8634439242407814234L;

    @Key
    protected List<Aspect> aspects;

    @Key
    public String author_name;

    @Key
    public String author_url;

    @Key
    public String text;

    @Key
    public long time;

    public static class Aspect implements Serializable {

        private static final long serialVersionUID = 6296158628038780369L;

        @Key
        public String type;

        @Key
        public double rating;

    }

    public List<Aspect> getAspects() {
        return aspects;
    }

    public String getAuthorName() {
        return author_name;
    }

    public String getAuthorUrl() {
        return author_url;
    }

    public String getText() {
        return text;
    }

    public long getTime() {
        return time;
    }

}
