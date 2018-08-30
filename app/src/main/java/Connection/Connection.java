package Connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.heshammuhammed.ta3ala2ma2a2olkadmin.MainActivity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HeshamMuhammed on 5/24/2018.
 */

public class Connection {


//   public static final String BASE_URL = "https://t3ala2ma2olk.herokuapp.com";
//    public static String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTI5NTUyMjIzLCJpYXQiOjE1Mjg5NDc0MjN9.6svkORCdANNwJt_O6CjkH9X769ieEFfRGL1O4XgKKEOOA0bUKeMgGD7pfnMGggjeqqp0drWPbOGDeMvzfc_Xlw";
//    static private Retrofit retrofit;
//    static private OkHttpClient httpClient;
//    static private Retrofit.Builder builder;
//
//    public static Retrofit getConnection() {
//        int cacheSize = 10 * 1024 * 1024; // 50 MiB
//        Cache cache = new Cache(MainActivity.getAppContext().getCacheDir(), cacheSize);
//
//        httpClient = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
//                .writeTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
//                .cache(cache)
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public okhttp3.Response intercept(Chain chain) throws IOException {
//
//                        if (!isNetworkAvalaiable()) {
//                            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
//
//                            cacheBuilder.maxStale(365, TimeUnit.DAYS);
//                            cacheBuilder.onlyIfCached();
//                            return chain.proceed(chain.request().newBuilder().cacheControl(cacheBuilder.build()).build());
//                        }
//
//                        return chain.proceed(chain.request());
//                    }
//                })
//                .addNetworkInterceptor(new Interceptor() {
//                    @Override
//                    public okhttp3.Response intercept(Chain chain) throws IOException {
//                        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
//
//                        if (isNetworkAvalaiable()) {
//                            cacheBuilder.maxAge(10, TimeUnit.SECONDS);
//                            okhttp3.Response response = chain.proceed(chain.request());
//                            return response.newBuilder()
//                                    .removeHeader("Pragma")
//                                    .removeHeader("Cache-Control")
//                                    .header("Cache-Control", cacheBuilder.build().toString())
//                                    .build();
//                        }
//
//                        return chain.proceed(chain.request());
//                    }
//                }).build();
//
//
//        builder = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create());
//        retrofit = builder.client(httpClient).build();
//        return retrofit;
//    }
//
//    public static boolean isNetworkAvalaiable(){
//        ConnectivityManager connectivityManager = (ConnectivityManager) MainActivity.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//    }
//}

    public static final String BASE_URL = "https://t3ala2ma2olk.herokuapp.com/";

    public static String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTI5OTM4OTE1LCJpYXQiOjE1MjkzMzQxMTV9.vitHfGuIqFv_z7LtsT4gGKKG5mMP7oFGrYBDA59533L7ArGwSzaFvwcZyvcJ7glDWWDJNCn30e8fxJjLgDRuMA";
    public static Retrofit retrofit = null;

    public static Retrofit getConnection() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
        return retrofit;
    }
}