package com.a2plab.googleplaces.query;

import android.location.Location;

/**
 * @author Giuseppe Mastroeni - aka: Kataklisma E-Mail: m.giuseppe@a2plab.com
 * 
 */
public class NearbySearchQuery extends SearchQuery {

	public enum Ranking {
		Prominence, Distance
	};

	/**
	 * @param apiKey
	 * @param location
	 */
	public NearbySearchQuery(String apiKey, Location location) {
		this(apiKey, location.getLatitude(), location.getLongitude());
	}

	/**
	 * @param apiKey
	 * @param lat
	 * @param lon
	 */
	public NearbySearchQuery(String apiKey, double lat, double lon,boolean sensor) {
		this(apiKey, lat, lon);
		
		
	}
	
	/**
	 * @param apiKey
	 * @param lat
	 * @param lon
	 */
	public NearbySearchQuery(String apiKey, double lat, double lon) {
		super(apiKey);
		setLocation(lat, lon);
		setRadius(DEFAULT_RADIUS);
	}

	/**
	 * @param ranking
	 */
	public void setRanking(Ranking ranking) {
		queryBuilder.addParameter("rankby", ranking.toString());
	}

	/**
	 * @param keyword
	 */
	public void setKeyword(String keyword) {
		queryBuilder.addParameter("keyword", keyword);
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		queryBuilder.addParameter("name", name);
	}

	/**
	 * @param pageToken
	 */
	public void setPageToken(String pageToken) {
		queryBuilder.addParameter("pagetoken", pageToken);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.a2plab.googleplaces.query.Query#getUrl()
	 */
	@Override
	public String getUrl() {
		return "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
	}
}
