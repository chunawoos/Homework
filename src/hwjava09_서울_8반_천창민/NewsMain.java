package hwjava09_서울_8반_천창민;

import java.util.List;

public class NewsMain {
	INewsDAO dao;
	
	public NewsMain() {
//		dao = new NewsDAODOMImpl();
		dao = new NewsDAOSAXImpl();
		showList();
		System.out.println("6번째 News : "+ dao.search(6));
	}
	public void showList() {
		List<News> datas = dao.getNewsList("http://rss.etnews.com/Section902.xml");
		for(int i=0; i<datas.size();i++)
			System.out.println(datas.get(i).toString());
	}
	
	public static void main(String[] args) {
		new NewsMain();
	}
}
