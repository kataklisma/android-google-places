package com.a2plab.googleplaces.query;

import java.io.IOException;

import com.google.api.client.http.HttpRequest;

public abstract class Query {

	protected static int DEFAULT_RADIUS =2500;
	protected QueryBuilder queryBuilder = new QueryBuilder();

	public Query(String apiKey) {
		setKey(apiKey);
		setSensor(true);
	}
	
	public Query(String apiKey, boolean sensor) {
		setKey(apiKey);
		setSensor(sensor);
	}

	/**
	 * @return
	 */
	public abstract String getUrl();

	/**
	 * @param apiKey
	 */
	private void setKey(String apiKey) {
		queryBuilder.addParameter("key", apiKey);
	}

	/**
	 * @param sensor
	 */
	public void setSensor(boolean sensor) {
		queryBuilder.addParameter("sensor", Boolean.toString(sensor));
	}

	/**
	 * @param language
	 */
	public void setLanguage(String language) {
		queryBuilder.addParameter("language", language);
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public HttpRequest getRequest() throws IOException {
		return queryBuilder.generateRequest(this);
	}
	
	/**
	 * @param name
	 * @return
	 */
	protected String getParameter(String name) {
		return this.queryBuilder.getParameter(name);
	}

	/**
	 * @param name
	 * @return
	 */
	protected boolean removeParameter(String name) {
		return queryBuilder.removeParameter(name);
	}

	/**
     * 
     */
	protected void clearParameters() {
		queryBuilder.clearParameters();
	}
}
