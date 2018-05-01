/**
 * 
 */
package com.org.es.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.org.es.model.Post;
import com.org.es.model.Users;

/**
 * @author hardikn
 *
 */
@Repository("userRepositoryES")
public interface UserRepository extends ElasticsearchRepository<Users, String> {

	List<Users> findByName(String text);

	List<Users> findBySalary(Long salary);


}
