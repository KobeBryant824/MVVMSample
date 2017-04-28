package com.cxh.mvvmsample.view.activity;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.cxh.mvvmsample.R;
import com.cxh.mvvmsample.base.BaseAutoActivity;
import com.cxh.mvvmsample.bindingadapter.ReplyCommand;
import com.cxh.mvvmsample.databinding.MyBinding;
import com.cxh.mvvmsample.listener.OkListener;
import com.cxh.mvvmsample.model.api.User;
import com.cxh.mvvmsample.util.ToastUtils;

import io.reactivex.functions.Action;

/**
 * Desc,
 * Created by Hai (haigod7@gmail.com) on 2017/4/28 13:58.
 */
public class DataBindingActivity extends BaseAutoActivity implements OkListener {

    private MyBinding mBinding;

    @Override
    protected void setContentView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
    }

    @Override
    protected void RetryEvent() {

    }

    @Override
    protected void initViewsAndEvents() {
        mPageStateManager.showContent();
        User user = new User("Kobe", "Bryant", 37);
        mBinding.setUser(user);
        mBinding.setOkText("hello点我");
        mBinding.setListener(this);
        mBinding.setCommand(this);
    }

    public final ReplyCommand mReplyCommand = new ReplyCommand(new Action() {
        @Override
        public void run() throws Exception {
            ToastUtils.showToast(DataBindingActivity.this, "ReplyCommand");
        }
    });

    @Override
    public void onClickOk(View view) {
        ToastUtils.showToast(this, "OkListener");
    }
}
