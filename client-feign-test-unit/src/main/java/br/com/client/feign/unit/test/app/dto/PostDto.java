package br.com.client.feign.unit.test.app.dto;

import lombok.Data;

@Data
public class PostDto {

	private Integer userId;
	private Integer Id;
	private String title;
	private String body;

}
