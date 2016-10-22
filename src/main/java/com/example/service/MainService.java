package com.example.service;

import java.util.Date;
import java.util.List;

import com.example.model.Pelajaran;
import com.example.model.Pemesanan;
import com.example.model.Topik;
import com.example.model.User;

public interface MainService
{
    User selectUser (String email);

	List<User> selectAllUsers();

	Pelajaran selectPelajaran(String id);

	List<Pelajaran> selectAllPelajaran();

	Topik selectTopik(String id);

	List<Topik> selectAllTopik();

	Pemesanan selectPemesanan(String id);

	List<Pemesanan> selectAllPemesanan();

	void addPemesanan(Pemesanan pemesanan);

	void addUser(User user);

	void updatePemesanan(String id, String guru);

	void updatePemesanan(String id, String komentar, int rating);

	void updatePemesanan(String id, Date date);

	List<Pemesanan> selectAllPemesananByGuru();

	List<Pemesanan> selectPemesananByUserProgres(String email);

	List<Pemesanan> selectPemesananByUserDone(String email);
}
