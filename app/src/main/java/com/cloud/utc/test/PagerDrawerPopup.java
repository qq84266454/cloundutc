package com.cloud.utc.test;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.cloud.utc.R;
import com.lxj.xpopup.core.DrawerPopupView;


/**
 * Description:
 * Create by dance, at 2019/5/5
 */
public class PagerDrawerPopup extends DrawerPopupView {
    public PagerDrawerPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.pop_view_pager_fragment;
    }

    ViewPager pager;
    @Override
    protected void onCreate() {
        super.onCreate();
        pager = findViewById(R.id.pager);
        pager.setAdapter(new PAdapter());
    }

    @Override
    protected void onShow() {
        super.onShow();
        Log.e("tag", "PagerDrawerPopup onShow");
    }

    @Override
    protected void onDismiss() {
        super.onDismiss();
        Log.e("tag", "PagerDrawerPopup onDismiss");
    }

    class PAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 2;
        }
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            TextView textView = new TextView(container.getContext());
            textView.setText("xxxx");
            textView.setTextSize(30);
            textView.setGravity(Gravity.CENTER);
            container.addView(textView);
            return textView;
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}