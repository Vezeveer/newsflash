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

public class Fragment2 extends Fragment{
	//Hardcoded database
	String[] titlesSports = {"Fabinho: Liverpool midfielder says top-four Premier League finish would mean a successful season", "Fox to Acquire Clay Travis’s Outkick Media, a Sports and Culture News Site", "US appeals court to examine transgender sports ban"};
	String[] contentSports = {"Fabinho says finishing in the Premier League's top four would count as a successful season for Liverpool, given their perilous position two months ago.\n"+
			"Last season's champions can close the gap on fourth-place Chelsea to a single point with victory at already-relegated West Brom on Sunday, live on Sky Sports.\n"+
			"The top four looked out of reach when the Reds lost 1-0 at home to Fulham in March, their sixth successive Premier League defeat at Anfield.\n"+
			"But since then they have gone seven league games unbeaten and reignited their Champions League qualification hopes with a 4-2 win at Manchester United in midweek.",
			
			"Fox Corp. FOX -2.16% said it agreed to acquire Outkick Media, a news outlet focused on sports, politics and culture that was founded by provocateur Clay Travis.\n"+
			"While best known for its irreverent takes on sports news, in recent years Outkick Media has featured more content focused on political and social issues, often with a right-leaning viewpoint that is in sync with Fox News opinion programming.\n"+
			"Fox Corp. and Outkick Media already have ties. Fox Sports Radio is the home of Mr. Travis’s national daily broadcast. In addition, Mr. Travis is a regular on the Fox Sports 1 cable channel.",
			
			"WASHINGTON: A federal appeals court is to examine a law on Monday (May 3) banning transgender athletes from competing in girls' and women's sports, an issue which has become highly politicised in the United States.\n"+
			"The 9th US Circuit Court of Appeals in California will hear arguments in a case challenging a law passed last year in the western state of Idaho.\n"+
			"Idaho was the first US state to pass legislation banning transgender athletes from taking part in girls' or women's sports.\n"+
			"The plaintiff in the landmark case is Lindsay Hecox, a 20-year-old transgender student-athlete at Boise State University who is barred by the law from competing on the women's track and field team."
	};
	
	int[] imagesSports = {R.drawable.liverpool1icon, R.drawable.foxnews1icon, R.drawable.transgender1icon};
	int[] imagesSportsFull = {R.drawable.liverpool1, R.drawable.foxnews1, R.drawable.transgender1};
	
	ListView listView;
	ItemAdapter adapter;
	View rootView;
	
	public Fragment2(){
		
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
		ItemModel liverpool1 = new ItemModel(titlesSports[0], contentSports[0], imagesSports[0]);
		ItemModel foxnews1 = new ItemModel(titlesSports[1], contentSports[1], imagesSports[1]);
		ItemModel transgender1 = new ItemModel(titlesSports[2], contentSports[2], imagesSports[2]);
		
		ArrayList<ItemModel> items = new ArrayList<ItemModel>();
		items.add(liverpool1);
		items.add(foxnews1);
		items.add(transgender1);
		
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
				intent.putExtra("title", titlesSports[position]);
				intent.putExtra("content", contentSports[position]);
				intent.putExtra("image", imagesSportsFull[position]);
				startActivity(intent);
				
			}
		});
		
		
		return rootView;
	}
	
	
}
