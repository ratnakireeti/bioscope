package news.kireeti.bioscope.repositories;

import com.mongodb.DBCollection;

import news.kireeti.bioscope.models.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Kireeti Eluri
 */
public class BlogRepositoryImpl implements BlogOperations {
	
	@Autowired private MongoTemplate mongoTemplate;

	private DBCollection getCollection(){
		return (DBCollection) mongoTemplate.getCollection(mongoTemplate.getCollectionName(BlogPost.class));
	}

	@Override
	public List<String> findTagsByFragment(String fragment) {
		Pattern pattern = Pattern.compile("^.*?" + fragment + ".*$", Pattern.CASE_INSENSITIVE);
		List<String> matched = new ArrayList<>();
		for (String tag: this.findAllTags()){
			if (pattern.matcher(tag).find()){
				matched.add(tag);
			}
		}
		return matched;
	}

	@Override 
	public List<String> findAllTags() {
		return getCollection().distinct("tags");
	}
}
