package com.example.valduezaviewpagerandactionbar;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleActivity extends Activity {

	String title = "";
	String content = "";
	int image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		Intent intent = getIntent();
		title = intent.getStringExtra("title");
		content = intent.getStringExtra("content");
		image = intent.getIntExtra("image", 0);
		
		ImageView ivImage = (ImageView) findViewById(R.id.imageViewArticle);
		TextView tvTitle = (TextView) findViewById(R.id.textViewTitle);
		TextView tvContent = (TextView) findViewById(R.id.textViewContent);
    	
    	
		ivImage.setImageResource(image);
    	tvTitle.setText(title);
    	tvContent.setText(content);
    	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.article, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();

	     if (id==android.R.id.home) {
	        finish();
	    }
	    return true;
	}

}
