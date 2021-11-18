package com.vti.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.dto.filter.Parameters;
import com.vti.entity.CtQuyenGop;
import com.vti.repository.ICTQuyenGopRepository;

@Service
public class CtQuyenGopServie implements ICtQuyenGopService{

	@Autowired
	private ICTQuyenGopRepository repository;
	
	
	@Override
	public List<CtQuyenGop> getAllCtQuyenGops(Parameters parameters) {
		
		List<CtQuyenGop> quyengops = null;
		Specification<CtQuyenGop> where = null;
		Sort sort = null;
		Pageable paging = null;
		
		if(parameters.getTypeSort() != null && !parameters.getFieldSort().isEmpty()) {
			if(parameters.getTypeSort().equals("ASC"))
				sort = Sort.by(parameters.getFieldSort()).ascending();
			else
				sort = Sort.by(parameters.getFieldSort()).descending();
		}
		
		if(parameters.getMaxId() > 0)
			where = lessterThanEqualsMaxId(parameters.getMaxId());
		if(parameters.getMinId() >= 0) {
			if(where == null)
				where = greaterThanEqualsMinId(parameters.getMinId());
			else
				where = where.and(greaterThanEqualsMinId(parameters.getMinId()));
		}
		
		if(parameters.getSearch() != null  && !parameters.getSearch().isEmpty()) {
			if(where!=null)
				where = where.and(searchByCtQuyenName(parameters.getSearch()));
			else
				where = searchByCtQuyenName(parameters.getSearch());
		}
		
		if(parameters.getPage() >= 0 && parameters.getPageSize() > 0)
		{
			if(sort != null)
				paging = PageRequest.of(parameters.getPage(), parameters.getPageSize(), sort);
			else
				paging = PageRequest.of(parameters.getPage(), parameters.getPageSize());
			
			if(where!=null)
				quyengops = repository.findAll(where, paging).toList();
			else
				quyengops = repository.findAll(paging).toList();
				
		}
		else {
			if(where != null && sort != null)
				quyengops = repository.findAll(where, sort);
			else if(where != null && sort == null)
				quyengops = repository.findAll(where);
			else if(where == null && sort != null)
				quyengops = repository.findAll(sort);
			else 
				quyengops = repository.findAll();
		}

				
		return quyengops;
	}

	
	
	
	Specification<CtQuyenGop> searchByCtQuyenName(String name){
		return new Specification<CtQuyenGop>() {

			@Override
			public Predicate toPredicate(Root<CtQuyenGop> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.like(root.get("name"), "%" + name + "%");
			}
			
		};
		
	}	
	
	Specification<CtQuyenGop> lessterThanEqualsMaxId(int maxId){
		return new Specification<CtQuyenGop>() {

			@Override
			public Predicate toPredicate(Root<CtQuyenGop> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.le(root.get("id") , maxId);
			}
			
		};
	}
	
	Specification<CtQuyenGop> greaterThanEqualsMinId(int minId){
		return new Specification<CtQuyenGop>() {

			@Override
			public Predicate toPredicate(Root<CtQuyenGop> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				return criteriaBuilder.ge(root.get("id") , minId);
			}
			
		};
	}
	
	
	
	@Override
	public CtQuyenGop getCtQuyenGopById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}


	@Override
	public CtQuyenGop getCtQuyenGopByName(String name) {
		// TODO Auto-generated method stub
		return repository.findCtQuyenGopByName(name);
	}


	@Override
	public boolean existsCtQuyenGopById(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}


	@Override
	public boolean existsCtQuyenGopByName(String name) {
		// TODO Auto-generated method stub
		return repository.existsCtQuyenGopByName(name);
	}


	@Override
	public void createQuyenGop(CtQuyenGop ct) {
		repository.save(ct);
	}

	
}
