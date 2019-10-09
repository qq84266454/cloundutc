package com.cloud.utc.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cloud.utc.R;
import com.github.mikephil.charting.charts.LineChart;

import butterknife.BindView;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {


    @BindView(R.id.line_chart)
    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        butterknife.ButterKnife.bind(this);
        //LineDataSet可以看做是一条线
//        initData();
//        setData();
//        initData2();

    }

    @OnClick(R.id.line_chart)
    public void onViewClicked() {
    }
//
//    private void initData2() {
//        //1.创建描述信息
//        Description description = new Description();
//        description.setText("测试图表");
//        description.setTextColor(Color.RED);
//        description.setTextSize(20);
//        lineChart.setTouchEnabled(true);
//        lineChart.setDoubleTapToZoomEnabled(false);
//        lineChart.setDragEnabled(true);
//        lineChart.setDescription(description);//设置图表描述信息
//        lineChart.setNoDataText("没有数据熬");//没有数据时显示的文字
//        lineChart.setNoDataTextColor(Color.BLUE);//没有数据时显示文字的颜色
//        lineChart.setDrawGridBackground(true);//chart 绘图区后面的背景矩形将绘制
//        lineChart.setDrawBorders(true);//禁止绘制图表边框的线
//        //lineChart.setBorderColor(); //设置 chart 边框线的颜色。
//        //lineChart.setBorderWidth(); //设置 chart 边界线的宽度，单位 dp。
//        //lineChart.setLogEnabled(true);//打印日志
//        //lineChart.notifyDataSetChanged();//刷新数据
//        //lineChart.invalidate();//重绘
////        Matrix m=new Matrix();
////        m.postScale(1.5f,1f);//两个参数分别是x,y轴的缩放比例。例如：将x轴的数据放大为之前的1.5倍
////        lineChart.getViewPortHandler().refresh(m,lineChart,false);//将图表动画显示之前进行缩放
//
//        lineChart.animateX(1000);// 立即执行的动画,x轴
//
//
//        // 2.绑定数据
//        /**
//         * Entry 坐标点对象  构造函数 第一个参数为x点坐标 第二个为y点
//         */
//        ArrayList<Entry> values1 = new ArrayList<>();
//        ArrayList<Entry> values2 = new ArrayList<>();
//
//        values1.add(new Entry(0f, 10));
//        values1.add(new Entry(1f, 15));
//        values1.add(new Entry(2f, 20));
//        values1.add(new Entry(3f, 5));
//        values1.add(new Entry(4f, 10));
//        values1.add(new Entry(5f, 15));
//        values1.add(new Entry(6f, 20));
//        values1.add(new Entry(7f, 5));
//        values1.add(new Entry(8f, 10));
//        values1.add(new Entry(9f, 15));
//        values1.add(new Entry(10f, 20));
//        values1.add(new Entry(11f, 5));
//
//        values2.add(new Entry(0, 110));
//        values2.add(new Entry(1, 115));
//        values2.add(new Entry(2, 130));
//        values2.add(new Entry(3, 85));
//        values2.add(new Entry(4, 110));
//        values2.add(new Entry(5, 115));
//        values2.add(new Entry(6, 130));
//        values2.add(new Entry(7, 85));
//        values2.add(new Entry(8, 110));
//        values2.add(new Entry(9, 115));
//        values2.add(new Entry(10, 130));
//        values2.add(new Entry(11, 85));
//
//        //LineDataSet每一个对象就是一条连接线
//        LineDataSet set1;
//        LineDataSet set2;
//
//
//        XAxis xAxis = lineChart.getXAxis();
//        xAxis.setEnabled(true);
//        xAxis.setDrawLabels(true);// 不显示该轴的标签
//        xAxis.setDrawGridLines(true);//设置为true，则绘制网格线。
//        xAxis.setDrawAxisLine(false); // 设置为true，则绘制该行旁边的轴线（axis-line）。
//
//        xAxis.setGridLineWidth(10f);
//
//        // 设置轴线的一些属性
//        xAxis.setTextColor(Color.BLUE);
//        xAxis.setTextSize(24f);
//        xAxis.setGridLineWidth(10f);
//        xAxis.setGridColor(Color.RED);
//        xAxis.setAxisLineColor(Color.GREEN);
//        xAxis.setAxisLineWidth(5f);
//        xAxis.enableGridDashedLine(5f, 2f, 0);
//        xAxis.setLabelCount(12);
//
//        LimitLine xLimitLine = new LimitLine(4f, "xL 测试");
//        xLimitLine.setLineColor(Color.GREEN);
//        xLimitLine.setTextColor(Color.GREEN);
//        xAxis.addLimitLine(xLimitLine);
//
//        LimitLine yLimitLine = new LimitLine(50f, "yLimit 测试");
//        yLimitLine.setLineColor(Color.RED);
//        yLimitLine.setTextColor(Color.RED);
//        // 获得左侧侧坐标轴
//        YAxis axisRight = lineChart.getAxisRight();
//        LimitLine yLimitLine2 = new LimitLine(70f, "yLimit 测试");
//        yLimitLine.setLineColor(Color.RED);
//        yLimitLine.setTextColor(Color.RED);
//
//        YAxis leftAxis = lineChart.getAxisLeft();
//        leftAxis.addLimitLine(yLimitLine);
//        axisRight.addLimitLine(yLimitLine2);
//
//
//        //判断图表中原来是否有数据
//        if (lineChart.getData() != null &&
//                lineChart.getData().getDataSetCount() > 0) {
//            //获取数据1
//            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
//            set1.setValues(values1);
//            set2 = (LineDataSet) lineChart.getData().getDataSetByIndex(1);
//            set2.setValues(values2);
//            //刷新数据
//            lineChart.getData().notifyDataChanged();
//            lineChart.notifyDataSetChanged();
//        } else {
//            //设置数据1  参数1：数据源 参数2：图例名称
//            set1 = new LineDataSet(values1, "测试数据1");
//            set1.setColor(R.color.zhe1);
//            set1.setCircleColor(R.color.zhe1);
//            set1.setLineWidth(2f);//设置线宽
//            set1.setCircleRadius(5f);//设置焦点圆心的大小
//            set1.enableDashedHighlightLine(10f, 5f, 0f);//点击后的高亮线的显示样式
//            set1.setHighlightLineWidth(2f);//设置点击交点后显示高亮线宽
//            set1.setHighlightEnabled(true);//是否禁用点击高亮线
//            set1.setHighLightColor(Color.RED);//设置点击交点后显示交高亮线的颜色
//            set1.setValueTextSize(9f);//设置显示值的文字大小
//            set1.setDrawFilled(false);//设置禁用范围背景填充
//
//            //格式化显示数据
//            final DecimalFormat mFormat = new DecimalFormat("###,###,##0");
//            set1.setValueFormatter(new ValueFormatter() {
//                @Override
//                public String getFormattedValue(float value) {
//                    return mFormat.format(value);
//                }
//            });
//            if (Utils.getSDKInt() >= 18) {
//                // fill drawable only supported on api level 18 and above
//                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.icon_b);
//                set1.setFillDrawable(drawable);//设置范围背景填充
//            } else {
//                set1.setFillColor(Color.BLACK);
//            }
//
//            //设置数据2
//            set2 = new LineDataSet(values2, "测试数据2");
//            set2.setColor(R.color.zhe1);
//            set2.setCircleColor(R.color.zhe1);
//            set2.setLineWidth(1f);
//            set2.setCircleRadius(3f);
//            set2.setValueTextSize(10f);
//
//            //保存LineDataSet集合
//            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
//            dataSets.add(set1); // add the datasets
//            set1.setColor(Color.GREEN);
//            set2.setColor(Color.RED);
//            dataSets.add(set2);
//            //创建LineData对象 属于LineChart折线图的数据集合
//            LineData data = new LineData(dataSets);
//            // 添加到图表中
//            lineChart.setData(data);
//            lineChart.setVisibleXRangeMaximum(6);
//            final String[] quarters = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
//            ValueFormatter formatter = new ValueFormatter() {
//                @Override
//                public String getAxisLabel(float value, AxisBase axis) {
//                    return quarters[(int) value];
//                }
//            };
//            xAxis = lineChart.getXAxis();
//            xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
//            xAxis.setValueFormatter(formatter);
//            //绘制图表
//            lineChart.invalidate();
//
//
//        }
//    }
}
