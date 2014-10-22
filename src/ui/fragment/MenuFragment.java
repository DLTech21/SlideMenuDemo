package ui.fragment;

import com.donal.slidemenudemo.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import de.greenrobot.event.EventBus;
import event.MenuClickEvent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment implements OnClickListener{
	@ViewInject(R.id.btn1)
	private Button btn1;
	@ViewInject(R.id.btn2)
	private Button btn2;
	@ViewInject(R.id.btn3)
	private Button btn3;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.menu_left, null);
		ViewUtils.inject(this, view);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			EventBus.getDefault().post(new MenuClickEvent(0));
			break;
		case R.id.btn2:
			EventBus.getDefault().post(new MenuClickEvent(1));
			break;
		case R.id.btn3:
			EventBus.getDefault().post(new MenuClickEvent(2));
			break;
		}
	}
}
