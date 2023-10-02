//package com.example.splitwise.Utils;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import javax.servlet.http.HttpSession;
//
//public class HttpSessionServletContextListener implements ServletContextListener {
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        ServletContext servletContext = sce.getServletContext();
//        HttpServletRequest request = new HttpServletRequestWrapper(ser);
//        HttpSession httpSession = request.getSession();
//        servletContext.setAttribute("httpSession", httpSession);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        // TODO: Clean up any resources associated with the HttpSession object
//    }
//}
