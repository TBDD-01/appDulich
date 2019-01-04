package com.example.asus.appdulich.HDV;

import android.support.v7.app.AppCompatActivity;

public class HDV_Activity extends AppCompatActivity {

//    ListView listView;
////    List<HDV> arrayHDV;
//    ListAdapter HDVAdapter;
//    String url ="http://172.20.10.2/dulich/HDV";
//    private void Getdata(String url){
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for (int i =0 ; i<response.length();i++){
//                    try {
//                        JSONObject object = response.getJSONObject(i);
//                        arrayHDV.add(new HDV(
//                                object.getInt("idHDV"),
//                                object.getString("name"),
//                                object.getString("username"),
//                                object.getString("password"),
//                                object.getString("email"),
//                                object.getString("chungchi")
//                        ));
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                        Toast.makeText(HDV_Activity.this, "", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                //tourAdapter.notifyDataSetChanged();
////                tourAdapter = new TourAdapter(TourActivity.this,R.layout.tour_detail,arrayTourList);
//                HDVAdapter = new ListAdapter(this,test);
//                listView.setAdapter(HDVAdapter);


//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(HDV_Activity.this, error.toString(), Toast.LENGTH_SHORT).show();
//                Log.d("error",error.toString());
//            }
//        });
//        requestQueue.add(jsonArrayRequest);

//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_test);
//        listView = findViewById(R.id.listfortest);
//        arrayHDV = new ArrayList<>();

//        Getdata(url);
//        Toast.makeText(this,removeAccent("IT"),Toast.LENGTH_SHORT);
//    }
//
//    public static String removeAccent(String s){
//        String temp = Normalizer.normalize(s,Normalizer.Form.NFD);
//        Pattern pattern = Pattern.compile("\\p{InCOMBINING_DIACRITICAL_MARKS}+");
//        return pattern.matcher(temp).replaceAll("");
//    }

}
