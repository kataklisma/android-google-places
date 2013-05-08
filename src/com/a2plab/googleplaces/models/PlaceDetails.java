package com.a2plab.googleplaces.models;

import com.a2plab.googleplaces.query.Query;
import com.google.api.client.util.Key;

public class PlaceDetails extends Place {

	@Key
	protected String formatted_phone_number;

	private static final long serialVersionUID = 8644547729432741509L;

	/**
	 * @return the formatted_phone_number
	 */
	public String getFormattedPhoneNumber() {
		return formatted_phone_number;
	}
}
