package com.olle.biz.jejusituation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.olle.dao.jejusituation.CoronaDao;
import com.olle.dto.jejusituation.CoronaDto;

@Service
public class CoronaBizImpl implements CoronaBiz{
	
	@Autowired
	private CoronaDao dao;
	
	//코로나 정보 저장하기
	@Scheduled(cron="0 41 0 * * *")
	@Override
	public void searchData() {
		// TODO Auto-generated method stub
		String weekAgo=LocalDate.now().minusDays(7).toString().replaceAll("-","");
		String today=LocalDate.now().toString().replaceAll("-","");
		String uri=new StringBuilder()
				.append("http://openapi.data.go.kr/openapi/service/rest/Covid19")
				.append("/getCovid19SidoInfStateJson")
				.append("?serviceKey="+CoronaBiz.coronaKey)
				.append("&pageNo="+1)
				.append("&numOfRows="+10)
				.append("&startCreateDt="+weekAgo)
				.append("&endCreateDt="+today)
				.toString();
		
		System.out.println("uri: "+uri);
		
		  //Document 객체 생성
        Document document=null;
        try {
			document=DocumentBuilderFactory.newInstance()
					.newDocumentBuilder()
					.parse(uri);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //root tag
        document.getDocumentElement().normalize();
     //   System.out.println("root tag: "+document.getDocumentElement().getNodeName());
        //파싱할 태그
      //  Element root=document.getDocumentElement();
      //  System.out.println("Element root : "+root);
 
        NodeList list=document.getElementsByTagName("item");

        List<CoronaDto> corona=new ArrayList<CoronaDto>();
        
        for(int i=0;i<list.getLength();i++) {
        	Node node=list.item(i);
        	if(node.getNodeType()==Node.ELEMENT_NODE) {
        		Element e=(Element)node;
        		String gubun=getTagValue("gubun",e);
        		CoronaDto dto=new CoronaDto();
        		dto.setCreateDt(getTagValue("createDt",e));
        		dto.setUpdateDt(getTagValue("updateDt",e));        		
        		dto.setDeathCnt(Integer.valueOf(getTagValue("deathCnt",e)));
        		dto.setDefCnt(Integer.valueOf(getTagValue("defCnt",e)));
        		dto.setGubun(gubun);
        		dto.setGubunCn(getTagValue("gubunCn",e));
        		dto.setGubunEn(getTagValue("gubunEn",e));
        		dto.setIncDec(Integer.valueOf(getTagValue("incDec",e)));
        		dto.setIsolClearCnt(Integer.valueOf(getTagValue("isolClearCnt",e)));
        		dto.setLocalOccCnt(Integer.valueOf(getTagValue("localOccCnt",e)));
        		dto.setOverFlowCnt(Integer.valueOf(getTagValue("overFlowCnt",e)));
        		dto.setQurRate(getTagValue("qurRate",e));
        		dto.setSeq(Long.valueOf(getTagValue("seq",e)));
        		dto.setStdDay(getTagValue("stdDay",e));
        		
        		if(gubun.equals("제주")) {
        			corona.add(dto);
        		}
        		
        	}
        }

        dao.searchData(corona);
        
        System.out.println("corona: "+corona);
	}

	  //태그값 가져오기
	@Override
	  public String getTagValue(String tagName, Element element) {
		  NodeList list=null;
		  Node val=null;
		  
		  try {
			  list=element.getElementsByTagName(tagName).item(0).getChildNodes();
			  val=(Node)list.item(0);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  if(val==null) {
			  return null;
		  }
		  return val.getNodeValue();
	  }

	@Override
	public List<HashMap<String,String>> coronaList(HashMap<String,String> map) {
		// TODO Auto-generated method stub
		return dao.coronaList(map);
	}

}
