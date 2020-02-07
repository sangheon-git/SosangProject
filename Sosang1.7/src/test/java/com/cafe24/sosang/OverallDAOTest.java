package com.cafe24.sosang;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.sosang.dao.OverallDAO;
import com.cafe24.sosang.dto.AreaDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class OverallDAOTest {
	
	@Autowired
	private OverallDAO overallDAO;
	
	AreaDTO adto = new AreaDTO();
	String[] area = {"압구정동","청담동","대치동","도곡동","개포동","일원동","논현동","삼성동","신사동","수서동","역삼동"};
	String[] food = {"한식음식점","일식음식점","중식음식점","양식음식점","분식전문점","치킨전문점","패스트푸드점","제과점","커피·음료","호프·간이주점"};
	
	public OverallDAOTest() {
		adto.setSelect_year(2019);
		adto.setSelect_quarter(2);
	}
	
	@Test
    public void testAllDAONullException(){
		for(int i=0; i < area.length; i++) {
			adto.setArea(area[i]);
			System.out.println(adto.getArea());
			for(int j=0; j < food.length; j++) {
				adto.setFood(food[j]);
				System.out.println(adto.getFood());
				overallDAO.getAllCnt(adto);
				overallDAO.getSelectCnt(adto);
				overallDAO.getSales(adto);
				overallDAO.getSalesCnt(adto);
				overallDAO.getResPop(adto);
				overallDAO.getSalPop(adto);
				overallDAO.getFloPop(adto);
				overallDAO.getFacilCnt(adto);
				overallDAO.getSchoolCnt(adto);
				overallDAO.getTrafficCnt(adto);
				overallDAO.getGrowth1Condition(adto);
				overallDAO.getGrowth2Condition(adto);
				overallDAO.getGrowth3Conditions(adto);
				overallDAO.getGrowth4Conditions(adto);
				overallDAO.getStability1Conditions(adto);
				overallDAO.getStability2Conditions(adto);
				overallDAO.getStability3Conditions(adto);
				overallDAO.getStability4Conditions(adto);
				overallDAO.getBusinessAbility1Conditions(adto);
				overallDAO.getBusinessAbility2Conditions(adto);
				overallDAO.getBusinessAbility3Conditions(adto);
				overallDAO.getBusinessAbility4Conditions(adto);
				overallDAO.getBusinessAbility5Conditions(adto);
				overallDAO.getBusinessAbility6Conditions(adto);
				overallDAO.getPurchasingPower1Conditions(adto);
				overallDAO.getPurchasingPower2Conditions(adto);
				overallDAO.getPurchasingPower3Conditions(adto).toString();
				overallDAO.getHouseArrest1Conditions(adto);
				overallDAO.getHouseArrest2Conditions(adto);
				overallDAO.getHouseArrest3Conditions(adto);
			}
		}
    }
}
