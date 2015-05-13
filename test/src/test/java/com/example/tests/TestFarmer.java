package com.example.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class TestFarmer {
  
  public static final String baseURI = "http://localhost:8080/unified-web-maven/";
		
	@Test
	public void testCRUD() throws ClientProtocolException, IOException {
		
	  String url = baseURI+"farmer";
    System.out.println(url);
		
    String name = "bingo"+TestUtil.rand.nextInt(100);
    Map<String, Object> map = new HashMap<>();

    map.put("id", 0);
    map.put("name", name);
    map = TestUtil.post(url, map);
    System.out.println(map);
    
    int id = ((Double) map.get("id")).intValue();
    
    map = TestUtil.get(url, id);
    Assert.assertEquals(name, map.get("name"));

    String name2 = name+"X";
    
    map.put("name", name2);
    map = TestUtil.put(url, map, id);
    Assert.assertEquals(name2, map.get("name"));
    
    map = TestUtil.get(url, id);
    System.out.println(map);
    Assert.assertEquals(name2, map.get("name"));
    
    //http://en.wikipedia.org/wiki/List_of_HTTP_status_codes#2xx_Success
    //No Content
    Assert.assertEquals(204, TestUtil.delete(url, id));
	}
  
}
