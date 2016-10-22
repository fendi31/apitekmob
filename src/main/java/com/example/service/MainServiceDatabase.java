package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.dao.MainMapper;
import com.example.model.Pelajaran;
import com.example.model.Pemesanan;
import com.example.model.Topik;
import com.example.model.User;

@Service
@Primary
public class MainServiceDatabase implements MainService
{
    @Autowired
    private MainMapper mainMapper;

    @Override
    public User selectUser (String email)
    {
        return mainMapper.selectUser (email);
    }

	@Override
	public List<User> selectAllUsers() {
		// TODO Auto-generated method stub
		return mainMapper.selectAllUsers ();
	}

	@Override
	public Pelajaran selectPelajaran(String id) {
		// TODO Auto-generated method stub
		return mainMapper.selectPelajaran (id);
	}

	@Override
	public List<Pelajaran> selectAllPelajaran() {
		// TODO Auto-generated method stub
		return mainMapper.selectAllPelajaran ();
	}

	@Override
	public Topik selectTopik(String id) {
		// TODO Auto-generated method stub
		return mainMapper.selectTopik (id);
	}

	@Override
	public List<Topik> selectAllTopik() {
		// TODO Auto-generated method stub
		return mainMapper.selectAllTopik ();
	}

	@Override
	public Pemesanan selectPemesanan(String id) {
		// TODO Auto-generated method stub
		return mainMapper.selectPemesanan (id);
	}

	@Override
	public List<Pemesanan> selectAllPemesanan() {
		// TODO Auto-generated method stub
		return mainMapper.selectAllPemesanan ();
	}

	@Override
	public void addPemesanan(Pemesanan pemesanan) {
		// TODO Auto-generated method stub
		mainMapper.addPemesanan(pemesanan);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		mainMapper.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		mainMapper.updateUser(user);
	}

	@Override
	public void updatePemesanan(String id, String guru) {
		// TODO Auto-generated method stub
		mainMapper.updatePemesananGuru(id, guru);
	}

	@Override
	public void updatePemesanan(String id, String komentar, int rating) {
		// TODO Auto-generated method stub
		mainMapper.updatePemesananKomentar(id, komentar, rating);
	}

	@Override
	public void updatePemesanan(String id, Date waktu_selesai) {
		// TODO Auto-generated method stub
		mainMapper.updatePemesananSelesai(id, waktu_selesai);
	}

	@Override
	public List<Pemesanan> selectAllPemesananByGuru() {
		// TODO Auto-generated method stub
		return mainMapper.selectAllPemesananByGuru();
	}

	@Override
	public List<Pemesanan> selectPemesananByUserProgres(String email) {
		// TODO Auto-generated method stub
		return mainMapper.selectPemesananByUserProgres(email);
	}

	@Override
	public List<Pemesanan> selectPemesananByUserDone(String email) {
		// TODO Auto-generated method stub
		return mainMapper.selectPemesananByUserDone(email);
	}

	@Override
	public List<Pemesanan> selectPemesananByGuruProgres(String email) {
		// TODO Auto-generated method stub
		return mainMapper.selectPemesananByGuruProgres(email);
	}

	@Override
	public List<Pemesanan> selectPemesananByGuruDone(String email) {
		// TODO Auto-generated method stub
		return mainMapper.selectPemesananByGuruDone(email);
	}

}
