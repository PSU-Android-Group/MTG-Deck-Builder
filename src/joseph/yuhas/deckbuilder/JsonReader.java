package joseph.yuhas.deckbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonReader {
	private String searchParams;
	private String url;
	private Card cardObj;
	private final String key = "http://api.mtgdb.info/cards/";
	
	
	JsonReader() {
		cardObj = new Card();
		setSearchParams(null);
		setURL(null);
	}
	
	// Concatenate key with search parameters and and our search key
	public void searchFor(String params) {
		url = key + params;
		connectToURL(url);
	}
	
	// Connect to the URL passes on an input stream object
	// This does need to be in a Async Task
	private void connectToURL(String url) {
		InputStream is = null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
            
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        buildJsonObj(is);
	}
	
	// Use string builder to read everything into a json Obj then send it to our card for parsing
	private void buildJsonObj(InputStream is) {
		String json = "";
		StringBuilder sb = null;
		BufferedReader reader = null;
		JSONObject jObj = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
			is.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

        if(sb != null) {
        	json = sb.toString();
        	try {
                jObj = new JSONObject(json);
            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data " + e.toString());
            }
        }
        cardObj.populateFromJSON(jObj);
	}



	public Card getCardObj() {
		return cardObj;
	}
	public void setCardObj(Card cardObj) {
		this.cardObj = cardObj;
	}
	public String getSearchParams() {
		return searchParams;
	}
	public void setSearchParams(String searchParams) {
		this.searchParams = searchParams;
	}
	public String getURL() {
		return url;
	}
	public void setURL(String uRL) {
		this.url = uRL;
	}
	
	
}
