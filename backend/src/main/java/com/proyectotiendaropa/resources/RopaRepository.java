package com.proyectotiendaropa.resources;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyectotiendaropa.model.Ropa;

public interface RopaRepository extends JpaRepository<Ropa, Long> {

	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion%")
	  List <Ropa> findByDescripcion(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.idRopa LIKE :id")
	  List <Ropa> findById(@Param("id") int id);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND genero LIKE 'H'")
	  List <Ropa> findByDescripcion10(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND genero LIKE 'M'")
	  List <Ropa> findByDescripcion20(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND precio < 15")
	  List <Ropa> findByDescripcion01(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND precio > 15 AND precio < 25")
	  List <Ropa> findByDescripcion02(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND precio > 25")
	  List <Ropa> findByDescripcion03(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND genero LIKE 'H' AND precio < 15")
	  List <Ropa> findByDescripcion11(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND genero LIKE 'H' AND precio > 15 AND precio < 25")
	  List <Ropa> findByDescripcion12(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND genero LIKE 'H' AND precio > 25")
	  List <Ropa> findByDescripcion13(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND genero LIKE 'M' AND precio < 15")
	  List <Ropa> findByDescripcion21(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND genero LIKE 'M' AND precio > 15 AND precio < 25")
	  List <Ropa> findByDescripcion22(@Param("descripcion") String descripcion);
	
	@Query("select x FROM Ropa x where x.descripcion LIKE %:descripcion% AND genero LIKE 'M' AND precio > 25")
	  List <Ropa> findByDescripcion23(@Param("descripcion") String descripcion);
}