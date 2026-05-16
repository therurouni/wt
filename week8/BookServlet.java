import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/books")
public class BookServlet
        extends HttpServlet {

    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        PrintWriter out =
                res.getWriter();

        out.println("<h1>Book Details</h1>");

        try {

            Class.forName(
                    "com.mysql.cj.jdbc.Driver"
            );

            Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/bookstore",
                            "root",
                            "password"
                    );

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM books"
                    );

            while(rs.next()) {

                out.println(
                        "Book ID : " +
                        rs.getInt("id")
                );

                out.println("<br>");

                out.println(
                        "Title : " +
                        rs.getString("title")
                );

                out.println("<br>");

                out.println(
                        "Author : " +
                        rs.getString("author")
                );

                out.println("<br>");

                out.println(
                        "Price : " +
                        rs.getInt("price")
                );

                out.println("<br><br>");
            }

            con.close();

        } catch(Exception e) {

            out.println(e);
        }
    }
}