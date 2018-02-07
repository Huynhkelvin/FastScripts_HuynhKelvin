import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fastscripts.model.business.AllBusinessTests;
import com.fastscripts.model.domain.AllDomainTests;
import com.fastscripts.model.services.AllServiceTests;


@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class, AllDomainTests.class, AllServiceTests.class})
public class ApplicationTestSuite {

}
