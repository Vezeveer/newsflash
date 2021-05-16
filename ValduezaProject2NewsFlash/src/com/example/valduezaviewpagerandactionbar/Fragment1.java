package com.example.valduezaviewpagerandactionbar;

import java.util.ArrayList;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Fragment1 extends Fragment {
	
	//Hardcoded database
	//TECHNOLOGY Articles
	String[] titlesTech = {"NASA Exercise Finds That No Tech Is Available to Stop an Asteroid’s Collision With Earth","China on Mars: Tianwen-1 Lands Successfully on Red Planet", "Amazon launches miniTV, a free video streaming service"};
	String[] contentTech = {"NASA and its peers around the world conducted a “table-top” exercise last month to determine the time scientists will take to understand and find ways to prevent a catastrophic collision of an incoming asteroid into the Earth. The simulation was hypothetical and intended to allow scientists time to prepare for such situations if that were to arise. They set the scenario: a mysterious asteroid from about 35 million miles (56.3 million kilometres) away is coming towards Earth and is expected to hit the planet in six months. Scientists sat down for a week starting April 26 to plan ways to stop or change the direction of the hypothetical asteroid, named 2021 PDC.\n"+
		"The participants were given information about the asteroid every day, which represented a month in the exercise timeline. The asteroid was determined to be anywhere between 35m and 700m in size. With each passing hour, the scientists began developing information.\n"+
		"Finally, on Day 2, they confirmed that the asteroid impact will happen in six months across a vast region, which includes Europe and Northern Africa. By the end of the week, they said with some degree of certainty that the asteroid would hit between Germany and the Czech Republic.\n"+
		"The scientists later concluded that currently there was no technology available to stop a massive asteroid from wiping out the world. For deflecting the asteroid, they added, more time than six months would be required.\n"+
		"The scientists said in a statement that if confronted with the hypothetical scenario in real life “we would not be able to launch any spacecraft on such short notice with current capabilities.”\n"+
		"They also said that use of a nuclear explosive device to disrupt the asteroid could reduce the risk of damage even in the absence of a clear understanding of asteroid properties. However, the ability of typical nuclear explosive devices to robustly disrupt near-Earth objects may not be adequate for larger asteroids.\n",
	
		"An uncrewed Chinese spacecraft successfully landed on the surface of Mars on Saturday, state news agency Xinhua reported, making China the second space-faring nation after the United States to land on the Red Planet.\n"+
		"The Tianwen-1 spacecraft landed on a site on a vast plain known as Utopia Planitia, \"leaving a Chinese footprint on Mars for the first time,\" Xinhua said.\n"+
		"Chinese President Xi Jinping issued a message of congratulations to all the people involved in the mission.",
		
		"Amazon has launched a new video streaming service, called miniTV. The service offers users “professionally” created and curated content across web series, comedy shows, tech news, food, beauty, fashion and more. It is free of cost, but users will witness ads. It is available within the Amazon shopping app.\n"+
		"“With the launch of miniTV, Amazon.in shopping app is now a single destination for customers to shop from millions of products, make payments and watch free entertainment videos,” Amazon said in a blogpost. Currently, the new video streaming service is only available for Android users. The iOS and mobile web versions will also be released in the coming months.\""
	};
	int[] imagesTech = {R.drawable.nasa1icon, R.drawable.china1icon, R.drawable.amazon1icon};
	int[] imagesTechFull = {R.drawable.nasa1, R.drawable.china1, R.drawable.amazon1};
	
	ListView listView;
	ItemAdapter adapter;
	View rootView;
	
	public Fragment1(){
		
	}
	
	public View onCreateView(LayoutInflater inflater,
							ViewGroup container,
							Bundle savedInstance){
		
		if(container == null){
			System.out.println("returned... null");
			return null;
		} else {
			System.out.println("NO null");
			rootView = inflater.inflate(R.layout.fragment1_layout, 
					container, false);
		}
		
		//Hardcoded. as opposed to fetching from database
		ItemModel nasa1 = new ItemModel(titlesTech[0], contentTech[0], imagesTech[0]);
		ItemModel china1 = new ItemModel(titlesTech[1], contentTech[1], imagesTech[1]);
		ItemModel amazon1 = new ItemModel(titlesTech[2], contentTech[2], imagesTech[2]);
		
		ArrayList<ItemModel> items = new ArrayList<ItemModel>();
		items.add(nasa1);
		items.add(china1);
		items.add(amazon1);
		
        ItemAdapter adapter = new ItemAdapter(this.getActivity(), R.layout.item_article, items);
        
		listView = (ListView)rootView.findViewById(R.id.listview1);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, 
					View view, int position,
					long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(parent.getContext(), ArticleActivity.class);
				intent.putExtra("title", titlesTech[position]);
				intent.putExtra("content", contentTech[position]);
				intent.putExtra("image", imagesTechFull[position]);
				startActivity(intent);
				
			}
		});
		
		
		return rootView;
	}
	
	
}
