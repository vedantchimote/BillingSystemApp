package tech.vedantchimote.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import tech.vedantchimote.entity.Address;
import tech.vedantchimote.entity.Role;
import tech.vedantchimote.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ConverToJson {


    public static void convertUser() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        Address address = new Address();
        address.setAddress1("1st Street");
        address.setAddress2("2nd Street");
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        user.setAddressList(addressList);
        String jsonString = objectMapper.writeValueAsString(user);
        System.out.println(jsonString);
    }

    public static void convertRole() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Role role = new Role();
        role.setName("GURU");
        role.setDescription("This is GURU Role");
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setEmail("kishore@gmail.com");
        user.setFirstName("Kishore");
        user.setLastName("Suresh");
        users.add(user);
        role.setUsers(users);
        String jsonString = objectMapper.writeValueAsString(role);
        System.out.println(jsonString);
    }

    public static void main(String[] args) throws Exception {

        ConverToJson.convertRole();

    }
}
