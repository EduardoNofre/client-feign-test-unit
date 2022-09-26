package br.com.client.feign.unit.test.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.client.feign.unit.test.app.dto.PostDto;
import feign.Headers;

@FeignClient(url = "${post.api}", name = "posts")
public interface PostClient {

	@Headers("Content-Type: application/json")
	@GetMapping("/posts")
	List<PostDto> consultaPostsClient();
}
