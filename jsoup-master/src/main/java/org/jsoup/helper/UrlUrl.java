package org.jsoup.helper;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUrl implements ConnectURL {
	private String newurl;
	
	//Constructor
	public UrlUrl()
	{	
	}
	
	@Override
	public String correct(String url) 
	{
		String https = "https://";
		String http = "http://";
		String newUrl = null;
		
		int cnt=0;
		
		for(int i = 0; i < https.length(); i++) 
		{
			if(url.charAt(i)!=https.charAt(i))
				cnt++;
		}
		
		//https://이 없을때
		if(cnt == 8)
		{
			newUrl = https + url;
		}
		else
		{
			String[] str = url.split("\\.");
			str[0] = str[0].replace("/", "");
			
			if(!str[0].equals(https) || !str[0].equals(http))
			{
				String[] str2 = str[0].split(":");
				String temp = null;
				temp = str2[1];
				if(temp.equals("w") || temp.equals("ww") || temp.equals("wwww"))
				{
					temp = "www";
				}
				
				str2[0] = "https";
				str2[1] = "//";
				
				newUrl = str2[0] + ":" + str2[1] + temp + ".";
			}
			
			for(int i = 1; i < str.length; i++)
			{
				newUrl += str[i] + ".";
			}
			newUrl = newUrl.substring(0, newUrl.length()-1);
		}
		System.out.println(newUrl);
		
		return newUrl;	
	}
	
	@Override
	public String URLtoString(URL url) {
		// TODO Auto-generated method stub
		newurl=url.toString();
		return newurl;
	}
	
	@Override
	public URL StringtoURL(String url) {
		URL reurl = null;
		try {
			 reurl=new URL(url);
	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reurl;
				
	}

	@Override
	public String urlFail(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String urlSuccess(String url) {
		// TODO Auto-generated method stub
		return null;
	}

}
