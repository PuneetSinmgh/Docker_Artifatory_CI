package com.sample.mvc.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.sample.mvc.controller.EmployeeController;
import com.sample.mvc.model.EmployeeCommand;
import com.sample.mvc.service.EmployeeService;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	

	
	
	 public EmployeeService employeeService=mock(EmployeeService.class);
	 
	 
	    @InjectMocks
	    public EmployeeController employeeController=new EmployeeController();
	    EmployeeCommand emp;
	 
	    @Before
	    public void setup() {
	 
	        MockitoAnnotations.initMocks(this);
	 
	       
	        emp = new EmployeeCommand();
	    	 emp.setCode(105);
	    	 emp.setName("vikas");
	    	 emp.setCity("pune");
	        }
	    
	        

	    
	    @Test
	    public void testAddEmployee() throws Exception 
	    {
	    	
	    	ModelAndView modelandview=mock(ModelAndView.class);
	        Mockito.doNothing().when(employeeService).addEmployee(any(EmployeeCommand.class));
	        assertNotNull(employeeController.addEmployee(emp));
	        assertFalse(employeeController.addEmployee(emp).isEmpty());
	        
	     
	    }
	    
	    @Test
		public void testGetEmployeeById()   throws Exception 
		{
	    	Model model=mock(Model.class);
			when(employeeService.getEmployeebyId(anyInt())).thenReturn(emp);
			assertEquals("vikas",employeeService.getEmployeebyId(anyInt()).getName());
			assertEquals("pune",employeeService.getEmployeebyId(anyInt()).getCity());
			model.addAttribute("employee", emp);
			assertEquals("edit",employeeController.getEmployeeById(20, model));
		}
	    
	    
	    @Test
		public void testViewHome()
		{
			
			Assert.assertEquals("home", employeeController.viewHome());
			
		}
	    
	    @Test
	    public void testUpdateEmployee() throws Exception
	    {
           doNothing().when(employeeService).updateEmployee(any(EmployeeCommand.class));
           assertEquals("redirect:/list",employeeController.updateEmployee(emp));
	    	
	    }
	    
	    
	    @Test
	    public void testDeleteEmployee() throws Exception
	    {
	    	doNothing().when(employeeService).deleteEmployee(anyInt());
	    	assertEquals("redirect:/list",employeeController.deleteEmplyee(101));
	    }
	    
	    
	    @Test
	    public void testListContacts() throws Exception
	    {
          List<EmployeeCommand> empList=mock(List.class);
          empList.add(emp);
          when(employeeService.listContact()).thenReturn(empList);
          Map<String,Object> map=mock(Map.class);
          map.put("contact", new EmployeeCommand());
          map.put("contactList",employeeService.listContact() );
          when(map.size()).thenReturn(2);
          assertEquals(2,map.size());
          assertEquals("list",employeeController.listContacts(map));
	    }
	    
}
