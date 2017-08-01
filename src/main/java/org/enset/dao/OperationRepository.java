package org.enset.dao;

import org.enset.esntities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	@Query("select o from Operation o where o.compte.codeCompte=:x")
	public Page<Operation> listOpperations(@Param("x")String codeCpt,Pageable pageable);
}
