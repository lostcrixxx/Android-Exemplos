// 1º option
        int versionCode = BuildConfig.VERSION_CODE;
        String versionName = BuildConfig.VERSION_NAME;
		
// 2º option
// value in gradle.properties
// example user.password=1.10.8
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("gradle.properties");
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            System.out.println(prop.getProperty("user.password")); // user key in gradle.properties
        } catch (IOException ex) {
            ex.printStackTrace();
        }