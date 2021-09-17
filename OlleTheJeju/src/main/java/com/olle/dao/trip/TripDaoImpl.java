package com.olle.dao.trip;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.olle.dto.etc.DibDto;
import com.olle.dto.suggest.SuggestDto;
import com.olle.dto.trip.TripDto;

@Repository
public class TripDaoImpl implements TripDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession; 

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
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {//nNode의 타입이 element인지 확인
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
	
	@Override
	public String getTagValue(String sTag, Element eElement) {
		NodeList nlist = eElement.getElementsByTagName(sTag).item(0).getChildNodes(); //sTag에 들어온 element중 첫번째 노드의 자식 노드들을 저장
		Node nValue = (Node)nlist.item(0); //저장된 자식노드들중 첫번째 값 저장
		return nValue.getNodeValue(); //노드 값 반환
	}
	
	@Override
	public int insert(TripDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert",dto);
		} catch (Exception e) {
			System.out.println("[ERROR : TRIP_INSERT]");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public List<TripDto> selectList(String kategorie, int page) {
		List<TripDto> result = new ArrayList<TripDto>();
		int pageP = (page-1)*6;
		int pageN = page*6;
		System.out.println("pageP: "+pageP);
		System.out.println("pageN: "+pageN);
		Map map = new HashMap();
		map.put("pageP", pageP);
		map.put("pageN", pageN);
		
		if(kategorie.equals("명소")) {
			map.put("name", "명소");
		}else if(kategorie.equals("맛집")) {
			map.put("name", "맛집");
		}else if(kategorie.equals("가격")) {
			map.put("name", "가격");
		}else {
			map.put("name", "명소");
		}
		System.out.println(map.get("name"));
		try {
			result = sqlSession.selectList(NAMESPACE+"selectList",map);
			System.out.println("실행"+result.size());
			
		} catch (Exception e) {
			System.out.println("[ERROR : SELECT_TRIP_LIST]");
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	@Override
	public int getAllCount(String kategorie) {
		int cnt=0;
		try {
			cnt = sqlSession.selectOne(NAMESPACE+"count", kategorie);
		} catch (Exception e) {
			System.out.println("[ERROR : COUNT]");
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public TripDto selectOne(int trip_num) {
		TripDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"selectOne",trip_num);
			sqlSession.update(NAMESPACE+"viewsUpdate",trip_num);
		} catch (Exception e) {
			System.out.println("[ERROR : SELECT_TRIP_ONE]");
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int update(TripDto dto) {
		int res=0;
		
		try {
			res = sqlSession.update(NAMESPACE+"update",dto);
		} catch (Exception e) {
			System.out.println("[ERROR: TRIP_UPDATE]");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int trip_num) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"delete",trip_num);
		} catch (Exception e) {
			System.out.println("[ERROR : TRIP_DELETE]");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public void likeUpdate(int trip_num) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"likeUpdate",trip_num);
		}catch(Exception e) {
			System.out.println("[ERROR : TRIP_LIKE]");
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertDibs(int trip_num, String user_id) {
		int res=0;
		int result = 0;
		DibDto chk = chkDibs(trip_num);
		if(chk==null) {
			try {
				DibDto in = new DibDto();
				in.setBoard_num(1);
				in.setTable_num(trip_num);
				in.setUser_id(user_id);
				res = sqlSession.insert("dib.insert",in);
				if(res>0) {
					result=1; //추가 성공
				}else {
					result=2; //추가 실패
				}
			} catch (Exception e) {
				System.out.println("[ERROR : DIB_INSERT]");
				e.printStackTrace();
			}
		}else {
			try {
				res = sqlSession.delete("dib.delete",chk.getDib_num());
				if(res>0) {
					result=3;//삭제 성공
				}else {
					result=4;//삭제 실패
				}
				
			} catch (Exception e) {
				System.out.println("[ERROR : DIB_DELETE");
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public DibDto chkDibs(/* String id, */ int tNum) {
		
		DibDto dd = new DibDto();
		//dd.setUser_id(id);
		dd.setTable_num(tNum);
		dd.setBoard_num(1);
		
		DibDto result=null;
		try {
			result = sqlSession.selectOne("dib.selectOne", dd);
		} catch (Exception e) {
			System.out.println("[ERROR : DIB_SELECTONE]");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<TripDto> DibList(List<TripDto> list, String user_id) {
		
		List<DibDto> dlist = new ArrayList<DibDto>();
		
		DibDto dd = new DibDto();
		dd.setUser_id(user_id); //세션에서 받아온 유저아이디
		dd.setBoard_num(1);
		
		try {
			dlist = sqlSession.selectList("dib.selectList", dd);
			for(int i=0; i<list.size(); i++) {
				int tNum = list.get(i).getTrip_num();
				
				for(int j=0; j<dlist.size(); j++) {
					if(dlist.get(j).getTable_num()==tNum) { //찜리스트에 해당 게시글의 번호가 있을경우
						
						list.get(i).setDib(1);
						break;
					}else {
						list.get(i).setDib(0);
					}
				}
				
			}
		} catch (Exception e) {
			System.out.println("[ERROR : DIB_SELECTLIST");
			e.printStackTrace();
		}
		
		return list;
	}
	
}
