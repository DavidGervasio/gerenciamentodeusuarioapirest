package com.gerenciamentodeusuarioapirest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gerenciamentodeusuarioapirest.models.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, String> {

}