package com.it1224.demos.psandbase.official.im.dao;

import android.content.Context;

import com.ab.db.orm.dao.AbDBDaoImpl;
import com.it1224.demos.psandbase.official.db.DBInsideHelper;
import com.it1224.demos.psandbase.official.im.model.IMMessage;


/**
 * IMMsgDao的存储实现类
 */
public class IMMsgDao extends AbDBDaoImpl<IMMessage> {
    public IMMsgDao(Context context) {
        super(new DBInsideHelper(context), IMMessage.class);
    }

}
