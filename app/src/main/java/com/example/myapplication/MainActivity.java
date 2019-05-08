package com.example.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    /**
     * 商品秒杀
     */
    private TextView tv_limit_hotel_one,tv_limit_hotel_two,tv_limit_hotel_three,tv_limit_hotel_four;
    /**
     * 订单支付
     */
    private TextView tv_order_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        // 获取一天后的当前时间
        String limitTime=DateUtil.offDate(DateUtil.getNowDates(),"yyyy-MM-dd HH:mm:ss");
        timeDown(limitTime);
        timeDowns(limitTime);
    }

    private void initView() {
        tv_limit_hotel_one= (TextView) findViewById(R.id.tv_limit_hotel_one);
        tv_limit_hotel_two= (TextView) findViewById(R.id.tv_limit_hotel_two);
        tv_limit_hotel_three= (TextView) findViewById(R.id.tv_limit_hotel_three);
        tv_limit_hotel_four= (TextView) findViewById(R.id.tv_limit_hotel_four);

        tv_order_time= (TextView) findViewById(R.id.tv_order_time);
    }


    /***************************** 商品秒杀倒计时 **************************************************/

    private MyCount count_down;
    private boolean isTiming=false;
    public long[] formatDuring(long mss) {
        long[] strTime=new long[4];
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        strTime[0] = days;
        strTime[1] = hours;
        strTime[2] = minutes;
        strTime[3] = seconds;
        return strTime;
    }
    private void timeDown(String createDate) {
        // 限时折扣，定时器
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long second=null;
        Long second2= null;
        try {
            second = format.parse(createDate).getTime();
            second2 = format.parse(DateUtil.getNowDates()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (second == null || second2==null)
            return;
        count_down = new MyCount((second-second2), 1000);
        count_down.start();
        isTiming=true;
    }

    // 倒计时类
    private class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long[] strTime=formatDuring(millisUntilFinished);
            if (strTime[0]/10 == 0){
                tv_limit_hotel_one.setText("0"+strTime[0]);
            }else {
                tv_limit_hotel_one.setText(strTime[0]+"");
            }
            if (strTime[1]/10 == 0){
                tv_limit_hotel_two.setText("0"+strTime[1]);
            }else {
                tv_limit_hotel_two.setText(strTime[1]+"");
            }
            if (strTime[2]/10 == 0){
                tv_limit_hotel_three.setText("0"+strTime[2]);
            }else {
                tv_limit_hotel_three.setText(strTime[2]+"");
            }
            if (strTime[3]/10 == 0){
                tv_limit_hotel_four.setText("0"+strTime[3]);
            }else {
                tv_limit_hotel_four.setText(strTime[3]+"");
            }
        }

        @Override
        public void onFinish() {
            tv_limit_hotel_one.setText("00");
            tv_limit_hotel_two.setText("00");
            tv_limit_hotel_three.setText("00");
            tv_limit_hotel_four.setText("00");
       }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isTiming)
            count_down.cancel();
    }
    /***************************** 商品秒杀倒计时 **************************************************/

    /***************************** 订单支付倒计时 15分钟 **************************************************/

    private long showCountDownStart;
    private MyCounts counts;
    //倒计时
    private void timeDowns(String createDate) {
        String orderTime = DateUtil.dataOne(createDate);
        String currentTime = String.valueOf(System.currentTimeMillis()).substring(0, 10);
        long expiredTime = Long.parseLong(currentTime) - Long.parseLong(orderTime);
        if (expiredTime < 0){
            //系统时间错误的情况
            showCountDownStart = 900000;
        }else {
            if (900000 - expiredTime*1000 > 0) {
                showCountDownStart = 900000 - expiredTime*1000;
            } else {
                showCountDownStart = 0;
                tv_order_time.setText("00:00");
            }
        }
        counts = new MyCounts(showCountDownStart, 1000);
        counts.start();
    }

    //倒计时类
    private class MyCounts extends CountDownTimer {

        public MyCounts(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public void onTick(long millisUntilFinished) {
            SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");// 初始化Formatter的转换格式。
                if (tv_order_time != null){
                    tv_order_time.setText(formatter.format(millisUntilFinished));
                }
        }

        public void onFinish() {
                if (tv_order_time != null){
                    tv_order_time.setText("00:00");
                }
        }
    }
    /***************************** 订单支付倒计时 **************************************************/

    /**
     * 2秒之内，两次回退键，退出activity
     */
    private long startTime = 0;
    @Override
    public void onBackPressed() {
        //删除super，否则执行系统默认的finish（）方法
        if (System.currentTimeMillis() - startTime < 2000) {
            finish();
        } else {
            Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
            startTime = System.currentTimeMillis();
        }

    }
}
