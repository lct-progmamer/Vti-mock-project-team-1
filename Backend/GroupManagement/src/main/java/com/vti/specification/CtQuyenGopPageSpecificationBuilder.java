package com.vti.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.dto.filter.CtQuyenGopPageFilter;
import com.vti.entity.CtQuyenGopPage;

public class CtQuyenGopPageSpecificationBuilder {

	private CtQuyenGopPageFilter filter;
	private String search;

	public CtQuyenGopPageSpecificationBuilder(CtQuyenGopPageFilter filter, String search) {
		this.filter = filter;
		this.search = search;
	}

	@SuppressWarnings("deprecation")
	public Specification<CtQuyenGopPage> build() {

		SearchCriteria seachCriteria = new SearchCriteria("name", "Like", search);
		SearchCriteria minTotalMemberCriteria = new SearchCriteria("totalMember", ">=", filter.getMinTotalMember());
		SearchCriteria maxTotalMemberCriteria = new SearchCriteria("totalMember", "<=", filter.getMaxTotalMember());

		Specification<CtQuyenGopPage> where = null;

		// search
		if (!StringUtils.isEmpty(search)) {
			where = new CtQuyenGopPageSpecification(seachCriteria);
		}

		// min totalMember filter
		if (filter.getMinTotalMember() != 0) {
			if (where != null) {
				where = where.and(new CtQuyenGopPageSpecification(minTotalMemberCriteria));
			} else {
				where = new CtQuyenGopPageSpecification(minTotalMemberCriteria);
			}
		}

		// max totalMember filter
		if (filter.getMaxTotalMember() != 0) {
			if (where != null) {
				where = where.and(new CtQuyenGopPageSpecification(maxTotalMemberCriteria));
			} else {
				where = new CtQuyenGopPageSpecification(maxTotalMemberCriteria);
			}
		}

		return where;
	}
}
