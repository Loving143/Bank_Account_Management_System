package com.bank.updation.strategypattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Repository.CustomerRepository;
import com.bank.Repository.DocumentTypeRepository;
import com.bank.dto.AddDocumentRequest;
import com.bank.entity.Address;
import com.bank.entity.Customer;
import com.bank.entity.Document;
import com.bank.enumm.DynamicResponse;
import com.bank.exception.BadRequestException;
import com.bank.fetch.factorydesignpattern.FetchClassStrategyFactory;
import com.bank.master.DocumentType;
import com.bank.services.EntityService;

@Service
public class CustomerUpdationStrategy<Type,T> implements UpdationBehaviour<Type,T>{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EntityService entityService;
	
	@Autowired DocumentTypeRepository documentTypeRepository;

	@Autowired
	private FetchClassStrategyFactory fetchClassStrategyFactory;
	
	@Override
	public void update(Type type,T t,Integer id) {
		Map<String,Object>data = (Map<String,Object>)t;
		validateCustomerUpdation(data,id);
		DynamicResponse response = entityService.fetchEntityById(fetchClassStrategyFactory.getClassStrategy((String)type),id);
		Customer customer =(Customer) response.getData().get("customer");
		
		Set<Document>documents = new HashSet();
		Set<AddDocumentRequest>documentsReq=null;
		
		List<Map<String, Object>> documentLists = (List<Map<String, Object>>) data.get("documents");
		    if (documentLists != null) {
		    	documentsReq = documentLists.stream()
		                                    .map(AddDocumentRequest::new) // Use Address constructor to convert each map
		                                    .collect(Collectors.toSet());
		    } else {
		    	documentsReq = new HashSet<>(); // Default to an empty set if addresses are null
		    }
		    
		 List<AddDocumentRequest>docRequest = new ArrayList(documentsReq);
		for(AddDocumentRequest docReq: docRequest ) {
			System.out.println(docReq.getDocExtension()+"docExt"+docReq.getDocumentTypeId()+"tere");
			if(!docReq.getDocExtension().equals(".pdf"))
				throw new BadRequestException("Document uploaded is not in a pdf format");
			if(!documentTypeRepository.existsById(docReq.getDocumentTypeId())) {
				throw new BadRequestException("Document Type Id does not exists!");
			}
			Optional<DocumentType> docType = documentTypeRepository.findById(docReq.getDocumentTypeId());
			String cv = docType.get().getDocTypeCode();
					Document doc = new Document(docReq,docType.get());
			documents.add(doc);
		}
		customer.setDocuments(documents);
		if(documents.size()<2) {
//			throw new BadRequestException("Both pan card and aadhaar card documents are required");
		}
		 List<Map<String, Object>> addressList = (List<Map<String, Object>>) data.get("addresses");
		 if (addressList != null) {
		        customer.setAddresses(addressList.stream()
		                                    .map(Address::new) // Use Address constructor to convert each map
		                                    .collect(Collectors.toSet()));
		    } else {
		        customer.setAddresses(new HashSet<>()); // Default to an empty set if addresses are null
		    }
		 customer.setUserName((String)data.get("name"));
		customer.setAadhaarCard((String)data.get("aadhaarCard"));
		customer.setEmail((String)data.get("email"));
		customer.setPanCard((String)data.get("panCard"));
		customer.setPhoneNo((String)data.get("phoneNo"));
		customerRepository.save((Customer)customer);
		
	}
	
	public void validateCustomerUpdation(Map<String,Object>data,Integer id) {
		if(customerRepository.existsByEmailAndIdNot((String)data.get("email"),id))
			throw new BadRequestException("Email already exists.Please use another email");
		if(customerRepository.existsByPhoneNoAndIdNot((String)data.get("phoneNo"),id))
			throw new BadRequestException("Phone number already exists!");
		if(customerRepository.existsByPanCardAndIdNot((String)data.get("panCard"),id))
			throw new BadRequestException("Pancard already exists!");
		if(customerRepository.existsByAadhaarCardAndIdNot((String)data.get("aadhaarCard"),id))
			throw new BadRequestException("AadhaarCard already exists!");
		if((Integer)data.get("age")<18)
			throw new BadRequestException("Customer age should be minimum 18 years!");
	}

}
