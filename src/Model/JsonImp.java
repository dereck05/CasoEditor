/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author naty9
 */
public class JsonImp implements IArchivo{
    public JsonImp(){}

    @Override
    public void guardar(String text, String fileName) {
        try {
            createJSON(fileName);
        } catch (IOException ex) {
            Logger.getLogger(JsonImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JSONObject textoJson = new JSONObject();
        textoJson.put("text", text);
        Type arrayListType = new TypeToken<ArrayList<JSONObject>>(){}.getType();
        try{
            FileReader fr = new FileReader(fileName);
            ArrayList<JSONObject> dtos = gson.fromJson(fr, arrayListType);
            fr.close();
            if(null==dtos) {
                dtos = new ArrayList<>();
            }
            dtos.add(textoJson);
            FileWriter fw  = new FileWriter(fileName);
            gson.toJson(dtos, fw);
            fw.close();
        } catch(Exception e){
            System.out.println("Error" + e);
        }
        
     } 

    @Override
    public String leer(String fileName) {
        String text = "";
        try(Reader reader = new FileReader(fileName)){
            Gson gson = new Gson(); 
            Type dtoListType = new TypeToken<ArrayList<JSONObject>>(){}.getType();
            ArrayList<JSONObject> dtos = gson.fromJson(reader, dtoListType);
            reader.close();
            for(JSONObject jsonObject: dtos){
                text = (String) jsonObject.get("text");
            }
            System.out.println("Texto json:" + text);
        }catch(Exception e){
            System.out.println("Error" + e);
        }
        return text;
    }
    
    public void createJSON(String fileName) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<JSONObject> dtos = new ArrayList<>();
        FileWriter fw  = new FileWriter(fileName);
        gson.toJson(dtos, fw); 
        fw.close();
    }
}
