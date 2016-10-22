package com.example.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pemesanan {
	private int id;
	private String siswa;
	private String guru;
	private Date waktu;
	private String tingkat;
	private int kelas;
	private String pelajaran;
	private String topik;
	private int durasi;
	private String catatan;
	private String komentar;
	private int harga;
	private int rating;
	private Date waktu_selesai;
}
