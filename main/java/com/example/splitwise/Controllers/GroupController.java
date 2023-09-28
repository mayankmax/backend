package com.example.splitwise.Controllers;

import com.example.splitwise.DTOS.GroupRequestDTO;
import com.example.splitwise.DTOS.GroupResponseDTO;
import com.example.splitwise.Modals.Users;
import com.example.splitwise.Services.GroupServices;
import com.example.splitwise.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
 @RequestMapping("/api/group")
public class GroupController {
    //Group controller can receive
    //a) create a group //when group is created we have to make sure ki user is already in our db and after successful creation of group we need to make a particluar
    //user admin as well
    //b) delete a group
    //c) add a member can be done only by admin
    //d) delete a member can be done only by admin
    //e) settle the expenses
    //make member as admin


    private GroupServices groupServices;
    @Autowired
    public GroupController(GroupServices groupServices){
        this.groupServices = groupServices;
    }


    @PostMapping("/creategroup")
    public ResponseEntity<GroupResponseDTO> CreateGroup(@RequestBody GroupRequestDTO groupRequestDTO){
        String name = groupRequestDTO.getGroupName();
       // Users admin = groupRequestDTO.getAdmin(); // i should not ideally pass the user but it should get from session or cache

        GroupResponseDTO groupResponseDTO = new GroupResponseDTO();

        //if i create a groupservices with user return type how can i add that user as admin?
        //but i already sending user("admin") to create why do i need to receive user?

        String msg = GroupServices.createGroup(name);

        if(msg.toLowerCase().contains("successfully")){
            //make user admin
            groupResponseDTO.setMessage("Successful with message" + msg);
            groupResponseDTO.setStatus("Success");
           // groupResponseDTO.setCreatedBY(admin);

        }else{
            groupResponseDTO.setMessage("Failure with message" + msg);
            groupResponseDTO.setStatus("Failure");
            groupResponseDTO.setCreatedBY(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(groupResponseDTO);
        }

        return ResponseEntity.ok(groupResponseDTO);

    }

}
