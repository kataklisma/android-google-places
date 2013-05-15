# Google Places API for Android

This library allows you to integrate the capabilities of google places in your App.
It uses the API provided by google for client to make an http request and parses the JSON to java objects easy to use (I hope).
You can also extend the base classes that represent queries, and and that that provide results to add functionality and customized information.
Thanks to  for stating the project.
thanks to <a href="https://github.com/gmarz">Gmarz</a> for having had the basic idea that the library is inspired.


## Features

- Nearby Search Request
- Text Search Request
- Place Details request
- Customized Request (based on previous)
- Support for all parameters of the query and results defined in json google places query and results.
- Integration and use of <a href="https://code.google.com/p/google-api-java-client/">Google APIs Client Library for Java</a>
- Use of Generics Java

## Todo

Any kind of help is welcome.

- Add License
- Make better documentation :)
- Public javadoc
- Test Unit
- Support of Radar Search
- Support of Place Photo
- Support of Place Actions
- Support of Place Autocomplete
- Support of Query Autocomplete
- Remove libs directory from repository (?)
- Move the supported types in an appropriate container
- Demo app for try this library (is already made but is not ready for you)

## Setup

1. Obtain an API key (Browser).  Visit the <a href="https://developers.google.com/places/documentation/">developer's guide</a> for more information.
2. Drop the googleplaces.jar in the lib folder of your Android project.
3. If necessary download or update the <a href="https://code.google.com/p/google-api-java-client/">google-api-java-client</a> ant put in yout libs directory all needed jar.

# Base Usage

