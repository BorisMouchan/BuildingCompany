package com.solvd.laba.interfaces.functional;

import com.solvd.laba.classes.Person;

public interface IComparable<T extends Person,K extends Person> {
    String compareEmployee(T t,K k);
}
