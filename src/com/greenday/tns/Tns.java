package com.greenday.tns;

import com.greenday.lyrics.Allsongs;
import com.greenday.lyrics.ReportSong;
import com.greenday.lyrics.Settings;
import com.greenday.lyrics.Util;
import com.greenday.lyrics.R;
import com.greenday.tns.Info;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Tns extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//Set theme must be used before super.oncreate or any other layout declaration
		Util.setAppTheme(this);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tns);
		TextView tv1 = (TextView)findViewById(R.id.textView1);
		int track = getIntent().getExtras().getInt("track");
		
		if(track == 1){
			ActionBar ab=getActionBar();
			ab.setTitle("At The Library");
			tv1.setText(R.string.atlibrary);
		}
		if(track == 2){
			ActionBar ab=getActionBar();
			ab.setTitle("Don't Leave Me");
			tv1.setText(R.string.dontleaveme);
		}
		if(track == 3){
			ActionBar ab=getActionBar();
			ab.setTitle("I Was There");
			tv1.setText(R.string.iwasthere);
		}
		if(track == 4){
			ActionBar ab=getActionBar();
			ab.setTitle("Disappearing Boy");
			tv1.setText(R.string.disappearingboy);
		}
		if(track == 5){
			ActionBar ab=getActionBar();
			ab.setTitle("Green Day");
			tv1.setText(R.string.greenday);
		}
		if(track == 6){
			ActionBar ab=getActionBar();
			ab.setTitle("Going To Pasalacqua");
			tv1.setText(R.string.goingpasalacqua_title);
		}
		if(track == 7){
			ActionBar ab=getActionBar();
			ab.setTitle("16");
			tv1.setText(R.string.sixteen);
		}
		if(track == 8){
			ActionBar ab=getActionBar();
			ab.setTitle("Road To Acceptance");
			tv1.setText(R.string.roadtoacceptance);
		}
		if(track == 9){
			ActionBar ab=getActionBar();
			ab.setTitle("Rest");
			tv1.setText(R.string.rest);
		}
		if(track == 10){
			ActionBar ab=getActionBar();
			ab.setTitle("The Judge's Daughter");
			tv1.setText(R.string.judgedaughter_title);
		}
		if(track == 11){
			ActionBar ab=getActionBar();
			ab.setTitle("Paper Lanterns");
			tv1.setText(R.string.paperlanterns);
		}
		if(track == 12){
			ActionBar ab=getActionBar();
			ab.setTitle("Why Do You Want Him?");
			tv1.setText(R.string.whyyouwanthim);
		}
		if(track == 13){
			ActionBar ab=getActionBar();
			ab.setTitle("409 In Your Coffeemaker");
			tv1.setText(R.string.coffeemaker);
		}
		if(track == 14){
			ActionBar ab=getActionBar();
			ab.setTitle("Knowledge");
			tv1.setText(R.string.knowledge);
		}
		if(track == 15){
			ActionBar ab=getActionBar();
			ab.setTitle("1,000 Hours");
			tv1.setText(R.string.thousandhours);
		}
		if(track == 16){
			ActionBar ab=getActionBar();
			ab.setTitle("Dry Ice");
			tv1.setText(R.string.dryice);
		}
		if(track == 17){
			ActionBar ab=getActionBar();
			ab.setTitle("Only Of You");
			tv1.setText(R.string.onlyofyou);
		}
		if(track == 18){
			ActionBar ab=getActionBar();
			ab.setTitle("The One I Want");
			tv1.setText(R.string.oneiwant);
		}
		if(track == 19){
			ActionBar ab=getActionBar();
			ab.setTitle("I Want To Be Alone");
			tv1.setText(R.string.wanttobealone);
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
				if(track == 1){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "At The Library");
					startActivity(intent);
					}
				if(track == 2){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Don't Leave Me");
					startActivity(intent);
					}
				if(track == 3){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "I Was There");
					startActivity(intent);
					}
				if(track == 4){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Disappearing Boy");
					startActivity(intent);
					}
				if(track == 5){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Green Day");
					startActivity(intent);
					}
				if(track == 6){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Going To Pasalacqua");
					startActivity(intent);
					}
				if(track == 7){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "16");
					startActivity(intent);
					}
				if(track == 8){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Road To Acceptance");
					startActivity(intent);
					}
				if(track == 9){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Rest");
					startActivity(intent);
					}
				if(track == 10){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "The Judge's Daughter");
					startActivity(intent);
					}
				if(track == 11){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Paper Lanterns");
					startActivity(intent);
					}
				if(track == 12){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Why Do You Want Him?");
					startActivity(intent);
					}
				if(track == 13){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "409 In Your Coffeemaker");
					startActivity(intent);
					}
				if(track == 14){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Knowledge");
					startActivity(intent);
					}
				if(track == 15){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "1,000 Hours");
					startActivity(intent);
					}
				if(track == 16){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Dry Ice");
					startActivity(intent);
					}
				if(track == 17){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "Only Of You");
					startActivity(intent);
					}
				if(track == 18){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "The One I Want");
					startActivity(intent);
					}
				if(track == 19){
					Intent intent = new Intent(this, ReportSong.class);
					intent.putExtra("report_sub", "I Want To Be Alone");
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
				if(track == 17){
					Info.info17(this);
				}
				if(track == 18){
					Info.info18(this);
				}
				if(track == 19){
					Info.info19(this);
				}
			}
		            return super.onOptionsItemSelected(item);
		}
}