package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VendorRequisitionItem;

@Repository
public interface VendorRequisitionItemRepository extends CrudRepository<VendorRequisitionItem, Long> {
	
	
	List<VendorRequisitionItem> findByQuotationId(Long quotationId);
	List<VendorRequisitionItem> findByQuotationIdAndVendorId(Long quotationId,Long vendorId);
	VendorRequisitionItem findByQuotationIdAndVendorIdAndRequisitionItemId(Long quotationId,Long vendorId,Long requisitionItemId);
	
}

