package no.nrk.origo.searchparser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;
import org.json.*;
import com.google.gson.Gson;
import org.restexpress.Request;
import org.restexpress.Response;

import java.util.List;

public class SampleController {
    public SampleController() {
        super();
    }

//    static List getKeysFromJson(JsonElement jsonObject) throws Exception {
//        Object things = new Gson().fromJson(jsonObject, Object.class);
//        List keys = new ArrayList();
//        collectAllTheKeys(keys, things);
//        return keys;
//    }
//
//    private static void collectAllTheKeys(List keys, Object o) {
//        Collection values = null;
//        if (o instanceof Map) {
//            Map map = (Map) o;
//            keys.addAll(map.keySet()); // collect keys at current level in hierarchy
//            values = map.values();
//        } else if (o instanceof Collection)
//            values = (Collection) o;
//        else // nothing further to collect keys from
//            return;
//
//        for (Object value : values)
//            collectAllTheKeys(keys, value);
//    }

    public Object create(Request request, Response response) {
        //TODO: Your 'POST' logic here...
        return null;
    }

    public Object read(Request request, Response response) throws Exception {
        response.setContentType("application/json");
        response.addHeader("Cache-Control", "no-cache");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Key1", "123456");
        map.put("Key2", "789123");
        list.add(map);

        Gson gson = new GsonBuilder().setPrettyPrinting()
                .create();
        String json = gson.toJson(list);
        response.noSerialization();
        return json;
    }

    public List<Object> readAll(Request request, Response response) {
        //TODO: Your 'GET collection' logic here...
        return Collections.emptyList();
    }

    public void update(Request request, Response response) {
        //TODO: Your 'PUT' logic here...
        response.setResponseNoContent();
    }

    public void delete(Request request, Response response) {
        //TODO: Your 'DELETE' logic here...
        response.setResponseNoContent();
    }
}
