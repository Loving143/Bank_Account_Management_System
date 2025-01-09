package com.bank.strategyPattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.Repository.CustomerRepository;
import com.bank.Repository.DocumentTypeRepository;
import com.bank.dto.AddDocumentRequest;
import com.bank.entity.Address;
import com.bank.entity.Customer;
import com.bank.entity.Document;
import com.bank.entity.Person;
import com.bank.exception.BadRequestException;
import com.bank.master.DocumentType;

@Component
public class CustomerRegistrationStrategy<T> implements RegistrationBehaviour<T> {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Override
	public void register(Person person,T t) {
		Map<String, Object> data = (Map<String, Object>) t;
		validateCustomerRegistration(data);
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
		if(documents.size()<2) {
//			throw new BadRequestException("Both pan card and aadhaar card documents are required");
		}
		Person customer = new Customer(data);
		System.out.println(customer);
		customerRepository.save((Customer)customer);
	}
	
	public void validateCustomerRegistration(Map<String,Object>data) {
		if(customerRepository.existsByEmail((String)data.get("email")))
			throw new BadRequestException("Email already exists.Please use another email");
		if(customerRepository.existsByPhoneNo((String)data.get("phoneNo")))
			throw new BadRequestException("Phone number already exists!");
		if(customerRepository.existsByPanCard((String)data.get("panCard")))
			throw new BadRequestException("Pancard already exists!");
		if(customerRepository.existsByAadhaarCard((String)data.get("aadhaarCard")))
			throw new BadRequestException("AadhaarCard already exists!");
		if((Integer)data.get("age")<18)
			throw new BadRequestException("Customer age should be minimum 18 years!");
	}
}
