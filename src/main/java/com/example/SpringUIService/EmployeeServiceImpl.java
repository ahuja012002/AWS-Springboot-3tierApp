package com.example.SpringUIService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	


	    @Autowired
	    EmployeeRepository userRepository;


		@Override
		public Employee saveEmployeeData(Employee userEntity) {
			// TODO Auto-generated method stub
			return userRepository.save(userEntity);
		}

		@Override
		public List<Employee> getEmployeeData() {
			// TODO Auto-generated method stub
			return userRepository.findAll();
		}

		@Override
		public Employee updateEmployeeData(Employee employee) {
			// TODO Auto-generated method stub
			return userRepository.save(employee);
		}

		@Override
	    @CacheEvict(value = "employee", key = "#id")
		public void deleteEmployeeData(Long id) {
			userRepository.deleteById(id);
			
		}
		
		@Override
		public Page<Employee> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
		      Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
		      PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);

		      return userRepository.findAll(pageable);
		  }

		@Override
		public Employee getEmployeeById(long id) {
			// TODO Auto-generated method stub
			Optional<Employee> e = userRepository.findById(id);
			return e.get();
		}
	}

