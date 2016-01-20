package com.it1224.demos.psandbase.official.demo.dao;

import android.content.Context;

import com.ab.db.orm.dao.AbDBDaoImpl;
import com.it1224.demos.psandbase.official.db.DBInsideHelper;
import com.it1224.demos.psandbase.official.demo.model.LocalUser;

/**
 * © 2012 amsoft.cn
 * 名称：UserInsideDao.java
 * 描述：本地数据库 在data下面
 *
 * @author 还如一梦中
 * @version v1.0
 * @date：2013-7-31 下午4:12:36
 */
public class UserInsideDao extends AbDBDaoImpl<LocalUser> {
    public UserInsideDao(Context context) {
        super(new DBInsideHelper(context), LocalUser.class);
    }
}
