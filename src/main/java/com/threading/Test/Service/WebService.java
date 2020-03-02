package com.threading.Test.Service;

import com.threading.Test.Domains.Number;

import java.util.List;


public interface WebService {
    List<Number> getData(int status);
}
