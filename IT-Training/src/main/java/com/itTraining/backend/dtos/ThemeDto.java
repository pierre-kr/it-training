package com.itTraining.backend.dtos;

import java.util.ArrayList;
import java.util.List;

import com.itTraining.backend.entities.Formation;

import lombok.Data;

@Data
public class ThemeDto {

	private Long id;
	private String nom;
	private List<ThemeFormationsDto> formations = new ArrayList<>();
	private Long idParent;
}
