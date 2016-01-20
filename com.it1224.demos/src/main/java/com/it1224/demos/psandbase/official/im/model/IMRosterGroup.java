package com.it1224.demos.psandbase.official.im.model;

import com.it1224.demos.psandbase.official.model.User;

import java.util.List;


/**
 * IM联系人分组
 */
public class IMRosterGroup {

    // 分组名称
    private String name;
    // 好友列表
    private List<User> users;

    public IMRosterGroup(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public int getCount() {
        if (users != null)
            return users.size();
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
