package com.sound.haolei.facade;

import com.sound.haolei.model.MapCountry;

import java.util.Map;


public interface MapCountryFacade extends BaseFacade<MapCountry> {

    Map<String, Object> selectByLikeName(String countryname);

}

