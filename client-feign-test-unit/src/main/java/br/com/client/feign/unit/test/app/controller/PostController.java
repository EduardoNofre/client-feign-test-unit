package br.com.client.feign.unit.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.client.feign.unit.test.app.dto.PostDto;
import br.com.client.feign.unit.test.app.service.PostServices;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostServices postServices;

	@GetMapping()
	public ResponseEntity<?> consultaPostWebServiece() {

		List<PostDto> posts = postServices.consultaPost();

		return new ResponseEntity<>(posts, HttpStatus.OK);

	}
}
