package com.app.androidnews.retrofitconfig;

public class RetrofitConfigToJson {

    public static String URL_API = "https://newsapi.org/";

    public static GetJsonAll getResponses(){

        return RetrofitInstance.getInstance(URL_API).create(GetJsonAll.class);

    }

}
