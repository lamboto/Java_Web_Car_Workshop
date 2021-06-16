package web;

import data.view.CarViewModel;
import org.modelmapper.ModelMapper;
import services.base.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/cars/all")
public class CarsAllServlet extends HttpServlet {

    private final CarServiceImpl carService = new CarServiceImpl();
    private final ModelMapper mapper = new ModelMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CarViewModel> cars = carService.getAll()
                .stream()
                .map(car -> this.mapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());


        // ViewModel<List<CarViewModel>> viewModel = new ViewModel<>(cars);

        req.setAttribute("viewModel", cars);

        req.getRequestDispatcher("/cars-all.jsp")
                .forward(req, resp);
    }
}
