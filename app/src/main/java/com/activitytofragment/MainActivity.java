package com.activitytofragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.activitytofragment.Fragment.MyFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText userName;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        userName = (EditText) findViewById(R.id.et_username);
        findViewById(R.id.bt_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_login:
                String name = userName.getText().toString().trim();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                MyFragment myFragment = new MyFragment();
                myFragment.setArguments(bundle);
                replaceFragment(myFragment,"myfragment");
                break;
        }
    }

    private void replaceFragment(Fragment fragment, String tag) {
        // 往容器中默认的添加Fragment1
        // 开始事物
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        // 要添加到的容器
        beginTransaction.replace(R.id.framelayout, fragment, tag);
        // 提交事务
        beginTransaction.commit();
    }
}
