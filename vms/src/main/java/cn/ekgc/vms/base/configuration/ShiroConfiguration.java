package cn.ekgc.vms.base.configuration;

import cn.ekgc.vms.util.security.ShiroDBRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <b>Shiro配置类</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Configuration
public class ShiroConfiguration {
	// 配置需要登录的时候，所采取的登录认证业务流程
	@Bean
	public ShiroDBRealm shiroDBRealm(){
		return new ShiroDBRealm();
	}

	@Bean
	public SecurityManager securityManager(){
		// 创建Shiro的核心对象 SecurityManager
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 当需要登录认证的时候，使用自定义的ShiroDBRealm进行
		securityManager.setRealm(shiroDBRealm());
		return securityManager;
	}

	// 配置认证规则
	@Bean
	public ShiroFilterFactoryBean shiroFilter (SecurityManager securityManager){
		// 创建过滤器对象
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		// 配置Shiro的核心对象 SecurityManager
		shiroFilter.setSecurityManager(securityManager);
		// 当发现请求是登录时，需要跳转到登录界面，配置登录的重定向地址
		shiroFilter.setLoginUrl("/user/login");
		// 登录成功之后，如果之前没有确定的请求地址，那么设定默认的登录跳转地址
		shiroFilter.setSuccessUrl("/");
		// 配置那些请求需要登录，那些请求是不需要登录的
		// 配置使用Map集合来完成，不过Shiro在配置的时候，从上到下依次配置
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不需要登录时的请求
		// 静态资源
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/fonts/**", "anon");
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		// 配置退出规则
		filterChainDefinitionMap.put("/user/logout", "logout");
		// 配置需要进行登录的规则
		filterChainDefinitionMap.put("/**", "authc");

		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilter;

	}


}
