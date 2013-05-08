package com.a2plab.googleplaces.result;

import java.util.List;

import com.a2plab.googleplaces.models.PlaceDetails;
import com.google.api.client.util.Key;

public class PlaceDetailsResult extends Result {

	@Key
	public PlaceDetails result;

	/**
	 * @return the results
	 */
	public PlaceDetails getResults() {
		return result;
	}

}
