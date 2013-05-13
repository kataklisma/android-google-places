package com.a2plab.googleplaces.result;

import java.util.List;

import com.a2plab.googleplaces.models.Place;
import com.google.api.client.util.Key;

public class PlacesResult extends Result {

	@Key
	public List<? extends Place> results;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.a2plab.googleplaces.result.Result#getResult()
	 */
	@Override
	public List<? extends Place> getResults() {
		return results;
	}

}
