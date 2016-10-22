package com.example.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, List<Pemesanan>> viewAllPemesananByGuru()
    {
        List<Pemesanan> pemesanan = mainDAO.selectAllPemesananByGuru ();
		Map<String, List<Pemesanan>> result = new HashMap<String, List<Pemesanan>>();
		
        result.put("Android", pemesanan);
        
        return result;
    }
	
	@RequestMapping("/pemesanan/userProgres")
    public Map<String, List<Pemesanan>> viewPemesananByUserProgress(@RequestParam(value = "email") String email)
    {
		List<Pemesanan> pemesanan = mainDAO.selectPemesananByUserProgres (email);
		Map<String, List<Pemesanan>> result = new HashMap<String, List<Pemesanan>>();
		
        result.put("Android", pemesanan);
        
        return result;
    }
	
	@RequestMapping("/pemesanan/userDone")
    public Map<String, List<Pemesanan>> viewPemesananByUserDone(@RequestParam(value = "email") String email)
    {
		List<Pemesanan> pemesanan = mainDAO.selectPemesananByGuruDone (email);
		Map<String, List<Pemesanan>> result = new HashMap<String, List<Pemesanan>>();
		
        result.put("Android", pemesanan);
        
        return result;
    }
	
	@RequestMapping("/pemesanan/guruProgres")
    public Map<String, List<Pemesanan>> viewPemesananByGuruProgress(@RequestParam(value = "email") String email)
    {
		List<Pemesanan> pemesanan = mainDAO.selectPemesananByGuruProgres (email);
		Map<String, List<Pemesanan>> result = new HashMap<String, List<Pemesanan>>();
		
        result.put("Android", pemesanan);
        
        return result;
    }
	
	@RequestMapping("/pemesanan/guruDone")
    public Map<String, List<Pemesanan>> viewPemesananByGuruDone(@RequestParam(value = "email") String email)
    {
		List<Pemesanan> pemesanan = mainDAO.selectPemesananByUserDone (email);
		Map<String, List<Pemesanan>> result = new HashMap<String, List<Pemesanan>>();
		
        result.put("Android", pemesanan);
        
        return result;
    }
	
	@RequestMapping("/pemesanan/add")
    public Map<String, List<Pemesanan>> addPemesanan (
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
		List<Pemesanan> listPemesanan = new ArrayList<Pemesanan>();
		listPemesanan.add(pemesanan);
		Map<String, List<Pemesanan>> result = new HashMap<String, List<Pemesanan>>();
		
        result.put("Android", listPemesanan);
        
        return result;
    }
	
	@RequestMapping("/pemesanan/addGuru")
    public Map<String, List<Pemesanan>> addGuru (
    		@RequestParam(value = "id") String id,
    		@RequestParam(value = "guru") String guru)
    {
		mainDAO.updatePemesanan(id, guru);
        Pemesanan pemesanan = mainDAO.selectPemesanan(id);
		List<Pemesanan> listPemesanan = new ArrayList<Pemesanan>();
		listPemesanan.add(pemesanan);
		Map<String, List<Pemesanan>> result = new HashMap<String, List<Pemesanan>>();
		
        result.put("Android", listPemesanan);
        
        return result;
    }
	
	@RequestMapping("/pemesanan/addKomentar")
    public Map<String, List<Pemesanan>> addKomentar (
    		@RequestParam(value = "id") String id,
    		@RequestParam(value = "rating") int rating)
    {
		mainDAO.updatePemesanan(id, "", rating);
        Pemesanan pemesanan = mainDAO.selectPemesanan(id);
		List<Pemesanan> listPemesanan = new ArrayList<Pemesanan>();
		listPemesanan.add(pemesanan);
		Map<String, List<Pemesanan>> result = new HashMap<String, List<Pemesanan>>();
		
        result.put("Android", listPemesanan);
        
        return result;
    }

	@RequestMapping("/pemesanan/addSelesai")
    public Map<String, List<Pemesanan>> addSelesai (
    		@RequestParam(value = "id") String id)
    {
		mainDAO.updatePemesanan(id, new Date());
        Pemesanan pemesanan = mainDAO.selectPemesanan(id);
		List<Pemesanan> listPemesanan = new ArrayList<Pemesanan>();
		listPemesanan.add(pemesanan);
		Map<String, List<Pemesanan>> result = new HashMap<String, List<Pemesanan>>();
		
        result.put("Android", listPemesanan);
        
        return result;
    }
	
	@RequestMapping("/user/check")
    public Map<String, List<User>> checkEmail (
    		@RequestParam(value = "email") String email,
    		@RequestParam(value = "password") String password)
    {        
        User user = mainDAO.selectUser (email);
        List<User> users = new ArrayList<User>();
		Map<String, List<User>> result = new HashMap<String, List<User>>();
        if(user == null){
        	user = new User();
        	user.setStatus(false);
        	
            users.add(user);
            result.put("Android", users);
        	return result;
        }
        if(password.equals(user.getPassword())){
        	user.setStatus(true);
        }
        else{
        	user.setStatus(false);
        }

        users.add(user);
        result.put("Android", users);
        return result;
    }
}
