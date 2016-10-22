package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private int id;
	private String email;
	private String password;
	private String role;
	private String no_hp;
	private String date_register;
	private String date_delete;
	private String picture;
	private String tingkat;
	private String sekolah;
	private boolean status;
}
