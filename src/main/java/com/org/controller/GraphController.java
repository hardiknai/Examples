package com.org.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.config.RequestPath;
import com.org.model.DealStatusPercentage;

@RestController
public class GraphController {


	@GetMapping(RequestPath.Graph.DEAL_STATUS)
	public List<DealStatusPercentage> getAllBySearchAuditType(){
		List<DealStatusPercentage> dealStatus = new ArrayList<>();
		dealStatus.add(new DealStatusPercentage("REVIEWED", 1.3));
		dealStatus.add(new DealStatusPercentage("PUBLISHED", 1.3));
		dealStatus.add(new DealStatusPercentage("FAILED", 28.57));
		dealStatus.add(new DealStatusPercentage("ACTIVE", 36.36));
		dealStatus.add(new DealStatusPercentage("IN_PROCESS", 18.18));
		dealStatus.add(new DealStatusPercentage("DELETED", 2.6));
		dealStatus.add(new DealStatusPercentage("UNDER_REVIEW", 11.69));
		return dealStatus;
				
	}
}
