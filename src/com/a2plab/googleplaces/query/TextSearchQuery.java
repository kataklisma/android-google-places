package com.a2plab.googleplaces.query;

public class TextSearchQuery extends SearchQuery {

    public TextSearchQuery(String apiKey, String query) {
        super(apiKey);
        setQuery(query);
    }

    public void setQuery(String query) {
        queryFactory.addParameter("query", query);
    }

    @Override
    public String getUrl() {
        return "https://maps.googleapis.com/maps/api/place/textsearch/json?";
    }
}
