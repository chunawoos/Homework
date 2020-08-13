package hwjava09_서울_8반_천창민;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO{

	List<News> list = new ArrayList<>();
	Element root;
	@Override
	public List<News> getNewsList(String url) {
		try {
			connectNews(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public News search(int index) {
		
		return list.get(index);
	}
	
	private void connectNews(String url) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(url);
		doc.getDocumentElement().normalize();
		
		root = doc.getDocumentElement();
		
		NodeList childNodes = root.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				
				Element element = (Element) node;
				NodeList chChildNodes = element.getChildNodes();
				News news = new News();
				for(int j=0; j< chChildNodes.getLength() ; j++) {
					Node chNode = chChildNodes.item(j);
					if(chNode.getNodeType() == Node.ELEMENT_NODE) {
						Element chElement = (Element) chNode;
						String chTextContent = chElement.getTextContent();
						String chNodeName = chElement.getNodeName();
						switch(chNodeName) {
						case "title" : 
							news.setTitle(chTextContent);
							break;
						case "description" :
							news.setDesc(chTextContent);
							list.add(news);
							break;
						case "link" :
							news.setLink(chTextContent);
							break;
						case "item" :
							NodeList itemChildNodes = chElement.getChildNodes();
							News childNews = new News();
							for(int k=0; k < itemChildNodes.getLength(); k++) {
								Node childNode = itemChildNodes.item(k);
								if(childNode.getNodeType() == Node.ELEMENT_NODE){
									Element childElement = (Element) childNode;
									String childTextContent = childElement.getTextContent();
									String childNodeName = childElement.getNodeName();
									switch(childNodeName) {
									case "title" : 
										childNews.setTitle(childTextContent);
										break;
									case "description" :
										childNews.setDesc(childTextContent);
										list.add(childNews);
										break;
									case "link" :
										childNews.setLink(childTextContent);
										break;
									}
								}
								
							}
						}
					}						
				}
			}
		}
	}
}
