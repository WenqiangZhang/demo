package com.it1224.demos.psandbase.official.friend;

import android.content.Context;

import com.ab.db.orm.dao.AbDBDaoImpl;
import com.it1224.demos.psandbase.official.db.DBSDHelper;
import com.it1224.demos.psandbase.official.model.User;

/**
 * © 2012 amsoft.cn
 * 名称：UserDao.java
 * 描述：用户信息
 *
 * @author 还如一梦中
 * @version v1.0
 * @date：2013-7-31 下午4:12:36
 */
public class UserDao extends AbDBDaoImpl<User> {
    public UserDao(Context context) {
        super(new DBSDHelper(context), User.class);
    }
}
