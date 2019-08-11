package com.beauty.beautician.command;

import java.util.Map;

public interface BeauticianCommandService {

	Beautician createBeautician(Beautician beautician);

	void deleteBeautician(Beautician beautician);

	Beautician updateBeautician(Beautician beautician);


	Beautician findBeautician(Long beauticianID);

}
