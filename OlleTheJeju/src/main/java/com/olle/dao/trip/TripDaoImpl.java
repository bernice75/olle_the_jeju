package com.olle.dao.trip;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Repository
public class TripDaoImpl implements TripDao {

	@Override
	public Map<String, List> getJeju(String page) {
		List dia= new ArrayList();
		List kor= new ArrayList();
		Map<String, List> result = new HashMap();
		
		try {
			dia.clear();
			kor.clear();
			
			URL url = new URL("http://www.jeju.go.kr/rest/JejuDialectService/getJejuDialectServiceList?authApiKey=&page="+page+"&pageSize=10");
			InputStream stream = url.openStream();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(stream);
			doc.getDocumentElement().normalize();//normalize 사용으로 텍스트 정규화
			
			System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
			NodeList jeju = doc.getElementsByTagName("item"); //item element를 NodeList에 저장
			
			for(int i=0; i<jeju.getLength(); i++) {
				
				Node nNode = jeju.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) { //nNode의 타입이 element인지 확인
					Element eElement = (Element) nNode; 
					
					String k=getTagValue("contents", eElement);
					String d=getTagValue("siteName",eElement);
					dia.add(d);
					kor.add(k);
				}
			}
			result.put("dia", dia);
			result.put("kor", kor);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Map<String, List> getSearch(String search) {
		List dia= new ArrayList();
		List kor = new ArrayList();
		Map<String, List> result = new HashMap();
		try {
			dia.clear();
			kor.clear();
			
			URL url = new URL("http://www.jeju.go.kr/rest/JejuDialectService/getJejuDialectServiceList?authApiKey=&pageSize=7159");
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
					
					String k=getTagValue("contents", eElement);
					String d=getTagValue("siteName",eElement);
					
					if(k.contains(search)||d.contains(search))  {
						System.out.println();
						dia.add(d);
						kor.add(k);
						
					}
				}
			}
			result.put("dia", dia);
			result.put("kor", kor);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlist = eElement.getElementsByTagName(sTag).item(0).getChildNodes(); //sTag에 들어온 element중 첫번째 노드의 자식 노드들을 저장
		Node nValue = (Node)nlist.item(0); //저장된 자식노드들중 첫번째 값 저장
		return nValue.getNodeValue(); //노드 값 반환
	}

}
