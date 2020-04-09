package cn.ekgc.vms.util;

import java.util.Properties;

/**
 * <b>系统常量</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
public class ConstanUtil {
	private static final Properties props = new Properties();

	static {
		try {
			props.load(ConstanUtil.class.getClassLoader().getResourceAsStream("props/vms.properties"));

		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * <b>分页信息：当前页码</b>
	 */
	public static final Integer PAGE_NUM  = Integer.parseInt(props.getProperty("page.num"));

	/**
	 * <b>分页信息：每页显示数量</b>
	 */
	public static final Integer PAGE_SIZE  = Integer.parseInt(props.getProperty("page.size"));
}
