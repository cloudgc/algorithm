package org.cloudfun.design.pattern.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/26
 * <p>
 * 拦截过滤器模式 用于对应用程序的请求或响应做一些预处理/后处理。 定义过滤器，并在把请求传给实际目标应用程序之前应用在请求上
 * </p>
 */
public class InterceptingFilterPattern {
    
    interface Filter {
        
        public void execute(String request);
    }
    
    static class DebugFilter implements Filter {
        
        @Override
        public void execute(String request) {
            System.out.println("request log: " + request);
        }
    }
    
    static class AuthenticationFilter implements Filter {
        
        @Override
        public void execute(String request) {
            System.out.println("Authenticating request: " + request);
        }
    }
    
    static class Target {
        
        public void execute(String request) {
            System.out.println("Executing request: " + request);
        }
    }
    
    static class FilterChain {
        
        private List<Filter> filters = new ArrayList<Filter>();
        
        private Target target;
        
        public void addFilter(Filter filter) {
            filters.add(filter);
        }
        
        public void execute(String request) {
            for (Filter filter : filters) {
                filter.execute(request);
            }
            target.execute(request);
        }
        
        public void setTarget(Target target) {
            this.target = target;
        }
    }
    
    static class FilterManager {
        
        FilterChain filterChain;
        
        public FilterManager(Target target) {
            filterChain = new FilterChain();
            filterChain.setTarget(target);
        }
        
        public void setFilter(Filter filter) {
            filterChain.addFilter(filter);
        }
        
        public void filterRequest(String request) {
            filterChain.execute(request);
        }
    }
    
    
    static class Client {
        
        FilterManager filterManager;
        
        public void setFilterManager(FilterManager filterManager) {
            this.filterManager = filterManager;
        }
        
        public void sendRequest(String request) {
            filterManager.filterRequest(request);
        }
    }
    
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        
        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }
    
}
