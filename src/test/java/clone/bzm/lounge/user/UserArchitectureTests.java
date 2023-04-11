package clone.bzm.lounge.user;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "clone.bzm.lounge.user")
public class UserArchitectureTests {

    @ArchTest
    static final ArchRule testOnionArchitecture =
            onionArchitecture()
                    .domainModels("clone.bzm.lounge.user.domain..")
                    .domainServices("clone.bzm.lounge.user.application.service..")
                    .applicationServices("clone.bzm.lounge.user.application..")
                    .adapter("in-rest", "clone.bzm.lounge.user.adapter.in.rest..")
                    .adapter("out-jpa", "clone.bzm.lounge.user.adapter.out.jpa..")
                    .adapter("out-event", "clone.bzm.lounge.user.adapter.out.event..")
            ;

}
