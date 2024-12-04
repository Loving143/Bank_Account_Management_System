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
import com.bank.master.DocumentType;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DocumentTypeRepository documentTypeRepository;

	@Override
	public void addCustomer(AddCustomerRequest request) throws Exception {
		
		Set<Document>documents = new HashSet();
		List<AddDocumentRequest>docRequest = new ArrayList(request.getDocuments());
		for(AddDocumentRequest docReq: docRequest ) {
			System.out.println(docReq.getDocumentId());
			if(!documentTypeRepository.existsById(docReq.getDocumentId())) {
				throw new Exception("Document Type Id does not exists!");
			}
			Optional<DocumentType> docType = documentTypeRepository.findById(docReq.getDocumentId());
					Document doc = new Document(docReq,docType.get());
			documents.add(doc);
		}
		
		Customer customer = new Customer(request,documents);
		customerRepository.save(customer);
		
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
