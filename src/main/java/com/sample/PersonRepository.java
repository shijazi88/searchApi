package com.sample;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person>
//public interface PersonRepository extends PagingAndSortingRepository<Person, Integer>
{

    List<Person> findAll();


    Page<Person> findAll(Pageable page);


    Person findOneById(Integer id);

}
