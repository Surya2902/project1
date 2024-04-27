package com.example.project1.controller;

import com.example.project1.dto.HelloWorldDto;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class HelloWorld {
    int[] arr = {4,5,6};

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
    public int[] insertNumbers(@RequestBody HelloWorldDto helloWorldDto ){
        int [] insertArray = helloWorldDto.getNumbers();

        int aLen = arr.length;
        int bLen = insertArray.length;
        int[] result = new int[aLen + bLen];

        System.arraycopy(arr, 0, result, 0, aLen);
        System.arraycopy(insertArray, 0, result, aLen, bLen);

        arr=result;

        return result;
    }
    @PutMapping("/")
    public int[] updateNumbers(@RequestBody HelloWorldDto helloWorldDto){
        arr = helloWorldDto.getNumbers();
        return arr;
    }
    @PatchMapping("/{index}")
    public int[] editNumber(@PathVariable(name="index",required=true)String index,@RequestBody HelloWorldDto helloWorldDto){
        int indexNumber=Integer.parseInt(index);
        int [] insertArray = helloWorldDto.getNumbers();
        int aLen = arr.length;
        int bLen = insertArray.length;
        int[] result = new int[(aLen+bLen)-1];
        System.arraycopy(arr, 0, result, 0, indexNumber);
        System.arraycopy(insertArray, 0, result, indexNumber, bLen);
        System.arraycopy(arr, indexNumber+1, result, indexNumber + bLen, aLen-(indexNumber+1));
        arr=result;
        return arr;
    }
}

