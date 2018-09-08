package com.oe.fetch.quartz;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.oe.fetch.props.Constans;
@Controller
public class FetchJob {
	@Resource
	Constans consts;
	
//	@Scheduled(fixedRate = 2000)
	@Scheduled(cron = "0/5 * * * * ?")
	public void fetch() {
		System.out.println(consts.getUrl());
		System.out.println("running");
	}
}
