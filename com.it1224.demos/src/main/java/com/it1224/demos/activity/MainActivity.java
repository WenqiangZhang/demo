package com.it1224.demos.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.it1224.demos.R;
import com.it1224.demos.psretrofit.ClientAPI.APIClient;
import com.it1224.demos.psretrofit.adapter.DemosAdapter;
import com.it1224.demos.entity.DemoInfo;
import com.it1224.demos.psretrofit.respinterface.IPhp;
import com.it1224.demos.psretrofit.utils.TextUtil;
import com.it1224.demos.utils.ActivityUtil;
import com.it1224.demos.utils.ClassUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by lenovo on 2016/1/15.
 */
public class MainActivity extends Activity implements AdapterView.OnItemClickListener {


    private DemosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
//        startActivity(new Intent(this,MyRetrofitDemoActivity.class));
        Toast.makeText(this, demo.toString() + "/n" + this.getPackageName(), Toast.LENGTH_LONG).show();
    }

    private void onPreToNext(String destClassName) {
        if (!TextUtil.isEmpty(destClassName)) {
            Intent destIntent = new Intent(this, ClassUtil.getClass(this, destClassName));
            destIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            if (ActivityUtil.isIntentAvailable(this, destIntent)) {
                startActivity(destIntent);
            }
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

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出DEMOS",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
