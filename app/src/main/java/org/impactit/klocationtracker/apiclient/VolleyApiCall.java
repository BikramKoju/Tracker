package org.impactit.klocationtracker.apiclient;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.impactit.klocationtracker.MySingleton;

import java.util.Map;

/**
 * Created by Bikram Koju on 4/25/18.
 * ImpactIT
 * info@impactit.org
 */
public class VolleyApiCall {
    private Context context;


    public VolleyApiCall(Context context) {
        this.context = context;
    }


    public void volleyPost(final String url, final Map<String, String> post_body, final VolleyCallback callback) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccessResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getParams() {
                return post_body;
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded";
            }
        };
        MySingleton.getInstance(this.context).addToRequestQueue(request);
    }


}
