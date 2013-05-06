package com.a2plab.googleplaces.query;

import android.location.Location;

public class NearbySearchQuery extends SearchQuery {

    public enum Ranking {
        Prominence, Distance
    };

    public NearbySearchQuery(String apiKey, Location location) {
        this(apiKey, location.getLatitude(), location.getLongitude());
    }

    public NearbySearchQuery(String apiKey, double lat, double lon) {
        super(apiKey);
        setLocation(lat, lon);
        setRadius(2500);
    }

    public void setRanking(Ranking ranking) {
        queryFactory.addParameter("rankby", ranking.toString());
    }

    public void setKeyword(String keyword) {
        queryFactory.addParameter("keyword", keyword);
    }

    public void setName(String name) {
        queryFactory.addParameter("name", name);
    }

    public void setPageToken(String pageToken) {
        queryFactory.addParameter("pagetoken", pageToken);
    }

    @Override
    public String getUrl() {
        return "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
    }
}
