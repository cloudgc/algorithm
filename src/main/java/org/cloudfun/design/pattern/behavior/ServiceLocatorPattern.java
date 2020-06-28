package org.cloudfun.design.pattern.behavior;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/26
 * <blockquote><pre>
 *     服务定位模式  查找jndi 如果找到就放入缓存 如果没找到就遍历寻找
 * </pre></blockquote>
 */
public class ServiceLocatorPattern {
    
    interface Service {
        
        //服务名称
        String getName();
        
        //服务能够被调用
        void execute();
    }
    
    static class JNDIService implements Service {
        
        @Override
        public String getName() {
            return "jndi";
        }
        
        @Override
        public void execute() {
            System.out.println("访问当前的JNDIg服务！");
            
        }
        
    }
    
    class DataSourceService implements Service {
        
        @Override
        public String getName() {
            return "dataSource";
        }
        
        @Override
        public void execute() {
            System.out.println("获取数据链接资源！");
            
        }
        
    }
    
    static class InitContext {
        
        public Service lookUp(String name) {
            Service service = null;
            switch (name) {
                case "jndi":
                    service = new JNDIService();
                    break;
                default:
                    throw new IllegalArgumentException("没有 " + name + " 的服务！");
            }
            return service;
        }
    }
    
    static class Cache {
        
        private Map<String, Service> cache = new HashMap<String, Service>();
        
        //获得缓存中的内容
        public Service getCache(String name) {
            Service service = cache.get(name);
            return service;
        }
        
        //添加缓存
        public void addCache(String name, Service service) {
            cache.put(name, service);
        }
        
    }
    
    static class ServiceLocator {
        
        private Cache cache;
        
        private InitContext initContext;
        
        public ServiceLocator() {
            initContext = new InitContext();
            cache = new Cache();
        }
        
        //获得服务
        public Service getService(String name) {
            Service service = cache.getCache(name);
            if (service == null) {
                System.out.println("通过初始化资源获取当前的jndi资源!");
                service = initContext.lookUp(name);
                cache.addCache(name, service);
                System.out.println("将获取的资源加入缓存中！");
            }
            System.out.println("已经获取到了jndi资源！");
            return service;
        }
        
        
    }
    
    public static void main(String[] args) {
        ServiceLocator locator = new ServiceLocator();
        Service service = locator.getService("jndi");
        service.execute();
        service = locator.getService("jndi");
        service.execute();
    }
    
    
}
