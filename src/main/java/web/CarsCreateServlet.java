package web;

import data.entity.User;
import services.base.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cars/create")
public class CarsCreateServlet extends HttpServlet {

    private final CarServiceImpl carService = new CarServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cars-create.jsp")
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession()
                .getAttribute("user");

        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String year = req.getParameter("year");
        String engine = req.getParameter("engine");
        int userId = user.getId();



        this.carService.create(brand,model,year,engine,userId);
        resp.sendRedirect("/home");
    }
}
