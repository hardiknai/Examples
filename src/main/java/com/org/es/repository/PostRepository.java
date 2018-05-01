/**
 * 
 */
package com.org.es.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.org.es.model.Post;

/**
 * @author hardikn
 *
 */
@Repository
public interface PostRepository extends ElasticsearchRepository<Post, String> {

	Page<Post> findByTagsName(String tagName, Pageable pageable);

//	@Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
//	Page<Post> findByTagsNameUsingCustomQuery(String tag, Pageable pageable);

}
