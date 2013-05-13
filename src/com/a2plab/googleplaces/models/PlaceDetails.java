package com.a2plab.googleplaces.models;

import java.io.Serializable;
import java.util.List;

import com.google.api.client.util.Key;

public class PlaceDetails extends Place {

	private static final long serialVersionUID = 8644547729432741509L;

	@Key
	protected String formatted_phone_number;

	@Key
	protected AddressComponents[] address_components;

	@Key
	protected Event[] events;

	@Key
	protected String international_phone_number;

	@Key
	protected String url;

	@Key
	protected double rating;

	@Key
	protected String[] types;

	@Key
	protected String website;

	@Key
	protected int utc_offset;

	@Key
	protected OpeningHours opening_hours;

	@SuppressWarnings("serial")
	public static class AddressComponents implements Serializable {

		@Key
		public String long_name;

		@Key
		public String short_name;

		@Key
		public List<String> types;
	}

	@SuppressWarnings("serial")
	public static class OpeningHours implements Serializable {

		@Key
		public boolean open_now;

		@Key
		public List<Period> periods;

		public static class Period implements Serializable {

			@Key
			public OpenClose open;

			@Key
			public OpenClose close;

			public static class OpenClose implements Serializable {
				@Key
				public int day;
				@Key
				public int time;
			}
		}

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFormattedPhoneNumber() {
		return formatted_phone_number;
	}

	public AddressComponents[] getAddressComponents() {
		return address_components;
	}

	public Event[] getEvents() {
		return events;
	}

	public String getInternationalPhoneNumber() {
		return international_phone_number;
	}

	public String getUrl() {
		return url;
	}

	public double getRating() {
		return rating;
	}

	public String[] getTypes() {
		return types;
	}

	public String getWebsite() {
		return website;
	}

	public int getUtcOffset() {
		return utc_offset;
	}

	public OpeningHours getOpeningHours() {
		return opening_hours;
	}
}
