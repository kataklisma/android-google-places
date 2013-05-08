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
	public void setReference(String reference) {
		queryBuilder.addParameter("reference", reference);
	}

	/**
	 * Experimental for google. not use this!
	 * 
	 * @param value
	 */
	protected void setExtensions(String value) {
		queryBuilder.addParameter("extensions", value);
	}

	/**
     * 
     */
	public void setExtensions() {
		queryBuilder.addParameter("extensions", "review_summary");
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