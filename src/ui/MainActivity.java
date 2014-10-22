package ui;

import com.donal.slidemenudemo.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import de.greenrobot.event.EventBus;
import event.MenuClickEvent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import ui.fragment.FirstFragment;
import ui.fragment.MenuFragment;
import ui.fragment.SecondFragment;
import ui.fragment.ThirdFragment;


public class MainActivity extends BaseSlidingFragmentActivity implements OnClickListener{

	MenuFragment menuFragment;
	FirstFragment firstFragment;
	SecondFragment secondFragment;
	ThirdFragment thirdFragment;
	
	private Fragment[] fragments;
	private int index;
	private int currentTabIndex;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		EventBus.getDefault().register(this);
		setBehindContentView(R.layout.menu_left); 
		menuFragment = new MenuFragment();
		firstFragment = new FirstFragment();
		secondFragment = new SecondFragment();
		thirdFragment = new ThirdFragment();
		fragments = new Fragment[]{firstFragment, secondFragment, thirdFragment};
		currentTabIndex = 0;
		getSupportFragmentManager().beginTransaction().add(R.id.menu_fl, menuFragment)
		.add(R.id.main_rl, firstFragment)
		.add(R.id.main_rl, secondFragment)
		.hide(secondFragment)
		.show(firstFragment)
		.commit();
		
		SlidingMenu localSlidingMenu = getSlidingMenu();
		localSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		localSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		localSlidingMenu.setShadowDrawable(R.drawable.shadow);
		localSlidingMenu.setBehindOffset(189);
		localSlidingMenu.setFadeDegree(0.35F);
	}
	
	@Override
	protected void onDestroy() {
		EventBus.getDefault().unregister(this);
		super.onDestroy();
	}
	
	public void onEventMainThread(MenuClickEvent event){
		toggle();
		switch (event.index) {
		case 0:
			index = 0;
			break;

		case 1:
			index = 1;
			break;
			
		case 2:
			index = 2;
			break;
			
		}
		if (currentTabIndex != index) {
			FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
			trx.hide(fragments[currentTabIndex]);
			if (!fragments[index].isAdded()) {
				trx.add(R.id.main_rl, fragments[index]);
			}
			trx.show(fragments[index]).commit();
		}
		currentTabIndex = index;
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLeft:
			toggle();
			break;

		default:
			break;
		}
	}
}
