package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Quotation;
import com.example.demo.repository.QuotationRepository;

@Service
public class QuotationService {

	@Autowired
	private QuotationRepository quotationRepository;

	public Quotation save(final Quotation quotation) {
		return quotationRepository.save(quotation);
	}

	public List<Quotation> findAll() {

		return (List<Quotation>) quotationRepository.findAll();
	}

	public void delete(final Quotation quotation) {
		quotationRepository.delete(quotation);
	}

	public Quotation findById(final Long id) {
		Optional<Quotation> quotation = quotationRepository.findById(id);
		if (quotation.isPresent()) {

			return quotationRepository.findById(id).get();
		}
		return null;
	}

	public List<Quotation> findAll(final Long id) {
		return (List<Quotation>) quotationRepository.findAll();
	}

	public List<Quotation> findAllById(final List<Long> ids) {
		return (List<Quotation>) quotationRepository.findAllById(ids);
	}

}
