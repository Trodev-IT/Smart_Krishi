package com.trodev.smartkrishi.AllCultivateAndFarming.agricultureinformation.fruits;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.trodev.smartkrishi.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShowPDFActivity extends AppCompatActivity {
    private String pdf;
    PDFView pdfView;
    ProgressDialog progressDialog;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pdfactivity);

        /*disable ss permission*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        /*action bar title*/
        getSupportActionBar().setTitle("পিডিএফ দেখুন");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*get data on FruitsAdapterr*/
        pdf = getIntent().getStringExtra("pdf");

        /*web view*/
        //  webView = findViewById(R.id.webView);
        pdfView = findViewById(R.id.pdfView);

        /*progress dialog show and init*/
        progressDialog = new ProgressDialog(ShowPDFActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog = ProgressDialog.show(this, "পিডিএফ লোড হচ্ছে", "কিছুক্ষণ অপেক্ষা করুন");
        progressDialog.show();

        new PdfDownload().execute(pdf);

    }
    private class PdfDownload extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {

            InputStream inputStream = null;

            try {
                progressDialog.show();
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                if (urlConnection.getResponseCode() == 200) {
                    progressDialog.show();
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            progressDialog.hide();
            pdfView.fromStream(inputStream).load();
        }
    }
}