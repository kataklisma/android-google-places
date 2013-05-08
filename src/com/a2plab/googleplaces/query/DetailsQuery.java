package com.a2plab.googleplaces.query;

public class DetailsQuery extends Query {

    public DetailsQuery(String apiKey, String reference) {
        super(apiKey);
        setReference(reference);
    }

    public void setReference(String reference) {
        queryBuilder.addParameter("reference", reference);
    }

    @Override
    public String getUrl() {
        return "https://maps.googleapis.com/maps/api/place/details/json?";
    }

}