package com.solvd.laba.interfaces;

import com.solvd.laba.exceptions.IncorectLevelBuildingException;


public interface IBulding {

    void build(int level) throws IncorectLevelBuildingException;

}
