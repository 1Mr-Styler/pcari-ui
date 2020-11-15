package com.lyshnia.pcari.user;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.Collection;
import java.util.HashMap;

public interface UserService {
    @GET("user/username")
    Call<User> getDetails(
            @Header("Authorization") String authorization,
            @Query("username") String username
    );

    @GET("user")
    Call<Collection<User>> findAll(
    );

    @GET("user/{id}")
    Call<User> get(
            @Path("id") Long id
    );

    /*@GET("user/{id}/employee")
    Call<Employee> getEmployee(
            @Header("Authorization") String authorization,
            @Path("id") Long id
    );

    @GET("user/{id}/customer")
    Call<Customer> getCustomer(
            @Header("Authorization") String authorization,
            @Path("id") Long id
    );*/

    @POST("user")
    Call<User> save(
            @Header("Authorization") String authorization,
            @Body HashMap<String, Object> body,
            @Query("branch") Long branch
    );

    @PUT("user/{id}")
    Call<User> update(
            @Header("Authorization") String authorization,
            @Path("id") Long id,
            @Body HashMap<String, Object> body
    );

    @DELETE("user/{id}")
    Call<User> delete(
            @Header("Authorization") String authorization,
            @Path("id") Long id
    );

}
