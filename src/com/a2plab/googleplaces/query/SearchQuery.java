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
	public void setLocation(double latitude, double longitude) {
		String location = Double.toString(latitude) + "," + Double.toString(longitude);
		queryBuilder.addParameter("location", location);
	}

	public void setOpenNow(boolean value) {
		queryBuilder.addParameter("opennow", Boolean.toString(value));
	}

	/**
	 * @param location
	 */
	public void setLocation(Location location) {
		setLocation(location.getLatitude(), location.getLongitude());
	}

	/**
	 * @param radius
	 */
	public void setRadius(int radius) {
		queryBuilder.addParameter("radius", Integer.toString(radius));
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
