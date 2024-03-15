package com.example.addwin.DemoWebAppTest;

import com.example.addwin.DemoWebAppTest.Model.Item;
import com.example.addwin.DemoWebAppTest.Service.ItemService;
import com.example.addwin.DemoWebAppTest.WebApp.ItemController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ItemController.class)
class DemoWebAppTestApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ItemService itemServiceMock;

	@Test
	void itemControllerTest() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/service-item").accept(MediaType.APPLICATION_JSON);
		when(itemServiceMock.getItem()).thenReturn(
				Arrays.asList(new Item(1, "Item-1", 10, 100, 1000)));
		MvcResult res = mockMvc.perform(req).andExpect(status().isOk()).andReturn();
		JSONAssert.assertEquals(
				"[{id=1,name=Item-1,qty=10,price=100,total=1000}]",
				res.getResponse().getContentAsString(),false);
	}

}
