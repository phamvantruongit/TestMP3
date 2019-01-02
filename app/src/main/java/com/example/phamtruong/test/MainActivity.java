package com.example.phamtruong.test;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;
    ListView listView;
    ArrayAdapter adapter;
    String[] listmp3;
    WebView webView;
    TextView tv,tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.lvList);
        tvContent= (TextView) findViewById(R.id.tv_content);

        tv= (TextView) findViewById(R.id.tv);
        String text=" resolve /ri'zɔlv/ = giai quet = ví dụ";
        String arr[]=text.split("=");

            Log.d("text",arr[0].toString() +"\n");
            Log.d("text",arr[1].toString() +"\n");
            Log.d("text",arr[2].toString() +"\n");
      

        try {
            listmp3 = this.getResources().getAssets().list("contracts");
            adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, listmp3);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        } catch (IOException e) {
            e.printStackTrace();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                playSound(getApplicationContext(), listmp3[i]);
            }
        });



    }
    public void playSound(final Context context, final String fileName) {
        mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor afd =  getAssets().openFd("contracts/"+fileName);
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mediaPlayer.prepare();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    public void OnPlay(View view) {
        for(int i=0;i<listmp3.length;i++){
            playSound(getApplicationContext(), listmp3[i]);
            SystemClock.sleep(2000);

        }
    }
}
