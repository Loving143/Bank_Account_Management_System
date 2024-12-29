package com.bank.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Repository.CustomerRepository;
import com.bank.Repository.DocumentTypeRepository;
import com.bank.dto.AddCustomerRequest;
import com.bank.dto.AddDocumentRequest;
import com.bank.dto.AddressRequest;
import com.bank.entity.Address;
import com.bank.entity.Customer;
import com.bank.entity.Document;
import com.bank.exception.BadRequestException;
import com.bank.master.DocumentType;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DocumentTypeRepository documentTypeRepository;

	@Override
	public void addCustomer(AddCustomerRequest request) throws Exception {
		validateCustomer(request);
		Set<Document>documents = new HashSet();
		List<AddDocumentRequest>docRequest = new ArrayList(request.getDocuments());
		for(AddDocumentRequest docReq: docRequest ) {
			if(!docReq.getDocExtension().equals(".pdf"))
				throw new BadRequestException("Document uploaded is not in a pdf format");
			if(!documentTypeRepository.existsById(docReq.getDocumentTypeId())) {
				throw new Exception("Document Type Id does not exists!");
			}
			Optional<DocumentType> docType = documentTypeRepository.findById(docReq.getDocumentTypeId());
			String cv = docType.get().getDocTypeCode();
					Document doc = new Document(docReq,docType.get());
			documents.add(doc);
		}
		if(documents.size()<2) {
			throw new BadRequestException("Both pan card and aadhaar card documents are required");
		}
		Customer customer = new Customer(request,documents);
		customerRepository.save(customer);
		
	}

	private void validateCustomer(AddCustomerRequest request) {
		if(customerRepository.existsByEmail(request.getEmail()))
			throw new BadRequestException("Email already exists.Please use another email");
		if(customerRepository.existsByPhoneNo(request.getPhoneNo()))
			throw new BadRequestException("Phone number already exists!");
		if(customerRepository.existsByPanCard(request.getPanCard()))
			throw new BadRequestException("Pancard already exists!");
		if(customerRepository.existsByAadhaarCard(request.getAadhaarCard()))
			throw new BadRequestException("AadhaarCard already exists!");
		
		
	}

	@Override
	public void addAddressByCustomerId(Integer customerId, AddressRequest addressRequest) throws Exception {
		
		Address address = new Address(addressRequest);
		Optional<Customer>customer = customerRepository.findById(customerId);
		if(customer.isEmpty()) {
			throw new Exception("Customer does not exists!");
		}else {
			Customer cust = customer.get();
			cust.getAddresses().add(address);
			customerRepository.save(cust);
		}
	}

	@Override
	public List<Address> addressHistoryByCustomerId(Integer customerId) {
		return customerRepository.addRessHistoryByCustomerId(customerId);
	}

	@Override
	public List<Address> currentAddressHistoryByCustomerId(Integer customerId) {
		return customerRepository.currentAddRessHistoryByCustomerId(customerId);
	}

	@Override
	public List<Address> permanentAddressHistoryByCustomerId(Integer customerId) {
		return customerRepository.permanentAddressHistoryByCustomerId(customerId);
	}
	
	




	

}