You first need to instantiate the base class library passing your Api Key.

    GooglePlaces gp = new GooglePlaces(getResources().getString("YOUR API KEY");

So you have some of methods(for now) to make the request:

> - getNearbyPlaces(List<String> types, String text, int radius, double lat, double lon)
> - getNearbyPlaces(List<String> types, int radius, double lat , double lon)
> - getNearbyPlaces(String type, String text, int radius, double lat, double lon)
> - getNearbyPlaces(double lat, double lon)
> - getNearbyPlaces(int radius, double lat, double lon)
> - getNearbyPlaces(int radius, double lat, double lon, boolean sensor)
> - getTextPlaces(String text, boolean sensor )
> - getTextPlaces(String text)
> - getPlaceDetails(String reference)
> - getPlaceDetails(Query query)
> - getPlaces(Query query)
> - getPlaces(Query query, Class<? extends Result> resultClass)
    
Each of these methods return a Class that implements the Result Interface.<br>
For places will be the class PlaceResult and for the details will be the class PlaceDetails.<br>
Waiting for the javadoc, you can see directly into sources such parameters are set by default by classes that extend the base class: Query.<br>
You can access at all the optional parameters of the  API Google Places queries, and in the result are present all the fields provided by response.<br>
Below you will see how to create a personalized result.

## Nearby Search

You have many ways to do nearby search request depending on the query that you want to perform.
If you do not specify any parameters required, the library does it for you by setting a default value.

Some examples...

Define types of places, radius and location:

    List<String> types = new ArrayList<String>();
    types.add("food");
    types.add("restaurant");
    PlacesResult result = gp.getNearbyPlaces(types, 2000, 37.513692, 15.090934);
    
Define one type and a text to sarch:

    PlacesResult result = gp.getNearbyPlaces("food","pizza", 2000, 37.513692, 15.090934);
    
Search Generic places near you location with default radius:

    PlacesResult result = gp.getNearbyPlaces(37.513692, 15.090934);
    
Search Generic places near you location with custom radius:

    PlacesResult result = gp.getNearbyPlaces(500, 37.513692, 15.090934);
    
For more information about NEarby Sarch Request you can see the <a href="https://developers.google.com/places/documentation/search#PlaceSearchRequests">Official Google Place Api Documentation for Nearby Search Request</a>

## Text Search

Some Examples...

Base:

    PlacesResult result = gp.getTextPlaces("restaurant");
    
With Sensor Disabeld:

    PlacesResult result = gp.getTextPlaces("restaurant",false);
    
With Custom Location:

    TextSearchQuery query = new TextSearchQuery(getResources().getString(R.string.browser_api_key), textToSearch, true);
    query.setLocation(37.513692, 15.090934);
    PlacesResult result = gp.getPlaces(query);
    
For more information about Text Sarch Request you can see the <a href="https://developers.google.com/places/documentation/search#TextSearchRequests">Official Google Place Api Documentation for Text Search Request</a>

## Supported Place Types
    
you can check whether the types that you want to look for are supported by the API of google invoking this method:

    boolean isSupported = gp.isSupportedPlace("placetype");
    
## Handling a place search response

    if (result.getStatusCode() == StatusCode.OK) {
        List<Place> placesList = result.getResults();
        foreach(Place place : placesList){
            //do something, for example add marker
            mapFragment.getMap()
                .addMarker(new MarkerOptions()
                    .position(new LatLng(place.getLatitude(), place.getLongitude()))
                    .title(place.getName())
                    .snippet(place.getFormattedAddress())
		   		.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        }
    }

## Place Details

The PlaceDetails Class extends the Place Clase and provide additional information such reviews, events, types and many others.
To retrieve this information must first have made a request for a Place to get the <i>reference</i> field, then you can get the details of this place in this way:

    String reference = place.getReference();
    PlaceDetailsResult detailsResult =  gp.getPlaceDetails(reference);
    
Or you can create custom details query:

    DetailsQuery dq = new DetailsQuery("YOUR API KEY", place.getReference());
    PlaceDetailsResult detailsResult = (PlaceDetailsResult) gp.getPlaceDetails(dq);

### Handling a place details response

    if (detailsResult.getStatusCode() == StatusCode.OK) {
        PlaceDetails placeDetails = detailsResult.getDetails();
        //do something
    }

# Advanced Usage
 
You can create custom Query using the classes provided by library and setting the parameters, or you can extend them to add custom functionality.
The most important things is that you can extend classes of the results.
Let's see how

## Custom Query Creation

For Example, we need to set many parameters on Nearby Search Request:

    NearbySearchQuery query = new NearbySearchQuery("YOUR API KEY",37.513692, 15.090934);
    q.setRanking(NearbySearchQuery.Ranking.Distance);
    q.setLanguage("en");
    q.setKeyword("pizza");
    q.addType("food");
    q.addType("restaurant");
    q.setOpenNow(true);
    q.setPageToken(previousResult.getPageToken());
    
    PlaceResults result = gp.getPlaces(query);

## Custom Result

Results of requests you can extend and create custom classes appropriate for your purposes.<br>
As an example we can create a class called POI that represents a point on google maps, then add a field "Marker".<br>
Another useful example would be to insert a field "distance" where we're going to save the distance from the origin point of the search (location).

<pre><code>
public class Poi extends Place {

    private Marker marker;

	public Poi() {
		super();
	}
	
	public Poi(Marker marker) {
		this();
		this.marker = marker;
	}
	
	public void removeMarker() {
		marker.remove();
	}
	
	public Marker getMarker() {
		return marker;
	}
	
	public void setMarker(Marker marker) {
		this.marker = marker;
	}

}    
</code>
</pre>

Then Extend The abstract Class Result:

<pre><code>
class PoiResult extends Result {

	@Key
	private List<Poi> results;
	
	@Override
	public List<Poi> getResults() {
		return results;
	}
}
    </code>
</pre>
    
then take the results of passing the method the class definition that you created:

    PoiResult poiResult = (PoiResult) gp.getPlaces(query, PoiResult.class);
    if (result.getStatusCode() == StatusCode.OK)
        List<Poi> placesList = result.getResults();        
        ....
        
for example we add the marker on google maps and save its reference.

    place.setMarker(mapFragment.getMap().addMarker(new MarkerOptions()
        	.position(new LatLng(place.getLatitude(), place.getLongitude()))
			.title(place.getName()).snippet(place.getFormattedAddress())
			.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))));
    
do you want remove marker?
    
    poi.removeMarker();
    
# Contributing

Thanks to <a href="https://github.com/gmarz">Gmarz</a> for having had the basic idea that the library is inspired.
Fork, push, and send a pull request. Enjoy!

Please Visit <a href="a2plab.com">a2plab.com</a>
