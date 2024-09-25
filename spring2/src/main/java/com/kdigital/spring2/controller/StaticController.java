package com.kdigital.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {
   
   @GetMapping("/image") // localhost:9000/image
   public String image() {
      return "image";
   }
   @GetMapping("/CSS") 
   public String CSS() {
      return "CSS";
   }
   @GetMapping("/javascript") 
   public String javascript() {
      return "javascript";
   }
   
}