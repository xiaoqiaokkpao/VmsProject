package cn.ekgc.vms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>车辆管理系统启动类</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */

@MapperScan("cn.ekgc.vms.dao")
@SpringBootApplication
public class VmsStarter {
	public static void main(String[] args) {
		SpringApplication.run(VmsStarter.class, args);
	}
}
