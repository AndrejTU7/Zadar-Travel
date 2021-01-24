package zadartravel.studioadriatic.com.zadartravel;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    public static final String API_LIST_URL = "http://www.zadar.travel/json.php?tag=lokacija&sort=cro365";
    private RecyclerView mRecyclerView;
    private ZadarTravelAdapter mZadarTravelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(this, API_LIST_URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    JSONObject json = new JSONObject(new String(responseBody, "UTF-8"));
                    JSONArray list = json.getJSONArray("lokacije");
                    final ArrayList<ZadarModel> zadarlist = new ArrayList<ZadarModel>();
                    for (int i = 0; i < list.length(); i++) {
                        ZadarModel model = new ZadarModel();// inicijaliziranje klase
                        JSONObject item = list.getJSONObject(i);
                        model.setId_lokacija(String.valueOf(item.getString("id_lokacija")));
                        model.setId_smjestaj(String.valueOf(item.getString("id_smjestaj")));
                        model.setNaziv(String.valueOf(item.getString("naziv")));
                        model.setVrsta(String.valueOf(item.getString("vrsta")));
                        model.setTelefon(String.valueOf(item.getString("telefon")));
                        model.setMobitel(String.valueOf(item.getString("mobitel")));
                        model.setAdresa(String.valueOf(item.getString("adresa")));
                        model.setEmail(String.valueOf(item.getString("email")));
                        model.setZvjezdice(Integer.valueOf(item.getString("zvjezdice")));
                        model.setWeb(String.valueOf(item.getString("web")));
                        model.setDuzina(Double.valueOf(item.getString("duzina")));
                        model.setSirina(Double.valueOf(item.getString("sirina")));
                        model.setBrojlezajeva(Integer.valueOf(item.getString("brojlezajeva")));
                        model.setInternet(Integer.valueOf(item.getString("internet")));
                        model.setKlima(Integer.valueOf(item.getString("klima")));
                        model.setCroatia365(Integer.valueOf(item.getString("croatia365")));
                        model.setImages("http://zadar.travel/images/thumb10/"+item.getString("images"));
                        //model.setOdmora(Integer.valueOf(item.getString("odmora")));
                        //model.setOdcentra(Integer.valueOf(item.getString("odcentra")));
                        model.setKucniljubimci(Integer.valueOf(item.getString("kucniljubimci")));
                        //model.setDostupno(Integer.valueOf(item.getString("dostupno")));
                        zadarlist.add(model);
                    }
                    mZadarTravelAdapter = new ZadarTravelAdapter(MainActivity.this, zadarlist, R.layout.item_layout);// dodajem adapter
                    LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
                    mRecyclerView.setLayoutManager(llm);
                    mRecyclerView.setAdapter(mZadarTravelAdapter);// namještam na recycler viewu adapter
                    mZadarTravelAdapter.setOnItemClickListener(new ZadarTravelAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(ZadarModel model) {
                            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                            intent.putExtra(DetailsActivity.ZADARMODEL, model);
                            startActivity(intent);
                        }


                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });



    };
}
