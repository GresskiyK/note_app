package com.example.anything;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadData {

    DownloadData(OnGetData onGetData){
        this.onGetData = onGetData;
    }

    public OnGetData onGetData;

    public void CreateUrl(String input){

        String request= input;
        // айпи компютера!
        String result ="http://192.168.25.55:5000/"+request;
        DownloadJSON json = new DownloadJSON(onGetData);
        json.execute(result);
    }



    private static class DownloadJSON extends AsyncTask<String, Void, String> {

        public OnGetData onGetData;

        DownloadJSON(OnGetData onGetData){
            super();
            this.onGetData = onGetData;
        }

        @Override
        protected String doInBackground(String... strings) {
            URL url=null;
            StringBuilder result= new StringBuilder();
            HttpURLConnection connection=null;
            String line =null;

            try {
                url = new URL(strings[0]);
                connection=(HttpURLConnection)
                url.openConnection();
                InputStream in = connection.getInputStream();
                InputStreamReader reader= new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(reader);
                line=bufferedReader.readLine();
                while(line!=null){
                    result.append(line);
                    line=bufferedReader.readLine();
                }

                return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            finally {
                if(connection!=null){
                    connection.disconnect();
                }
            }
            return null;


        }

        @Override
        protected void onPostExecute(String s) {

            onGetData.onDataGetListener(s);

            super.onPostExecute(s);
        }
    }
}
