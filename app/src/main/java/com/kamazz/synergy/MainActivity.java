package com.kamazz.synergy;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://api.telegram.org/bot5124466490:AAHtVCPHamAWWkRsjVzCBnINo_JAQByOaCY/sendMessage?chat_id=5086080378&parse_mode=html&text=sasa";
        new GetUrlData().execute(url);
    }

    private class GetUrlData extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;

            try {
                URL url = new URL(strings[0]);

                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
            }catch (IOException e){
                e.printStackTrace();
            } finally {
                if(connection != null)
                    connection.disconnect();
            }
            return null;
        }
    }
}
