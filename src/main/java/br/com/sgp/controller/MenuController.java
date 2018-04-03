package br.com.sgp.controller;

import br.com.sgp.model.Menu;
import br.com.sgp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping
    public ResponseEntity<?> listAllMenus() {
        try {
            List<Menu> listMenu = menuService.listAllMenus();
            return ResponseEntity.ok().body(listMenu);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity<?> listByFuncionarioId(@PathVariable("id") Integer prefId) {

        try {
            List<Menu> listMenu = menuService.listByPerfId(prefId);

            return ResponseEntity.ok().body(listMenu);
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e);
        }
    }
}
