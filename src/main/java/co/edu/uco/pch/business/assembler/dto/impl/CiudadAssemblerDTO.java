package co.edu.uco.pch.business.assembler.dto.impl;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.dto.CiudadDTO;

public final class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO> {
	
	private static final AssemblerDTO<CiudadDomain, CiudadDTO> instance = new CiudadAssemblerDTO();

	private CiudadAssemblerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance(){
		return instance;
	}

	@Override
	public CiudadDomain toDomain(CiudadDTO data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadDTO toDTO(CiudadDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
