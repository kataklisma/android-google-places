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

## TODO
- Radar Sarch
- Place Photo
- 
## Setup

1). Obtain an API key (Browser).  Visit the <a href="https://developers.google.com/places/documentation/">developer's guide</a> for more information.
2). Drop the googleplaces.jar in the lib folder of your Android project.

## Base Usage

Sending a search request

    GooglePlaces googlePlaces = new GooglePlaces("Your API Key");
    
    PlacesResult result = googlePlaces.getPlaces("food", 500, 40.764941, -73.984886);
    
    PlacesResult result = googlePlaces.getPlaces("food", "steakhouse", 500, 40.764941, -73.984886);
    
    PlacesResult result = googlePlaces.getPlaces("diners", 40.764941, -73.984886);

Handling a place search response

    if (result.getStatusCode() == StatusCode.OK) {
        List<Place> places = result.getPlaces();
    }
        
Place Details
-------------

Sending a Place Details request

    Place somePlace = result.getPlaces().get(0);
    
    DetailsResult detailsResult = googlePlaces.getPlaceDetails(somePlace.getReference());

Handling a place details response

    if (detailsResult.getStatusCode() == StatusCode.OK) {
        PlaceDetails details = detailsResult.getDetails();
    }

Contributing
============

Fork, push, and send a pull request.
