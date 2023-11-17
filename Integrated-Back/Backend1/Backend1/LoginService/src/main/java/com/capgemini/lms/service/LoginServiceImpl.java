package com.capgemini.lms.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.lms.dao.LoginDao;
import com.capgemini.lms.dto.Login;

@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	LoginDao ldao;
	public void setLoginDao(LoginDao ldao) { this.ldao = ldao; }
	 
    @Transactional(readOnly=true)
    public Optional<Login> checkLoginDetails(String userId)
    {
   	 return ldao.findById(userId);
    }
    @Transactional
	public Login addLoginDetails(String userId, String password, String role)
	{
    	Login login = new Login(userId,password,role);
		return ldao.save(login);
	}

	@Transactional
	public Login updateLoginDetails(Login login)
	{
		return ldao.save(login);
	}

	@Transactional
	public void deleteLoginDetails(String userId)
	{
		ldao.deleteById(userId);
	}

	@Override
	public String getUserIdbyRole(String role) {
		List<Login> login = ldao.findByRole(role);
		Login l = login.get(login.size()-1);
		return "\""+l.getUserId()+"\"";
	}

	@Override
	public Optional<Login> getLoginDetails(String userId) {
		return ldao.findById(userId);
	}
}
