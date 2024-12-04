package com.bank.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.bank.dto.AddDocumentRequest;
import com.bank.master.DocumentType;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String docExtension;
	@Lob
	private byte document[];
	@ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;
	private String remark;
	private boolean verified;
	
	public Document() {
	}


	public Document(AddDocumentRequest docRequest, DocumentType docType) {
		this.docExtension = docRequest.getDocExtension();
		this.document = docRequest.getDocument();
		this.documentType = docType;
		this.remark = docRequest.getRemarkk();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDocExtension() {
		return docExtension;
	}


	public void setDocExtension(String docExtension) {
		this.docExtension = docExtension;
	}


	public byte[] getDocument() {
		return document;
	}


	public void setDocument(byte[] document) {
		this.document = document;
	}


	public DocumentType getDocumentType() {
		return documentType;
	}


	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

}
