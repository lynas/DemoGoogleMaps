package com.gsa;

import com.gsa.util.L;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends BaseActivity {
	private Button bSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_layout);

		bSearch = (Button) findViewById(R.id.buttonSearch);

		bSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(SearchActivity.this,
						ListOfMyTruckActivity.class);
				startActivity(intent);

			}
		});

	}

}
