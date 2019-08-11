package com.beauty.beautician.command;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeauticianCommandServiceImpl implements BeauticianCommandService {
	
	@Autowired
	BeauticianRepository repository;

	
	
	
	@Override
	public Beautician findBeautician(Long beauticianID) {
		Optional<Beautician> optional = repository.findById(beauticianID);
		
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	@Override
	public Beautician createBeautician(Beautician beautician) {
		
		

		return repository.save(beautician);
	}

	@Override
	public void deleteBeautician(Beautician beautician) {
		repository.delete(beautician);

	}

	@Override
	public Beautician updateBeautician(Beautician beautician) {
		
		return repository.save(beautician);
	}


}
