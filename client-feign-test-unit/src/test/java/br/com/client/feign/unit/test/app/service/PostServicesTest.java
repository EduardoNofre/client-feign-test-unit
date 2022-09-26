package br.com.client.feign.unit.test.app.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.util.Assert;

import br.com.client.feign.unit.test.app.client.PostClient;
import br.com.client.feign.unit.test.app.dto.PostDto;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;


@SpringBootTest
public class PostServicesTest {
	
	private static final String URL_BASE = "https://jsonplaceholder.typicode.com";
	
	private static final String RESPONSE = "[{\"userId\":1,\"title\":\"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\"body\":\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\",\"id\":1}]";
	

	PostClient postClient;
	
	@Autowired
	PostServices postServices;
	
	
	public void builderMockPostClient(MockClient mockClient) {
		
		postClient = Feign.builder()
				     .client(mockClient)
				     .encoder(new JacksonEncoder())
				     .decoder(new JacksonDecoder())
				     .contract(new SpringMvcContract())
				     .target(PostClient.class,URL_BASE);
		
	}
	
	@Test
	public void testClientFeingPostClient() {
		
		this.builderMockPostClient(new MockClient().ok(
					HttpMethod.GET,
					URL_BASE.concat("/posts"),
					RESPONSE
				));
		
		List<PostDto> postDtoList = postClient.consultaPostsClient();
		
//		Mockito.when(postServices.consultaPost()).thenReturn(postDtoList);
				
		postServices.consultaPost();
		
		Assert.notNull(postDtoList);
	}
	
	
}
