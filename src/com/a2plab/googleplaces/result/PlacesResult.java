package com.a2plab.googleplaces.result;

import java.util.List;

import com.a2plab.googleplaces.models.Place;
import com.google.api.client.util.Key;

public class PlacesResult extends Result {

    @Key
    public List<Place> results;

    /**
     * @return the results
     */
    public List<Place> getResults() {
        return results;
    }

}
