package net.edutech.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.edutech.app.utility.NetworkChangeList;

public class admissionprocess extends AppCompatActivity {
    NetworkChangeList networkChangeList = new NetworkChangeList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admissionprocess);
        ImageView back=findViewById(R.id.back5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),aboutkcet2.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                finish();
            }
        });
        TextView schedule = findViewById(R.id.schedule);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cetonline.Karnataka.gov.in/kea/"));
                startActivity(browser);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);



            }
        });
        TextView required_documents = findViewById(R.id.required_documents);
        required_documents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), requiredDocuments.class);
                startActivity(intent);
                                overridePendingTransition(R.anim.slide_up, R.anim.slide_down);


            }
        });
        TextView official_notification = findViewById(R.id.official_notification);
        official_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cetonline.Karnataka.gov.in/kea/"));
                startActivity(browser);
                                overridePendingTransition(R.anim.slide_up, R.anim.slide_down);


            }
        });
    }
    @Override
    protected void onStart() {
        IntentFilter filter =new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeList,filter);

        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeList);
        super.onStop();
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}