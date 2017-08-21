package com.hfad.giphyapp;


/**
 * Created by sarahzhou on 8/7/17.
 */
public class GiphyAPI {

    private static final String BETA_KEY = "dc6zaTOxFJmzC";
    private static final String BASE_URL = "https://api.giphy.com/";
    private static final String SEARCH_PATH = "v1/gifs/search";
    private static final String TRENDING_PATH = "v1/gifs/trending";

    private static final int DEFAULT_LIMIT = 30;
    private static final int DEFAULT_OFFSET = 0;

    //URL Format: http://api.giphy.com/v1/gifs/search?q=cute+cat&api_key=dc6zaTOxFJmzC&limit=1&offset=0
    //Random Search URL: http://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC&tag=cute+funny+cat+kitten
    //Trending Search URL: http://api.giphy.com/v1/gifs/trending?api_key=dc6zaTOxFJmzC

    private static String signUrl(String url) {
        return url + "&api_key=" + BETA_KEY;
    }

    private static String getSearchUrl(String query, int limit, int offset) {
        return signUrl(BASE_URL + SEARCH_PATH + "?q=" + query + "&limit=" + limit + "&offset=" + offset);
    }

    private static String getTrendingUrl(int limit, int offset) {
        return signUrl(BASE_URL + TRENDING_PATH + "?" + "&limit=" + limit + "&offset=" + offset);
    }

    public String search(String searchTerm) {
        String searchUrl = getSearchUrl(searchTerm.replace(" "," "), DEFAULT_LIMIT, DEFAULT_OFFSET);
        return(searchUrl);
    }

    public String getTrending() {
        String searchUrl = getTrendingUrl(DEFAULT_LIMIT, DEFAULT_OFFSET);
        return(searchUrl);
    }


}
