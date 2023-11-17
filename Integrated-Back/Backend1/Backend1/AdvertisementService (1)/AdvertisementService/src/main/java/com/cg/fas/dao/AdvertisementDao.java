package com.cg.fas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fas.entity.AdvertisementEntity;

@Repository
public interface AdvertisementDao extends JpaRepository<AdvertisementEntity, String> {

	public List<AdvertisementEntity> findByAdvertisementOwnerId(String userId);
	public List<AdvertisementEntity> findByTargetedAudience(String targetAudience);
}
