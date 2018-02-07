package com.fastscripts.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fastscripts.model.services.factory.ServiceFactoryTest;
import com.fastscripts.model.services.inventoryservice.InventorySvcImplTest;
import com.fastscripts.model.services.patientservice.PatientSvcImplTest;
import com.fastscripts.model.services.prescribeservice.PrescribeSvcImplTest;

@RunWith(Suite.class)
@SuiteClasses({ ServiceFactoryTest.class, InventorySvcImplTest.class, PatientSvcImplTest.class, PrescribeSvcImplTest.class })
public class AllServiceTests {

}
