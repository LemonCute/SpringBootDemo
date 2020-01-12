package com.lcke.demo.utils.MVC3Com;

/**
 * ClassName: ssadsadsa <br/>
 * Description: <br/>
 * date: 2020/1/9 22:07<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * @WebServlet(urlPatterns = "/myservlet") // 定义访问路径
 * @Author niujinpeng
 * @Date 2019/1/24 16:25
 */
@Slf4j
@WebServlet(urlPatterns = "/myservlet")
public class MyServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        log.info("Servlet 开始初始化");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Servlet 开始处理 GET 方法");
        PrintWriter writer = resp.getWriter();
        writer.println("Hello Servlet");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        log.info("Servlet 开始销毁");
        super.destroy();
    }
}