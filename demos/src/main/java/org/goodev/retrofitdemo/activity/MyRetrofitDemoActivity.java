package org.goodev.retrofitdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.goodev.retrofitdemo.ClientAPI.APIClient;
import org.goodev.retrofitdemo.R;
import org.goodev.retrofitdemo.respinterface.IPhp;
import org.goodev.retrofitdemo.base.ABaseAdapter;
import org.goodev.retrofitdemo.entity.ImageInfo;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by lenovo on 2016/1/15.
 */
public class MyRetrofitDemoActivity extends Activity {


        private static final int SUCCESS = 1;
        private Context getContext;
        private TextView textView;
        private Handler handler = new Handler(new Handler.Callback() {

            @Override
            public boolean handleMessage(Message message) {
                if (message.what == SUCCESS) {
//                textView.setText(message.obj.toString());
                }
                return false;
            }
        });

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_retrofit);
            this.getContext = MyRetrofitDemoActivity.this;

//        final ImageView imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.text);
        final ListView lv = (ListView) findViewById(android.R.id.list);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());


        //异步请求
        IPhp iPhp = APIClient.createApi(this, IPhp.class);
            iPhp.getImageUrls("1", new Callback<List<ImageInfo>>() {
                @Override
                public void success(List<ImageInfo> imageUrls, Response response) {
                    StringBuffer sb = new StringBuffer(256);
                    for (ImageInfo imageUrl : imageUrls) {
                        sb.append(imageUrl.getImgUrl() + "\n");
                    }
//                textView.setText(sb.toString());
//                Toast.makeText(MainActivity.this, imageUrls.toString(), Toast.LENGTH_LONG).show();
                    lv.setAdapter(new ImageAdapter(getContext, imageUrls));
                }

                @Override
                public void failure(RetrofitError retrofitError) {

                    textView.setText(retrofitError.getUrl() + "\n" + retrofitError.toString());
                }
            });

        new Thread(new Runnable() {
            @Override
            public void run() {
                //同步请求
                IPhp iPhp = APIClient.createApi(MyRetrofitDemoActivity.this, IPhp.class);
                List<ImageInfo> imageInfos = iPhp.getImageUrls("1");
                StringBuffer sb = new StringBuffer(256);
                for (ImageInfo imageInfo : imageInfos) {
                    sb.append(imageInfo.getImgUrl() + "\n");
                }

                Message msg = handler.obtainMessage(SUCCESS, sb);
                handler.sendMessage(msg);
            }
        }).start();

    }

        class ImageAdapter extends ABaseAdapter<ImageInfo> {

            public ImageAdapter(Context context, List<ImageInfo> data) {
                super(context, data);
            }

            @Override
            public View convert(int i, View view, ViewGroup viewGroup) {
                ViewHolder h = null;
                if(view == null){
                    view = inflater.inflate(R.layout.lv_item, null);
                    h = new ViewHolder();
                    h.iv = (ImageView) view.findViewById(R.id.iv);
                    view.setTag(h);
                }else{
                    h = (ViewHolder) view.getTag();
                }
                ImageInfo info = getItem(i);
                bitmapUtils.display(h.iv,info.getImgUrl());
                return view;
            }
            class ViewHolder{
                public ImageView iv;
            }
        }

        class ImageUrls {
            public static final String img1 = "http://audio.ycaudio.com/UploadFile/2005-6/2005612143316487.jpg";
            public static final String img2 = "http://img3.imgtn.bdimg.com/it/u=1551433713,4281670161&fm=21&gp=0.jpg";
            public static final String img3 = "http://www.deskcar.com/desktop/else/20083392350/15.jpg";
            public static final String img4 = "http://hiphotos.baidu.com/xiaenteng/pic/item/b8785bf5373875c5f3d38513.jpg";
            public static final String img5 = "http://gzdaily.dayoo.com/img/2003-07/20/xin_740b956274614bb49f02d8cbc902d4f0.JPG";
            public static final String img6 = "http://image2.sina.com.cn/dongman/m/2005-11-18/U637P55T4D75566F50DT20051118113243.jpg";
            public static final String img7 = "http://image2.sina.com.cn/dongman/m/2005-11-18/U637P55T4D75561F50DT20051118112013.jpg";
            public static final String img8 = "http://image2.sina.com.cn/dongman/m/2005-11-18/U637P55T4D75562F50DT20051118112302.jpg";
            public static final String img9 = "http://image.tianjimedia.com/uploadImages/2012/229/10/7F8786KA3394.jpg";
            public static final String img0 = "http://t2.qpic.cn/mblogpic/fa57e8818c53d89eeec0/2000.jpg";
            public static final String img10 = "http://images.17173.com/2014/news/2014/04/24/cb0424xxs30s.jpg";
            public static final String img11 = "http://i3.img.969g.com/pub/imgx2013/07/27/196_141937_1c8c9.jpg";

//        TRUNCATE test_image_urls;
//SELECT * FROM test_image_urls;
//INSERT INTO test_image_urls (imgUrl) VALUES("http://img3.imgtn.bdimg.com/it/u=1551433713,4281670161&fm=21&gp=0.jpg");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://www.deskcar.com/desktop/else/20083392350/15.jpg");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://hiphotos.baidu.com/xiaenteng/pic/item/b8785bf5373875c5f3d38513.jpg");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://gzdaily.dayoo.com/img/2003-07/20/xin_740b956274614bb49f02d8cbc902d4f0.JPG");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://image2.sina.com.cn/dongman/m/2005-11-18/U637P55T4D75566F50DT20051118113243.jpg");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://image2.sina.com.cn/dongman/m/2005-11-18/U637P55T4D75561F50DT20051118112013.jpg");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://image2.sina.com.cn/dongman/m/2005-11-18/U637P55T4D75562F50DT20051118112302.jpg");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://image.tianjimedia.com/uploadImages/2012/229/10/7F8786KA3394.jpg");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://t2.qpic.cn/mblogpic/fa57e8818c53d89eeec0/2000.jpg");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://images.17173.com/2014/news/2014/04/24/cb0424xxs30s.jpg");
//INSERT INTO test_image_urls (imgUrl) VALUES("http://i3.img.969g.com/pub/imgx2013/07/27/196_141937_1c8c9.jpg");
//SELECT * FROM test_image_urls;
        }
}
