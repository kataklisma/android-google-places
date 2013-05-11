package com.a2plab.googleplaces.query;

/**
 * @author Giuseppe Mastroeni - aka: Kataklisma E-Mail: m.giuseppe@a2plab.com
 * 
 */
public class DetailsQuery extends Query {

	/**
	 * @param apiKey
	 * @param reference
	 */
	public DetailsQuery(String apiKey, String reference) {
		super(apiKey);
		setReference(reference);
	}

	/**
	 * @param reference
	 */
	public DetailsQuery setReference(String reference) {
		queryBuilder.addParameter("reference", reference);
		return this;
	}

	/**
	 * @param value
	 * @return
	 */
	public DetailsQuery setOpenNow(boolean value) {
		queryBuilder.addParameter("opennow", Boolean.toString(value));
		return this;
	}

	/**
	 * Experimental for google. not use this!
	 * 
	 * @param value
	 */
	protected DetailsQuery setExtensions(String value) {
		queryBuilder.addParameter("extensions", value);
		return this;
	}

	/**
     * 
     */
	public DetailsQuery setExtensions() {
		queryBuilder.addParameter("extensions", "review_summary");
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.a2plab.googleplaces.query.Query#getUrl()
	 */
	@Override
	public String getUrl() {
		return "https://maps.googleapis.com/maps/api/place/details/json?";
	}

}