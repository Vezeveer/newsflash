package com.example.valduezaviewpagerandactionbar;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<ItemModel> {
	
	private Context mContext;
	int mResource;
	
    public ItemAdapter(Context context, int resource, ArrayList<ItemModel> users) {
       super(context, resource, users);
       mContext = context;
       mResource = resource;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    
    	String title1 = getItem(position).getTitle();
    	int image1 = getItem(position).getImage();
    	
    	//ItemModel item = new ItemModel(name1, town1, image1);
    	
    	LayoutInflater inflater = LayoutInflater.from(mContext);
    	convertView = inflater.inflate(mResource, parent, false);
    	
    	TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
    	ImageView ivImage = (ImageView) convertView.findViewById(R.id.image1);
    	
    	
    	tvTitle.setText(title1);
    	ivImage.setImageResource(image1);
    	
       return convertView;
   }
}