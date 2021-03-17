package com.hsbc.mastergroupservice.MastergroupMapping.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.mastergroupservice.MastergroupMapping.bean.MastergroupBean;
@Service
public class MasterGroupServiceImpl implements MastergroupService {

	@Override
	public List<MastergroupBean> readcsvfile(String file) {
		BufferedReader fileReader = null;
		CSVParser csvParser = null;

		List<MastergroupBean> mgroup = new ArrayList<>();
		
		try {
			fileReader = new BufferedReader(new FileReader(file));
			csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
 
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			for (CSVRecord csvRecord : csvRecords) {
				MastergroupBean mgroup1 = new MastergroupBean(
						csvRecord.get("cin"),
						csvRecord.get("siteCustomerName"),
						csvRecord.get("mastergroupid")
						);
				
				mgroup.add(mgroup1);
			}
 
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvParser.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader/csvParser Error!");
				e.printStackTrace();
			}
		}
		
		return mgroup;
	
	}

	@Override
	public String csvtojson() {
		List<MastergroupBean> mgroup=readcsvfile("D:\\Spring_Orielly_Workspace\\MastergroupMapping\\src\\main\\resources\\namee.csv");
		ObjectMapper mapper = new ObjectMapper();
    	String jsonString = "";
    	
    	try {
    		jsonString = mapper.writeValueAsString(mgroup);
    	} catch (JsonProcessingException e) {
    		e.printStackTrace();
    	}
    	
    	return jsonString; 
		
	}

}
