package hwjava09_서울_8반_천창민;

import java.util.List;

public interface INewsDAO {
	List<News> getNewsList(String url);
	public News search(int index);
}
