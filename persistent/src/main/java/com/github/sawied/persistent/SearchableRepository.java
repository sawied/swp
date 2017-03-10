package com.github.sawied.persistent;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchableRepository<T> {
	
	Page<T> search(SearchCriteria searchCriteria, Pageable pageable);

}
