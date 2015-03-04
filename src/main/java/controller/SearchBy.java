/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Best
 */
public class SearchBy {

    public String SearchData(String name) {
        if (name.equals("name")) {
            return "first_name";
        }
        if (name.equals("email")) {
            return "email";
        }
        if (name.equals("salary")) {
            return "salary";
        }
        if (name.equals("phone")) {
            return "phone_number";
        }

        return null;
    }

}
