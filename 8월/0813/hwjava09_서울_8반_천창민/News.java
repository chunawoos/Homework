package hwjava09_서울_8반_천창민;

public class News {
	private String title;
	private String desc;
	private String link;
	
	public News() { }

	public News(String title, String desc, String link) {
		this.title = title;
		this.desc = desc;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("News : title = ");
		builder.append(title);
		builder.append(", desc = ");
		builder.append(desc);
		builder.append(", link = ");
		builder.append(link);
		return builder.toString();
	}
	
	
}
