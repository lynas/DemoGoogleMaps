package com.gsa;

import java.util.ArrayList;

import com.gsa.util.L;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class OptionActivity extends BaseActivity {
	ListView optionList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.option_layout);
		
		optionList = (ListView) findViewById(R.id.listViewOptionList);
		optionList.setAdapter(new OptionApapter(OptionActivity.this));
		
		
		
		optionList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {
				
				TextView tv = (TextView) view.findViewById(R.id.textViewQuickOptionEach);
				L.m(tv.getText().toString());
				
				if(tv.getText().toString().equals("Icon Settings")){
					Intent intent = new Intent(OptionActivity.this, IconSettingsActivity.class);
					startActivity(intent);
				}else if(tv.getText().toString().equals("Map Refresh Settings")){
					Intent intent = new Intent(OptionActivity.this, MapRefreshSettingsActivity.class);
					startActivity(intent);
				}
				
				/*TextView tv = (TextView) arg1.findViewById(R.id.textViewTruckNameEach);
				TextView tv2 = (TextView) arg1.findViewById(R.id.textViewTruckInfoInEach);
				Intent intent = new Intent(context, EachTruckInfoActivity.class);
				intent.putExtra("TruckName", ""+tv.getText().toString());
				intent.putExtra("TruckStatus", ""+tv2.getText().toString());
				startActivity(intent);*/
				
			}
		});
	}

}

class OptionApapter extends BaseAdapter {
	ArrayList<SingleOptionRow> list;
	Context context;
	
	public OptionApapter(Context context){
		this.context = context;
		this.list = new ArrayList<SingleOptionRow>();
		int[] image = {R.drawable.icon_settings,R.drawable.map_refresh_settings};
		String[] name = {"Icon Settings","Map Refresh Settings"};
		for (int i = 0; i < 2; i++) {
			list.add(new SingleOptionRow(image[i],name[i]));
			
		}
	}

	@Override
	public int getCount() {
		
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.option_item_each, arg2, false);
		ImageView image = (ImageView) row.findViewById(R.id.imageViewQuickOption);
		TextView name = (TextView) row.findViewById(R.id.textViewQuickOptionEach);
		
		image.setImageResource(list.get(arg0).getImageId());
		name.setText(list.get(arg0).getOptionName());
		return row;
	}

}

class SingleOptionRow {
	int imageId;
	String optionName;

	public SingleOptionRow() {
	}

	public SingleOptionRow(int imageId, String optionName) {
		super();
		this.imageId = imageId;
		this.optionName = optionName;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

}
