package news.kireeti.bioscope.repositories;

import java.util.List;

/**
 * @author Kireeti Eluri
 */
public interface BlogOperations {
	List<String> findTagsByFragment(String fragment);
	List<String> findAllTags();
}
