package com.rays.pro4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Exception.RecordNotFoundException;
import com.rays.pro4.Model.UserModel;
import com.rays.pro4.bean.UserBean;

/**
 * User Model Test classes.
 * 
 * @author SAGAR PATNE
 *
 */
public class UserModelTest {
	
	public static UserModel model =  new UserModel();
	
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException, ParseException, RecordNotFoundException {
	testadd();
		//testDelete();
		//testFindByLogin();
		//testFindByPK();
		//testUpdate();
		//testSearch();
		
		//testList();
	//testAuthenticate();
		//testGetRoles();
		//testRegisterUser();
	//	testchangePassword();
		//testforgetPassword();
	}
	
	public static void testadd() throws ParseException, DuplicateRecordException, ApplicationException, RecordNotFoundException{
		
		try{
		UserBean bean = new UserBean();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		
		bean.setId(28);
		bean.setFirstName("sagar");
		bean.setLastName("patne");
		bean.setLogin("sp@gmail.com");
		bean.setPassword("sagar@123");
		bean.setDob(sdf.parse("22-08-1998"));
		bean.setRoleId(1L);
		bean.setUnSuccessfulLogin(5);
		bean.setGender("male");
		bean.setLastLogin(new Timestamp(new Date().getTime()));
		bean.setLock("yes");
		bean.setConfirmPassword("sagar@123");
		
		long pk = model.add(bean);
		UserBean addedbean = model.findByPK(pk);
		System.out.println("Test add succ");
		
		if(addedbean == null){
			System.out.println("Test add fail");
		}
		
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	
	public static void testDelete(){
		
		try{
			 UserBean bean = model.findByPK(1L);
			 
			 long pk =3L;
			 bean.setId(pk);
			 model.delete(bean);
			 System.out.println("Test Delete succ" + bean.getId());
			 
			 UserBean deletebean = model.findByPK(pk);
			 
			 if(deletebean == null){
				 System.out.println("Test Delete fail");
			 }
			
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	
	public static void testFindByPK(){
		try{
			UserBean bean = new UserBean();
			long pk=1L;
			bean= model.findByPK(pk);
			if(bean == null){
				System.out.println("Test find by pk fail");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
			
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	
	public static void testFindByLogin(){
		try{
			UserBean bean = new UserBean();
			bean = model.findByLogin("ajay@gmail.com");
			if(bean == null){
				System.out.println("Test findByLogin fail");
			}
			System.out.println(bean.getId());
			
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfulLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	public static void testUpdate(){
		try{
			UserBean bean = model.findByPK(1L);
			bean.setFirstName("sagar");
			bean.setLastName("goyal");
			bean.setLogin("sagar@gmail.com");
			bean.setPassword("sagar123");
			model.update(bean);
			
			System.out.println("test update succ");
			
			/*UserBean updatebean = model.findByPK(1L);
			if(!"ranjit".equals(updatebean.getLogin())){
				System.out.println("Test Update fail");
			}*/
		}catch(ApplicationException e){
			e.printStackTrace();
		}catch(DuplicateRecordException e){
			e.printStackTrace();
		}
	}
	
	public static void testSearch(){
		try{
			UserBean bean =new UserBean();
			List list = new ArrayList();
			//bean.setFirstName("ajay");
			list=model.search(bean,1,10);
			if(list.size() < 0){
				System.out.println("Test search fail");
			}
			Iterator it = list.iterator();
			while(it.hasNext()){
				bean=(UserBean) it.next();
				System.out.println(bean.getId());
				  System.out.println(bean.getFirstName());
	                System.out.println(bean.getLastName());
	                System.out.println(bean.getLogin());
	                System.out.println(bean.getPassword());
	                System.out.println(bean.getDob());
	                System.out.println(bean.getRoleId());
	                System.out.println(bean.getUnSuccessfulLogin());
	                System.out.println(bean.getGender());
	                System.out.println(bean.getLastLogin());
	                System.out.println(bean.getLock());
			}
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	
	public static void testList(){
		try{
			UserBean bean = new UserBean();
			List list = new ArrayList();
			list = model.list();
			if(list.size() < 0){
				System.out.println("Test list fail ");
			}
			Iterator it = list.iterator();
			while(it.hasNext()){
				bean = (UserBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLogin());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
				System.out.println(bean.getRoleId());
				System.out.println(bean.getUnSuccessfulLogin());
				System.out.println(bean.getGender());
				System.out.println(bean.getLastLogin());
				System.out.println(bean.getLock());
				System.out.println(bean.getMobileNo());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedDatetime());
				
			}
		}catch(ApplicationException e){
			e.printStackTrace();
		}
	}
	
	public static void testAuthenticate() {
		try {
			UserBean bean = new UserBean();
			bean.setLogin("sawan@gmail.com");
			bean.setPassword("sawan123");
			bean = model.authenticate(bean.getLogin(),bean.getPassword());
			if(bean != null) {
				System.out.println("Successfully login");
			}else {
				System.out.println("Invaliad login Id & password");
			}
		}catch(ApplicationException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetRoles() {
		try {
			UserBean bean = new UserBean();
			List list = new ArrayList();
			bean.setRoleId(1L);
			list = model.getRoles(bean);
			if(list.size() < 0) {
				System.out.println("Test Get Roles fail");
			}
			Iterator it= list.iterator();
			 while (it.hasNext()) {
	                bean = (UserBean) it.next();
	                System.out.println(bean.getId());
	                System.out.println(bean.getFirstName());
	                System.out.println(bean.getLastName());
	                System.out.println(bean.getLogin());
	                System.out.println(bean.getPassword());
	                System.out.println(bean.getDob());
	                System.out.println(bean.getRoleId());
	                System.out.println(bean.getUnSuccessfulLogin());
	                System.out.println(bean.getGender());
	                System.out.println(bean.getLastLogin());
	                System.out.println(bean.getLock());
	            }
		}catch(ApplicationException e) {
			e.printStackTrace();
		}
	}
	
	public static void testRegisterUser() throws ParseException {
		try {
			
			UserBean bean = new UserBean();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			//bean.setId(3L);
			bean.setFirstName("Ram");
			bean.setLastName("yadav");
			bean.setLogin("Ramyadav@gmail.com");
			bean.setPassword("R@12345");
			bean.setDob(sdf.parse("07/23/1998"));
			bean.setMobileNo("9798798799");
			bean.setGender("male");
			bean.setRoleId(2);
			bean.setCreatedBy("admin");
			bean.setModifiedBy("admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.registerUser(bean);
			System.out.println("Successfully register");
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			
			UserBean registerbean = model.findByPK(pk);
			if(registerbean != null) {
				System.out.println("Test registation fail");
			}
		}catch(ApplicationException e) {
			e.printStackTrace();
		}catch(DuplicateRecordException e) {
			e.printStackTrace();
		}
	}
	
	public static void testchangePassword() {
		
		try {
			UserBean bean = model.findByLogin("sagar@gmail.com");
			String oldPassword = bean.getPassword();
			bean.setId(1L);
			bean.setPassword("K@12345678");
			bean.setConfirmPassword("K@12345678");
			String newPassword = bean.getPassword();
			
			try {
				model.changePassword(1L, oldPassword, newPassword);
				System.out.println("Password has bean change successfully");
			}catch(RecordNotFoundException e) {
				e.printStackTrace();
			}
		}catch(ApplicationException e) {
			e.printStackTrace();
		}
	}
	
	public static void testforgetPassword() {
		try {
			boolean b= model.forgetPassword("Ramyadav@gmail.com");
			
			System.out.println("Success : Test Forgate Password Success");
		}catch(RecordNotFoundException e) {
			e.printStackTrace();
		}catch(ApplicationException e) {
			e.printStackTrace();
		}
	}
	
	

}
