package com.a2plab.googleplaces.result;

import java.util.ArrayList;
import java.util.List;

import com.a2plab.googleplaces.models.Place;
import com.a2plab.googleplaces.models.PlaceDetails;
import com.google.api.client.util.Key;

public class PlaceDetailsResult extends Result {

	@Key
	public PlaceDetails result;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.a2plab.googleplaces.result.Result#getResult()
	 */
	@Override
	public List<? extends Place> getResults() {
		List<PlaceDetails> detailsList = new ArrayList<PlaceDetails>();
		detailsList.add(result);
		return detailsList;
	}

	public PlaceDetails getDetails() {
		return this.result;
	}

}
