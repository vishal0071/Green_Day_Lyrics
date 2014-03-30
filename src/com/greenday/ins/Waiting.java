package com.greenday.ins;

import com.greenday.lyrics.Allsongs;
import com.greenday.lyrics.R;
import com.greenday.lyrics.ReportSong;
import com.greenday.lyrics.Settings;
import com.greenday.lyrics.Util;
import com.greenday.warning.WarningMain;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Waiting extends Activity {
	
	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
    	
		//Set theme must be used before super.oncreate or any other layout declaration
		Util.setAppTheme(this);

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ins_waiting);
		tv1 = (TextView)findViewById(R.id.textView1);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//getWindow().setBackgroundDrawableResource(R.drawable.ins_cover2);
		
		//Display
		boolean display = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("display", false);
		if(display)
		{
			tv1.setKeepScreenOn(true);
		}
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
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Waiting");
					startActivity(intent);
				}
				if(item.getItemId()==R.id.action_search)
				{
					// Search action | Add as new task
					Intent intent = new Intent(this, Allsongs.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					intent.putExtra("Search", true);
					startActivity(intent);
					return true;
				}
				if(item.getItemId()==R.id.action_label)
				{
					//Info
					new AlertDialog.Builder(this)
			        .setMessage(Html.fromHtml("<font color='#524ef8'><b><u>From</font></b></u><br>" +
			        		"<font color='#006500'>Warning, <i>2000</i></font>"))
			        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
			                closeContextMenu();
			            }
			        })
			        .setNegativeButton("Go To Original", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
			            	Intent newActivity9 = new Intent(Waiting.this, WarningMain.class);     
			                 newActivity9.putExtra("track", 10);
			                 startActivityForResult(newActivity9, 1);
			            }
			        })
			        .show();  
				}
			            return super.onOptionsItemSelected(item);
				
			}
			
		}
