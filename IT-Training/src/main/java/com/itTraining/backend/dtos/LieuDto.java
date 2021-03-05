package com.itTraining.backend.dtos;

import lombok.Data;

@Data
public class LieuDto {
	
	private Long id;
	private String num;
	private String rue;
	private String ville;
	private String cp;
}
