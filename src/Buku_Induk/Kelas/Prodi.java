package Buku_Induk.Kelas;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;

public class Prodi {

    private static String prodi;

    String token = "ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49";
    String query;

    public static String getProdi() {
        return prodi;
    }

    public static void setProdi(String prodi) {
        Prodi.prodi = prodi;
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
        query = "SELECT * FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 AND p.prodi = '" + prodi + "' ORDER BY m.angkatan DESC LIMIT 2000000";
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

    public JSONObject jumlahJurusan() {
        query = "SELECT COUNT(DISTINCT prodi) AS jumlah_jurusan FROM t_prodi";
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
