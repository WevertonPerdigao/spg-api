package br.com.sgp.service;

import br.com.sgp.model.Menu;
import br.com.sgp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public List<Menu> listAllMenus() {
        return menuRepository.findAll();
    }

    public List<Menu> listByPerfId(Integer perfId) {
        return menuRepository.listByPerfId(perfId);
    }


}
