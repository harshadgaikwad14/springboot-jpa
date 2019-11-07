package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VendorRequisition;

@Repository
public interface VendorRequisitionRepository extends CrudRepository<VendorRequisition, Long> {

	public List<VendorRequisition> findByVendorId(Long vendorId);

	public List<VendorRequisition> findByRequisitionId(Long requisitionId);

	public List<VendorRequisition> findByIdAndRequisitionId(final Long quotationId, Long requisitionId);

	public VendorRequisition findByQuotationIdAndVendorId(final Long quotationId, final Long vendorId);

	public VendorRequisition findByRequisitionIdAndVendorId(Long requisitionId, Long vendorId);
}
