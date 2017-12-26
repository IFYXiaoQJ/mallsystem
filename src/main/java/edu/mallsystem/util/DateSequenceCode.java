package edu.mallsystem.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取日期序号码的类
 * Created by Administrator on 2017/12/24.
 */
public class DateSequenceCode {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHssmm");

    public static String getTimeSequence(){
        return sdf.format(new Date());
    }

}
