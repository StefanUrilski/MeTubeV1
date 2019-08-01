package metube.web.servlets;

import metube.domain.models.binding.TubeCreateBindingModel;
import metube.domain.models.services.TubeServiceModel;
import metube.service.TubeService;
import metube.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tubes/create")
public class TubeCreateServlet extends HttpServlet {

    private final ModelMapper modelMapper;
    private final TubeService tubeService;

    @Inject
    public TubeCreateServlet(ModelMapper modelMapper,
                             TubeService tubeService) {
        this.modelMapper = modelMapper;
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsps/create-tube.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TubeCreateBindingModel tubeCreateBindingModel = (TubeCreateBindingModel) req
                .getAttribute("tubeCreateBindingModel");

        TubeServiceModel tubeServiceModel = modelMapper.map(tubeCreateBindingModel, TubeServiceModel.class);

        try {
            tubeService.saveTube(tubeServiceModel);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            req.getRequestDispatcher("/jsps/error-page.jsp").forward(req, resp);
        }

        resp.sendRedirect("/tubes/details?name=" + tubeCreateBindingModel.getName());
    }

}
