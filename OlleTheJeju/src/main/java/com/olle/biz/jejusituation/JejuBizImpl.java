package com.olle.biz.jejusituation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.olle.dao.jejusituation.JejuDao;
import com.olle.dto.jejusituation.CoronaDto;
import com.olle.dto.jejusituation.JejuDto;

@Service
public class JejuBizImpl implements JejuBiz {
	@Autowired
	private JejuDao dao;
	
	//코로나 정보 가져오기
	@Override
	public List<CoronaDto> searchData() {
		String weekAgo=LocalDate.now().minusDays(7).toString().replaceAll("-","");
		String today=LocalDate.now().toString().replaceAll("-","");

		String uri=new StringBuilder()
				.append("http://openapi.data.go.kr/openapi/service/rest/Covid19")
				.append("/getCovid19SidoInfStateJson")
				.append("?serviceKey="+JejuBiz.coronaKey)
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
        //root tag
        document.getDocumentElement().normalize();

        NodeList list=document.getElementsByTagName("item");

        List<CoronaDto> corona=new ArrayList<CoronaDto>();

        for(int i=0;i<list.getLength();i++) {
        	Node node=list.item(i);
        	if(node.getNodeType()==Node.ELEMENT_NODE) {
        		Element e=(Element)node;

        		CoronaDto dto=new CoronaDto();
        		dto.setCreateDt(getTagValue("createDt",e));
        		dto.setUpdateDt(getTagValue("updateDt",e));        		
        		dto.setDeathCnt(Integer.valueOf(getTagValue("deathCnt",e)));
        		dto.setDefCnt(Integer.valueOf(getTagValue("defCnt",e)));
        		dto.setGubun(getTagValue("gubun",e));
        		dto.setGubunCn(getTagValue("gubunCn",e));
        		dto.setGubunEn(getTagValue("gubunEn",e));
        		dto.setIncDec(Integer.valueOf(getTagValue("incDec",e)));
        		dto.setIsolClearCnt(Integer.valueOf(getTagValue("isolClearCnt",e)));
        		dto.setLocalOccCnt(Integer.valueOf(getTagValue("localOccCnt",e)));
        		dto.setOverFlowCnt(Integer.valueOf(getTagValue("overFlowCnt",e)));
        		dto.setQurRate(getTagValue("qurRate",e));
        		dto.setSeq(Long.valueOf(getTagValue("seq",e)));
        		dto.setStdDay(getTagValue("stdDay",e));

        		corona.add(dto);

        	}
        }

        System.out.println("corona: "+corona);

		return corona;
	}
	
	//태그값 가져오기
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
	public int getMaxJejuDtoNum() {
		return dao.getMaxJejuDtoNum();
	}


	@Override
	public int saveStore(JejuDto dto) {
		return dao.saveStore(dto);
	}


	@Override
	public void setMaxPkFromSelectKey(int primaryKey) {
		dao.setMaxPkFromSelectKey(primaryKey);
	}


	@Override
	public int getMaxPkFromSelectKey() {
		return dao.getMaxPkFromSelectKey();
	}
	
	@Override
	public JejuDto getOurStoreInfo(int situ_num) {
		return dao.getOurStoreInfo(situ_num);
	}
}