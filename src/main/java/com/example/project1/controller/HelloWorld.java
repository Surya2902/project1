package com.example.project1.controller;

import com.example.project1.dto.HelloWorldDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class HelloWorld {
    int[] arr = {4};

    @GetMapping("/")
    public int[] getAllNumbers(){
        return arr;
    }

    @GetMapping("/{index}")
    public int getNumber(@PathVariable(name="index",required=true)String index){
        int indexNumber=Integer.parseInt(index);
        return arr[indexNumber];
    }

    @DeleteMapping("/")
    public int[] deleteAllNumbers(){
        arr = null;
        return arr;
    }

    @DeleteMapping("/{index}")
    public int[] deleteNumber(@PathVariable(name="index",required=true)String index) {
        int i = Integer.parseInt(index);
        for(int j=i;j<arr.length-1;j++)
        {
            arr[j]=arr[j+1];
        }
        arr= Arrays.copyOf(arr,arr.length-1);
        return arr;
    }

    @PostMapping("/")
    public int[] createNumbers(@RequestBody HelloWorldDto helloWorldDto){
        arr = helloWorldDto.getNumbers();
        return arr;
    }
}

