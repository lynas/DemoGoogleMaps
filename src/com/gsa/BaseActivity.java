package com.gsa;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BaseActivity extends FragmentActivity {
	String[] menu;
	DrawerLayout dLayout;
	ListView dList;
	ArrayAdapter<String> adapter;
	ActionBarDrawerToggle mDrawerToggle;
	FrameLayout frameLayout;

	@Override
	public void setContentView(int layoutResID) {

		dLayout = (DrawerLayout) getLayoutInflater().inflate(
				R.layout.left_navigation_drawer, null);
		frameLayout = (FrameLayout) dLayout.findViewById(R.id.content_frame);
		getLayoutInflater().inflate(layoutResID, frameLayout, true);
		super.setContentView(dLayout);
		menu = new String[] { "GPS Trackers", "Remote Control", "Options",
				"Quick Map", "Search" };
		dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		dList = (ListView) findViewById(R.id.left_drawer);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, menu);
		dList.setAdapter(new DrawerAdapter(BaseActivity.this));
		dList.setSelector(android.R.color.holo_blue_dark);
		dList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {
				dLayout.closeDrawers();

				/*
				 * Bundle args = new Bundle(); args.putString("Menu",
				 * menu[position]); Fragment detail = new DetailFragment();
				 * detail.setArguments(args); FragmentManager fragmentManager =
				 * getFragmentManager(); fragmentManager.beginTransaction()
				 * .replace(R.id.content_frame, detail).commit();
				 */
				switch (position) {
				case 0:
					Intent intentLandingPage = new Intent(BaseActivity.this, ListOfMyTruckActivity.class);
					startActivity(intentLandingPage);
					break;
				case 1:
					Intent intentRemoteControl = new Intent(BaseActivity.this, RemoteControlActivity.class);
					startActivity(intentRemoteControl);
					break;
				case 2:
					Intent option = new Intent(BaseActivity.this, OptionActivity.class);
					startActivity(option);
					break;
				case 3:
					Intent quickMap = new Intent(BaseActivity.this, ListOfMyTruckActivity.class);
					startActivity(quickMap);
					break;
				case 4:
					Intent searchIntent = new Intent(BaseActivity.this, SearchActivity.class);
					startActivity(searchIntent);
					break;

				default:
					break;
				}
			}
		});

		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		dLayout, /* DrawerLayout object */
		R.drawable.ic_action_overflow, /* nav drawer icon to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description */
		R.string.drawer_close /* "close drawer" description */
		) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				getActionBar().setTitle(BaseActivity.this.getTitle());
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getActionBar().setTitle("Track Your Truck");
			}
		};

		dLayout.setDrawerListener(mDrawerToggle);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// Your drawer content...

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.left_navigation_drawer);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle your other action bar items...

		return super.onOptionsItemSelected(item);
	}

}



class DrawerAdapter extends BaseAdapter{
	ArrayList<SingleRowNavDrawer> list;
	Context context;
	
	public DrawerAdapter(Context context){
		this.context = context;
		this.list = new ArrayList<SingleRowNavDrawer>();
		String[] name = {
				"GPS Trackers", 
				"Remote Control", 
				"Options",
				"Quick Map", 
				"Search"};
		int[] imageId = {
				R.drawable.icon_gps_tracker,
				R.drawable.icon_remote_control,
				R.drawable.icon_option,
				R.drawable.icon_map,
				R.drawable.icon_search};
		list.clear();
		for (int i = 0; i < 5; i++) {
			list.add(new SingleRowNavDrawer(name[i], imageId[i]));
		}
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.drawer_item_each, arg2, false);
		TextView name = (TextView) row.findViewById(R.id.textViewDrawerItemName);
		ImageView image = (ImageView) row.findViewById(R.id.imageViewDrawerImage);
		name.setText(list.get(arg0).getOptionName());
		image.setImageResource(list.get(arg0).getOptionImageId());
		return row;
	}
	
}





class SingleRowNavDrawer{
	String optionName;
	int optionImageId;
	public SingleRowNavDrawer(String optionName, int optionImageId) {
		super();
		this.optionName = optionName;
		this.optionImageId = optionImageId;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public int getOptionImageId() {
		return optionImageId;
	}
	public void setOptionImageId(int optionImageId) {
		this.optionImageId = optionImageId;
	}
	
	
	
}

