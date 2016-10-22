package com.example.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Pelajaran;
import com.example.model.Pemesanan;
import com.example.model.Topik;
import com.example.model.User;
import com.example.service.MainService;

@RestController
public class MainRestController {
	@Autowired
    MainService mainDAO;    
    
    @RequestMapping("/user/view/{email}")
    public User viewUser (@PathVariable(value = "email") String email)
    {
        User user = mainDAO.selectUser (email);
        return user;
    }

	@RequestMapping("/user/viewall")
    public List<User> viewAllUser()
    {
        List<User> users = mainDAO.selectAllUsers ();
        return users;
    }
	
	@RequestMapping("/user/add")
    public User addUser (
    		@RequestParam(value = "email") String email,
    		@RequestParam(value = "password") String password,
    		@RequestParam(value = "role") String role,
    		@RequestParam(value = "no_hp") String no_hp,
    		@RequestParam(value = "date_register") String date_register,
    		@RequestParam(value = "date_delete") String date_delete,
    		@RequestParam(value = "picture") String picture,
    		@RequestParam(value = "tingkat") String tingkat,
    		@RequestParam(value = "sekolah") String sekolah)
    {
		User user = new User(0, email, password, role, no_hp, date_register, date_delete, picture, tingkat, sekolah, false);
		mainDAO.addUser(user);
        return user;
    }
	
	@RequestMapping("/pelajaran/view/{id}")
    public Pelajaran viewPelajaran (@PathVariable(value = "id") String id)
    {
		Pelajaran pelajaran = mainDAO.selectPelajaran (id);
        return pelajaran;
    }

	@RequestMapping("/pelajaran/viewall")
    public List<Pelajaran> viewAllPelajaran()
    {
        List<Pelajaran> pelajaran = mainDAO.selectAllPelajaran ();
        return pelajaran;
    }
	
	@RequestMapping("/topik/view/{id}")
    public Topik viewTopik (@PathVariable(value = "id") String id)
    {
		Topik topik = mainDAO.selectTopik (id);
        return topik;
    }

	@RequestMapping("/topik/viewall")
    public List<Topik> viewAllTopik()
    {
        List<Topik> topik = mainDAO.selectAllTopik ();
        return topik;
    }
	
	@RequestMapping("/pemesanan/view/{id}")
    public Pemesanan viewPemesanan (@PathVariable(value = "id") String id)
    {
		Pemesanan pemesanan = mainDAO.selectPemesanan (id);
        return pemesanan;
    }

	@RequestMapping("/pemesanan/viewall")
    public List<Pemesanan> viewAllPemesanan()
    {
        List<Pemesanan> pemesanan = mainDAO.selectAllPemesanan ();
        return pemesanan;
    }
	
	@RequestMapping("/pemesanan/guru")
    public List<Pemesanan> viewAllPemesananByGuru()
    {
        List<Pemesanan> pemesanan = mainDAO.selectAllPemesananByGuru ();
        return pemesanan;
    }
	
	@RequestMapping("/pemesanan/userProgres")
    public List<Pemesanan> viewPemesananByUserProgress(@RequestParam(value = "email") String email)
    {
		List<Pemesanan> pemesanan = mainDAO.selectPemesananByUserProgres (email);
        return pemesanan;
    }
	
	@RequestMapping("/pemesanan/userDone")
    public List<Pemesanan> viewPemesananByUserDone(@RequestParam(value = "email") String email)
    {
		List<Pemesanan> pemesanan = mainDAO.selectPemesananByUserDone (email);
        return pemesanan;
    }
	
	@RequestMapping("/pemesanan/add")
    public Pemesanan addPemesanan (
    		@RequestParam(value = "siswa") String siswa,
    		@RequestParam(value = "tingkat") String tingkat,
    		@RequestParam(value = "kelas") int kelas,
    		@RequestParam(value = "pelajaran") String pelajaran,
    		@RequestParam(value = "topik") String topik,
    		@RequestParam(value = "durasi") int durasi,
    		@RequestParam(value = "catatan") String catatan,
    		@RequestParam(value = "harga") int harga)
    {
		Pemesanan pemesanan = new Pemesanan(0, siswa, null, new Date(), tingkat, kelas, pelajaran, topik, durasi, catatan, null, harga, -1, null);
		mainDAO.addPemesanan(pemesanan);
        return pemesanan;
    }
	
	@RequestMapping("/pemesanan/addGuru")
    public Pemesanan addGuru (
    		@RequestParam(value = "id") String id,
    		@RequestParam(value = "guru") String guru)
    {
		mainDAO.updatePemesanan(id, guru);
        return mainDAO.selectPemesanan(id);
    }
	
	@RequestMapping("/pemesanan/addKomentar")
    public Pemesanan addKomentar (
    		@RequestParam(value = "id") String id,
    		@RequestParam(value = "rating") int rating)
    {
		mainDAO.updatePemesanan(id, "", rating);
        return mainDAO.selectPemesanan(id);
    }

	@RequestMapping("/pemesanan/addSelesai")
    public Pemesanan addSelesai (
    		@RequestParam(value = "id") String id)
    {
		mainDAO.updatePemesanan(id, new Date());
        return mainDAO.selectPemesanan(id);
    }
	
	@RequestMapping("/user/check")
    public User checkEmail (
    		@RequestParam(value = "email") String email,
    		@RequestParam(value = "password") String password)
    {
        User user = mainDAO.selectUser (email);
        if(user == null){
        	user = new User();
        	user.setStatus(false);
        	return user;
        }
        if(password.equals(user.getPassword())){
        	user.setStatus(true);
        }
        else{
        	user.setStatus(false);
        }
        return user;
    }
}
