package com.a2plab.googleplaces.query;

import android.location.Location;

public abstract class SearchQuery extends Query {

	public SearchQuery(String apiKey) {
        super(apiKey);
    }

    private StringBuilder mTypes = new StringBuilder();
	
	public void setLocation(double latitude, double longitude) {
		String location = Double.toString(latitude) + "," + Double.toString(longitude);
		queryFactory.addParameter("location", location);
	}
	
	public void setLocation(Location location) {
		setLocation(location.getLatitude(), location.getLongitude());
	}
	
	public void setRadius(int radius) {
		queryFactory.addParameter("radius", Integer.toString(radius));
	}
	
	public void setKey(String key) {
		queryFactory.addParameter("key", key);
	}
	
	public void addType(String type) {
		mTypes.append(type);
		mTypes.append("|");
		mTypes.deleteCharAt(mTypes.length() - 1);
	}
	
	@Override
	public String toString() {
		queryFactory.addParameter("types", mTypes.toString());
		return (getUrl() + queryFactory.toString());
	}
}
