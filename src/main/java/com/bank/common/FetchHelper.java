package com.bank.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bank.Repository.AdminRepository;
import com.bank.exception.BadRequestException;
import com.bank.fetch.factorydesignpattern.FetchStrategyFactory;

@Component
public class FetchHelper {

	@Autowired
	private FetchStrategyFactory fetchStrategyFactory;
    public <T> T fetchById(JpaRepository<T, Integer> repository, Integer id, String entityName) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException(entityName + " not found for ID: " + id));
    }
    
    public <T> boolean existsByEmail(JpaRepository<T, Integer> repository,String email, String entityName) {
    	return fetchStrategyFactory.fetchExistsByEmailStrategy(repository,entityName,email);
    }

	public<T> boolean ExistsByAadhaarCard(JpaRepository<T, Integer> repository, String entityName,String aadhaarCard) {
		return fetchStrategyFactory.fetchExistsByAdhaarCardStrategy(repository, entityName, aadhaarCard);
	}
	
	public<T> boolean ExistsByPancard(JpaRepository<T, Integer> repository, String entityName,String panCard) {
		return fetchStrategyFactory.fetchExistsByPancardStrategy(repository, entityName, panCard);
	}
	
	public<T> boolean ExistsByMobNo(JpaRepository<T, Integer> repository, String entityName,String mobNo) {
		return fetchStrategyFactory.fetchExistsByMobNoStrategy(repository, entityName, mobNo);
	}

	public <T> boolean ExistsById(JpaRepository<T, Integer> repository, String entityName, Integer id) {
		return fetchStrategyFactory.fetchExistsByIdStrategy(repository,entityName,id);
	}
}
