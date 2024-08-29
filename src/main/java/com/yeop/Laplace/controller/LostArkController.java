package com.yeop.Laplace.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeop.Laplace.VO.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/loa")
public class LostArkController {

    static final String apiKey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyIsImtpZCI6IktYMk40TkRDSTJ5NTA5NWpjTWk5TllqY2lyZyJ9.eyJpc3MiOiJodHRwczovL2x1ZHkuZ2FtZS5vbnN0b3ZlLmNvbSIsImF1ZCI6Imh0dHBzOi8vbHVkeS5nYW1lLm9uc3RvdmUuY29tL3Jlc291cmNlcyIsImNsaWVudF9pZCI6IjEwMDAwMDAwMDA1NDc3MDcifQ.mo9WzWy4tGvl9Ih2Ulv7-M3xRLzbY56zNvkN13LC-9kQmOjvIRTEgyso_7Gezk8jKwcif-R_7T6h4odGRhtzrpTRYSJU4lwYFN9k_vORisYK5rJomY6EGfB7Igep8sHl41TVP6m3BWNQJ2NYVVpDEHrUzXmpidXj2a1uFOCfwhCeCtx9VG3du4Dqa9C4yTFfYmB0AS7TcE9a6oeveYbe7IVElVY9StLvBNiodYGY6KdaUXM6_nBegCEDPZCyLZNovjO45IAfIhsPAkzpTD6FCQzz30DaekF6DO-WhemqfxHt-RbuxVC0ZjEU90IaLleHRMX7deuqjBEjQ4BxZXrlUw";

    @GetMapping("")
    public Character getUser(){
        String url = "https://developer-lostark.game.onstove.com/armories/characters/%EB%82%98%EB%AF%BC%EC%97%BD%EC%B4%9D/profiles";
        HttpClient client = HttpClient.newHttpClient();
        String responseBody = "";
        JsonNode jsonNode = null;
        Character character = null;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization","Bearer "+apiKey)
                .header("Accept","application/json")
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                responseBody = response.body();
                ObjectMapper mapper = new ObjectMapper();
                character = mapper.readValue(responseBody,Character.class);

            }else{

            }
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

        return character;

    }
}
