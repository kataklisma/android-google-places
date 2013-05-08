package com.a2plab.googleplaces.models;

import java.io.Serializable;

import com.google.api.client.util.Key;

public class Place implements Serializable {

	private static final long serialVersionUID = 1983125240283709545L;

	@Key
	protected String id;

	@Key
	protected String name;

	@Key
	protected String reference;

	@Key
	protected String icon;

	/**
	 * Use this for Nearby Search instead formatted_address
	 */
	@Key
	protected String vicinity;

	@Key
	protected Geometry geometry;

	@Key
	protected String formatted_address;

	public static class Geometry implements Serializable {

		private static final long serialVersionUID = 1670272243139023026L;
		@Key
		public Location location;
	}

	public static class Location implements Serializable {

		private static final long serialVersionUID = -1932110927792589446L;

		@Key
		public double lat;

		@Key
		public double lng;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @return the vicinity
	 */
	public String getVicinity() {
		return vicinity;
	}

	/**
	 * @return the geometry
	 */
	public Geometry getGeometry() {
		return geometry;
	}

	/**
	 * @return the formatted_address
	 */
	public String getFormattedAddress() {
		return formatted_address;
	}


	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @param vicinity
	 *            the vicinity to set
	 */
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	/**
	 * @param geometry
	 *            the geometry to set
	 */
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	/**
	 * @param formatted_address
	 *            the formatted_address to set
	 */
	public void setFormattedAddress(String formatted_address) {
		this.formatted_address = formatted_address;
	}

}