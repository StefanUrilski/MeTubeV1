package metube.service;

import metube.domain.models.services.TubeServiceModel;

import java.util.List;

public interface TubeService {

    void saveTube(TubeServiceModel tubeServiceModel);

    TubeServiceModel findTubeByName(String name);

    List<TubeServiceModel> findAllTubes();
}
