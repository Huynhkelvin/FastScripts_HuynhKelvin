package com.fastscripts.model.business;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fastscripts.model.business.factory.ServiceFactoryTest;
import com.fastscripts.model.business.manager.PrescribeMedicationManagerTest;


@RunWith(Suite.class)
@SuiteClasses({PrescribeMedicationManagerTest.class, ServiceFactoryTest.class})
public class AllBusinessTests {


}
