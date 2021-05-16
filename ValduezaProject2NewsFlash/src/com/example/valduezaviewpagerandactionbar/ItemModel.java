package com.example.valduezaviewpagerandactionbar;

public class ItemModel {
	public String title;
    public String content;
    public int image;

    public ItemModel(String title, String content, int image) {
       this.title = title;
       this.content = content;
       this.image = image;
    }
    
    public String getTitle(){
    	return title;
    }
    public String getContent(){
    	return content;
    }
    public int getImage(){
    	return image;
    }
}
