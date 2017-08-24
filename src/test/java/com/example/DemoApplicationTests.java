package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.lee.Application;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=Application.class)
public class DemoApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

//	private MockMvc mvc;
	
//	@Autowired  
//    private WebApplicationContext webApplicationConnect; 
//	@Autowired
//	private TestMapper mapper;
	/*@Autowired
	private FrameNoticeMapper mapper;
	
	@Test
	public void testColLength() {
		FrameNotice fn = new FrameNotice();
		fn.setName("12345678901234567890123456789012345678901234567890");
		try {
			mapper.save(fn);
		} catch(DataIntegrityViolationException e) {
			log.error("超长"+e.getMessage());
		}
	}*/
	
//	@Test
//	public void del() {
//		mapper.delete();
//	}
	
	/*@Before  
    public void setUp() throws JsonProcessingException {  
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();  
    }
	
	@Test
	public void contextLoads() throws Exception {
        String uri = "/greeting";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).param("name", "Denny").accept(MediaType.APPLICATION_JSON))
                .andReturn();  
        int status = mvcResult.getResponse().getStatus();  
        String content = mvcResult.getResponse().getContentAsString();  
        System.out.println(content);
  
        Assert.assertTrue("OK, 200", status == 200);
	}*/

}
