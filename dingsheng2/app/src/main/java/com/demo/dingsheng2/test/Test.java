package com.demo.dingsheng2.test;

import com.demo.dingsheng2.util.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by tea9 at 2019/1/14
 *
 * 比较时间
 * https://blog.csdn.net/u013991521/article/details/60471545
 */
public class Test {

    public static void main(String args[]) {
       Test test = new Test();
       test.check_date();
    }

    private void check_date() {
        String format = "dd HH:mm:ss";
        String format1 = "HH:mm:ss";
        Date nowTime = null;
        try {
            nowTime = new SimpleDateFormat(format).parse("11 09:27:00");

            Date startTime = new SimpleDateFormat(format).parse("11 09:27:00");
            Date endTime = new SimpleDateFormat(format).parse("11 09:30:59");

            Date startTime1 = new SimpleDateFormat(format1).parse("00:00:00");
            Date endTime1 = new SimpleDateFormat(format1).parse("07:00:00");
            if (startTime.before(endTime)) {
                System.out.println("sssstrue");
            } else {
                System.out.println("sssfalse");
            }

            System.out.println("aaaa"+TimeUtil.isEffectiveDate(nowTime, startTime, endTime)); // 区间
            System.out.println("aaaa1"+new Date()); // 区间
            System.out.println("aaaa1"+TimeUtil.isEffectiveDate(new Date(), startTime1, endTime1)); // 区间
            System.out.println(TimeUtil.getDatePoor(endTime, startTime)); // 时间差

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void xx() throws ParseException {
//        getdata
//        30d getdata+30
//        String format = "HH:mm:ss";
//        Date startTime = new SimpleDateFormat(format).parse("09:27:00");

        Date date = new Date();
//        System.out.println(TimeUtil.getDatePoor(endTime, startTime)); // 时间差

        while (true){
            //getdata ==> 30d break
        }
    }

}
