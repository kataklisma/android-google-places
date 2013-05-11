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
	public NearbySearchQuery(String apiKey, double lat, double lon) {
		super(apiKey);
		setLocation(lat, lon);
		setRadius(DEFAULT_RADIUS);
	}

	/**
	 * @param ranking
	 */
	public NearbySearchQuery setRanking(Ranking ranking) {
		queryBuilder.addParameter("rankby", ranking.toString());
		return this;
	}

	/**
	 * @param keyword
	 */
	public NearbySearchQuery setKeyword(String keyword) {
		queryBuilder.addParameter("keyword", keyword);
		return this;
	}

	/**
	 * @param name
	 */
	public NearbySearchQuery setName(String name) {
		queryBuilder.addParameter("name", name);
		return this;
	}

	/**
	 * @param pageToken
	 */
	public NearbySearchQuery setPageToken(String pageToken) {
		queryBuilder.addParameter("pagetoken", pageToken);
		return this;
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
