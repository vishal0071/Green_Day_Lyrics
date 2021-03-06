package com.greenday.lyrics;
 
import com.espian.showcaseview.OnShowcaseEventListener;
import com.espian.showcaseview.ShowcaseView;
import com.greenday.americanidiot.AmericanIdiotFragment;
import com.greenday.demolicious.DemoliciousFragment;
import com.greenday.dookie.DookieFragment;
import com.greenday.dos.DosFragment;
import com.greenday.ins.IntSuperFragment;
import com.greenday.insomniac.InsomniacFragment;
import com.greenday.kerplunk.KerplunkFragment;
import com.greenday.nimrod.NimrodFragment;
import com.greenday.shenanigans.ShenanigansFragment;
import com.greenday.tcb.TcbFragment;
import com.greenday.tns.TnsFragment;
import com.greenday.tre.TreFragment;
import com.greenday.uno.UnoFragment;
import com.greenday.unreleased.UnreleasedFragment;
import com.greenday.warning.WarningFragment;
import com.slidingmenu.adapter.NavDrawerListAdapter;
import com.slidingmenu.model.NavDrawerItem;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
 
import java.util.ArrayList;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
 
public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
 
    // nav drawer title
    private CharSequence mDrawerTitle;
 
    // used to store app title
    private CharSequence mTitle;
 
    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
 
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private ListView lv;
    private ActionBar ab;
    private DrawerLayout.LayoutParams params;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Nav. Drawer Listview background
        lv=(ListView) findViewById(R.id.list_slidermenu);
        
        //Actionbar
        ab = getActionBar();
        
        //Do not rearrange this stuff!
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
        params = (android.support.v4.widget.DrawerLayout.LayoutParams) mDrawerList.getLayoutParams();
        
        //Loading Preferences
        getPref();
        
        mTitle = mDrawerTitle = getTitle();
        
        //Get user account for spinner
        Account[] accounts = AccountManager.get(this).getAccountsByType("com.google");
        for (Account account : accounts) {

        	SharedPreferences prefs = this.getSharedPreferences(
				      "EXTRA_PREF", Context.MODE_PRIVATE);
			prefs.edit().putString("account", account.name).commit();

        }
        
        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
 
        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);
 
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
 
        navDrawerItems = new ArrayList<NavDrawerItem>();
 
        // adding nav drawer items to array
        // Home
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1), true, null));
        // 39/Smooth
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1), true, "19"));
        // Kerplunk
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1), true, "16"));
        // Dookie
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "15"));
        // Insomniac
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1), true, "14"));
        // Nimrod
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1), true, "18"));
        // Warning
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons.getResourceId(6, -1), true, "12"));
        // International Superhits
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[7], navMenuIcons.getResourceId(7, -1), true, "21"));
        // Shenanigans
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[8], navMenuIcons.getResourceId(8, -1), true, "14"));
        // American Idiot
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[9], navMenuIcons.getResourceId(9, -1), true, "13"));
        // 21st Centuary Breakdown
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[10], navMenuIcons.getResourceId(10, -1), true, "18"));
        // UNO
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[11], navMenuIcons.getResourceId(11, -1), true, "12"));
        // DOS
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[12], navMenuIcons.getResourceId(12, -1), true, "13"));
        // TRE
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[13], navMenuIcons.getResourceId(13, -1), true, "12"));
        // Demolicious
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[14], navMenuIcons.getResourceId(14, -1), true, "18"));
        // Unreleased
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[15], navMenuIcons.getResourceId(15, -1), true, "53"));
 
        // Recycle the typed array
        navMenuIcons.recycle();
 
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
 
        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);
 
        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
 
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }
 
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
 
        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }
 
    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
        case R.id.item1:
        	startActivity(new Intent(MainActivity.this, Settings.class));
            return true;
        case R.id.item2:
        	Intent intent = new Intent(this, ReportSong.class);
			intent.putExtra("report_sub", "Feedback");
			startActivity(intent);
            return true;
        case R.id.action_search:
			// search action
        	Intent intent2 = new Intent(MainActivity.this, Allsongs.class);
        	intent2.putExtra("Search", true);
        	startActivity(intent2);
			return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
 
    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    
 
    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
        case 0:
            fragment = new HomeFragment();
            break;
        case 1:
            fragment = new TnsFragment();
            break;
        case 2:
            fragment = new KerplunkFragment();
            break;
        case 3:
            fragment = new DookieFragment();
            break;
        case 4:
            fragment = new InsomniacFragment();
            break;
        case 5:
            fragment = new NimrodFragment();
            break;
        case 6:
            fragment = new WarningFragment();
            break;
        case 7:
            fragment = new IntSuperFragment();
            break;
        case 8:
            fragment = new ShenanigansFragment();
            break;
        case 9:
            fragment = new AmericanIdiotFragment();
            break;
        case 10:
            fragment = new TcbFragment();
            break;
        case 11:
            fragment = new UnoFragment();
            break;
        case 12:
            fragment = new DosFragment();
            break;
        case 13:
            fragment = new TreFragment();
            break;
        case 14:
            fragment = new DemoliciousFragment();
            break;
        case 15:
            fragment = new UnreleasedFragment();
            break;
        default:
            break;
        }
 
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
 
            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
 
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }
 
    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
 
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
 
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    
    @Override
    protected void onDestroy() {
    	//Protect crouton
        Crouton.clearCroutonsForActivity(this);
        super.onDestroy();
     }
    
    //Override back button function
    long lastPress;
    @Override
    public void onBackPressed() {
    	boolean exit = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("exit", false);
    	if(exit)
    	{
        long currentTime = System.currentTimeMillis();
        Toast exit_toast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_LONG);
        if(currentTime - lastPress > 5000){
            exit_toast.show();
            lastPress = currentTime;
        }else{
        	exit_toast.cancel();
            super.onBackPressed();
        }
    	}
    	else
    	{
    		finish();
    	}
    }
    
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		getPref();
		super.onResume();
	}
    
    private void getPref() {
    	//Nav Drawer ListView Background
        int nav_def_color= Color.parseColor("#70222222");
        int nav_color=PreferenceManager.getDefaultSharedPreferences(this).getInt("nav_theme", nav_def_color);
        lv.setBackgroundColor(nav_color);

        //Action bar color
        int ab_def_color= Color.parseColor("#222222");
        int ab_color=PreferenceManager.getDefaultSharedPreferences(this).getInt("ab_theme", ab_def_color);
        ab.setBackgroundDrawable(new ColorDrawable(ab_color));

        //Drawer width
        int px = (int) (240 * Resources.getSystem().getDisplayMetrics().density);
        int nav_width = PreferenceManager.getDefaultSharedPreferences(this).getInt("nav_width", px);
        params.width = nav_width;
        mDrawerList.setLayoutParams(params);
        
        //Boot_pref
        boolean firstboot = getSharedPreferences("BOOT_PREF", MODE_PRIVATE).getBoolean("firstboot", true);

        if (firstboot){
        	
    		//Showcaseview
            ShowcaseView.ConfigOptions co = new ShowcaseView.ConfigOptions();
            //For leavign action bar unhidden; 
      		//co.insert = ShowcaseView.INSERT_TO_VIEW;
            @SuppressWarnings("deprecation")
			ShowcaseView sv=ShowcaseView.insertShowcaseViewWithType(ShowcaseView.ITEM_ACTION_HOME, 1, this,
            		"Welcome", "\nSlide from left to right to access list of albums.\n" +
            				"\nYou can also press highlighted area as an alternative.", co);
           
            //Click listeners for showcaseview
            sv.setOnShowcaseEventListener(new OnShowcaseEventListener() {
            	 @Override
            	    public void onShowcaseViewHide(ShowcaseView showcaseView) {
            	     //The view is hidden/dismissed
            		 //RelativeLayout v = new RelativeLayout(MainActivity.this);
            		 Crouton.makeText(MainActivity.this, "Please report if you find any incorrect lyrics.", Style.INFO).show();
            	    }

            	 @Override
            	    public void onShowcaseViewShow(ShowcaseView showcaseView) {
            	        //The view is shown
            	    }

				@Override
				public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
					// TODO Auto-generated method stub
					
				}
            	});

            getSharedPreferences("BOOT_PREF", MODE_PRIVATE)
                .edit()
                .putBoolean("firstboot", false)
                .commit();
        }
        //Boot_pref ends
    }
}