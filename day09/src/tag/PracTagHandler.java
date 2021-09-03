package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PracTagHandler extends SimpleTagSupport{
	private String color;
	private String size;
	
	public void doTag() throws IOException, JspException {
		JspWriter out=getJspContext().getOut();
		
		JspFragment body=getJspBody();
		if(body !=null) {
			StringBuffer sb = new StringBuffer();
			 sb.append("<p style='color :").append(color).append("; font-size:").append(size).append(";'>");			
			 out.println(sb.toString());
			body.invoke(null);
			out.println("</p>");
		}
		
		
		
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
