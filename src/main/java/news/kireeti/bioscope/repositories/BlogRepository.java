
package news.kireeti.bioscope.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import news.kireeti.bioscope.models.BlogPost;

import java.util.List;

/**
 * @author Kireeti Eluri 
 */

public interface BlogRepository extends MongoRepository<BlogPost, String>, BlogOperations {
    List<BlogPost> findByStatusOrderByPostDateAsc(String status);
    Page<BlogPost> findByStatusOrderByPostDateAsc(String status, Pageable pageable);
    BlogPost findBySlug(String slug);
	List<BlogPost> findByTags(String tag);
}
