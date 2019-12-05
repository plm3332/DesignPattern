package org.jsoup.helper;

import java.net.URL;

public interface ConnectURL {
	
	//Correct String type url
	public String correct(String url);
	
	//Correct Url type url
	public String URLtoString(URL url);
	
	//Change String to Url
	public URL StringtoURL(String url);
	
	//Changing Process Failed
	public String urlFail(String url);
	
	//Changing Process Successed
	public String urlSuccess(String url);
}
