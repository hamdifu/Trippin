package com.example.trippin.adapter;


import com.example.trippin.R;

public class PlaceAutoSuggester  {

    String[] places={"Agartala","Almora","Agra","Ahmedabad","Ajmer","Allahabad","Ayodhya","Amritsar","Andaman and Nicobar Island","Aurangabad",
            "Amarnath","Banglore","Bhopal","Baroda","Bilaspur","Bhubaneshwar","Bhilai","Chandigarh","Chennai","Coimbatore","Delhi",
            "Faridabad","Gandhinagar","Gurgaon","Gangtok","Gulmarg","Gwalior","Guwahati","Hyderabad","Himachal","Imphal","Indore","Itanagar",
            "Jaipur","Jalandhar","Jodhpur","Jamshedpur","Jabalpur","Jammu","Kanpur","Kolkata","Karwar","Kashmir","Kerela","Lakshadweep","Ludhiana","Lucknow",
            "Mumbai","Mysore","Madurai","Margoa","Meghalaya","Nashik","Patna","Pune","Pondicherry","Puri","Raipur","Ranchi","Rishikesh","Rajgir","Rourkela",
            "Surat","Tezpur","Tirupati","Udaipur","Varanasi","Vishakhapatnam"};
    String[] famousPlaces= {"Udaipur","Himachal","Jaipur","Jammu","Goa","Kerela","Varanasi"};
    public String[] getPlaces()
    {
        return places;
    }
    public String[] getFamousPlaces()
    {
        return famousPlaces;
    }



}
