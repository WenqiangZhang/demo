package com.it1224.demos.psandbase.official.im.activity;

import android.app.Application;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ab.db.storage.AbSqliteStorage;
import com.ab.db.storage.AbSqliteStorageListener.AbDataSelectListener;
import com.ab.db.storage.AbStorageQuery;
import com.ab.util.AbToastUtil;
import com.ab.view.pullview.AbPullToRefreshView;
import com.ab.view.pullview.AbPullToRefreshView.OnFooterLoadListener;
import com.ab.view.pullview.AbPullToRefreshView.OnHeaderRefreshListener;
import com.it1224.demos.R;
import com.it1224.demos.global.BaseApplication;
import com.it1224.demos.psandbase.official.im.adapter.ChatMessageListAdapter;
import com.it1224.demos.psandbase.official.im.dao.IMMsgDao;
import com.it1224.demos.psandbase.official.im.model.IMMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 会话消息列表界面
 */
public class ChatMessageFragment extends Fragment implements
        OnHeaderRefreshListener, OnFooterLoadListener {

    private BaseApplication application;
    private ContacterActivity mActivity = null;
    private List<IMMessage> list = null;
    private AbPullToRefreshView mAbPullToRefreshView = null;
    private ListView mListView = null;
    private ChatMessageListAdapter myListViewAdapter = null;
    // 每一页显示的行数
    public int pageSize = 10;
    // 当前页数
    public int pageNum = 1;

    // 数据库操作类
    private AbSqliteStorage mAbSqliteStorage = null;
    private IMMsgDao mIMMsgDao = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = (ContacterActivity) this.getActivity();
        application = (BaseApplication) mActivity.getApplication();

        View view = inflater.inflate(R.layout.im_message_list, null);
        // 初始化AbSqliteStorage
        mAbSqliteStorage = AbSqliteStorage.getInstance(mActivity);
        // 数据业务类
        mIMMsgDao = new IMMsgDao(mActivity);

        // 获取ListView对象
        mAbPullToRefreshView = (AbPullToRefreshView) view
                .findViewById(R.id.mPullRefreshView);
        mListView = (ListView) view.findViewById(R.id.mListView);

        // 打开关闭下拉刷新加载更多功能
        mAbPullToRefreshView.setOnHeaderRefreshListener(this);
        mAbPullToRefreshView.setOnFooterLoadListener(this);

        // 设置进度条的样式
        mAbPullToRefreshView.getHeaderView().setHeaderProgressBarDrawable(
                this.getResources().getDrawable(R.drawable.progress_circular));
        mAbPullToRefreshView.getFooterView().setFooterProgressBarDrawable(
                this.getResources().getDrawable(R.drawable.progress_circular));
        // mAbPullListView.getHeaderView().setHeaderProgressBarDrawable(this.getResources().getDrawable(R.drawable.progress_circular2));
        // mAbPullListView.getFooterView().setFooterProgressBarDrawable(this.getResources().getDrawable(R.drawable.progress_circular2));

        // ListView数据
        list = new ArrayList<IMMessage>();

        // 使用自定义的Adapter
        myListViewAdapter = new ChatMessageListAdapter(mActivity, list);
        mListView.setAdapter(myListViewAdapter);
        // item被点击事件
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        // 第一次下载数据
        list.clear();
        queryData(0);

        super.onResume();
    }

    @Override
    public void onHeaderRefresh(AbPullToRefreshView view) {
        pageNum = 1;
        list.clear();
        queryData(0);
    }

    @Override
    public void onFooterLoad(AbPullToRefreshView view) {
        pageNum++;
        queryData(1);
    }

    public void queryData(final int query) {
        // 查询数据
        AbStorageQuery mAbStorageQuery = new AbStorageQuery();
        AbStorageQuery mAbStorageQuery2 = new AbStorageQuery();
        mAbStorageQuery.equals("message_type", IMMessage.ADD_FRIEND_MSG);
        mAbStorageQuery2.equals("message_type", IMMessage.CHAT_MSG);
        mAbStorageQuery.or(mAbStorageQuery2);
        mAbStorageQuery.setLimit(pageSize);
        mAbStorageQuery.setOffset((pageNum - 1) * pageSize);

        // 无sql存储的查询
        mAbSqliteStorage.findData(mAbStorageQuery, mIMMsgDao,
                new AbDataSelectListener() {

                    @Override
                    public void onFailure(int errorCode, String errorMessage) {
                        AbToastUtil.showToast(mActivity, errorMessage);
                    }

                    @Override
                    public void onSuccess(List<?> paramList) {
                        if (query == 0) {
                            if (paramList != null && paramList.size() > 0) {
                                list.addAll((List<IMMessage>) paramList);
                                myListViewAdapter.notifyDataSetChanged();
                            }
                            mAbPullToRefreshView.onHeaderRefreshFinish();
                        } else {
                            if (paramList != null) {
                                list.addAll((List<IMMessage>) paramList);
                                myListViewAdapter.notifyDataSetChanged();
                            }
                            mAbPullToRefreshView.onFooterLoadFinish();
                        }

                    }

                });

    }

    public void toChat(String userName) {
        // 进入会话窗口
        Intent chatIntent = new Intent(mActivity, ChatActivity.class);
        chatIntent.putExtra("USERNAME", userName);
        startActivity(chatIntent);
    }

}
