package Buku_Induk.Kelas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;

public class mahasiswa {
    private static String nama, prodi, nim, search;
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


    public JSONObject getMahasiswa() {
//        query = "SELECT m.mhs_nim, m.mhs_nama, m.mhs_jk, m.angkatan, p.prodi FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 ORDER BY m.angkatan DESC LIMIT 600";
        query = "SELECT * FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 ORDER BY m.angkatan DESC, m.mhs_nim ASC  LIMIT 2000000";
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
        query = "SELECT * FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 AND p.prodi = '"+ prodi +"' AND m.angkatan = "+ angkatan +" ORDER BY m.angkatan DESC LIMIT 2000000";
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
        query = "SELECT * FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 AND p.deleted = 0  AND p.prodi IS NOT NULL AND m.mhs_nim like '%"+search+"%' OR m.mhs_nama like '%"+search+"%' ORDER BY m.angkatan DESC LIMIT 2000000";
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

        public static ImageIcon base64ToImage(String base64String, int width, int height) {
        try {
            if (base64String.contains(",")) {
                base64String = base64String.split(",")[1];
            }
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
            BufferedImage bufferedImage = ImageIO.read(bis);
            ImageIcon image = new ImageIcon(bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
             return null;
        }
    }
         public JSONObject jumlahMahasiswa() {
        query = "SELECT COUNT(mhs_nim) AS jumlah_mhs FROM t_mhs WHERE deleted = 0";
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


