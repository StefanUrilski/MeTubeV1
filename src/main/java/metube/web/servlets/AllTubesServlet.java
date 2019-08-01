package metube.web.servlets;

import metube.domain.models.view.AllTubesViewModel;
import metube.service.TubeService;
import metube.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/tubes/all")
public class AllTubesServlet extends HttpServlet {

    private final ModelMapper modelMapper;
    private final TubeService tubeService;

    @Inject
    public AllTubesServlet(ModelMapper modelMapper,
                           TubeService tubeService) {
        this.modelMapper = modelMapper;
        this.tubeService = tubeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(
            "allTubes",
            tubeService.findAllTubes()
                    .stream()
                    .map(tube -> modelMapper.map(tube, AllTubesViewModel.class))
                    .collect(Collectors.toList())
        );
        req.getRequestDispatcher("/jsps/all-tubes.jsp").forward(req, resp);
    }
}
