package com.a2plab.googleplaces.query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;

class QueryFactory {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private List<NameValuePair> mParameters = new ArrayList<NameValuePair>();

    public void addParameter(String name, String value) {
        removeParameter(name);
        mParameters.add(new BasicNameValuePair(name, value));
    }

    public void removeParameter(String name) {
        if (mParameters.contains(name)) {
            mParameters.remove(name);
        }
    }

    public void clearParameters() {
        mParameters.clear();
    }

    protected HttpRequest generateRequest(Query query) throws IOException {
        HttpRequest request = createRequestFactory(HTTP_TRANSPORT).buildGetRequest(new GenericUrl(query.getUrl()));
        for (NameValuePair parameter : mParameters) {
            request.getUrl().put(parameter.getName(), parameter.getValue());
        }
        return request;
    }

    private static HttpRequestFactory createRequestFactory(final HttpTransport transport) {

        return transport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
                request.setHeaders(new HttpHeaders());
                request.setParser(new JsonObjectParser(new GsonFactory()));
            }
        });
    }
}
