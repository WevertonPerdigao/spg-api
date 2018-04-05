package br.com.sgp.repository;

        import br.com.sgp.model.Menu;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;

        import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT mp.menu FROM MenuPerfil as mp  where mp.menuPerfilPk.mepePerfId = :perfId")
    List<Menu> listByPerfId(@Param("perfId") Integer id);

}
