package com.gerenciamentodeusuarioapirest.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.gerenciamentodeusuarioapirest.models.Cargo;



@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
	Cargo findById(long id);
	
	@Query("DELETE FROM Cargo c WHERE c.id = ?1")
	Cargo deleteById(long id);
}