// build.gradle(Module: app)

android.applicationVariants.all { variant ->
    variant.outputs.each { output ->
        def name = "NameAppExample_v${variant.versionName}(${variant.versionCode}).apk"
        output.outputFileName = name
    }
}
