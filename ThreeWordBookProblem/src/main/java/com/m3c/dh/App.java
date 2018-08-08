package com.m3c.dh;

import com.m3c.dh.Application.ApplicationController;
import com.m3c.dh.MultithreadedApplication.MultithreadedController;


public class App 
{
    public static void main( String[] args )    {
        ApplicationController myApp = new ApplicationController();
        myApp.StartApplication();

        MultithreadedController threadApp = new MultithreadedController();
        threadApp.StartApplication();
    }
}
