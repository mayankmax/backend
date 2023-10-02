package com.example.splitwise.Services;

import com.example.splitwise.Exceptions.GroupException;
import com.example.splitwise.Modals.splitwise_group;
import com.example.splitwise.Modals.Users;
import com.example.splitwise.Utils.GroupConstraints;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class GroupServices {


    public static String createGroup(String name)
    {
        // we will try to retrieve user from session or local storage
        //for now we are creating it manually

        Users groupCreatedBy = new Users();
        GroupConstraints groupConstraints = new GroupConstraints();

        groupCreatedBy.setUserName("Mayank");
        groupCreatedBy.setUserEmail("mayank11785@gmail.com");
        groupCreatedBy.setUserPassword("mayankmaX@1");
        groupCreatedBy.setUserPhone("8789610355");

        //do we need to create group instance locally here? will it reside with design pattern and solid principle
        try{

            if(groupConstraints.isValidGroupName(groupCreatedBy.getUserName()))
                throw new GroupException.InvalidGroupNameException("Name is not valid, try again");

            splitwise_group group = new splitwise_group(name,1, new Date());


            //before returning we should even add RBAC to user
            return "Successfully";

        }catch(Exception e){
            e.printStackTrace();
            return "Failure";

        }

    }

}
