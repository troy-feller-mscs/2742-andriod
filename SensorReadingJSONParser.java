package southeast.edu;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class SensorReadingJSONParser {
    private static String json = "{}";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<SensorReading> getSensorReadings(String json) {
        ArrayList<SensorReading> sensorReadings = new ArrayList<SensorReading>();
        try {
            JSONObject obj = new JSONObject(SensorReadingJSONParser.json);
            JSONArray jsonReadings = obj.getJSONArray("readings");
            if (jsonReadings != null) {
                for (int i = 0; i < jsonReadings.length(); i++) {
                    try {
                        JSONObject jsonSensorReading = (JSONObject) jsonReadings.get(i);
                        SensorReading sensorReading = null;
                        int sensorReadingId = jsonSensorReading.getInt("sensorReadingId");
                        int sensorId = jsonSensorReading.getInt("sensorId");
                        String strDateTime = jsonSensorReading.getString("dateTime");
                        LocalDateTime localDateTime = LocalDateTime.parse(strDateTime);
                        float value = (float) jsonSensorReading.getDouble("value");
                        sensorReading = new SensorReading(sensorReadingId, sensorId, localDateTime, value);
                        sensorReadings.add(sensorReading);
                    } catch (JSONException e) {
                        System.out.println(e);
                    } catch (DateTimeParseException e) {
                        System.out.println(e);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
        catch (JSONException e) {
            System.out.println(e);
        }
            return sensorReadings;
    }
}