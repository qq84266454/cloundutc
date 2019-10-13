package com.cloud.utc.ui;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.LogUtils;
import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.cloud.utc.popup.HashDetailPopup;
import com.cloud.utc.test.LineChartEntity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HashRateActivity extends BaseActivity {

    @BindView(R.id.m_iv_back)
    ImageView mIvBack;
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.m_iv_save)
    ImageView mIvSave;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.rl_title_bar)
    RelativeLayout rlTitleBar;
    @BindView(R.id.mTvLabel1)
    TextView mTvLabel1;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.mTvLabel2)
    TextView mTvLabel2;
    @BindView(R.id.mTvTG)
    TextView mTvTG;
    @BindView(R.id.mTvEarning)
    TextView mTvEarning;
    @BindView(R.id.mTvLabel3)
    TextView mTvLabel3;
    @BindView(R.id.line_chart)
    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_hashrate);
        ButterKnife.bind(this);
        initView();
        lineChart();
    }


    private void lineChart() {
        List<Entry>[] entries = new ArrayList[2];
        for (int index = 0, len = entries.length; index < len; index++) {
            ArrayList<Entry> values = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                float val = (float) (Math.random() * 34) + 3;
                values.add(new Entry(i, val));
            }
            entries[index] = values;
        }
        String[] labels = {"label1", "label2"};
        int[] chartColors = {Color.parseColor("#FF3E4ABE"), Color.parseColor("#FFED773C")};


        LineChartEntity lineChartEntity = new LineChartEntity(lineChart, entries, labels, chartColors, Color.parseColor("#FF9EA9C3"), 14f);
        lineChartEntity.drawCircle(true);
        lineChartEntity.toggleFilled(null, chartColors, false);
        lineChartEntity.setLineMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        lineChartEntity.setEnableDashedLine(true);
        final String[] quarters = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return quarters[(int) value];
            }


        };
        lineChartEntity.setXAxisFormatter(formatter);
    }

    private void initView() {
        mTvTitle.setText("Hashrate");
        View barView = findViewById(R.id.m_bar_view);
        if (findViewById(R.id.m_bar_view) != null) {
            ViewGroup.LayoutParams layoutParams = barView.getLayoutParams();
            layoutParams.height = BarUtils.getStatusBarHeight();
            barView.setLayoutParams(layoutParams);
        }
        setAnimation(progressBar,40);

    }
    private void setAnimation(final ProgressBar view, final int mProgressBar) {
        ValueAnimator animator = ValueAnimator.ofInt(0, mProgressBar).setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LogUtils.e((int)valueAnimator.getAnimatedValue());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.setProgress((Integer) valueAnimator.getAnimatedValue(),true);
                }else {
                    view.setProgress((Integer) valueAnimator.getAnimatedValue());
                }
            }
        });
        animator.start();
    }
    @OnClick({R.id.m_iv_back, R.id.m_tv_title, R.id.mTvDetail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.m_tv_title:
                break;
            case R.id.mTvDetail:
                showDetailPopup();
                break;
        }
    }

    private void showDetailPopup() {
        HashDetailPopup popup = new HashDetailPopup(this);
        popup.setPopupGravity(Gravity.BOTTOM).setBackground(null);
        popup.showPopupWindow();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out_bottom);
    }
}
