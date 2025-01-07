package Buku_Induk.Kelas;



import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;


public class Angkatan {

    private static int angkatan;
    private static JSONArray dataANgkatan;
    String token = "ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49";
    String query;

    public static int getAngkatan() {
        return angkatan;
    }

    public static void setAngkatan(int angkatan) {
        Angkatan.angkatan = angkatan;
    }

    public static JSONArray getDataANgkatan() {
        return dataANgkatan;
    }

    public static void setDataANgkatan(JSONArray dataANgkatan) {
        Angkatan.dataANgkatan = dataANgkatan;
    }

    public JSONObject getAngkattan() {
        query = "SELECT DISTINCT angkatan  FROM t_mhs where deleted = 0 ORDER BY angkatan DESC";
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
//                String angk = item.getString("angkatan");
//                System.out.println(angk);
            }
        }
        return obj;
    }

    public JSONObject tampilAngkatan() {
        query = "SELECT * FROM t_mhs m LEFT JOIN t_prodi p ON m.prodi_id = p.prodi_id WHERE m.deleted = 0 AND m.angkatan = '" + angkatan + "' ORDER BY m.angkatan DESC LIMIT 2000000";
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

    public JSONObject jumlahAngkatan() {
        query = "SELECT COUNT(DISTINCT angkatan) AS jumlah_angkatan FROM t_mhs where deleted = 0 ORDER BY angkatan DESC";
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
//                String angk = item.getString("angkatan");
//                System.out.println(angk);
            }
        }
        return obj;
    }
}