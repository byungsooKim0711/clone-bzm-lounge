package clone.bzm.lounge.notice;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "clone.bzm.lounge.notice")
public class NoticeArchitectureTests {

    @ArchTest
    static final ArchRule testOnionArchitecture =
            onionArchitecture()
                    .domainModels("clone.bzm.lounge.notice.domain..")
                    .domainServices("clone.bzm.lounge.notice.application.service..")
                    .applicationServices(
                            "clone.bzm.lounge.notice.application..",
                            "clone.bzm.lounge.common..",
                            "clone.bzm.lounge.configuration.."
                    )
                    .adapter("in-rest", "clone.bzm.lounge.notice.adapter.in.rest..")
                    .adapter("out-jpa", "clone.bzm.lounge.notice.adapter.out.jpa..")
            ;

}
