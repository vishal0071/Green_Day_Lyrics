package com.greenday.dos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.greenday.lyrics.Allsongs;
import com.greenday.lyrics.R;
import com.greenday.lyrics.Report;
import com.greenday.lyrics.Settings;
import com.greenday.lyrics.Util;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Nightlife extends Activity {
	
	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
    	
		//Set theme must be used before super.oncreate or any other layout declaration
		Util.setAppTheme(this);

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dos_nightlife);
		tv1 = (TextView)findViewById(R.id.textView1);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getWindow().setBackgroundDrawableResource(R.drawable.dos_cover2);
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
					ConnectivityManager cm=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
					NetworkInfo ni=cm.getActiveNetworkInfo();
					if(ni!=null && ni.isConnected())
					{
				    Logger log = LoggerFactory.getLogger(Nightlife.class);
				    log.info("DOS/Nightlife");
				    Report.report1(this);
					}
					else
					{
						Crouton.makeText(this, "Unable to report while offline", Style.ALERT).show();
					}
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
			        .setMessage(Html.fromHtml(getString(R.string.album)+
			        		getString(R.string.dos_album) +
			        		getString(R.string.track_length) +
			        		"<font color='#006500'><i>3:04</font></i><br><br>" + 
			        		getString(R.string.writers) +
			        		"<font color='#006500'>Billie Joe Armstrong, Monica Painter a.k.a. Lady Cobra</font><br><br>" +
			        		getString(R.string.copyright) +
			        		getString(R.string.copyright1)))
			        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
			                closeContextMenu();
			            }
			        })
			        .show(); 
				}
			            return super.onOptionsItemSelected(item);
				
			}
			
		}
