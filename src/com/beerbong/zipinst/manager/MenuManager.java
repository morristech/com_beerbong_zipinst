package com.beerbong.zipinst.manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.beerbong.zipinst.R;
import com.beerbong.zipinst.activities.About;
import com.beerbong.zipinst.activities.Sdcard;
import com.beerbong.zipinst.ui.UI;
import com.beerbong.zipinst.ui.UIListener;
import com.beerbong.zipinst.util.Constants;

/**
 * @author Yamil Ghazi Kantelinen
 * @version 1.0
 */

public class MenuManager implements UIListener {
	
	private Activity mActivity;
	
	protected MenuManager(Activity activity) {
		mActivity = activity;
		
		UI.getInstance().addUIListener(this);
	}

	public void onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = mActivity.getMenuInflater();
      inflater.inflate(R.menu.menu, menu);
	}
	public void onOptionsItemSelected(MenuItem item) {
		Intent i;
   	switch (item.getItemId()) {
       	case R.id.sdcard:
       		i = new Intent(mActivity, Sdcard.class);
       		mActivity.startActivity(i);
       		break;
       	case R.id.about:
       		i = new Intent(mActivity, About.class);
       		mActivity.startActivity(i);
       		break;
       	case R.id.donate:
       		i = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.DONATE_URL));
       		mActivity.startActivity(i);
       		break;
       	case R.id.exit:
       		mActivity.finish();
       		break;
   	}
	}
	public void onPreferenceClicked(String id) {
	}
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	}
}