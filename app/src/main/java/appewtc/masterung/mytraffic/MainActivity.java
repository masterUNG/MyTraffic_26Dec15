package appewtc.masterung.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit หรือ การประกาศตัวแปร
    private ListView trafficListView;
    private Button aboutMeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Button Controller
        buttonController();

        //ListView Contorller
        listViewController();

    }   // Main Method

    private void listViewController() {

        //#1
        final int[] intIcon = {R.drawable.traffic_01, R.drawable.traffic_02,
                R.drawable.traffic_03, R.drawable.traffic_04, R.drawable.traffic_05,
                R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08,
                R.drawable.traffic_09, R.drawable.traffic_10, R.drawable.traffic_11,
                R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14,
                R.drawable.traffic_15, R.drawable.traffic_16, R.drawable.traffic_17,
                R.drawable.traffic_18, R.drawable.traffic_19, R.drawable.traffic_20};

        //#2
        final String[] strTitle = new String[20];
        strTitle[0] = "หัวข้อทีี่ 1";
        strTitle[1] = "หัวข้อทีี่ 2";
        strTitle[2] = "หัวข้อทีี่ 3";
        strTitle[3] = "หัวข้อทีี่ 4";
        strTitle[4] = "หัวข้อทีี่ 5";
        strTitle[5] = "หัวข้อทีี่ 6";
        strTitle[6] = "หัวข้อทีี่ 7";
        strTitle[7] = "หัวข้อทีี่ 8";
        strTitle[8] = "หัวข้อทีี่ 9";
        strTitle[9] = "หัวข้อทีี่ 10";
        strTitle[10] = "หัวข้อทีี่ 11";
        strTitle[11] = "หัวข้อทีี่ 12";
        strTitle[12] = "หัวข้อทีี่ 13";
        strTitle[13] = "หัวข้อทีี่ 14";
        strTitle[14] = "หัวข้อทีี่ 15";
        strTitle[15] = "หัวข้อทีี่ 16";
        strTitle[16] = "หัวข้อทีี่ 17";
        strTitle[17] = "หัวข้อทีี่ 18";
        strTitle[18] = "หัวข้อทีี่ 19";
        strTitle[19] = "หัวข้อทีี่ 20";

        //#3
        final String[] strDetail = getResources().getStringArray(R.array.detail_short);

        //Call MyAdapter
        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, strTitle, strDetail, intIcon);
        trafficListView.setAdapter(objMyAdapter);

        //Active When Click on ListView
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Intent to DetailActivity
                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);

                //putExtra
                objIntent.putExtra("Title", strTitle[i]);
                objIntent.putExtra("Image", intIcon[i]);
                objIntent.putExtra("Index", i);

                startActivity(objIntent);

            }   // event
        });


    }   // listViewController


    private void buttonController() {

        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Sound Effect
                MediaPlayer buttonMediaPlayer = MediaPlayer.create(getBaseContext(),
                        R.raw.cow);
                buttonMediaPlayer.start();

                //Intent to WebView
                Intent objIntent = new Intent(Intent.ACTION_VIEW);
                objIntent.setData(Uri.parse("https://youtu.be/uzSKvYbd1XQ"));
                startActivity(objIntent);

            }   // event
        });

    }   // buttonController

    private void bindWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);
    }

}   // Main Class นี่คือ คลาสหลักเว้ยเห้ย
