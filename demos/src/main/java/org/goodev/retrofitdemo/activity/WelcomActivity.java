package org.goodev.retrofitdemo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.goodev.retrofitdemo.ClientAPI.APIClient;
import org.goodev.retrofitdemo.R;
import org.goodev.retrofitdemo.adapter.DemosAdapter;
import org.goodev.retrofitdemo.entity.DemoInfo;
import org.goodev.retrofitdemo.respinterface.IPhp;
import org.goodev.retrofitdemo.utils.TextUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by lenovo on 2016/1/15.
 */
public class WelcomActivity extends Activity implements AdapterView.OnItemClickListener {

    private DemosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setOnItemClickListener(this);
        List<DemoInfo> data = new ArrayList<DemoInfo>();
        adapter = new DemosAdapter(this, data);
        lv.setAdapter(adapter);
        loadDemosInfo();
    }

    private void loadDemosInfo() {
        APIClient.createApi(this, IPhp.class).getAndroidDemos(new Callback<List<DemoInfo>>() {
            @Override
            public void success(List<DemoInfo> demoInfos, Response response) {
                adapter.addAll(demoInfos);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DemoInfo demo = (DemoInfo) parent.getItemAtPosition(position);
        onPreToNext(demo.getActivity());
        Toast.makeText(this,demo.toString(),Toast.LENGTH_LONG).show();
    }

    private void onPreToNext(String destClassName) {
        if (!TextUtil.isEmpty(destClassName)) {
            ComponentName componentName = new ComponentName(this, destClassName);
            Intent destIntent = new Intent(this, componentName.getClass());
            destIntent.setComponent(componentName);
            startActivity(destIntent);
        }
    }

    private DemoInfo getDemoInfo(String id, String name, String description, String time) {
        DemoInfo demo = new DemoInfo();
        demo.setId(id);
        demo.setName(name);
        demo.setDescription(description);
        demo.setTime(time);
        return demo;
    }

}
