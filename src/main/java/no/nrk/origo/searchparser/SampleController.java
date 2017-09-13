package no.nrk.origo.searchparser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONTokener;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.restexpress.Request;
import org.restexpress.Response;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class SampleController {
    public SampleController() {
        super();
    }

    public Object create(Request request, Response response) {
        //TODO: Your 'POST' logic here...
        return null;
    }

    public Object read(Request request, Response response) throws IOException {
        response.setContentType("application/json");
        response.addHeader("Cache-Control", "no-cache");
//        String json = "[{album_id:1,album_title:'album1'},{album_id:2,album_title:'album2'}]";
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("abc", "123456");
        map.put("def", "hmm");
        list.add(map);

        //1. Convert object to JSON string
        Gson gson = new Gson();
        String jsonFormattedString;
        String json = gson.toJson(list);
        try {
            jsonFormattedString = new JSONTokener(json).nextValue().toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("list.json")) {

            gson.toJson(list, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        JsonWriter writer = new JsonWriter(out);
        //set indentation for pretty print
        writer.setIndent("\t");
        //start writing
        writer.beginObject();

        writer.name("myStuff").value(json);
        writer.endObject();

        writer.flush();
        //close writer
        writer.close();

//        return  gson.toJson(list);
        return json.replaceAll("\\\\", "");
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
