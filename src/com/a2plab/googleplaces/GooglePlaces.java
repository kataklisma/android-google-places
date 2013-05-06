package com.a2plab.googleplaces;

import java.io.IOException;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.a2plab.googleplaces.models.PlacesResult;
import com.a2plab.googleplaces.models.Result;
import com.a2plab.googleplaces.query.NearbySearchQuery;
import com.a2plab.googleplaces.query.Query;
import com.a2plab.googleplaces.query.TextSearchQuery;

public class GooglePlaces {

    private String mApiKey = "";
    private AbstractSet<String> mSupportedPlaces;

    public GooglePlaces(String apiKey) {
        mApiKey = apiKey;
        loadSupportedPlaces();
    }

    public Result getPlaces(List<String> types, String keyword, int radius, double lat, double lon) throws JSONException,
            ClientProtocolException, IOException {
        NearbySearchQuery query = new NearbySearchQuery(mApiKey, lat, lon);

        query.setRadius(radius);

        if (types != null) {
            for (String type : types) {
                query.addType(type);
            }
        }

        if (keyword != null && keyword != "") {
            query.setKeyword(keyword);
        }

        return getPlaces(query);
    }

    public Result getPlaces(List<String> types, int radius, double lat, double lon) throws ClientProtocolException,
            JSONException, IOException {
        return getPlaces(types, null, radius, lat, lon);
    }

    public Result getPlaces(String type, String keyword, int radius, double lat, double lon) throws ClientProtocolException,
            JSONException, IOException {
        List<String> types = Arrays.asList(type);
        return getPlaces(types, keyword, radius, lat, lon);
    }

    public Result getPlaces(String type, int radius, double lat, double lon) throws ClientProtocolException, JSONException,
            IOException {
        return getPlaces(type, null, radius, lat, lon);
    }

    public Result getPlaces(String searchText, double lat, double lon) throws ClientProtocolException, JSONException, IOException {
        TextSearchQuery query = new TextSearchQuery(mApiKey, searchText);
        query.setLocation(lat, lon);
        return getPlaces(query);
    }

    public Result getPlaces(String searchText) throws ClientProtocolException, JSONException, IOException {
        return getPlaces(new TextSearchQuery(mApiKey, searchText));
    }

    public Result getPlaces(Query query) throws JSONException, ClientProtocolException, IOException {
        return this.getPlaces(query, PlacesResult.class);
    }

    public Result getPlaces(Query query, Class<? extends Result> resultClass) throws JSONException, ClientProtocolException,
            IOException {
        return retrievePlaces(query, resultClass);
    }

    // public DetailsResult getPlaceDetails(String reference) throws
    // JSONException, ClientProtocolException, IOException {
    // DetailsQuery query = new DetailsQuery(reference);
    // DetailsResult result = getPlaceDetails(query);
    //
    // return result;
    // }

    // public DetailsResult getPlaceDetails(Query query) throws JSONException,
    // ClientProtocolException, IOException {
    // JSONObject response = executeRequest(query.toString());
    // DetailsResult result = new DetailsResult(response);
    //
    // return result;
    // }

    public boolean isSupportedPlace(String placeType) {
        return (mSupportedPlaces.contains(placeType));
    }

    private Result retrievePlaces(Query query, Class<? extends Result> resultClass) throws ClientProtocolException, IOException,
            JSONException {
        return query.getRequest().execute().parseAs(resultClass);
    }

