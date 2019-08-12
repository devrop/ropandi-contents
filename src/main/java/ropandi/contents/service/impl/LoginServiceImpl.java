package ropandi.contents.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import ropandi.contents.entity.UserLogin;
import ropandi.contents.model.AccessToken;
import ropandi.contents.model.BaseModel;
import ropandi.contents.model.LoginRequest;
import ropandi.contents.model.LoginResponse;
import ropandi.contents.repository.UserLoginRepository;
import ropandi.contents.security.jwt.JwtProvider;
import ropandi.contents.service.LoginService;
import ropandi.contents.utility.Utility;
import ropandi.contents.variable.Variable;

@Service
public class LoginServiceImpl implements LoginService {
 
    @Value("${ropandi.jwtSecret}")
	private String jwtSecret;

    @Value("${ropandi.encrypted}")
	private String key;
	@Value("${ropandi.regex1}")
    private String regex1;
 
	@Value("${ropandi.regex2}")
    private String regex2;

	@Autowired
    private JwtProvider jwtProvider;
	
	

	@Autowired
	private UserLoginRepository userRepository;
	
	
	@Override
	public BaseModel<List<LoginResponse>> login(LoginRequest request) {
		BaseModel<List<LoginResponse>> result = new BaseModel<List<LoginResponse>>();
		try {
			result.setStatus(Variable.RESPONSEOK);
			List<UserLogin> userLogin = userRepository.findUsersByNameAndPassword(request.getUsername(), request.getPassword());
			//System.out.println("list userLOgin " + userLogin.size());
			if(!userLogin.isEmpty()) {
				List<LoginResponse> listUser= userLogin.stream().map(us->{
					LoginResponse log = new LoginResponse();
					log.setUsername(us.getUsername());
					log.setRoles(us.getRoles());
					log.setMenus(us.getMenus());
					
					//generateToken
					List<String> roleString = us.getRoles().stream().map(s-> s.getRoleName()).collect(Collectors.toList());
					String bodyToken = Utility.buildingBodyTokenUsernameAndRole(us.getUsername(), regex1, roleString, regex2);
					String token = jwtProvider.generateJwtTokenCustom(bodyToken);
				    log.setToken(token);
				    return log;
				}).collect(Collectors.toList());
				result.setMessage(Variable.MESSAGESUCCES);
				result.setDatasEntity(listUser);
			}else {
				result.setStatus(Variable.RESPONSENOTFOUND);
				result.setMessage(Variable.MESSAGENOTFOUND);
			}

			
			//successModel.setDatasEntity(datasEntity);
        	return result;
        }catch(Exception e) {
        	result.setStatus(Variable.RESPONSEERROR);
        	result.setMessage("ERROR in UserServiceImpl class login proccess with message : " + e.getMessage());
        	return result;
        }
	}


	@Override
	public AccessToken getToken(String token) {
		String bodyToken = Utility.decrypt(token, key);
		// TODO Auto-generated method stub
		AccessToken at = new AccessToken();
		String act = jwtProvider.generateJwtTokenCustom(bodyToken);	
        at.setStatus(Variable.STATUSOK);
		at.setToken(act);
		return at;
	}
	

	
	
}
