package com.hfad.giphyapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sarahzhou on 8/19/17.
 */
public class JSONParser {

    public static ArrayList<FeedItem> parseResult(String result) {
        ArrayList<FeedItem> ret = new ArrayList<>();
        try {
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray("data");
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.optJSONObject(i);
                FeedItem item = new FeedItem();
                item.setTitle(post.optString("url"));
                item.setThumbnail(post.optJSONObject("images").optJSONObject("original").optString("url"));
                ret.add(item);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return ret;
        }
    }
}
