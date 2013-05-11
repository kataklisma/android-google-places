package com.a2plab.googleplaces.query;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;

/**
 * @author Giuseppe Mastroeni - aka: Kataklisma E-Mail: m.giuseppe@a2plab.com
 * 
 */
class QueryBuilder {

	private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	private HashMap<String, String> parameters = new HashMap<String, String>();

	/**
	 * @param name
	 * @param value
	 */
	protected void addParameter(String name, String value) {
		parameters.put(name, value);
	}

	/**
	 * @param name
	 * @return
	 */
	protected String getParameter(String name) {
		return parameters.get(name);
	}

	/**
	 * @param name
	 * @return
	 */
	protected boolean removeParameter(String name) {
		return parameters.remove(name) != null ? true : false;
	}

	/**
     * 
     */
	protected void clearParameters() {
		parameters.clear();
	}

	/**
	 * @param query
	 * @return
	 * @throws IOExceptions
	 */
	protected HttpRequest generateRequest(Query query) throws IOException  {
		HttpRequest request = createRequestFactory(HTTP_TRANSPORT).buildGetRequest(new GenericUrl(query.getUrl()));

		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			request.getUrl().put(entry.getKey(), entry.getValue());
		}
		return request;
	}

	/**
	 * @param transport
	 * @return
	 */
	private static HttpRequestFactory createRequestFactory(final HttpTransport transport) {

		return transport.createRequestFactory(new HttpRequestInitializer() {
			public void initialize(HttpRequest request) {
				request.setHeaders(new HttpHeaders());
				request.setParser(new JsonObjectParser(new GsonFactory()));
			}
		});
	}
}
