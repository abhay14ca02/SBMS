package com.rajabhay.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rajabhay.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	// select * from user_info where country=?
	List<User> findByCountry(String country);

	// select * from user_info where country=? and gender=?
	List<User> findByCountryAndGender(String country, String gender);

	@Query("From User")
	List<User> getAllUsersHQL();

	@Query(value = "select * from user_info", nativeQuery = true)
	List<User> getAllUsersSQL();

	@Modifying
	@Transactional
	@Query("Update User u set u.city =:city where u.id = :id")
	void updateCityById(String city, Integer id);

	@Modifying
	@Transactional
	@Query("Delete FROM User u where u.id = :id")
	void deleteUserById(Integer id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO USER_INFO (user_id, user_name, gender, city, country) VALUES (:id, :name, :gender, :city, :country)", nativeQuery = true)
	void saveUserBySQL(Integer id, String name, String gender, String city, String country);

}
