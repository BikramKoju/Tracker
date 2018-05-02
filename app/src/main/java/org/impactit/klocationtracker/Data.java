package org.impactit.klocationtracker;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bikram Koju on 5/2/18.
 * ImpactIT
 * info@impactit.org
 */

@IgnoreExtraProperties
public class Data {
    private double latitute, longitude;

    Data(double latitute, double longitude) {
        this.latitute = latitute;
        this.longitude = longitude;
    }

    public Data() {
    }

    public double getLat() {
        return latitute;
    }


    public double getLng() {
        return longitude;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("latitute", latitute);
        result.put("longitude", longitude);
        return result;
    }


}
