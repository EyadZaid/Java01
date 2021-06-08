//package com.experis.robotfleetspring;
//
//import com.experis.robotfleetspring.weapons.*;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Configuration
//public class WeaponConfig {
//    @Bean
//    @Scope("prototype")
//    public Set<Weapon> hal9000_weapons(@Qualifier("claw") Weapon weapon1,
//                                       @Qualifier("gun") Weapon weapon2) {
//        Set<Weapon> weapons = new HashSet<>();
//        weapons.add(weapon1);
//        weapons.add(weapon2);
//        return weapons;
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Set<Weapon> tachikomas_weapons(@Qualifier("saber") Weapon weapon1,
//                                          @Qualifier("claw") Weapon weapon2,
//                                          @Qualifier("gun") Weapon weapon3) {
//        Set<Weapon> weapons = new HashSet<>();
//        weapons.add(weapon1);
//        weapons.add(weapon2);
//        weapons.add(weapon3);
//        return weapons;
//    }
//}
