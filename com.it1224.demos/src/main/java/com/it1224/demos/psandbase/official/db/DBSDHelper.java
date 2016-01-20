package com.it1224.demos.psandbase.official.db;

import android.content.Context;

import com.ab.db.orm.AbSDDBHelper;
import com.ab.util.AbFileUtil;
import com.it1224.demos.psandbase.official.demo.model.LocalUser;
import com.it1224.demos.psandbase.official.demo.model.Stock;
import com.it1224.demos.psandbase.official.friend.Friend;
import com.it1224.demos.psandbase.official.im.model.IMMessage;
import com.it1224.demos.psandbase.official.model.User;

public class DBSDHelper extends AbSDDBHelper {
    // 数据库名
    private static final String DBNAME = "andbasedemo.db";

    // 当前数据库的版本
    private static final int DBVERSION = 1;
    // 要初始化的表
    private static final Class<?>[] clazz = {User.class, LocalUser.class, Stock.class, Friend.class, IMMessage.class};

    public DBSDHelper(Context context) {
        super(context, AbFileUtil.getDbDownloadDir(context), DBNAME, null, DBVERSION, clazz);
    }

}



