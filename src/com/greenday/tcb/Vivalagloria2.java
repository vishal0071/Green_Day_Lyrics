package com.greenday.tcb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.greenday.americanidiot.Americanidiot;
import com.greenday.lyrics.Allsongs;
import com.greenday.lyrics.R;
import com.greenday.lyrics.Reportproblem;
import com.greenday.lyrics.Reportsong;
import com.greenday.lyrics.Settings;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class Vivalagloria2 extends Activity {
	
	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tcb_vivalagloria2);
		tv1 = (TextView)findViewById(R.id.textView1);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		ImageButton b=(ImageButton) findViewById(R.id.imageButton1);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog builder = new AlertDialog.Builder(Vivalagloria2.this)
		        .setMessage(Html.fromHtml("<b>Album</b><br>" +
		        		"21st Century Breakdown <i>(2009)</i><br><br>" +
		        		"<b>Track Length</b><br>" +
		        		"<i>3:48</i><br><br>" + 
		        		"<b>Writers</b><br>" +
		        		"Michael Pritchard, Billie Joe Armstrong, Frank E. Iii Wright<br><br>" +
		        		"<b>Copyright</b><br>" +
		        		"Green Daze Music, WB Music Corp."))
		        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		                closeContextMenu();
		            }
		        })
		        .show();    
			}
		});
	}
	
	//Action bar code below
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_song, menu);
        return true;
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case android.R.id.home:
			onBackPressed();
			break;

		default:

		};
		if(item.getItemId()==R.id.settings)
		{
			startActivity(new Intent(getApplicationContext(), Settings.class));
		}
		if(item.getItemId()==R.id.reportsong)
		{
			//Log report
		    Logger log = LoggerFactory.getLogger(Vivalagloria2.class);
		    log.info("21st Centuary Breakdown/Viva La Gloria Little Girl");
			startActivity(new Intent(getApplicationContext(), Reportsong.class));
		}
		if(item.getItemId()==R.id.action_search)
		{
			// search action
        	Intent intent = new Intent(this, Allsongs.class);
        	intent.putExtra("Search", true);
        	startActivity(intent);
			return true;
		}
	            return super.onOptionsItemSelected(item);
		
	}
	
}
