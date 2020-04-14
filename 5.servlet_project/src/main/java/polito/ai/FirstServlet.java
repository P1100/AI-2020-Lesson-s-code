package polito.ai;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/index.html")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){ //}throws ServletException, IOException {
        try {
            //super.doGet(req, res);
            PrintWriter pw = res.getWriter();
            pw.println("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"></head><body><h1>Hello Servlet!</h1>");
            pw.println("<ul>");
            Enumeration<String> names = req.getHeaderNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                pw.println("<li>");
                pw.println(name);
                pw.print(": ");
                pw.print(req.getHeader(name));
                pw.println("</li>");
            }
            pw.println("</ul>");
            pw.println("<p>"+req.getSession().getId()+"</p>");
            pw.println("</body></html>");
//            res.getWriter().println("<html><head></head><body><h1>Hello Servlet!</h1>/</body></html>");
            res.setContentType("text/html");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
