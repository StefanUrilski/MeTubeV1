package metube.web.servlets;

import metube.domain.models.services.TubeServiceModel;
import metube.domain.models.view.TubeDetailsViewModel;
import metube.service.TubeService;
import metube.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/tubes/details")
public class TubeDetailsServlet extends HttpServlet {

    private final ModelMapper modelMapper;
    private final TubeService tubeService;

    @Inject
    public TubeDetailsServlet(ModelMapper modelMapper,
                              TubeService tubeService) {
        this.modelMapper = modelMapper;
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = URLDecoder.decode(req.getQueryString().split("=")[1], StandardCharsets.UTF_8.name());

        req.setAttribute("tubeDetailsViewModel",
                modelMapper.map(
                        this.tubeService.findTubeByName(name),
                        TubeDetailsViewModel.class
                )
        );
        req.getRequestDispatcher("/jsps/details-tube.jsp")
                .forward(req, resp);
    }
}

