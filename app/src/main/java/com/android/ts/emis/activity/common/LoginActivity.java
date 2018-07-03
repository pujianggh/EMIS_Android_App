package com.android.ts.emis.activity.common;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.ts.emis.R;
import com.android.ts.emis.activity.MainActivity;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.utils.PopupWindowUtil;
import com.android.ts.emis.utils.SPUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 系统登录
 *
 * @author pujiang
 * @date 2018-4-13 16:48
 * @mail 515210530@qq.com
 * @Description:
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.edt_account)
    EditText edtAccount;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.tv_company)
    TextView tvCompany;

    private PopupWindowUtil mPopupWindowUtil = null;
    private boolean isShow = false;

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);
        if (!TextUtils.isEmpty(mUserPasswrd.getUserName())) {
            edtAccount.setText(mUserPasswrd.getUserName());
        }
        if (!TextUtils.isEmpty(mUserPasswrd.getPassword())) {
            edtPassword.setText(mUserPasswrd.getPassword());
        }
        initEnvet();
    }

    @OnClick({R.id.btn_next, R.id.tv_company})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_company:
                isShow = true;
                break;
            case R.id.btn_next:
                if (TextUtils.isEmpty(edtAccount.getText().toString())) {
                    showToast("请输入账号");
                    return;
                }
                if (TextUtils.isEmpty(edtPassword.getText().toString())) {
                    showToast("请输入密码");
                    return;
                }
                if (edtAccount.getText().toString().length() >= 4 && "111111".equals(edtPassword.getText().toString())) {
                    mUserPasswrd = SPUtil.INSTANCE.getAllModle(mAPPApplication, mUserPasswrd);
                    mUserPasswrd.setUserName(edtAccount.getText().toString());
                    mUserPasswrd.setPassword(edtPassword.getText().toString());
                    mUserPasswrd.setUserPhone("18000008808");
                    SPUtil.INSTANCE.putAllModle(mAPPApplication, mUserPasswrd);
                    startActivity(new Intent(this, MainActivity.class));
                    onBackPressed();
                } else {
                    showToast("账号或密码错误");
                }
                break;
        }
    }

    private void initEnvet() {
        edtAccount.addTextChangedListener(new TextChangeListeners());
        edtPassword.addTextChangedListener(new TextChangeListeners());
        tvCompany.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (isShow) {
                    if (mPopupWindowUtil == null)
                        mPopupWindowUtil = new PopupWindowUtil(mContext);
                    mPopupWindowUtil.showSetConnectURLWindow();
                }
                return false;
            }
        });
    }

    private class TextChangeListeners implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!TextUtils.isEmpty(edtAccount.getText().toString()) && !TextUtils.isEmpty(edtPassword.getText().toString())) {
                btnNext.setEnabled(true);
            } else {
                btnNext.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
