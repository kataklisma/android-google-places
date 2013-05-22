/**
 * 
 */
package com.a2plab.googleplaces.query;

/**
 * @author Giuseppe Mastroeni - aka: Kataklisma E-Mail: m.giuseppe@a2plab.com
 * 
 */
public class PhotoQuery extends Query {

    /**
     * @param apiKey
     */
    public PhotoQuery(String apiKey) {
        super(apiKey);
        this.setMaxHeight(720);
        this.setMaxWidth(1280);
    }

    /**
     * @param apiKey
     * @param reference
     */
    public PhotoQuery(String apiKey, String reference) {
        this(apiKey);
        this.setPhotoReference(reference);
    }

    /**
     * @param reference
     * @return
     */
    public PhotoQuery setPhotoReference(String reference) {
        queryBuilder.addParameter("photoreference", reference);
        return this;
    }

    /**
     * @param maxHeight
     * @return
     */
    public PhotoQuery setMaxHeight(int maxHeight) {
        queryBuilder.addParameter("maxheight", Integer.toString(maxHeight));
        return this;
    }

    /**
     * @param maxWidth
     * @return
     */
    public PhotoQuery setMaxWidth(int maxWidth) {
        queryBuilder.addParameter("maxwidth", Integer.toString(maxWidth));
        return this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.a2plab.googleplaces.query.Query#getUrl()
     */
    @Override
    public String getUrl() {
        return "https://maps.googleapis.com/maps/api/place/photo?";
    }
}
