package com.it1224.demos.psandbase.official.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ab.activity.AbActivity;
import com.ab.util.AbToastUtil;
import com.it1224.demos.R;
import com.it1224.demos.psandbase.official.view.carousel.CarouselAdapter;
import com.it1224.demos.psandbase.official.view.carousel.CarouselView;
import com.it1224.demos.psandbase.official.view.carousel.CarouselViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * © 2012 amsoft.cn
 * 名称：CarouselViewActivity.java
 * 描述：View适配的旋转木马
 *
 * @author 还如一梦中
 * @version v1.0
 * @date：2013-8-23 下午2:07:13
 */
public class CarouselViewActivity extends AbActivity {

    private CarouselView carousel = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAbContentView(R.layout.carousel_view);

        carousel = (CarouselView) findViewById(R.id.carousel);
        int[] drawables = new int[]{
                R.mipmap.icon1,
                R.mipmap.icon2,
                R.mipmap.icon3,
                R.mipmap.icon4,
                R.mipmap.icon5,
                R.mipmap.icon6,
        };

        //不支持的动态添加adapter.notifyDataSetChanged()增强滑动的流畅

        List<View> mViews = new ArrayList<View>();
        for (int i = 0; i < 6; i++) {
            View convertView = mInflater.inflate(R.layout.carousel_item_view, null, false);
            TextView textView = (TextView) convertView.findViewById(R.id.itemsText);
            textView.setText("Item" + i);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.itemsIcon);
            imageView.setBackgroundResource(drawables[i]);
            mViews.add(convertView);
        }


        CarouselViewAdapter adapter = new CarouselViewAdapter(this, mViews, true);
        carousel.setAdapter(adapter);


        carousel.setOnItemClickListener(new CarouselAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(CarouselAdapter<?> parent, View view,
                                    int position, long id) {
                AbToastUtil.showToast(CarouselViewActivity.this, "Click Position=" + position);

            }

        });

        carousel.setOnItemSelectedListener(new CarouselAdapter.OnItemSelectedListener() {

            @Override
            public void onItemSelected(CarouselAdapter<?> parent, View view,
                                       int position, long id) {
                AbToastUtil.showToast(CarouselViewActivity.this, "Selected Position=" + position);
            }

            @Override
            public void onNothingSelected(CarouselAdapter<?> parent) {
            }

        });

    }

}
