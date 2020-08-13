package hwjava09_서울_8반_천창민;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO {
	List<News> list = new  ArrayList<>();

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
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(url, handler);
	}
	
	class SAXHandler extends DefaultHandler{
		
		StringBuilder b =null;
		boolean flag;
		News n = new News();
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equals("title")) flag = true;
			else if(qName.equals("description")) flag = true;
			else if(qName.equals("link")) flag = true;
			
			b = new StringBuilder();
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("title")) {
				n.setTitle(b.toString());
				flag = false;
			}
			else if(qName.equals("description")) {
				n.setDesc(b.toString());
				list.add(n);
				n = new News();
				flag = false;
			}
			else if(qName.equals("link")) {
				n.setLink(b.toString());
				flag = false;
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			b.append(new String(ch,start,length));
		}
	}
}