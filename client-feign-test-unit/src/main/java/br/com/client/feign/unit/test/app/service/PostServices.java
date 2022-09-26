package br.com.client.feign.unit.test.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.client.feign.unit.test.app.client.PostClient;
import br.com.client.feign.unit.test.app.dto.PostDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostServices {

	@Autowired
	PostClient postClient;

	public List<PostDto> consultaPost() {

		List<PostDto> listaPost = postClient.consultaPostsClient();

		if (!CollectionUtils.isEmpty(listaPost)) {
			
			log.info("lista ok");
			
		} else {
			
			log.info("lista vazia");
			
		}

		return listaPost;
	}
}
