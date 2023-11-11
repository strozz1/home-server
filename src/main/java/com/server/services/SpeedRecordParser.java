package com.server.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.server.entitties.SpeedRecord;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SpeedRecordParser {
    public static SpeedRecord parse(String script) throws Exception {

        Runtime runtime = Runtime.getRuntime();

        Process process = runtime.exec(script);

        InputStream inputStream = process.getInputStream();

        StringBuilder stringBuilder = new StringBuilder();

        byte[] buffer = new byte[1024];

        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            stringBuilder.append(new String(buffer, 0, bytesRead));
        }

        String result = stringBuilder.toString();

        System.out.println("Script response: "+result);

        result=result.replaceAll("'","\"");
        SpeedRecord record = parseJSON(result);
        return record;
    }

    public static SpeedRecord parseJSON(String json) throws Exception {
        // Crea un parser JSON
        JSONParser parser = new JSONParser();

        // Parsea el JSON a un objeto JSONObject
        JSONObject jsonObject = (JSONObject) parser.parse(json);

        // Crea un nuevo `SpeedRecord`
        SpeedRecord record = new SpeedRecord();

        // Obtiene los valores del objeto JSONObject y los añade al `SpeedRecord`
        record.setTime(LocalDateTime.parse((String) jsonObject.get("time")));
        record.setPing(((Double) jsonObject.get("ping")).floatValue());
        record.setDownload(((Double) jsonObject.get("download")).floatValue());
        record.setUpload(((Double) jsonObject.get("upload")).floatValue());

        // Devuelve el `SpeedRecord`
        return record;
    }
}