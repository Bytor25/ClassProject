package co.edu.uco.pch.business.assembler.entity.impl;

import java.util.List;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.assembler.dto.impl.PaisAssemblerDTO;
import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.dto.DepartamentoDTO;
import co.edu.uco.pch.dto.PaisDTO;
import co.edu.uco.pch.entity.DepartamentoEntity;
import co.edu.uco.pch.entity.PaisEntity;

public final class DepartamentoAssemblerEntity implements AssemblerEntity<DepartamentoDomain, DepartamentoEntity> {
	
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> instance = new DepartamentoAssemblerEntity();
	
	private static final AssemblerEntity< PaisDomain, PaisEntity > PaisAssembler = PaisAssemblerEntity.getInstance();
	
	

	protected DepartamentoAssemblerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> getInstance() {
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

	@Override
	public List<DepartamentoDomain> toDomainCollection(List<DepartamentoEntity> EntityCollection) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
