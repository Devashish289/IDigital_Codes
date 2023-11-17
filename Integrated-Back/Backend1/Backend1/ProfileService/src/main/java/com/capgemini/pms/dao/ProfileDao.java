package com.capgemini.pms.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capgemini.pms.dto.Profile;

@Repository
public interface ProfileDao extends JpaRepository<Profile, String>
{
}
