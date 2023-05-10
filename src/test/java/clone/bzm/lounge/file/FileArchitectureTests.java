package clone.bzm.lounge.file;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "clone.bzm.lounge.file")
public class FileArchitectureTests {

    @ArchTest
    static final ArchRule testOnionArchitecture =
            onionArchitecture()
                    .domainModels("clone.bzm.lounge.file.domain..")
                    .domainServices("clone.bzm.lounge.file.application.service..")
                    .applicationServices(
                            "clone.bzm.lounge.file.application..",
                            "clone.bzm.lounge.common..",
                            "clone.bzm.lounge.configuration.."
                    )
                    .adapter("in-rest", "clone.bzm.lounge.file.adapter.in.rest..")
                    .adapter("out-jpa", "clone.bzm.lounge.file.adapter.out.jpa..")
                    .adapter("out-disk", "clone.bzm.lounge.file.adapter.out.disk..")
                    .adapter("out-storage", "clone.bzm.lounge.file.adapter.out.storage..")
            ;

}
