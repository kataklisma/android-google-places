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
public class Photo implements GooglePlaceBase {

    private static final long serialVersionUID = -2840484304599187115L;

    @Key
    private HtmlAttributions[] html_attributions;

    @Key
    private int height;

    @Key
    private int width;

    @Key
    private String photo_reference;

    public class HtmlAttributions implements Serializable {

        private static final long serialVersionUID = 5071127066265551063L;

    }

    public HtmlAttributions[] getHtmlAttributions() {
        return html_attributions;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getPhotoReference() {
        return photo_reference;
    }
}
