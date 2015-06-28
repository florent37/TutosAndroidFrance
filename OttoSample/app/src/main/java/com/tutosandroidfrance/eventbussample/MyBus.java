package com.tutosandroidfrance.eventbussample;

import com.squareup.otto.Bus;

public class MyBus{

   private static Bus bus = new Bus();

   public static Bus getBus(){
        return bus;
   }

}