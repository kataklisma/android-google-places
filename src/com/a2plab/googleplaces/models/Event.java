/**
 * 
 */
package com.a2plab.googleplaces.models;

import java.io.Serializable;

import com.google.api.client.util.Key;

/**
 * @author Giuseppe Mastroeni - aka: Kataklisma E-Mail: m.giuseppe@a2plab.com
 * 
 */
public class Event implements Serializable {

	private static final long serialVersionUID = 1152192624470816483L;

	@Key
	protected String event_id;

	@Key
	protected String start_time;

	@Key
	protected String summary;

	@Key
	protected String url;

	/**
	 * @return
	 */
	public String getEventId() {
		return event_id;
	}

	/**
	 * @return
	 */
	public String getStartTime() {
		return start_time;
	}

	/**
	 * @return
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @return
	 */
	public String getUrl() {
		return url;
	}

}
