package com.userDemo.common.database;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class DataSourceAspect {
    public void pointCut() {
    }

    ;

    public void before(JoinPoint point) {
        Object target = point.getTarget();// 拦截的实体类
        String method = point.getSignature().getName();// 拦截的方法名称
        Class[] classz = target.getClass().getInterfaces();
        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();// 拦截的方法参数类型
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                HandleDataSource.putDataSource(data.value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void after(JoinPoint point) {
        Object target = point.getTarget();// 拦截的实体类
        String method = point.getSignature().getName();// 拦截的方法名称
        Class[] classz = target.getClass().getInterfaces();
        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();// 拦截的方法参数类型
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                HandleDataSource.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
