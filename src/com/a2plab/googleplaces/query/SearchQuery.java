package com.a2plab.googleplaces.query;

import android.location.Location;

/**
 * @author Giuseppe Mastroeni - aka: Kataklisma E-Mail: m.giuseppe@a2plab.com
 * 
 */
public abstract class SearchQuery extends Query {

	public SearchQuery(String apiKey) {
		super(apiKey);
	}

	/**
	 * @param latitude
	 * @param longitude
	 */
	public SearchQuery setLocation(double latitude, double longitude) {
		String location = Double.toString(latitude) + "," + Double.toString(longitude);
		queryBuilder.addParameter("location", location);
		return this;
	}

	/**
	 * @param value
	 * @return
	 */
	public SearchQuery setOpenNow(boolean value) {
		queryBuilder.addParameter("opennow", Boolean.toString(value));
		return this;
	}

	/**
	 * @param location
	 * @return
	 */
	public SearchQuery setLocation(Location location) {
		setLocation(location.getLatitude(), location.getLongitude());
		return this;
	}

	/**
	 * @param radius
	 */
	public SearchQuery setRadius(int radius) {
		queryBuilder.addParameter("radius", Integer.toString(radius));
		return this;
	}

	/**
	 * @param type
	 */
	public void addType(String type) {
		StringBuilder builder = new StringBuilder();
		String currentTypes = queryBuilder.getParameter("types");
		if(currentTypes != null){
			builder.append(currentTypes);
		}
		queryBuilder.addParameter("types", builder.append(type).append("|").toString());
	}

	/**
	 * @return StringBuilder types
	 */
	public String getTypes() {
		return queryBuilder.getParameter("types");
	}

}
