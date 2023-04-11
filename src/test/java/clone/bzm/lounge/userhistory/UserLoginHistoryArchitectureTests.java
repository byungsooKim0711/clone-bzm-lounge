package clone.bzm.lounge.userhistory;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "clone.bzm.lounge.userhistory")
public class UserLoginHistoryArchitectureTests {

    @ArchTest
    static final ArchRule testOnionArchitecture =
            onionArchitecture()
                    .domainModels("clone.bzm.lounge.userhistory.domain..")
                    .domainServices("clone.bzm.lounge.userhistory.application.service..")
                    .applicationServices("clone.bzm.lounge.userhistory.application..")
                    .adapter("out-jpa", "clone.bzm.lounge.userhistory.adapter.out.jpa..")
                    .adapter("in-event", "clone.bzm.lounge.userhistory.adapter.in.event..")
            ;

}
