package com.android.ts.emis.mode;

import java.io.Serializable;

/**
 * 用户密码
 *
 * @author pujiang
 * @date 2018-6-8 22:59
 * @mail 515210530@qq.com
 * @Description:
 */
public class UserPasswordBean extends BaseBean implements Serializable {
    private String userName = "";//	名字
    private String password = "";// 密码
    private String userPhone = "";// 密码

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
