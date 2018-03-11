package com.activitytofragment.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.activitytofragment.R;


public class MyFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.my_fragment, null);

		TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
		// 获取参数
		Bundle arguments = getArguments();
		String name = arguments.getString("name");
		// 设置内容
		tv_name.setText(name);
		return view;
	}
}
