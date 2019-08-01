<%@ page import="metube.domain.models.view.TubeDetailsViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<% TubeDetailsViewModel viewModel = (TubeDetailsViewModel) request.getAttribute("tubeDetailsViewModel"); %>
<div class="container">
    <main>
        <div class="jumbotron">
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h1>
                        <%= viewModel.getName() %>
                    </h1>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h3>
                        <%= viewModel.getDescription() %>
                    </h3>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col col-md-6 d-flex justify-content-center">
                    <p>
                        <%= viewModel.getUploader() %>
                    </p>
                </div>
                <div class="col col-md-6 d-flex justify-content-center">
                    <a href="<%= viewModel.getYouTubeLink() %>" >
                        Link to Video.
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <a href="/">Back to home.</a>
                </div>
            </div>
        </div>
    </main>
</div>
<footer>
    <c:import url="templates/footer.jsp" />
</footer>
</body>
</html>