    private void loadSupportedPlaces() {
        mSupportedPlaces = new HashSet<String>();

        mSupportedPlaces.add("accounting");
        mSupportedPlaces.add("airport");
        mSupportedPlaces.add("amusement park");
        mSupportedPlaces.add("aquarium");
        mSupportedPlaces.add("art gallery");
        mSupportedPlaces.add("atm");
        mSupportedPlaces.add("bakery");
        mSupportedPlaces.add("bank");
        mSupportedPlaces.add("bar");
        mSupportedPlaces.add("beauty salon");
        mSupportedPlaces.add("bicycle store");
        mSupportedPlaces.add("book store");
        mSupportedPlaces.add("bowling alley");
        mSupportedPlaces.add("bus station");
        mSupportedPlaces.add("cafe");
        mSupportedPlaces.add("campground");
        mSupportedPlaces.add("car dealer");
        mSupportedPlaces.add("car rental");
        mSupportedPlaces.add("car repair");
        mSupportedPlaces.add("car wash");
        mSupportedPlaces.add("casino");
        mSupportedPlaces.add("cemetery");
        mSupportedPlaces.add("church");
        mSupportedPlaces.add("city hall");
        mSupportedPlaces.add("clothing store");
        mSupportedPlaces.add("convenience store");
        mSupportedPlaces.add("courthouse");
        mSupportedPlaces.add("dentist");
        mSupportedPlaces.add("department store");
        mSupportedPlaces.add("doctor");
        mSupportedPlaces.add("electrician");
        mSupportedPlaces.add("electronics store");
        mSupportedPlaces.add("embassy");
        mSupportedPlaces.add("establishment");
        mSupportedPlaces.add("finance");
        mSupportedPlaces.add("fire station");
        mSupportedPlaces.add("florist");
        mSupportedPlaces.add("food");
        mSupportedPlaces.add("funeral home");
        mSupportedPlaces.add("furniture store");
        mSupportedPlaces.add("gas station");
        mSupportedPlaces.add("general contractor");
        mSupportedPlaces.add("grocery or supermarket");
        mSupportedPlaces.add("gym");
        mSupportedPlaces.add("hair care");
        mSupportedPlaces.add("hardware store");
        mSupportedPlaces.add("health");
        mSupportedPlaces.add("hindu temple");
        mSupportedPlaces.add("home goods store");
        mSupportedPlaces.add("hospital");
        mSupportedPlaces.add("insurance agency");
        mSupportedPlaces.add("jewelry store");
        mSupportedPlaces.add("laundry");
        mSupportedPlaces.add("lawyer");
        mSupportedPlaces.add("library");
        mSupportedPlaces.add("liquor store");
        mSupportedPlaces.add("local government office");
        mSupportedPlaces.add("locksmith");
        mSupportedPlaces.add("lodging");
        mSupportedPlaces.add("meal delivery");
        mSupportedPlaces.add("meal takeaway");
        mSupportedPlaces.add("mosque");
        mSupportedPlaces.add("movie rental");
        mSupportedPlaces.add("movie theater");
        mSupportedPlaces.add("moving company");
        mSupportedPlaces.add("museum");
        mSupportedPlaces.add("night club");
        mSupportedPlaces.add("painter");
        mSupportedPlaces.add("park");
        mSupportedPlaces.add("parking");
        mSupportedPlaces.add("pet store");
        mSupportedPlaces.add("pharmacy");
        mSupportedPlaces.add("physiotherapist");
        mSupportedPlaces.add("place of worship");
        mSupportedPlaces.add("plumber");
        mSupportedPlaces.add("police");
        mSupportedPlaces.add("post office");
        mSupportedPlaces.add("real estate agency");
        mSupportedPlaces.add("restaurant");
        mSupportedPlaces.add("roofing contractor");
        mSupportedPlaces.add("rv park");
        mSupportedPlaces.add("school");
        mSupportedPlaces.add("shoe store");
        mSupportedPlaces.add("shopping mall");
        mSupportedPlaces.add("spa");
        mSupportedPlaces.add("stadium");
        mSupportedPlaces.add("storage");
        mSupportedPlaces.add("store");
        mSupportedPlaces.add("subway station");
        mSupportedPlaces.add("synagogue");
        mSupportedPlaces.add("taxi stand");
        mSupportedPlaces.add("train station");
        mSupportedPlaces.add("travel agency");
        mSupportedPlaces.add("university");
        mSupportedPlaces.add("veterinary care");
        mSupportedPlaces.add("zoo");
    }
}
