package org.goodev.retrofitdemo.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.goodev.retrofitdemo.ClientAPI.APIClient;
import org.goodev.retrofitdemo.respinterface.IGitHub;
import org.goodev.retrofitdemo.entity.Contributor;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RetrofitActivity extends ListActivity {

    ListView mListView;
    Callback<List<Contributor>> callback = new Callback<List<Contributor>>() {

        @Override
        public void success(List<Contributor> contributors, Response response) {
            ArrayAdapter<Contributor> adapter = new ArrayAdapter<Contributor>(getApplicationContext(),
                    android.R.layout.simple_list_item_1, contributors);
            mListView.setAdapter(adapter);
        }

        @Override
        public void failure(RetrofitError error) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListView = getListView();
        APIClient.createApi(this, IGitHub.class).contributors("square", "retrofit", callback);
    }

}
