package com.org.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.org.service.StorageService;


@Service
public class StorageServiceImpl implements StorageService {

	private final static Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);
	
	@Value("${file.upload:data/upload/}")
	private String input;
	
	public String store(MultipartFile uploadedFile) {
		File file = null;
		String text ="";
		try (InputStream inputStream = uploadedFile.getInputStream()){
			file = new File(input + uploadedFile.getOriginalFilename());
			Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			text = parseToPlainText(uploadedFile.getInputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("==========>" + text);
		return text;
		
	}

	private String extractTextToPdf(File file){
		String text = "";
		try (PDDocument document = PDDocument.load(file)){
			PDFTextStripper pdfStripper = new PDFTextStripper();
			text = pdfStripper.getText(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}
	
	public String parseToPlainText(InputStream inputStream) {
	    BodyContentHandler handler = new BodyContentHandler();
	    AutoDetectParser parser = new AutoDetectParser();
	    Metadata metadata = new Metadata();
	        try {
				parser.parse(inputStream, handler, metadata);
			} catch (IOException | SAXException | TikaException e) {
				e.printStackTrace();
			}
	        return handler.toString();
	}
	
}
