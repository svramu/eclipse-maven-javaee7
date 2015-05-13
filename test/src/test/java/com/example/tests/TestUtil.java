package com.example.tests;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import com.google.gson.Gson;

public class TestUtil {
  public static final Random rand = new Random();
  private static final Gson gson = new Gson();

  private static Map<String, Object> jsonToMap(String json) {
    // TODO:
    // http://stackoverflow.com/questions/21720759/convert-a-json-string-to-a-hashmap
    @SuppressWarnings("unchecked")
    Map<String, Object> map = gson.fromJson(json, Map.class);
    return map;
  }

  private static String mapToJson(Map<String, Object> map) {
    String json = gson.toJson(map);
    return json;
  }

  public static Map<String, Object> get(String url, int id) 
      throws ClientProtocolException, IOException {
    return jsonToMap(Request.Get(url + "/" + id).execute().returnContent().asString());
  }

  public static Map<String, Object> post(String url, Map<String, Object> map)
      throws ClientProtocolException, IOException {
    return jsonToMap(Request.Post(url)
        .bodyString(mapToJson(map), ContentType.APPLICATION_JSON).execute()
        .returnContent().asString());
  }

  public static Map<String, Object> put(String url, Map<String, Object> map, int id)
      throws ClientProtocolException, IOException {
    return jsonToMap(Request.Put(url + "/" + id)
        .bodyString(mapToJson(map), ContentType.APPLICATION_JSON).execute()
        .returnContent().asString());
  }

  public static int delete(String url, int id) 
      throws ClientProtocolException, IOException {
    return Request.Delete(url + "/" + id).execute().returnResponse()
        .getStatusLine().getStatusCode();
  }

}
