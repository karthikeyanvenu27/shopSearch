package utils;

import java.util.Properties;

public class ObjectRepoReader {
    private String keyValue;
    private Properties propertyFile;

//    public utils.ObjectRepoReader(utils.ObjectRepoReader.Builder builder) {
//        ConfigReader configReader = new ConfigReader();
//        configReader.loadProperty(builder.propertyFileName);
//        this.keyValue = configReader.readPropertiesFile(builder.keyName);
//    }

    public String getKeyValue() {
        return this.keyValue;
    }

    public static class Builder {
        private String propertyFileName = "src/test/resources/objectRepository/android";
        private String keyName = "Unsub";

        public Builder() {
        }

        public ObjectRepoReader.Builder propertyFileName(String val) {
            this.propertyFileName = val;
            return this;
        }

        public ObjectRepoReader.Builder keyName(String val) {
            this.keyName = val;
            return this;
        }

//        public utils.ObjectRepoReader build() {
//            return new utils.ObjectRepoReader(this);
//        }
    }
}
