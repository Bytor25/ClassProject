package co.edu.uco.pch.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.entity.CiudadEntity;
import co.edu.uco.pch.entity.DepartamentoEntity;

public final  class CiudadAssemblerEntity implements AssemblerEntity<CiudadDomain, CiudadEntity> {
	
	private static final AssemblerEntity<CiudadDomain, CiudadEntity> instance = new CiudadAssemblerEntity();
	
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> departamentoAssembler = DepartamentoAssemblerEntity.getInstance();
	
	

	private CiudadAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<CiudadDomain, CiudadEntity> getInstance(){
		return instance;
	}
	

	@Override
	public CiudadDomain toDomain(CiudadEntity data) {
		var ciudadEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, CiudadEntity.build());
		var departamentoDomain = departamentoAssembler.toDomain(ciudadEntityTmp.getDepartamento());
		return CiudadDomain.build(ciudadEntityTmp.getId(), ciudadEntityTmp.getNombre(), departamentoDomain);
	}

	@Override
	public CiudadEntity toEntity(CiudadDomain domain) {
		var ciudadDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
		var departamentoEntity = departamentoAssembler.toEntity(ciudadDomainTmp.getDepartamento());
		return CiudadEntity.build().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre()).setDepartamento(departamentoEntity);
	}
	
	@Override
	public List<CiudadDomain> toDomainCollection(final List<CiudadEntity> EntityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(EntityCollection, new ArrayList<CiudadEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}
	
}
