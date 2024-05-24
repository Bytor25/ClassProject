package co.edu.uco.pch.business.assembler.entity.impl;

import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.entity.DepartamentoEntity;

public final class CiudadAssemblerEntity implements AssemblerEntity<DepartamentoDomain, DepartamentoEntity> {
	
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> instance = new CiudadAssemblerEntity();
	
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> DepartamentoAssembler = DepartamentoAssemblerEntity.getInstance();
	
	

	private CiudadAssemblerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> getInstance(){
		return instance;
	}
	

	@Override
	public DepartamentoDomain toDomain(DepartamentoEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoEntity toEntity(DepartamentoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
