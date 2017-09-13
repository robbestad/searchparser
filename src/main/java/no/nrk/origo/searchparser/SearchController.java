package no.nrk.origo.searchparser;

import java.util.*;

import com.google.gson.GsonBuilder;
import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.common.query.QueryFilter;
import org.restexpress.common.query.QueryOrder;
import org.restexpress.common.query.QueryRange;
import org.restexpress.query.QueryFilters;
import org.restexpress.query.QueryOrders;
import org.restexpress.query.QueryRanges;

import java.util.List;

public class SearchController {
    public SearchController() {
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

    public void create(Request request, Response response) {
        //TODO: Your 'POST' logic here...
        System.out.println(request);
        response.setResponseCreated();
    }

    public Object read(Request request, Response response) throws Exception {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("Key1", "123456");
        map.put("Key2", "789123");
        list.add(map);

        response.setContentType("application/json");
        response.addHeader("Cache-Control", "no-cache");
        response.noSerialization();

        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(list);
    }

    public List<Object> readAll(Request request, Response response) {
        //TODO: Your 'GET collection' logic here...
        System.out.println("Read All");
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
