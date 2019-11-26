package org.cloudfun.design.pattern.behavior;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/26
 * <p>
 * 前端控制器模式
 * 是用来提供一个集中的请求处理机制，所有的请求都将由一个单一的处理程序处理。
 * 该处理程序可以做认证/授权/记录日志，或者跟踪请求，然后把请求传给相应的处理程序
 * </p>
 */
public class FrontControllerPattern {


    static class HomeView {
        public void show() {
            System.out.println("Displaying Home Page");
        }
    }

    static class StudentView {
        public void show() {
            System.out.println("Displaying Student Page");
        }
    }

    static class Dispatcher {
        private StudentView studentView;
        private HomeView homeView;

        public Dispatcher() {
            studentView = new StudentView();
            homeView = new HomeView();
        }

        public void dispatch(String request) {
            if (request.equalsIgnoreCase("STUDENT")) {
                studentView.show();
            } else {
                homeView.show();
            }
        }
    }

    static class FrontController {

        private Dispatcher dispatcher;

        public FrontController() {
            dispatcher = new Dispatcher();
        }

        private boolean isAuthenticUser() {
            System.out.println("User is authenticated successfully.");
            return true;
        }

        private void trackRequest(String request) {
            System.out.println("Page requested: " + request);
        }

        public void dispatchRequest(String request) {
            //记录每一个请求
            trackRequest(request);
            //对用户进行身份验证
            if (isAuthenticUser()) {
                dispatcher.dispatch(request);
            }
        }
    }

    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }


}
