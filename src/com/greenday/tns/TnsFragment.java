package com.greenday.tns;

import com.greenday.lyrics.R;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class TnsFragment extends Fragment {
	private View rootView;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        rootView = inflater.inflate(R.layout.fragment_tns, container, false);
        
        //Loading Preferences
        getPref();
        
		 ImageButton b=(ImageButton) rootView.findViewById(R.id.imageButton1);
			b.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					@SuppressWarnings("unused")
					AlertDialog builder = new AlertDialog.Builder(getActivity())
			        .setMessage(Html.fromHtml(getString(R.string.album) +
			        		getString(R.string.tns_album_release) +
			        		getString(R.string.length) +
			        		"<font color='#006500'><i>56:15</font></i><br><br>" +
			        		getString(R.string.track_list) +
			        		"<font color='#006500'>1. At the Library <i>(2:26)</i><br>" +
			        		"2. Don't Leave Me <i>(2:37)</i><br>" +
			        		"3. I Was There <i>(3:36)</i><br>" +
			        		"4. Disappearing Boy <i>(2:52)</i><br>" +
			        		"5. Green Day <i>(3:29)</i><br>" +
			        		"6. Going to Pasalacqua <i>(3:30)</i><br>" +
			        		"7. 16 <i>(3:24)</i><br>" +
			        		"8. Road to Acceptance <i>(3:35)</i><br>" +
			        		"9. Rest <i>(3:05)</i><br>" +
			        		"10. The Judge's Daughter <i>(2:34)</i><br>" +
			        		"11. Paper Lanterns <i>(2:23)</i><br>" +
			        		"12. Why Do You Want Him? <i>(2:31)</i><br>" +
			        		"13. 409 in Your Coffeemaker <i>(2:52)</i><br>" +
			        		"14. Knowledge <i>(2:19)</i><br>" +
			        		"15. 1,000 Hours <i>(2:25)</i><br>" +
			        		"16. Dry Ice <i>(3:45)</i><br>" +
			        		"17. Only of You <i>(2:47)</i><br>" +
			        		"18. The One I Want <i>(3:01)</i><br>" +
			        		"19. I Want to Be Alone <i>(3:09)</i></font>"))
			        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
			                getActivity().closeContextMenu();
			            }
			        })
			        .show();    
				}
			});
		
        ListView listview = (ListView) rootView.findViewById(R.id.listView1);

        String[] values = new String[] {
        		"At the Library",
        		"Don't Leave Me",
        		"I Was There",
        		"Disappearing Boy",
        		"Green Day",
        		"Going to Pasalacqua",
        		"16",
        		"Road to Acceptance",
        		"Rest",
        		"The Judge's Daughter",
        		"Paper Lanterns",
        		"Why Do You Want Him?",
        		"409 in Your Coffeemaker",
        		"Knowledge",
        		"1,000 Hours",
        		"Dry Ice",
        		"Only of You",
        		"The One I Want",
        		"I Want to Be Alone"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values); 
                super.onActivityCreated(savedInstanceState);
                 listview.setAdapter(adapter);  

                /*
                 * Adding individual onclicklistener commands below;  
                 */
                 
                 listview.setOnItemClickListener(new AdapterView.OnItemClickListener() 
                 { 
                	 public void onItemClick(AdapterView<?> p, View view, int position, long id)
                	 
                	 { 
                		 switch(position)
                         {
                         case 0:  //At The Library
                        	 Intent newActivity = new Intent(getActivity(), Tns.class);     
			                 newActivity.putExtra("track", 1);
			                 startActivity(newActivity);
                             break;
                         case 1:  //Don't Leave Me
                        	 Intent newActivity1 = new Intent(getActivity(), Tns.class);     
			                 newActivity1.putExtra("track", 2);
			                 startActivity(newActivity1);
                             break;
                         case 2:  //I Was There
                        	 Intent newActivity2 = new Intent(getActivity(), Tns.class);     
			                 newActivity2.putExtra("track", 3);
			                 startActivity(newActivity2);
        			         break;
                         case 3:  //Disappearing Boy
                        	 Intent newActivity3 = new Intent(getActivity(), Tns.class);     
			                 newActivity3.putExtra("track", 4);
			                 startActivity(newActivity3);
        	              	 break;
                         case 4:  //Green Day
                        	 Intent newActivity4 = new Intent(getActivity(), Tns.class);   
                        	 newActivity4.putExtra("track", 5);
			                 startActivity(newActivity4);
        		         	 break;
                         case 5:  //Going To Pasalacqua
                        	 Intent newActivity5 = new Intent(getActivity(), Tns.class);     
			                 newActivity5.putExtra("track", 6);
			                 startActivity(newActivity5);
        		        	 break;
                         case 6:  //16
                        	 Intent newActivity6 = new Intent(getActivity(), Tns.class);     
			                 newActivity6.putExtra("track", 7);
			                 startActivity(newActivity6);
        			       	 break;
                         case 7:  //Road To Acceptance
                        	 Intent newActivity7 = new Intent(getActivity(), Tns.class);     
			                 newActivity7.putExtra("track", 8);
			                 startActivity(newActivity7);
        			       	 break;
                         case 8:  //Rest
                        	 Intent newActivity8 = new Intent(getActivity(), Tns.class);     
			                 newActivity8.putExtra("track", 9);
			                 startActivity(newActivity8);
        			       	 break; 
                         case 9:  //The Judge's Daughter
                        	 Intent newActivity9 = new Intent(getActivity(), Tns.class);     
			                 newActivity9.putExtra("track", 10);
			                 startActivity(newActivity9);
        			       	 break; 
                         case 10: //Paper Lanterns
                        	 Intent newActivity10 = new Intent(getActivity(), Tns.class);     
			                 newActivity10.putExtra("track", 11);
			                 startActivity(newActivity10);
        			       	 break;
                         case 11: //Why Do You Want Him?
                        	 Intent newActivity11 = new Intent(getActivity(), Tns.class);     
			                 newActivity11.putExtra("track", 12);
			                 startActivity(newActivity11);
        			       	 break;
                         case 12: //409 In Your Coffeemaker
                        	 Intent newActivity12 = new Intent(getActivity(), Tns.class);     
			                 newActivity12.putExtra("track", 13);
			                 startActivity(newActivity12);
        			       	 break;
                         case 13: //Knowledge
                        	 Intent newActivity13 = new Intent(getActivity(), Tns.class);     
			                 newActivity13.putExtra("track", 14);
			                 startActivity(newActivity13);
        			       	 break;
                         case 14: //1,000 Hours
                        	 Intent newActivity14 = new Intent(getActivity(), Tns.class);     
			                 newActivity14.putExtra("track", 15);
			                 startActivity(newActivity14);
        			       	 break;
                         case 15: //Dry Ice
                        	 Intent newActivity15 = new Intent(getActivity(), Tns.class);     
			                 newActivity15.putExtra("track", 16);
			                 startActivity(newActivity15);
        			       	 break;
                         case 16: //Only Of You
                        	 Intent newActivity16 = new Intent(getActivity(), Tns.class);     
			                 newActivity16.putExtra("track", 17);
			                 startActivity(newActivity16);
        			       	 break;
                         case 17: //The One I Want
                        	 Intent newActivity17 = new Intent(getActivity(), Tns.class);     
			                 newActivity17.putExtra("track", 18);
			                 startActivity(newActivity17);
        			       	 break;
                         case 18: //I Want To Be Alone
                        	 Intent newActivity18 = new Intent(getActivity(), Tns.class);     
			                 newActivity18.putExtra("track", 19);
			                 startActivity(newActivity18);
        			       	 break;
                         }
                	 }
                 });
                 return rootView;
    }   
    
    @Override
    public void onResume() {
    	// TODO Auto-generated method stub
    	getPref();
    	super.onResume();
    }
    
    private void getPref() {

		//Boot_pref
        boolean firstboot = getActivity().getSharedPreferences("BOOT_PREF", Context.MODE_PRIVATE).getBoolean("firstboot_detail", true);

        if (firstboot){
		 
        	Crouton.makeText(getActivity(), "Press on the circular album art icon...", Style.INFO).show();
        	Crouton.makeText(getActivity(), "to see more info about the album.", Style.INFO).show();
        	Crouton.makeText(getActivity(), "Similar feature is available for the tracks too!", Style.CONFIRM).show();
        	
		getActivity().getSharedPreferences("BOOT_PREF", Context.MODE_PRIVATE)
         .edit()
         .putBoolean("firstboot_detail", false)
         .commit();
        }
		//Boot_pref ends

        //Background transparency
        int def_alpha = 70;
        int alpha = PreferenceManager.getDefaultSharedPreferences(getActivity()).getInt("alpha", def_alpha);
        rootView.findViewById(R.id.tns_layout).getBackground().setAlpha(alpha);
    }
}