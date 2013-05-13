# Android Wrapper for Google Places API

This library allows you to integrate the capabilities of google places in your App.
It uses the API provided by google for client to make an http request and parses the JSON to java objects easy to use (I hope).
You can also extend the base classes that represent queries, and and that that provide results to add functionality and customized information.

## Features

- Integration and use of <a href="https://code.google.com/p/google-api-java-client/">Google APIs Client Library for Java</a>
- Use of Generics Java
- Nearby  Search Request
- Text Search Request
- Place Details request
- Customized Request (based on previous)

## Todo

any kind of help is welcome

- Make better documentation :)
- Public javadoc
- Test Code 
- Radar Search
- Place Photo
- Place Actions
- Place Autocomplete
- Query Autocomplete
- Remove libs directory from repository
- Demo app for try this library (is already made but is not ready for you)

## Setup

1. Obtain an API key (Browser).  Visit the <a href="https://developers.google.com/places/documentation/">developer's guide</a> for more information.
2. Drop the googleplaces.jar in the lib folder of your Android project.
3. If necessary download or update the <a href="https://code.google.com/p/google-api-java-client/">google-api-java-client</a> ant put in yout libs directory all needed jar.

# Base Usage

you first need to instantiate the base class library passing your Api Key.

    GooglePlaces gp = new GooglePlaces(getResources().getString("YOUR API KEY");

So you have some of methods(for now) to make the request:

> - getNearbyPlaces(List<String>, String, int, double, double)
> - getNearbyPlaces(List<String>, int, double, double)
> - getNearbyPlaces(String, String, int, double, double)
> - getNearbyPlaces(double, double)
> - getNearbyPlaces(int, double, double)
> - getNearbyPlaces(int, double, double, boolean)
> - getTextPlaces(String text, boolean sensor )
> - getTextPlaces(String text)
> - getPlaceDetails(String reference)
> - getPlaceDetails(Query query)
> - getPlaces(Query query)
> - getPlaces(Query query, Class<? extends Result> resultClass)
    
Each of these methods return a Class that implements the Result Interface.
For places will be the class PlaceResult and for the details will be the class PlaceDetails.
Waiting for the javadoc, you can see directly into sources such parameters are set by default in classes that extend  the base class: Query.
Below you will see how to create a personalized result.

### Text Search
Some Examples:

    PlacesResult result = gp.getPlaces("restaurant");

    PlacesResult result = gp.getPlaces("restaurant",true);

    TextSearchQuery query = new TextSearchQuery(getResources().getString(R.string.browser_api_key), textToSearch, true);
    query.setLocation(37.513692, 15.090934); 
    PlacesResult result = gp.getPlaces(query);

### Nearby Search

## Handling a place search response

    if (result.getStatusCode() == StatusCode.OK) {
        List<Place> places = result.getPlaces();
    }

## Place Details


Sending a Place Details request

###Handling a place details response

    if (detailsResult.getStatusCode() == StatusCode.OK) {
        PlaceDetails details = detailsResult.getDetails();
    }


        




# Advanced Usage

## Custom Query

## Custom Result

Contributing
============

Fork, push, and send a pull request.
