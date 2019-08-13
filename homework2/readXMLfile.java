package homework2;
import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;


public class readXMLfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    SAXBuilder builder= new SAXBuilder();
    try {
    	Document document=builder.build(new File("F:\\eclipse-workspace\\homework2\\src\\homework2\\book.xml"));
    	Element bookroot=document.getRootElement();
    	List<Element> bookchildren=bookroot.getChildren();
    	//��ȡxml
    	System.out.println("��ȡbook.xml");
    	for(Element book:bookchildren) {
    		System.out.println("�ڵ�����"+book.getName()+" id��"+book.getAttributeValue("id")+" title:"+book.getChildText("title")+" author:"+book.getChildText("author")+" price:"+book.getChildText("price"));
    	}
    	
    	//��xml���Ԫ��
    	Element newbook=new Element("book");
    	bookroot.addContent(newbook);
    	newbook.setAttribute("id","003");
    	Element newbook_title=new Element("title");
    	newbook_title.setText("Learing Java");
    	newbook.addContent(newbook_title);
    	Element newbook_author=new Element("author");
    	newbook_author.setText("Bill Gates");
    	newbook.addContent(newbook_author);
    	Element newbook_price=new Element("price");
    	newbook_price.setText("$48");
    	newbook.addContent(newbook_price);
    	System.out.println("��book.xml�����һ��Ԫ��");
    	for(Element book:bookchildren) {
    		System.out.println("�ڵ�����"+book.getName()+" id��"+book.getAttributeValue("id")+" title:"+book.getChildText("title")+" author:"+book.getChildText("author")+" price:"+book.getChildText("price"));
    	}
    	
    	//ɾ��xml��Ԫ��
    	for(Element delbook:bookchildren) {
    		if(delbook.getAttributeValue("id").equals("003"))
    			bookroot.removeContent(delbook);
    	}
    	System.out.println("ɾ��book.xml����ӵ�Ԫ��");
    	for(Element book:bookchildren) {
    		System.out.println("�ڵ�����"+book.getName()+" id��"+book.getAttributeValue("id")+" title:"+book.getChildText("title")+" author:"+book.getChildText("author")+" price:"+book.getChildText("price"));
    	}
  
    	}catch (Exception e) {   
          e.printStackTrace(); 
    } 
	}
}
