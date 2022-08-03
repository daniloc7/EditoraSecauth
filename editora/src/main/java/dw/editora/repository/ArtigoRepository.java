package dw.editora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dw.editora.model.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
    
    List<Artigo> findByPublicado(boolean publicado);
    
    
//    List<Artigo> findByTituloContaining(String titulo);
    
    @Query(value = "select * from Artigo where titulo = :titulo",nativeQuery = true)
    List<Artigo> findByTituloContaining(String titulo);
}
