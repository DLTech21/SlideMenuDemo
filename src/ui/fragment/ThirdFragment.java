package ui.fragment;

import com.donal.slidemenudemo.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThirdFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		LogUtils.i("ThirdFragment");
		View view = inflater.inflate(R.layout.fragment_3, null);
		ViewUtils.inject(this, view);
		return view;
	}
}
