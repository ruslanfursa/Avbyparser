package io.smth.repo;

import io.smth.models.Auto;
import java.util.List;

public interface Repository {

     List<String> getAutoBrandList();
     List<Auto> getAutoList(String brand);

}
