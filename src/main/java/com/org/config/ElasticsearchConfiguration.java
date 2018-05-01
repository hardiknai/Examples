//package com.org.config;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.InetSocketAddress;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.node.NodeBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.org.es.repository")
//public class ElasticsearchConfiguration {
//
//	@Value("${elasticsearch.jest.proxy.host:10.10.10.124}")
//	private String hostname;
//
//	@Value("${elasticsearch.jest.proxy.port:9300}")
//	private int port;
//	
//	
//	public Client client() {
//	
//		TransportClient client = TransportClient.builder().build();
//		TransportAddress transportAddress =new InetSocketTransportAddress(new InetSocketAddress(hostname, port));
//		client.addTransportAddresses(transportAddress);
//		return client;
//	}
//	
//	@Bean
//	public ElasticsearchTemplate elasticsearchTemplate(){
//		File tmpDir = null;
//		try {
//			tmpDir = File.createTempFile("temp-elastic",Long.toString(System.nanoTime()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		Settings.Builder elastucSearchSetting = Settings.settingsBuilder().
//				put("http.enabled",true)
//				.put("index.number_of_shards","1")
//				.put("path.data",new File(tmpDir,"data").getAbsolutePath())
//				.put("path.logs",new File(tmpDir,"logs").getAbsolutePath())
//				.put("path.work",new File(tmpDir,"work").getAbsolutePath())
//				.put("path.home",tmpDir);
//		return new ElasticsearchTemplate(nodeBuilder().local(true).settings(elastucSearchSetting.build()).node().client());
//	}
//	
//	@Bean
//	public NodeBuilder nodeBuilder() {
//		return new NodeBuilder();
//	}
//}