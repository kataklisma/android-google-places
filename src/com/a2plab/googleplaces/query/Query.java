package com.a2plab.googleplaces.query;

import java.io.IOException;

import com.google.api.client.http.HttpRequest;

public abstract class Query {

	protected QueryBuilder queryFactory = new QueryBuilder();
	
	public Query(String apiKey) {
	    setKey(apiKey);
		setSensor(false);
	}
	
	private void setKey(String apiKey) {
        queryFactory.addParameter("key",apiKey);
    }

    public void setSensor(boolean sensor) {
		queryFactory.addParameter("sensor", Boolean.toString(sensor));
	}
	
	public void setLanguage(String language) {
		queryFactory.addParameter("language", language);
	}
	
	public HttpRequest getRequest() throws IOException{
	    return queryFactory.generateRequest(this);
	}
	public abstract String getUrl();
	
	
}
