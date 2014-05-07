package com.greenday.americanidiot;

import com.fourmob.poppyview.PoppyViewHelper;
import com.fourmob.poppyview.PoppyViewHelper.PoppyViewPosition;
import com.greenday.lyrics.Allsongs;
import com.greenday.lyrics.ReportSong;
import com.greenday.lyrics.Settings;
import com.greenday.lyrics.R;
import com.greenday.americanidiot.Info;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class AmericanIdiotMain extends Activity {
	
	private PoppyViewHelper mPoppyViewHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.americanidiot);
		
		//Action bar color
        int ab_def_color= Color.parseColor("#222222");
        int ab_color=PreferenceManager.getDefaultSharedPreferences(this).getInt("ab_theme", ab_def_color);
        ActionBar ab =getActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(ab_color));
        
        //Text Size
		TextView tv1 = (TextView)findViewById(R.id.textView1);
		int text_size = PreferenceManager.getDefaultSharedPreferences(this).getInt("text", 18);
		tv1.setTextSize(text_size);
		
		//Text Color
		int text_def_color= Color.parseColor("#222222");
        int text_color=PreferenceManager.getDefaultSharedPreferences(this).getInt("text_theme", text_def_color);
        tv1.setTextColor(text_color);
		
		//Poppyview 
		mPoppyViewHelper=new PoppyViewHelper(this, PoppyViewPosition.BOTTOM);
		View poppyview = mPoppyViewHelper.createPoppyViewOnScrollView(R.id.scrollView, R.layout.poppyview);
		int poppy_def_color=Color.parseColor("#222222");
		int poppy_color=PreferenceManager.getDefaultSharedPreferences(this).getInt("poppy_theme", poppy_def_color);
		poppyview.setBackgroundColor(poppy_color);
		
		ImageButton search = (ImageButton) poppyview.findViewById(R.id.imageButton1);
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// Search action | Add as new task
				Intent intent = new Intent(AmericanIdiotMain.this, Allsongs.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.putExtra("Search", true);
				startActivity(intent);
			}
		});
		ImageButton report = (ImageButton) poppyview.findViewById(R.id.imageButton2);
		report.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int track = getIntent().getExtras().getInt("track");
				Intent intent = new Intent(AmericanIdiotMain.this, ReportSong.class);
				if(track == 1){
					intent.putExtra("report_sub", "American Idiot");
					startActivity(intent);
					}
				if(track == 2){
					intent.putExtra("report_sub", "Jesus Of Suburbia");
					startActivity(intent);
					}
				if(track == 3){
					intent.putExtra("report_sub", "Holiday");
					startActivity(intent);
					}
				if(track == 4){
					intent.putExtra("report_sub", "Boulevard of Broken Dreams");
					startActivity(intent);
					}
				if(track == 5){
					intent.putExtra("report_sub", "Are We The Waiting");
					startActivity(intent);
					}
				if(track == 6){
					intent.putExtra("report_sub", "St. Jimmy");
					startActivity(intent);
					}
				if(track == 7){
					intent.putExtra("report_sub", "Give Me Novacaine");
					startActivity(intent);
					}
				if(track == 8){
					intent.putExtra("report_sub", "She's A Rebel");
					startActivity(intent);
					}
				if(track == 9){
					intent.putExtra("report_sub", "Extraordinary Girl");
					startActivity(intent);
					}
				if(track == 10){
					intent.putExtra("report_sub", "Letterbomb");
					startActivity(intent);
					}
				if(track == 11){
					intent.putExtra("report_sub", "Wake Me Up When September Ends");
					startActivity(intent);
					}
				if(track == 12){
					intent.putExtra("report_sub", "Homecoming");
					startActivity(intent);
					}
				if(track == 13){
					intent.putExtra("report_sub", "Whatshername");
					startActivity(intent);
					}
			}
		});
		ImageButton label=(ImageButton) poppyview.findViewById(R.id.imageButton3);
		label.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int track = getIntent().getExtras().getInt("track");
				if(track == 1){
					Info.info1(AmericanIdiotMain.this);
				}
				if(track == 2){
					Info.info2(AmericanIdiotMain.this);
				}
				if(track == 3){
					Info.info3(AmericanIdiotMain.this);
				}
				if(track == 4){
					Info.info4(AmericanIdiotMain.this);
				}
				if(track == 5){
					Info.info5(AmericanIdiotMain.this);
				}
				if(track == 6){
					Info.info6(AmericanIdiotMain.this);
				}
				if(track == 7){
					Info.info7(AmericanIdiotMain.this);
				}
				if(track == 8){
					Info.info8(AmericanIdiotMain.this);
				}
				if(track == 9){
					Info.info9(AmericanIdiotMain.this);
				}
				if(track == 10){
					Info.info10(AmericanIdiotMain.this);
				}
				if(track == 11){
					Info.info11(AmericanIdiotMain.this);
				}
				if(track == 12){
					Info.info12(AmericanIdiotMain.this);
				}
				if(track == 13){
					Info.info13(AmericanIdiotMain.this);
				}
			}
		});
		ImageButton settings=(ImageButton) poppyview.findViewById(R.id.imageButton4);
		settings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), Settings.class));
			}
		});
		//Poppyview
		
		//Lyrics
		int track = getIntent().getExtras().getInt("track");
		if(track == 1){
			ab.setTitle("American Idiot");
			tv1.setText(R.string.americanidiot);
		}
		if(track == 2){
			ab.setTitle("Jesus Of Suburbia");
			tv1.setText(R.string.jos);
		}
		if(track == 3){
			ab.setTitle("Holiday");
			tv1.setText(R.string.holiday);
		}
		if(track == 4){
			ab.setTitle("Boulevard of Broken Dreams");
			tv1.setText(R.string.boulevards);
		}
		if(track == 5){
			ab.setTitle("Are We The Waiting");
			tv1.setText(R.string.arewethewaiting);
		}
		if(track == 6){
			ab.setTitle("St. Jimmy");
			tv1.setText(R.string.stjimmy);
		}
		if(track == 7){
			ab.setTitle("Give Me Novacaine");
			tv1.setText(R.string.givemenov);
		}
		if(track == 8){
			ab.setTitle("She's A Rebel");
			tv1.setText(R.string.shesarebel);
		}
		if(track == 9){
			ab.setTitle("Extraordinary Girl");
			tv1.setText(R.string.extordgirl);
		}
		if(track == 10){
			ab.setTitle("Letterbomb");
			tv1.setText(R.string.letterbomb);
		}
		if(track == 11){
			ab.setTitle("Wake Me Up When September Ends");
			tv1.setText(R.string.wakemeup);
		}
		if(track == 12){
			ab.setTitle("Homecoming");
			tv1.setText(R.string.homecoming);
		}
		if(track == 13){
			ab.setTitle("Whatshername");
			tv1.setText(R.string.whatshername);
		}
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		//Display
		boolean display = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("display", false);
		if(display)
		{
			tv1.setKeepScreenOn(true);
		}
	}
	
		@Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        //getMenuInflater().inflate(R.menu.main_song, menu);
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
		            return super.onOptionsItemSelected(item);
		}
}