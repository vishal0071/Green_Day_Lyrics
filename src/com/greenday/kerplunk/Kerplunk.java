package com.greenday.kerplunk;

import com.greenday.lyrics.Allsongs;
import com.greenday.lyrics.ReportSong;
import com.greenday.lyrics.Settings;
import com.greenday.lyrics.Util;
import com.greenday.lyrics.R;
import com.greenday.kerplunk.Info;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Kerplunk extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//Set theme must be used before super.oncreate or any other layout declaration
		Util.setAppTheme(this);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kerplunk);
		TextView tv1 = (TextView)findViewById(R.id.textView1);
		int text = PreferenceManager.getDefaultSharedPreferences(this).getInt("text", 18);
		tv1.setTextSize(text);

		//Text theme
		int themetext = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("themechooser", null));
		boolean themetextb = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("themetext", true);
		if(themetextb){
			if(themetext==0){
				//Black
				tv1.setTextColor(Color.parseColor("#000000"));
			}
			else if(themetext==1){
				//Grey
				tv1.setTextColor(Color.parseColor("#A4A4A4"));
			}
			else if(themetext==2){
				//Lime
				tv1.setTextColor(Color.parseColor("#669002"));
			}
			else if(themetext==3){
				//Dark Sky
				tv1.setTextColor(Color.parseColor("#464ea3"));
			}
			else if(themetext==4){
				//Rose
				tv1.setTextColor(Color.parseColor("#cf2a9b"));
			}
			else if(themetext==5){
				//Mojo
				tv1.setTextColor(Color.parseColor("#c84741"));
			}
			else if(themetext==6){
				//Saffron
				tv1.setTextColor(Color.parseColor("#f48935"));
			}
			else if(themetext==7){
				//Frooti
				tv1.setTextColor(Color.parseColor("#E4A803"));
			}
			else if(themetext==8){
				//Lavender
				tv1.setTextColor(Color.parseColor("#92278f"));
			}
		}
		else{
			//Black
			tv1.setTextColor(Color.parseColor("#000000"));
		}
		
		int track = getIntent().getExtras().getInt("track");
		ActionBar ab=getActionBar();
		if(track == 1){
			ab.setTitle("2000 Light Years Away");
			tv1.setText(R.string.lightyears);
		}
		if(track == 2){
			ab.setTitle("One For The Razorbacks");
			tv1.setText(R.string.razorbacks);
		}
		if(track == 3){
			ab.setTitle("Welcome To Paradise");
			tv1.setText(R.string.welcometoparadise);
		}
		if(track == 4){
			ab.setTitle("Christie Road");
			tv1.setText(R.string.christieroad);
		}
		if(track == 5){
			ab.setTitle("Private Ale");
			tv1.setText(R.string.privateale);
		}
		if(track == 6){
			ab.setTitle("Dominated Love Slave");
			tv1.setText(R.string.dominatedloveslave);
		}
		if(track == 7){
			ab.setTitle("One Of My Lies");
			tv1.setText(R.string.oneoflies);
		}
		if(track == 8){
			ab.setTitle("80");
			tv1.setText(R.string.eighty);
		}
		if(track == 9){
			ab.setTitle("Android");
			tv1.setText(R.string.android);
		}
		if(track == 10){
			ab.setTitle("No One Knows");
			tv1.setText(R.string.nooneknows);
		}
		if(track == 11){
			ab.setTitle("Who Wrote Holden Caulfield?");
			tv1.setText(R.string.whowrote);
		}
		if(track == 12){
			ab.setTitle("Words I Might Have Ate");
			tv1.setText(R.string.wordsmightate);
		}
		if(track == 13){
			ab.setTitle("Sweet Children");
			tv1.setText(R.string.sweetchildren);
		}
		if(track == 14){
			ab.setTitle("Best Thing In Town");
			tv1.setText(R.string.bestthing);
		}
		if(track == 15){
			ab.setTitle("Strangeland");
			tv1.setText(R.string.strangeland);
		}
		if(track == 16){
			ab.setTitle("My Generation");
			tv1.setText(R.string.mygeneration);
		}
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
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
				int track = getIntent().getExtras().getInt("track");
				Intent intent = new Intent(this, ReportSong.class);
				if(track == 1){
					intent.putExtra("report_sub", "2000 Light Years Away");
					startActivity(intent);
					}
				if(track == 2){
					intent.putExtra("report_sub", "One For The Razorbacks");
					startActivity(intent);
					}
				if(track == 3){
					intent.putExtra("report_sub", "Welcome To Paradise");
					startActivity(intent);
					}
				if(track == 4){
					intent.putExtra("report_sub", "Christie Road");
					startActivity(intent);
					}
				if(track == 5){
					intent.putExtra("report_sub", "Private Ale");
					startActivity(intent);
					}
				if(track == 6){
					intent.putExtra("report_sub", "Dominated Love Slave");
					startActivity(intent);
					}
				if(track == 7){
					intent.putExtra("report_sub", "One Of My Lies");
					startActivity(intent);
					}
				if(track == 8){
					intent.putExtra("report_sub", "80");
					startActivity(intent);
					}
				if(track == 9){
					intent.putExtra("report_sub", "Android");
					startActivity(intent);
					}
				if(track == 10){
					intent.putExtra("report_sub", "No One Knows");
					startActivity(intent);
					}
				if(track == 11){
					intent.putExtra("report_sub", "Who Wrote Holden Caulfield?");
					startActivity(intent);
					}
				if(track == 12){
					intent.putExtra("report_sub", "Words I Might Have Ate");
					startActivity(intent);
					}
				if(track == 13){
					intent.putExtra("report_sub", "Sweet Children");
					startActivity(intent);
					}
				if(track == 14){
					intent.putExtra("report_sub", "Best Thing In Town");
					startActivity(intent);
					}
				if(track == 15){
					intent.putExtra("report_sub", "Strangeland");
					startActivity(intent);
					}
				if(track == 16){
					intent.putExtra("report_sub", "My Generation");
					startActivity(intent);
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
				int track = getIntent().getExtras().getInt("track");
				if(track == 1){
					Info.info1(this);
				}
				if(track == 2){
					Info.info2(this);
				}
				if(track == 3){
					Info.info3(this);
				}
				if(track == 4){
					Info.info4(this);
				}
				if(track == 5){
					Info.info5(this);
				}
				if(track == 6){
					Info.info6(this);
				}
				if(track == 7){
					Info.info7(this);
				}
				if(track == 8){
					Info.info8(this);
				}
				if(track == 9){
					Info.info9(this);
				}
				if(track == 10){
					Info.info10(this);
				}
				if(track == 11){
					Info.info11(this);
				}
				if(track == 12){
					Info.info12(this);
				}
				if(track == 13){
					Info.info13(this);
				}
				if(track == 14){
					Info.info14(this);
				}
				if(track == 15){
					Info.info15(this);
				}
				if(track == 16){
					Info.info16(this);
				}
			}
		            return super.onOptionsItemSelected(item);
		}
}