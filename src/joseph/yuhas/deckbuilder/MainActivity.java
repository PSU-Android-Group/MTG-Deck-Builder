package joseph.yuhas.deckbuilder;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	JsonReader reader = null;
	Card currentCard = null;
	Button searchButton = null;
	// reader.searchFor(searchTerm)
	// currentCard = reader.getCardObj();
	// if curCard != null continue
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		searchButton = (Button) findViewById(R.id.searchButton);
		reader = new JsonReader();
		currentCard = new Card();
		setButtonOnClickListeners();
	}

	public void setButtonOnClickListeners() {
		
		searchButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				EditText searchField = (EditText) findViewById(R.id.editText1);
				String key = searchField.getText().toString();
				reader.searchFor(key);
			}
		});
	}

}
