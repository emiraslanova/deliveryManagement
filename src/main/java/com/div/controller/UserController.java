package com.div.controller;

import com.div.dto.UserDto;
import com.div.response.BaseResponse;
import com.div.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public BaseResponse <UserDto> creatUser(@RequestBody UserDto userDto){
        try {
            return  BaseResponse.ok(userService.creatUser(userDto));
        }catch (Exception e){
          return BaseResponse.fail();
        }


    }

    @GetMapping
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public BaseResponse<UserDto> getUserById(@PathVariable Long id){
        try {
            return  BaseResponse.success(userService.getUserById(id)) ;
        }catch (Exception e){
            return BaseResponse.fail();
        }

    }

   @PutMapping("/{id}")
   public void updateUserById( @PathVariable Long id ,@RequestBody UserDto userDto){
        userService.updateUserById(id,userDto);
   }
  @DeleteMapping("/{id}")
 public   void  deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
  }
}
