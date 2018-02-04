package news.kireeti.bioscope.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import news.kireeti.bioscope.models.User;

/**
 * @author Kireeti Eluri
 */
public interface UserRepository extends MongoRepository<User, String>, UserDetailsService {
}
