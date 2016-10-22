package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topik {
	private int id;
	private String pelajaran;
	private String topik;
	private int kelas;
}
