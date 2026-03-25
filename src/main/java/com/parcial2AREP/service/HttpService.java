package com.parcial2AREP.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpService {

    private static final String AGENTE = "Mozilla/5.0";

    public String consumirGet(String url) {

        try {
            URL direccion = new URL(url);
            HttpURLConnection conexion = (HttpURLConnection) direccion.openConnection();

            conexion.setRequestMethod("GET");
            conexion.setRequestProperty("User-Agent", AGENTE);

            int codigo = conexion.getResponseCode();

            if (codigo == HttpURLConnection.HTTP_OK) {

                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(conexion.getInputStream())
                );

                String linea;
                StringBuilder contenido = new StringBuilder();

                while ((linea = lector.readLine()) != null) {
                    contenido.append(linea);
                }

                lector.close();
                return contenido.toString();

            } else {
                throw new RuntimeException("Error en GET: " + codigo);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error consumiendo URL: " + url, e);
        }
    }
}