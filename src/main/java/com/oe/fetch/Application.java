package com.oe.fetch;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oe.util.HttpUtils;

@Controller
@SpringBootApplication
@EnableScheduling
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() throws Exception {
		String sendGet = HttpUtils.sendGet("https://www.baidu.com");
		Document doc = Jsoup.parse(sendGet);
		System.out.println(doc);
		Elements root = doc.select("title");
		System.out.println(root);
		
		/*for (Element element : root) {
			System.out.println(element);
			System.out.println(element.text());
			System.out.println(element.attr("action"));
		}*/
		
		return sendGet;
	}

}
