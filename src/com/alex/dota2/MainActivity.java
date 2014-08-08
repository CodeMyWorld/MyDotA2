package com.alex.dota2;

import android.support.v7.app.ActionBarActivity;
import android.net.wifi.WifiConfiguration.Status;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import org.dom4j.*;

public class MainActivity extends ActionBarActivity {

	private int status = 0;
    private ProgressBar bar;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg){
			if(msg.what == 911){
				bar.setProgress(status);
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bar = (ProgressBar)findViewById(R.id.initDB);
		Button initBt = (Button)findViewById(R.id.commitBt);
		initBt.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(){

						public void run() {
							for(int i = 0; i < 100; i++){
								try {
									Thread.sleep(100);
									Message msg = new Message();
									msg.what = 911;
									status++;
									handler.sendMessage(msg);
								} catch (Exception ex) {
									// TODO: handle exception
								}
							}

					}
				}.start();

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
