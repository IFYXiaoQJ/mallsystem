package edu.mallsystem.util;

import org.apache.struts2.util.StrutsTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * 时间转换类
 * @author Administrator
 *
 */
public class DateConversion extends StrutsTypeConverter{

	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if(arg1!=null&&arg1.length>0){
			if(arg1[0]!=null&&arg1[0].length()>0){
				try {
					return sdf.parse(arg1[0]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		return sdf.format(arg1);
	}

}
