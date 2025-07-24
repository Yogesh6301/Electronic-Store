package com.example.electronics.service;

import java.util.List;

import com.example.electronics.dto.PageableResponse;
import com.example.electronics.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, String userId);

	void deleteUser(String userId);

	PageableResponse<UserDto> getAllUsers(int pageNumber, int pageSize, String sortBy, String sortDir);

	UserDto getUserById(String userId);

	UserDto getUserByEmail(String email);
	
	List<UserDto> searchUser(String keyword);


}
