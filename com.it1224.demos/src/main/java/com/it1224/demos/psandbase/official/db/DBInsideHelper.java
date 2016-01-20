package com.it1224.demos.psandbase.official.db;

import android.content.Context;

import com.ab.db.orm.AbDBHelper;
import com.it1224.demos.psandbase.official.demo.model.LocalUser;
import com.it1224.demos.psandbase.official.demo.model.Stock;
import com.it1224.demos.psandbase.official.friend.Friend;
import com.it1224.demos.psandbase.official.im.model.IMMessage;
import com.it1224.demos.psandbase.official.model.User;

/**
 * © 2012 amsoft.cn
 * 名称：DBInsideHelper.java
 * 描述：手机data/data下面的数据库
 *
 * @author 还如一梦中
 * @version v1.0
 * @date：2013-7-31 下午3:50:18
 */
public class DBInsideHelper extends AbDBHelper {
    // 数据库名
    private static final String DBNAME = "andbasedemo.db";

    // 当前数据库的版本
    private static final int DBVERSION = 1;
    // 要初始化的表
    private static final Class<?>[] clazz = {User.class, LocalUser.class, Stock.class, Friend.class, IMMessage.class};

    public DBInsideHelper(Context context) {
        super(context, DBNAME, null, DBVERSION, clazz);
    }

}



