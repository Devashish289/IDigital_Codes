package com.capgemini.fa.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.fa.dto.MspDTO;
@Repository
public interface MspDao extends CrudRepository<MspDTO, String> {
	@Query(value="select m from MspDTO m where m.cropName= :cropName")
	MspDTO findCropByCropName(@Param("cropName")String cropName);
	
	

}
