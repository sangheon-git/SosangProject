package com.cafe24.sosang;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.sosang.dto.AreaDTO;
import com.cafe24.sosang.service.OverallService;
import com.cafe24.sosang.service.OverallServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class OverallServiceTest {
	
	@Autowired
	OverallServiceImpl overallService;
	
	AreaDTO adto = new AreaDTO();
	
	public OverallServiceTest() {
		adto.setArea("논현동");
		adto.setFood("한식음식점");
		adto.setSelect_year(2019);
		adto.setSelect_quarter(2);
	}
	
	@Test
    public void testCheckScore(){
		assertEquals(0.0, overallService.checkScore(-1.0, 5.0), 0);
		assertEquals(5.0, overallService.checkScore(6.0, 5.0), 0);
    }
	//성장성
	@Test
    public void testGetGrowth1() {
		double val = overallService.getGrowth1(adto);
		System.out.println("getGrowth1: " + val);
		assertEquals(2.0, val, 0);
	}
	@Test
    public void testGetGrowth2() {
		double val = overallService.getGrowth2(adto);
		System.out.println("getGrowth2: " + val);
		assertEquals(3.9, val, 0);
	}
	@Test
    public void testGetGrowth3() {
		double val = overallService.getGrowth3(adto);
		System.out.println("getGrowth3: " + val);
		assertEquals(3.6, val, 0);
	}
	@Test
    public void testGetGrowth4() {
		double val = overallService.getGrowth4(adto);
		System.out.println("getGrowth4: " + val);
		assertEquals(2.3, val, 0);
	}
	//안정성
	@Test
    public void testGetStability1() {
		double val = overallService.getStability1(adto);
		System.out.println("getStability1: " + val);
		assertEquals(4.8, val, 0);
	}
	@Test
    public void testGetStability2() {
		double val = overallService.getStability2(adto);
		System.out.println("getStability2: " + val);
		assertEquals(4.2, val, 0);
	}
	@Test
    public void testGetStability3() {
		double val = overallService.getStability3(adto);
		System.out.println("getStability3: " + val);
		assertEquals(2.4, val, 0);
	}
	@Test
    public void testGetStability4() {
		double val = overallService.getStability4(adto);
		System.out.println("getStability4: " + val);
		assertEquals(4.1, val, 0);
	}
	//영업력
	@Test
    public void testGetBusinessAbility1() {
		double val = overallService.getBusinessAbility1(adto);
		System.out.println("getBusinessAbility1: " + val);
		assertEquals(5.0, val, 0);
	}
	@Test
    public void testGetBusinessAbility2() {
		double val = overallService.getBusinessAbility2(adto);
		System.out.println("getBusinessAbility2: " + val);
		assertEquals(5.0, val, 0);
	}
	@Test
    public void testGetBusinessAbility3() {
		double val = overallService.getBusinessAbility3(adto);
		System.out.println("getBusinessAbility3: " + val);
		assertEquals(2.7, val, 0);
	}
	@Test
    public void testGetBusinessAbility4() {
		double val = overallService.getBusinessAbility4(adto);
		System.out.println("getBusinessAbility4: " + val);
		assertEquals(0.0, val, 0);
	}
	@Test
    public void testGetBusinessAbility5() {
		double val = overallService.getBusinessAbility5(adto);
		System.out.println("getBusinessAbility5: " + val);
		assertEquals(0.0, val, 0);
	}
	@Test
    public void testGetBusinessAbility6() {
		double val = overallService.getBusinessAbility6(adto);
		System.out.println("getBusinessAbility6: " + val);
		assertEquals(0.0, val, 0);
	}
	//구매력
	@Test
    public void testGetPurchasingPower1() {
		double val = overallService.getPurchasingPower1(adto);
		System.out.println("getPurchasingPower1: " + val);
		assertEquals(5.8, val, 0);
	}
	@Test
    public void testGetPurchasingPower2() {
		double val = overallService.getPurchasingPower2(adto);
		System.out.println("getPurchasingPower2: " + val);
		assertEquals(3.7, val, 0);
	}
	@Test
    public void testGetPurchasingPower3() {
		double val = overallService.getPurchasingPower3(adto);
		System.out.println("getPurchasingPower3: " + val);
		assertEquals(4.5, val, 0);
	}
	//집객력
	@Test
    public void testGetHouseArrest1() {
		double val = overallService.getHouseArrest1(adto);
		System.out.println("getHouseArrest1: " + val);
		assertEquals(8.4, val, 0);
	}
	@Test
    public void testGetHouseArrest2() {
		double val = overallService.getHouseArrest2(adto);
		System.out.println("getHouseArrest2: " + val);
		assertEquals(4.5, val, 0);
	}
	@Test
    public void testGetHouseArrest3() {
		double val = overallService.getHouseArrest3(adto);
		System.out.println("getHouseArrest3: " + val);
		assertEquals(2.9, val, 0);
	}
	//이전 분기
	@Test
    public void testGetBeforeQuarter() {
		AreaDTO val = overallService.getBeforeQuarter(adto,1);
		assertEquals(2019, val.getSelect_year());
		assertEquals(1, val.getSelect_quarter());
		
		AreaDTO val2 = overallService.getBeforeQuarter(adto,2);
		assertEquals(2018, val2.getSelect_year());
		assertEquals(4, val2.getSelect_quarter());
		
		AreaDTO val3 = overallService.getBeforeQuarter(adto,3);
		assertEquals(2018, val3.getSelect_year());
		assertEquals(3, val3.getSelect_quarter());
		
		AreaDTO val4 = overallService.getBeforeQuarter(adto,4);
		assertEquals(2018, val4.getSelect_year());
		assertEquals(2, val4.getSelect_quarter());
	}
	//일반계산
	@Test
    public void testGetSum() {
		double val = overallService.getSum(1,2,3);
		assertEquals(6, val, 0);
		
		double[] exam = {1,2,3};
		double val2 = overallService.getSum(exam);
		assertEquals(6, val2, 0);
	}
	@Test
    public void testGetRank() {
		double val = overallService.getRank(46);
		assertEquals(3, val, 0);
	}
}
