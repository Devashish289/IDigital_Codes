package com.capgemini.pms.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.pms.dao.ProfileDao;
import com.capgemini.pms.dto.Profile;

@Service
public class ProfileServiceImpl implements ProfileService
{
	@Autowired
	ProfileDao pdao;
	public void setPdao(ProfileDao pdao) { this.pdao = pdao; }

	public Profile addProfile(Profile profile)
	{
		return pdao.save(profile);
	}

	
	public Profile updateProfile(Profile profile)
	{
		return pdao.save(profile);
	}

	
	public void deleteProfile(String userId)
	{
		pdao.deleteById(userId);
	}

	
	public Optional<Profile> viewProfile(String userId)
	{
		return pdao.findById(userId);
	}

	/*@Override
	public String getUserIdbyRole(String role) 
	{
		String userId = pdao.getIdbyRole(role);
		if(userId==null)
		{
			return role.charAt(0)+"10000";
		}
		return userId;
	} */
}
