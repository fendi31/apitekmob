package com.example.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.Pelajaran;
import com.example.model.Pemesanan;
import com.example.model.Topik;
import com.example.model.User;

@Mapper
public interface MainMapper
{    
    @Select("select * from user where email = #{email}")
    User selectUser (@Param("email") String email);
    
    @Select("select * from user")
    List<User> selectAllUsers ();

    @Select("select * from pelajaran where id = #{id}")
    Pelajaran selectPelajaran (@Param("id") String id);
    
    @Select("select * from pelajaran")
    List<Pelajaran> selectAllPelajaran ();

    @Select("select * from topik where id = #{id}")
    Topik selectTopik (@Param("id") String id);
    
    @Select("select * from topik")
    List<Topik> selectAllTopik ();

    @Select("select * from pemesanan where id = #{id}")
    Pemesanan selectPemesanan (@Param("id") String id);
    
    @Select("select * from pemesanan")
    List<Pemesanan> selectAllPemesanan ();

    @Insert("INSERT INTO pemesanan VALUES (0, #{siswa}, #{guru}, #{waktu}, #{tingkat}, #{kelas}, #{pelajaran}, #{topik}, #{durasi}, #{catatan}, #{komentar}, #{harga}, #{rating}, #{waktu_selesai})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addPemesanan(Pemesanan pemesanan);

    @Insert("INSERT INTO user VALUES (0, #{email}, #{password}, #{role}, #{no_hp}, #{date_register}, #{date_delete}, #{picture}, #{tingkat}, #{sekolah})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void addUser(User user);

    @Update("UPDATE pemesanan SET "
    		+ "guru = #{guru} "
    		+ "WHERE id = #{id}")
	void updatePemesananGuru(@Param("id") String id, @Param("guru") String guru);

    @Update("UPDATE pemesanan SET "
    		+ "komentar = #{komentar}, "
    		+ "rating = #{rating} "
    		+ "WHERE id = #{id}")
	void updatePemesananKomentar(@Param("id") String id, @Param("komentar") String komentar, @Param("rating") int rating);

    @Update("UPDATE pemesanan SET "
    		+ "waktu_selesai = #{waktu_selesai} "
    		+ "WHERE id = #{id}")
	void updatePemesananSelesai(@Param("id") String id, @Param("waktu_selesai") Date waktu_selesai);

    @Select("select * from pemesanan where guru is null")
	List<Pemesanan> selectAllPemesananByGuru();

    @Select("select * from pemesanan where siswa = #{email} and waktu_selesai is null")
	List<Pemesanan> selectPemesananByUserProgres(String email);

    @Select("select * from pemesanan where siswa = #{email} and waktu_selesai is not null")
	List<Pemesanan> selectPemesananByUserDone(String email);

    @Select("select * from pemesanan where guru = #{email} and waktu_selesai is null")
	List<Pemesanan> selectPemesananByGuruDone(String email);

    @Select("select * from pemesanan where guru = #{email} and waktu_selesai is not null")
	List<Pemesanan> selectPemesananByGuruProgres(String email);

    @Update("UPDATE user SET email = #{email}, "
    		+ "password = #{password}, "
    		+ "no_hp = #{no_hp}, "
    		+ "picture = #{picture}, "
    		+ "tingkat = #{tingkat}, "
    		+ "sekolah = #{sekolah} "
    		+ "WHERE id = #{id}")
	void updateUser(User user);
    
}
