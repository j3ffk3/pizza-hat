package com.example.product.infra.util;

import org.mapstruct.TargetType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationContextUtils implements ApplicationContextAware {

	private static ApplicationContext appctx;

	@Override
	public synchronized void setApplicationContext(ApplicationContext applicationContext) {
		ApplicationContextUtils.appctx = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static synchronized ApplicationContext getApplicationContext() {
		return appctx;
	}

	/**
	 * 獲取類型為requiredType的對象
	 *
	 * @param clazz 需要獲取的bean的類型
	 * @return 該類型的一個在ioc容器中的bean
	 */
	public static <T> T getEntity(Class<T> clazz) {
		return appctx.getBean(clazz);
	}

	/**
	 * 如果ioc容器中包含一個與所給名稱匹配的bean定義，則返回true否則返回false
	 *
	 * @param name ioc容器中註冊的bean名稱
	 * @return 存在返回true否則返回false
	 */
	public static boolean containsEntity(String name) {
		return appctx.containsBean(name);
	}

	/**
	 * 獲取類型為requiredType的對象
	 *
	 * @param clazz 需要獲取的bean的類型
	 * @return 該類型的一個在ioc容器中的bean
	 */
	public <T> T createEntity(@TargetType Class<T> clazz) {
		return appctx.getBean(clazz);
	}

}