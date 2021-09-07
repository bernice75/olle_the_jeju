package com.olle.dao.trip;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Repository
public class TripDao {
	
	public List getDialect() {
		
		List bang = new ArrayList();
		try {
			bang.clear();
			
			URL url = new URL("http://www.jeju.go.kr/rest/JejuDialectService/getJejuDialectServiceList?authApiKey=&startPage=1&pageSize=2077");
			InputStream stream = url.openStream();
			char ch=0;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stream);
			doc.getDocumentElement().normalize();//normalize 사용으로 텍스트 정규화
			
			System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
			NodeList jeju = doc.getElementsByTagName("item"); //item element를 NodeList에 저장
			
			for(int i=0; i<jeju.getLength(); i++) {
				
				Node nNode = jeju.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {//nNode의 타입이 element인지 확인
					Element eElement = (Element) nNode; 
					String b=getTagValue("siteName",eElement);
					bang.add(b);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return bang;
	}
	
	public List getKor() {
		
		List kor= new ArrayList();
		try {
			kor.clear();
			
			URL url = new URL("http://www.jeju.go.kr/rest/JejuDialectService/getJejuDialectServiceList?authApiKey=&startPage=1&pageSize=2077");
			InputStream stream = url.openStream();
			char ch=0;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stream);
			doc.getDocumentElement().normalize();//normalize 사용으로 텍스트 정규화
			
			System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
			NodeList jeju = doc.getElementsByTagName("item"); //item element를 NodeList에 저장
			
			for(int i=0; i<jeju.getLength(); i++) {
				
				Node nNode = jeju.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {//nNode의 타입이 element인지 확인
					Element eElement = (Element) nNode; 
					String k=getTagValue("contents",eElement);
					kor.add(k);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return kor;
	}
	
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlist = eElement.getElementsByTagName(sTag).item(0).getChildNodes(); //sTag에 들어온 element중 첫번째 노드의 자식 노드들을 저장
		Node nValue = (Node)nlist.item(0); //저장된 자식노드들중 첫번째 값 저장
		return nValue.getNodeValue(); //노드 값 반환
	}
	
}
