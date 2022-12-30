package cn.cod.server.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String getTime(){
        // 获取当前时间戳
        long timestamp = System.currentTimeMillis();

        // 创建 SimpleDateFormat 对象，指定日期格式为 yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 将时间戳转换为日期字符串
        String dateString = sdf.format(new Date(timestamp));

        return dateString;
    }

}
