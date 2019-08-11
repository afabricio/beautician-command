package com.beauty.beautician.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/beauticians")
public class BeauticianCommandRestController {

	@Autowired
	private BeauticianCommandService beauticianService;


	@PostMapping
	public Beautician createBeautician(@RequestBody Beautician beautician) {
		return beauticianService.createBeautician(beautician);
	}

	@DeleteMapping("/{beauticianId}")
	public void deleteBeautician(@PathVariable Long beauticianId) {
		
		Beautician beautician = new Beautician();
		beautician.setId(beauticianId);
		
		beauticianService.deleteBeautician(beautician);
	}

	@PutMapping("/{beauticianId}")
	public Beautician updateBeautician(@RequestBody Beautician beautician, @PathVariable Long beauticianId) {
		beautician.setId(beauticianId);
		return beauticianService.updateBeautician(beautician);
	}

	@PatchMapping("/{beauticianId}")
	public Beautician updateBeautician(@RequestBody Map<String, String> updates, @PathVariable Long beauticianId) {
		
		Beautician beautician = beauticianService.findBeautician(beauticianId);
		
		beautician.setByMap(updates);
		
		return beauticianService.updateBeautician(beautician);
	}
	
	

	
}