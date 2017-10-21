package com.track.referrers.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackDao {
	private static Map<String, TrackUrl> registry = new HashMap<String,TrackUrl>();

	public void addUrl(String url){
		TrackUrl trackUrl = new TrackUrl();
		trackUrl.setDomainName(url);
		if(!registry.containsKey(url))
		{
			trackUrl.setCount(1);
			registry.put(url, trackUrl);
		}
		else
		{
			int count = registry.get(url).getCount();
			registry.get(url).setCount(count+1);
		}
	}

	public List<String> getTopVisited()
	{
		List<String> topVisitedList = new ArrayList<String>();
		List<TrackUrl> trackUrlList = new ArrayList<TrackUrl>(registry.values());
		Collections.sort(trackUrlList, new Comparator<TrackUrl>(){
			public int compare(TrackUrl o1, TrackUrl o2)
			{
				return String.valueOf(o2.getCount())
						.compareTo(String.valueOf(o1.getCount()));
			}
		});
		if(trackUrlList.size() >= 3)
		{
			topVisitedList.add(trackUrlList.get(0).getDomainName());
			topVisitedList.add(trackUrlList.get(1).getDomainName());
			topVisitedList.add(trackUrlList.get(2).getDomainName());
		}
		return topVisitedList;
	}
}
