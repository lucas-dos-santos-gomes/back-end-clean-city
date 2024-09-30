package br.com.cleancity.CleanCity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cleancity.CleanCity.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}