 package com.rays.pro4.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DatabaseException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Model.CollegeModel;
import com.rays.pro4.bean.CollegeBean;

/**
 * College Model Test classes.
 *
 */
/**
 * @author SAGAR PATNE
 *
 */
public class CollegeModelTest {

	public static CollegeModel model=new CollegeModel();
	public static void main(String[] args) throws Throwable  {
		//testAdd();
		//testDelete();
		//testFindByName();
		//testFindByPK();
		//testUpdate();
		//testSearch();
		testList();
	}
	
	
	public static void testAdd() throws DuplicateRecordException{
		try{
			CollegeBean bean=new CollegeBean();
			//bean.setId(2L);
			bean.setName("sage");
			bean.setAddress("indore");
			bean.setState("mp");
			bean.setCity("Indore");
			bean.setPhoneNo("767856545435");
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk=model.add(bean);
			System.out.println("Test Add succ");
			CollegeBean addedBean=model.findByPK(pk);
			if(addedBean==null){
				System.out.println("Test ass fail");
			}
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	public static void testDelete() throws ApplicationException{
		try{
		CollegeBean bean=new CollegeBean();
		long pk=1L;
		bean.setId(2);
		model.delete(bean);
		System.out.println("Test Delete suc");
		CollegeBean deletedBean= model.findByPK(pk);
		if(deletedBean==null){
			System.out.println("Test Delete fail");
		}
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	public static void testFindByName(){
		try{
			CollegeBean bean=model.findByName("rpl");
			if(bean==null){
				System.out.println("Test FindByName fill");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getState());
			System.out.println(bean.getCity());
			System.out.println(bean.getPhoneNo());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	public static void testFindByPK(){
		try{
			CollegeBean bean=new CollegeBean();
			long pk=1L;
			bean=model.findByPK(3);
			if(bean==null){
				System.out.println("Test Find By Pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getState());
			System.out.println(bean.getCity());
			System.out.println(bean.getPhoneNo());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	public static void testUpdate() throws Throwable{

        try {
            CollegeBean bean = model.findByPK(1L);
        	
           bean.setName("Davv");
            bean.setAddress("Indore");
            model.update(bean);
            System.out.println("Test Update succ");
            CollegeBean updateBean = model.findByPK(2L);
//            if (!"oit".equals(updateBean.getName())) {
//                System.out.println("Test Update fail");
//            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }catch (DuplicateRecordException e) {
        	e.printStackTrace();
        }

    }
	 public static void testSearch() {
	        try {
	            CollegeBean bean = new CollegeBean();
	            List list = new ArrayList();
	            bean.setName("rpl");
	             //bean.setAddress("dewas");
	            list = model.search(bean, 0, 0);
	            if (list.size() > 0) {
	                System.out.println("Test Search fail");
	            }
	            Iterator it = list.iterator();
	            while (it.hasNext()) {
	                bean = (CollegeBean) it.next();
	                System.out.println(bean.getId());
	                System.out.println(bean.getName());
	                System.out.println(bean.getAddress());
	                System.out.println(bean.getState());
	                System.out.println(bean.getCity());
	                System.out.println(bean.getPhoneNo());
	                System.out.println(bean.getCreatedBy());
	                System.out.println(bean.getCreatedDatetime());
	                System.out.println(bean.getModifiedBy());
	                System.out.println(bean.getModifiedDatetime());
	            }
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	    }
	 public static void testList() {

			try {
				CollegeBean bean = new CollegeBean();
				List list = new ArrayList();
				list = model.list(1, 10);
				if (list.size() < 0) {
					System.out.println("Test list fail");
				}
				Iterator it = list.iterator();
				while (it.hasNext()) {
					bean = (CollegeBean) it.next();
					System.out.println(bean.getId());
					System.out.println(bean.getName());
					System.out.println(bean.getAddress());
					System.out.println(bean.getState());
					System.out.println(bean.getCity());
					System.out.println(bean.getPhoneNo());
					System.out.println(bean.getCreatedBy());
					System.out.println(bean.getCreatedDatetime());
					System.out.println(bean.getModifiedBy());
					System.out.println(bean.getModifiedDatetime());
				}

			} catch (ApplicationException e) {
				e.printStackTrace();
		
		}

	}


}
