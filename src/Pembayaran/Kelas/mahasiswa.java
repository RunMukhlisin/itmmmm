/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pembayaran.Kelas;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author X1 Carbon
 */
public class mahasiswa {
    private static String nama, prodi, nim, search, koneksi;
    private static int semester, angkatan;
    String token = "ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49";
    String query;
    private static JSONArray dataMhs;
    private static int baris;
    
      public static int getBaris() {
        return baris;
    }

    public static void setBaris(int baris) {
        mahasiswa.baris = baris;
    }

    public static JSONArray getDataMhs() {
        return dataMhs;
    }

    public static void setDataMhs(JSONArray dataMhs) {
        mahasiswa.dataMhs = dataMhs;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        mahasiswa.nama = nama;
    }

    public static String getProdi() {
        return prodi;
    }

    public static void setProdi(String prodi) {
        mahasiswa.prodi = prodi;
    }

    public static int getSemester() {
        return semester;
    }

    public static void setSemester(int semester) {
        mahasiswa.semester = semester;
    }

    public static int getAngkatan() {
        return angkatan;
    }

    public static void setAngkatan(int angkatan) {
        mahasiswa.angkatan = angkatan;
    }

    public static String getNim() {
        return nim;
    }

    public static void setNim(String nim) {
        mahasiswa.nim = nim;
    }

    public static String getSearch() {
        return search;
    }

    public static void setSearch(String search) {
        mahasiswa.search = search;
    }

    public static String getKoneksi() {
        return koneksi;
    }

    public static void setKoneksi(String koneksi) {
        mahasiswa.koneksi = koneksi;
    }

        

//    SELECT m.mhs_nim, m.mhs_nama, m.mhs_jk, m.angkatan, m.jalur_masuk, p.prodi FROM  t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id ORDER BY m.angkatan DESC LIMIT 600
    public JSONObject getMahasiswa() {
        query = "SELECT m.mhs_nim, m.mhs_nama, m.mhs_jk, m.angkatan, p.prodi FROM t_mhs m  LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id  WHERE m.deleted = 0 ORDER BY RAND()  LIMIT 25; ";
                
        JSONObject obj = null;
        try {
            HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                    .header("Content-Type", "application/json")
                    .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                    .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                    .asString();

            String jsonresponse = response.getBody();
            obj = new JSONObject(jsonresponse);
            int rows = obj.getInt("rows");
            JSONArray results = obj.getJSONArray("results");
            if (rows != 0) {
                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);
                }
            }
            koneksi = "true";
        } catch (UnirestException unirestException) {
            koneksi = "false";
        }
        return obj;
    }

    public JSONObject getAngkattan() {
        query = "SELECT DISTINCT angkatan FROM t_mhs where deleted = 0 ORDER BY angkatan DESC";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }

    public JSONObject getJurusan() {
        query = "SELECT DISTINCT prodi FROM t_prodi";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }

    public JSONObject tampilJurusan() {
        query = "SELECT m.mhs_nim, m.mhs_nama, m.mhs_jk, m.angkatan, m.jalur_masuk, p.prodi FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 AND p.prodi = '" + prodi + "' ORDER BY m.angkatan DESC LIMIT 18446744073709551615";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }

    public JSONObject tampilAngkatan() {
        query = "SELECT m.mhs_nim, m.mhs_nama, m.mhs_jk, m.angkatan, m.jalur_masuk, p.prodi FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 AND m.angkatan = " + angkatan + " ORDER BY m.angkatan DESC LIMIT 18446744073709551615";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }

    public JSONObject tampilDua() {
        query = "SELECT m.mhs_nim, m.mhs_nama, m.mhs_jk, m.angkatan, m.jalur_masuk, p.prodi FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 AND p.prodi = '" + prodi + "' AND m.angkatan = " + angkatan + " ORDER BY m.angkatan DESC LIMIT 18446744073709551615";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }

    public JSONObject getJalur() {
        query = "SELECT jalur_masuk FROM t_mhs where deleted = 0 AND mhs_nim = " + nim;
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }

    public JSONObject search() {
        query = "SELECT m.mhs_nim, m.mhs_nama, m.mhs_jk, m.angkatan, p.prodi FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 AND m.mhs_nim like '%" + search + "%' OR m.mhs_nama like '%" + search + "%' ORDER BY m.angkatan DESC LIMIT 18446744073709551615";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }

    public JSONObject searchNim() {
        query = "SELECT mhs_nim, mhs_nama FROM t_mhs WHERE deleted = 0 AND mhs_nim =" + nim;
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }
}
